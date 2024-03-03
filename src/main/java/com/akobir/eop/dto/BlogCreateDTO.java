package com.akobir.eop.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

public record BlogCreateDTO(
        @NotBlank(message = "Title cannot be blank!")
        String title,

        @NotBlank(message = "Description cannot be blank!")
        String description,

        @Min(value = 1, message = "Id cannot be negative!")
        Long userId
) {
}
