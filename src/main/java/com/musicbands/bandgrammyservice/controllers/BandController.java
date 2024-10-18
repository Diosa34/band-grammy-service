package com.musicbands.bandgrammyservice.controllers;

import com.musicbands.bandgrammyservice.schemas.SingleBaseSchema;
import com.musicbands.bandgrammyservice.schemas.SingleReadSchema;
import com.musicbands.bandgrammyservice.services.RewardService;
import com.musicbands.bandgrammyservice.services.SingleService;
import com.musicbands.musicbandsservice.models.MusicGenre;
import com.musicbands.musicbandsservice.schemas.musicBand.MusicBandReadSchema;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/band")
@Validated
public class BandController {
    SingleService singleService;
    RewardService rewardService;

    @Operation(summary = "Добавить новый сингл группе")
    @PostMapping("/{band-id}/singles/add")
    public SingleReadSchema addSingle(@PathVariable("band-id") Long musicBandId, @RequestBody @Valid SingleBaseSchema schema) {
        return singleService.add(musicBandId, schema);
    }

    @Operation(summary = "Список музыкальных групп")
    @PostMapping("/{band-id}/reward/{genre}")
    public MusicBandReadSchema addReward(@PathVariable("band-id") Long musicBandId, @PathVariable MusicGenre genre) {
        return rewardService.add(musicBandId, genre);
    }
}
