package com.musicbands.bandgrammyservice.services.mappers;

import com.musicbands.bandgrammyservice.models.Reward;
import com.musicbands.bandgrammyservice.schemas.reward.RewardBaseSchema;
import com.musicbands.bandgrammyservice.schemas.reward.RewardReadSchema;
import org.springframework.stereotype.Service;

@Service
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
