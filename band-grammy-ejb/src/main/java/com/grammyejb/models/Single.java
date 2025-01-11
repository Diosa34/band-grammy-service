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
public class Single {
    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false)
    private Long MusicBandId;

    @Column(length = 128)
    private String name;

    @Column(length = 512)
    private String description;
}
