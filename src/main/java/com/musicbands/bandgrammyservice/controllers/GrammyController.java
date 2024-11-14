package com.musicbands.bandgrammyservice.controllers;

import com.musicbands.bandgrammyservice.schemas.PingSchema;
import io.swagger.v3.oas.annotations.Operation;
import lombok.AllArgsConstructor;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping(path = "/grammy")
//@Validated
public class GrammyController {

//    @Value("${music-band-service.url}")
//    private String MUSICBANDS_SERVICE_URL;
//
//    @Value("${music-band-service.port}")
//    private Integer MUSICBANDS_SERVICE_PORT;

//    @Operation(summary = "Добавить новый сингл группе")
//    @ApiResponses(value = {
//            @ApiResponse(responseCode = "200", description = "Returns the music band that was just added a single to"),
//            @ApiResponse(responseCode = "400", description = "Invalid query param", content = @Content(schema = @Schema(implementation = BadRequestSchema.class))),
//            @ApiResponse(responseCode = "404", description = "Object not found", content = @Content(schema = @Schema(implementation = ObjectNotFoundSchema.class))),
//            @ApiResponse(responseCode = "422", description = "Validation error", content = @Content(schema = @Schema(implementation = ValidationExceptionSchema.class))),
//            @ApiResponse(responseCode = "500", description = "Internal server error", content = @Content(schema = @Schema(implementation = InternalServerErrorSchema.class)))
//    })
//    @PostMapping("/{band-id}/singles/add")
//    public ResponseEntity<SingleReadSchema> addSingle(
//      @PathVariable("band-id") Long musicBandId,
//      @RequestBody @Valid SingleBaseSchema singleBaseSchema){
//        URI uri = UriComponentsBuilder
//            .fromHttpUrl(MUSICBANDS_SERVICE_URL)
//            .port(MUSICBANDS_SERVICE_PORT)
//            .path("/grammy/singles/add")
//            .queryParam("band-id", musicBandId)
//            .build()
//            .toUri();
//
//        HttpHeaders headers = new HttpHeaders();
//        headers.setAccept(List.of(MediaType.APPLICATION_JSON));
//        headers.add("user-agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/54.0.2840.99 Safari/537.36");
//
//        return restTemplate.exchange(
//                uri,
//                HttpMethod.POST,
//                new HttpEntity<>(singleBaseSchema, headers),
//                SingleReadSchema.class);
//    }

    @Operation(summary = "Приветствие")
    @PostMapping(path = "/ping", consumes = MediaType.APPLICATION_XML_VALUE, produces = MediaType.APPLICATION_XML_VALUE)
    public PingSchema ping(@RequestBody PingSchema pingSchema) {
        return new PingSchema(pingSchema.getPingMessage());
    }

    @Operation(summary = "Приветствие")
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(path = "/ping2", produces = {MediaType.APPLICATION_XML_VALUE})
    public PingSchema ping2() {
        return new PingSchema("pingSchema.getPingMessage()");
    }
}
