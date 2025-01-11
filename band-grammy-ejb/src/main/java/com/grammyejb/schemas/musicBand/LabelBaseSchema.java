package com.grammyejb.schemas.musicBand;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class LabelBaseSchema {
    @NotBlank
    @NotNull
    private String name;
}
