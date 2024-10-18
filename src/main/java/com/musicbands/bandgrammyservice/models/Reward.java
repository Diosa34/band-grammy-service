package com.musicbands.bandgrammyservice.models;

import com.musicbands.musicbandsservice.models.MusicBand;
import com.musicbands.musicbandsservice.models.MusicGenre;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Reward {
    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    @JoinColumn(name = "musicBand_id", nullable = false)
    private MusicBand musicBand;

    @Column(nullable = false)
    private MusicGenre genre;

    public Reward(MusicBand musicBand, MusicGenre genre) {
        this.musicBand = musicBand;
        this.genre = genre;
    }
}

