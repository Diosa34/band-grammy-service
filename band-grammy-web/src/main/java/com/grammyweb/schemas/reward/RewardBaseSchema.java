package com.grammyweb.schemas.reward;

import com.grammyweb.models.MusicGenre;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class RewardBaseSchema {
    @NotNull
    private MusicGenre genre;
}
