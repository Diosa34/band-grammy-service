package com.grammyweb.controllers;


import com.grammyejb.models.MusicGenre;
import com.grammyejb.schemas.reward.RewardReadSchema;
import com.grammyweb.jaxbgenerated.CreateRewardRequest;
import com.grammyweb.jaxbgenerated.CreateRewardResponse;
import com.grammyweb.mappers.MusicGenreMapper;
import com.grammyweb.mappers.RewardReadSchemaMapper;
import com.grammyweb.services.RewardService;
import lombok.RequiredArgsConstructor;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@Endpoint
@RequiredArgsConstructor
public class RewardEndpoint {
    private final RewardService rewardService;

    private static final String NAMESPACE_URI = "http://example.com/please";

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "CreateRewardRequest")
    public @ResponsePayload CreateRewardResponse giveReward(@RequestPayload CreateRewardRequest saveRewardRequest) {
        Long musicBandId = saveRewardRequest.getMusicBandId();
        MusicGenre genre = MusicGenreMapper.MAPPER.map(saveRewardRequest.getMusicGenre());

        RewardReadSchema readScheme = rewardService.giveReward(musicBandId, genre);
        CreateRewardResponse response = new CreateRewardResponse();
        response.setId(readScheme.getId());
        response.setMusicGenre(MusicGenreMapper.MAPPER.map(readScheme.getGenre()));
        response.setMusicBandId(readScheme.getMusicBandId());
        return response;
    }
}
