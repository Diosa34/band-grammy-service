package com.grammyejb.schemas.single;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class SingleBaseSchema {
    @NotBlank
    @Size(max = 128)
    private String name;

    @NotBlank
    @Size(max = 512)
    private String description;
}

