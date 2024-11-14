package com.musicbands.bandgrammyservice.schemas.reward;

import com.musicbands.bandgrammyservice.models.MusicGenre;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class RewardBaseSchema {
    @NotNull
    private MusicGenre genre;
}
