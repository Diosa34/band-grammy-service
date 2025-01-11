package com.grammyweb.controllers;

import com.grammyejb.models.MusicGenre;
import com.grammyejb.schemas.reward.RewardReadSchema;
import com.grammyweb.schemas.exceptions.Http422Schema;
import com.grammyweb.schemas.exceptions.Http503Schema;
import com.grammyweb.services.RewardService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;


@Tag(name = "Награды")
@Validated
@RestController
@RequestMapping("/grammy")
@AllArgsConstructor
public class RewardController {
    private final RewardService rewardService;

    @Operation(
            summary = "Наградить музыкальную группу",
            description = "Награждает группу с идентификатором musicBandId в указанном жанре genre")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "422", description = "Валидационная ошибка", content = @Content(schema = @Schema(implementation = Http422Schema.class))),
            @ApiResponse(responseCode = "503", description = "Опорный сервис не доступен", content = @Content(schema = @Schema(implementation = Http503Schema.class)))
    })
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(
            path = "/{musicBandId}/reward/{genre}",
            produces = MediaType.APPLICATION_XML_VALUE)
    public RewardReadSchema giveReward(@PathVariable Long musicBandId, @PathVariable MusicGenre genre) {
        return rewardService.giveReward(musicBandId, genre);
    }
}
