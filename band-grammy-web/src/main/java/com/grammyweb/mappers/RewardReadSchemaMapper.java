package com.grammyweb.mappers;

import com.grammyejb.schemas.reward.RewardReadSchema;
import com.grammyweb.jaxbgenerated.SOAPRewardReadSchema;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface RewardReadSchemaMapper {
    RewardReadSchemaMapper MAPPER = Mappers.getMapper(RewardReadSchemaMapper.class);

    RewardReadSchema map(SOAPRewardReadSchema soapRewardReadSchema);
    SOAPRewardReadSchema map(RewardReadSchema rewardReadSchema);
}
