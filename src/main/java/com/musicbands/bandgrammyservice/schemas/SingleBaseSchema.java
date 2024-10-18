package com.musicbands.bandgrammyservice.schemas;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class SingleBaseSchema {
    @Schema(example = "First single")
    private String name;

    @Schema(example = "Awesome single")
    private String description;
}
