package com.musicbands.bandgrammyservice.schemas.single;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
public class SingleReadSchema extends SingleBaseSchema {
    @Schema(example = "1")
    @NotNull
    private Long id;

    @Schema(example = "1")
    @NotNull
    private Long musicBandId;
}

