package com.musicbands.bandgrammyservice.services;

import com.musicbands.bandgrammyservice.models.Reward;
import com.musicbands.bandgrammyservice.repositories.RewardRepository;
import com.musicbands.musicbandsservice.exceptions.NotFoundException;
import com.musicbands.musicbandsservice.mappers.MusicBandMapper;
import com.musicbands.musicbandsservice.models.MusicBand;
import com.musicbands.musicbandsservice.models.MusicGenre;
import com.musicbands.musicbandsservice.repositories.MusicBandRepository;
import com.musicbands.musicbandsservice.schemas.musicBand.MusicBandReadSchema;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RewardService {
    private final RewardRepository rewardRepository;
    private final MusicBandRepository musicBandRepository;
    private final MusicBandMapper musicBandMapper;

    public MusicBandReadSchema add(Long bandId, MusicGenre genre) {
        MusicBand musicBand = musicBandRepository.findById(bandId).orElseThrow(
                () -> new NotFoundException(bandId, "Музыкальная группа"));
        Reward model = new Reward(musicBand, genre);
        rewardRepository.save(model);
        return musicBandMapper.mapEntityToMusicBandRead(musicBand);
    }
}
