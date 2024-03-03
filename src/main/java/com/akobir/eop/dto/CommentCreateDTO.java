package com.akobir.eop.dto;

import jakarta.validation.constraints.NotBlank;

public record CommentCreateDTO(
        Long blogId,
        Long userId,
        @NotBlank(message = "Message cannot be blank!")
        String message
) {
}
