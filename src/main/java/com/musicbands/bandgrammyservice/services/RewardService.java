package com.musicbands.bandgrammyservice.services;

import com.musicbands.bandgrammyservice.models.MusicGenre;
import com.musicbands.bandgrammyservice.models.Reward;
import com.musicbands.bandgrammyservice.repositories.RewardRepository;
import com.musicbands.bandgrammyservice.schemas.reward.RewardReadSchema;
import com.musicbands.bandgrammyservice.services.external.MusicBandService;
import com.musicbands.bandgrammyservice.services.mappers.RewardMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class RewardService {
    private final RewardMapper rewardMapper;
    private final RewardRepository rewardRepository;
    private final MusicBandService musicBandService;

    public RewardReadSchema giveReward(Long toMusicBand, MusicGenre genre) {
        // todo: check id
        Reward newReward = new Reward();
        newReward.setMusicBandId(toMusicBand);
        newReward.setGenre(genre);
        newReward = rewardRepository.save(newReward);
        return rewardMapper.mapEntityToReadSchema(newReward);
    }
}
