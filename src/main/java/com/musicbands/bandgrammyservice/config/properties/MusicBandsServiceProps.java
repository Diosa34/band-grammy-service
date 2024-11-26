package com.musicbands.bandgrammyservice.config.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;

@Data
@ConfigurationPropertiesScan
@ConfigurationProperties(prefix = "application.services.music-bands")
public class MusicBandsServiceProps {
    private String host;
    private Integer port;

    public String getUrl() {
        return String.format("%s:%d", host, port);
    }
}
