package com.akobir.eop.dto;

import jakarta.validation.constraints.NotBlank;

public record BlogCreateDTO(
        @NotBlank(message = "Title cannot be blank!")
        String title,

        @NotBlank(message = "Description cannot be blank!")
        String description,

        Long userId
) {
}
