package com.musicbands.bandgrammyservice.services.mappers;

import com.musicbands.bandgrammyservice.models.Single;
import com.musicbands.bandgrammyservice.schemas.single.SingleBaseSchema;
import com.musicbands.bandgrammyservice.schemas.single.SingleReadSchema;
import org.springframework.stereotype.Service;

@Service
public class SingleMapper {
    public Single mapSingleBaseToEntity(SingleBaseSchema schema, Single entity) {
        entity.setName(schema.getName());
        entity.setDescription(schema.getDescription());
        return entity;
    }

    public Single mapSingleBaseToEntity(SingleBaseSchema schema) {
        return mapSingleBaseToEntity(schema, new Single());
    }

    public SingleReadSchema mapEntityToReadSchema(Single entity) {
        SingleReadSchema schema = new SingleReadSchema();
        schema.setId(entity.getId());
        schema.setMusicBandId(entity.getMusicBandId());
        schema.setName(entity.getName());
        schema.setDescription(entity.getDescription());
        return schema;
    }
}
