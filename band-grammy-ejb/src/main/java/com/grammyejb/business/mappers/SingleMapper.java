package com.grammyejb.business.mappers;

import com.grammyejb.models.Single;
import com.grammyejb.schemas.single.SingleBaseSchema;
import com.grammyejb.schemas.single.SingleReadSchema;
import jakarta.ejb.Stateless;

@Stateless
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
