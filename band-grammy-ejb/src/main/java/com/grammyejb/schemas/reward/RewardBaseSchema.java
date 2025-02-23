package com.grammyejb.schemas.reward;

import com.grammyejb.models.MusicGenre;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class RewardBaseSchema {
    @NotNull
    private MusicGenre genre;
}
