package com.musicbands.bandgrammyservice.schemas.single;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class SingleBaseSchema {
    @Schema(example = "Awesome single")
    @NotBlank
    @Size(max = 128)
    private String name;

    @Schema(example = "Uplifting and introspective anthem.")
    @NotBlank
    @Size(max = 512)
    private String description;
}

