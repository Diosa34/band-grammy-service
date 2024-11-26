package com.musicbands.bandgrammyservice.schemas.musicBand;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class LabelReadSchema extends LabelBaseSchema {
    private Long id;
}
