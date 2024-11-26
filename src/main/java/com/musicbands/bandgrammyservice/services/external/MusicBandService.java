package com.musicbands.bandgrammyservice.services.external;

import com.musicbands.bandgrammyservice.config.properties.MusicBandsServiceProps;
import com.musicbands.bandgrammyservice.exceptions.NotFoundException;
import com.musicbands.bandgrammyservice.exceptions.ServiceUnavailableException;
import com.musicbands.bandgrammyservice.schemas.musicBand.MusicBandReadSchema;
import io.netty.handler.ssl.SslContext;
import io.netty.handler.ssl.SslContextBuilder;
import io.netty.handler.ssl.util.InsecureTrustManagerFactory;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.client.reactive.ReactorClientHttpConnector;
import org.springframework.http.codec.xml.Jaxb2XmlDecoder;
import org.springframework.http.codec.xml.Jaxb2XmlEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.ExchangeStrategies;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClientException;
import reactor.core.publisher.Mono;
import reactor.netty.http.client.HttpClient;

import javax.net.ssl.SSLException;


@Service
@AllArgsConstructor
public class MusicBandService {
    private final MusicBandsServiceProps musicBandsServiceProps;

    private WebClient getWebClient() {
        SslContext sslContext;
        try {
            sslContext = SslContextBuilder
                    .forClient()
                    .trustManager(InsecureTrustManagerFactory.INSTANCE)
                    .build();
        } catch (SSLException e) {
            throw new RuntimeException(e);
        }
        SslContext finalSslContext = sslContext;
        HttpClient httpClient = HttpClient.create().secure(t -> t.sslContext(finalSslContext));
        return WebClient.builder()
                .baseUrl(musicBandsServiceProps.getUrl())
                .exchangeStrategies(
                        ExchangeStrategies.builder()
                                .codecs(configurer -> {
                                    configurer.defaultCodecs().jaxb2Decoder(new Jaxb2XmlDecoder());
                                    configurer.defaultCodecs().jaxb2Encoder(new Jaxb2XmlEncoder());
                                })
                                .build()
                )
                .clientConnector(new ReactorClientHttpConnector(httpClient))
                .build();
    }

    public MusicBandReadSchema getMusicBand(Long musicBandId) {
        WebClient webClient = getWebClient();
        return webClient
                .get()
                .uri(String.join("", "/music-bands/", musicBandId.toString()))
                .retrieve()
                .onStatus(
                        httpStatusCode -> httpStatusCode == HttpStatus.NOT_FOUND,
                        error -> Mono.error(new NotFoundException(musicBandId, "MusicBand"))
                )
                .bodyToMono(MusicBandReadSchema.class)
                .onErrorResume(WebClientException.class, error -> {
                    throw new ServiceUnavailableException("MusicBands");
                })
                .block();
    }
}
