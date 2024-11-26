package com.musicbands.bandgrammyservice.schemas.musicBand;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.musicbands.bandgrammyservice.utils.jaxb.ZonedDateTimeAdapter;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.time.ZonedDateTime;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@XmlRootElement(name = "MusicBandReadSchema")
@XmlAccessorType(XmlAccessType.FIELD)
public class MusicBandReadSchema extends MusicBandBaseSchema {
    @Schema(example = "1")
    private Long id;

    @JacksonXmlElementWrapper(useWrapping = false)
    private CoordinatesReadSchema coordinates;

    @Schema(example = "70")
    @Positive
    private Long numberOfParticipants;

    @Schema(example = "2022-09-19T00:00:10Z")
    @NotNull
    @XmlJavaTypeAdapter(ZonedDateTimeAdapter.class)
    private ZonedDateTime creationDate;

    @JacksonXmlElementWrapper(useWrapping = false)
    private LabelReadSchema label;
}
