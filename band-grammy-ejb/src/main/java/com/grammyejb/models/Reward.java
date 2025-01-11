package com.grammyejb.models;

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

    @Column(nullable = false)
    private Long musicBandId;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private MusicGenre genre;
}
