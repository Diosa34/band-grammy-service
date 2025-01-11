package com.grammyejb.schemas.musicBand;

import com.grammyejb.models.MusicGenre;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class MusicBandBaseSchema {
    @NotBlank
    @NotNull
    private String name;

    @Positive
    private Long numberOfParticipants;

    private String description;

    @NotNull
    private MusicGenre genre;
}

