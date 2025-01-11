package com.grammyejb.business.mappers;

import com.grammyejb.models.Reward;
import com.grammyejb.schemas.reward.RewardBaseSchema;
import com.grammyejb.schemas.reward.RewardReadSchema;
import jakarta.ejb.Stateless;

@Stateless
public class RewardMapper {
    public Reward mapRewardBaseToEntity(RewardBaseSchema schema, Reward entity) {
        entity.setGenre(schema.getGenre());
        return entity;
    }

    public Reward mapRewardBaseToEntity(RewardBaseSchema schema) {
        return mapRewardBaseToEntity(schema, new Reward());
    }

    public RewardReadSchema mapEntityToReadSchema(Reward entity) {
        RewardReadSchema schema = new RewardReadSchema();
        schema.setId(entity.getId());
        schema.setMusicBandId(entity.getMusicBandId());
        schema.setGenre(entity.getGenre());
        return schema;
    }
}
