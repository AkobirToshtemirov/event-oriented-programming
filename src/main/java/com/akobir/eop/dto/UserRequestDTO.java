package com.akobir.eop.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

public record UserRequestDTO(
        @NotBlank(message = "Name cannot be blank!")
        String name,

        @Min(value = 1, message = "Age cannot be negative!")
        Integer age
) {
}
