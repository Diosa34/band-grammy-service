package com.grammyejb.schemas.musicBand;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class CoordinatesBaseSchema {
    @NotNull
    @Min(-531)
    private Double x;

    @NotNull
    private Long y;
}
