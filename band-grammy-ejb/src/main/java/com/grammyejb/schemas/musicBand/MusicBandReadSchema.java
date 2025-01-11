package com.grammyejb.schemas.musicBand;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.grammyejb.utils.jaxb.ZonedDateTimeAdapter;
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
    private Long id;

    @JacksonXmlElementWrapper(useWrapping = false)
    private CoordinatesReadSchema coordinates;

    @Positive
    private Long numberOfParticipants;

    @NotNull
    @XmlJavaTypeAdapter(ZonedDateTimeAdapter.class)
    private ZonedDateTime creationDate;

    @JacksonXmlElementWrapper(useWrapping = false)
    private LabelReadSchema label;
}
