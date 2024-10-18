package com.musicbands.bandgrammyservice.mappers;

import com.musicbands.bandgrammyservice.models.Single;
import com.musicbands.bandgrammyservice.schemas.SingleBaseSchema;
import com.musicbands.bandgrammyservice.schemas.SingleReadSchema;
import com.musicbands.musicbandsservice.exceptions.NotFoundException;
import com.musicbands.musicbandsservice.repositories.MusicBandRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class SingleMapper {
    private final MusicBandRepository musicBandRepository;

    public SingleReadSchema mapEntityToSingleRead(Single entity) {
        SingleReadSchema schema = new SingleReadSchema();
        schema.setMusicBandId(entity.getMusicBand().getId());
        schema.setName(entity.getName());
        schema.setDescription(entity.getDescription());
        return schema;
    }

    public Single mapSingleBaseToEntity(Long bandId, SingleBaseSchema schema) {
        Single entity = new Single();
        entity.setMusicBand(
                musicBandRepository.findById(bandId).orElseThrow(
                        () -> new NotFoundException(bandId, "Музыкальная группа")
        ));
        entity.setName(schema.getName());
        entity.setDescription(schema.getDescription());
        return entity;
    }
}
