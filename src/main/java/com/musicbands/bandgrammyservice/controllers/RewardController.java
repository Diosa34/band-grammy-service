package com.musicbands.bandgrammyservice.controllers;

import com.musicbands.bandgrammyservice.models.MusicGenre;
import com.musicbands.bandgrammyservice.schemas.reward.RewardReadSchema;
import com.musicbands.bandgrammyservice.services.RewardService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;


@Validated
@RestController
@RequestMapping("/grammy")
@AllArgsConstructor
public class RewardController {
    private final RewardService rewardService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(
            path = "/{musicBandId}/reward/{genre}",
            produces = MediaType.APPLICATION_XML_VALUE)
    public RewardReadSchema giveReward(@PathVariable Long musicBandId, @PathVariable MusicGenre genre) {
        return rewardService.giveReward(musicBandId, genre);
    }
}
