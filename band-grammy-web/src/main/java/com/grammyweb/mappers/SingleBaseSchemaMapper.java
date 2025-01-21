package com.grammyweb.mappers;

import com.grammyejb.schemas.single.SingleBaseSchema;
import com.grammyweb.jaxbgenerated.SOAPSingleBaseSchema;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface SingleBaseSchemaMapper {
    SingleBaseSchemaMapper MAPPER = Mappers.getMapper(SingleBaseSchemaMapper.class);

    SingleBaseSchema map(SOAPSingleBaseSchema soapSingleBaseSchema);
    SOAPSingleBaseSchema map(SingleBaseSchema SingleBaseSchema);
}
