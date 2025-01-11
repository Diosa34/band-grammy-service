package com.grammyejb.schemas.musicBand;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class CoordinatesReadSchema extends CoordinatesBaseSchema {
    private Long id;
}
