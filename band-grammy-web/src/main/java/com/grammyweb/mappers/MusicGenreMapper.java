package com.grammyweb.mappers;

import com.grammyejb.models.MusicGenre;
import com.grammyweb.jaxbgenerated.SoapMusicGenre;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
        componentModel = MappingConstants.ComponentModel.SPRING,
        unmappedTargetPolicy = ReportingPolicy.IGNORE
)
public interface MusicGenreMapper {
    MusicGenreMapper MAPPER = Mappers.getMapper(MusicGenreMapper.class);

    MusicGenre map(SoapMusicGenre soapMusicGenre);
    SoapMusicGenre map(MusicGenre musicGenre);
}
