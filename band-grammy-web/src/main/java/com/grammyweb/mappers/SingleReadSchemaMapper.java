package com.grammyweb.mappers;

import com.grammyejb.schemas.single.SingleReadSchema;
import com.grammyweb.jaxbgenerated.SOAPSingleReadSchema;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface SingleReadSchemaMapper {
    SingleReadSchemaMapper MAPPER = Mappers.getMapper(SingleReadSchemaMapper.class);

    SingleReadSchema map(SOAPSingleReadSchema soapSingleReadSchema);
    SOAPSingleReadSchema map(SingleReadSchema SingleReadSchema);
}
