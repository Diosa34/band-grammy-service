package com.grammyejb.schemas.reward;

import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
public class RewardReadSchema extends RewardBaseSchema {
    @NotNull
    private Long id;

    @NotNull
    private Long musicBandId;
}
