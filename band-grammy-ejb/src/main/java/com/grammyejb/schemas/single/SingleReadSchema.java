package com.grammyejb.schemas.single;

import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
public class SingleReadSchema extends SingleBaseSchema {
    @NotNull
    private Long id;

    @NotNull
    private Long musicBandId;
}

