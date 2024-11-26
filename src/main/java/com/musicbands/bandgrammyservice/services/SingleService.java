package com.musicbands.bandgrammyservice.services;

import com.musicbands.bandgrammyservice.models.Single;
import com.musicbands.bandgrammyservice.repositories.SingleRepository;
import com.musicbands.bandgrammyservice.schemas.single.SingleBaseSchema;
import com.musicbands.bandgrammyservice.schemas.single.SingleReadSchema;
import com.musicbands.bandgrammyservice.services.external.MusicBandService;
import com.musicbands.bandgrammyservice.services.mappers.SingleMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class SingleService {
    private final SingleMapper singleMapper;
    private final SingleRepository singleRepository;
    private final MusicBandService musicBandService;

    public SingleReadSchema createSingle(Long toMusicBand, SingleBaseSchema schema) {
        musicBandService.getMusicBand(toMusicBand);
        Single newSingle = singleMapper.mapSingleBaseToEntity(schema);
        newSingle.setMusicBandId(toMusicBand);
        newSingle = singleRepository.save(newSingle);
        return singleMapper.mapEntityToReadSchema(newSingle);
    }
}
