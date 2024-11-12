package com.musicbands.bandgrammyservice.controllers;

import com.musicbands.bandgrammyservice.schemas.SingleBaseSchema;
import com.musicbands.bandgrammyservice.schemas.SingleReadSchema;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/grammy")
@Validated
public class GrammyController {

    @Value("${music-band-service.url}")
    private String MUSICBANDS_SERVICE_URL;

    @Value("${music-band-service.port}")
    private Integer MUSICBANDS_SERVICE_PORT;

    private final RestTemplate restTemplate;

    @Operation(summary = "Добавить новый сингл группе")
    @PostMapping("/{band-id}/singles/add")
    public ResponseEntity<SingleReadSchema> addSingle(
      @PathVariable("band-id") Long musicBandId,
      @RequestBody @Valid SingleBaseSchema singleBaseSchema){
        URI uri = UriComponentsBuilder
            .fromHttpUrl(MUSICBANDS_SERVICE_URL)
            .port(MUSICBANDS_SERVICE_PORT)
            .path("/grammy/singles/add")
            .queryParam("band-id", musicBandId)
            .build()
            .toUri();

        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(List.of(MediaType.APPLICATION_JSON));
        headers.add("user-agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/54.0.2840.99 Safari/537.36");

        return restTemplate.exchange(
                uri,
                HttpMethod.POST,
                new HttpEntity<>(singleBaseSchema, headers),
                SingleReadSchema.class);
    }

    @Operation(summary = "Приветствие")
    @GetMapping
    public String getUserList() {
        return "Привет!";
    }
}
