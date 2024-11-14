package com.musicbands.bandgrammyservice.controllers;

import com.musicbands.bandgrammyservice.schemas.single.SingleBaseSchema;
import com.musicbands.bandgrammyservice.schemas.single.SingleReadSchema;
import com.musicbands.bandgrammyservice.services.SingleService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Validated
@RestController
@RequestMapping("/grammy")
@AllArgsConstructor
public class SingleController {
    private final SingleService singleService;

    @PostMapping(
            value = "/{musicBandId}/singles/add",
            consumes = MediaType.APPLICATION_XML_VALUE,
            produces = MediaType.APPLICATION_XML_VALUE)
    public SingleReadSchema createSingle(@PathVariable Long musicBandId, @RequestBody @Valid SingleBaseSchema schema) {
        return singleService.createSingle(musicBandId, schema);
    }
}
