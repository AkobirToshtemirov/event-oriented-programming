package com.akobir.eop.dto;

import jakarta.validation.constraints.NotBlank;

public record CommentUpdateDTO(
        @NotBlank(message = "Message cannot be blank!")
        String message
) {
}
