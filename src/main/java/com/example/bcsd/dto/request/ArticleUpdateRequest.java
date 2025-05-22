package com.example.bcsd.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record ArticleUpdateRequest (
        @NotNull
        Long authorId,

        @NotNull
        Long boardId,

        @NotBlank
        @Size(max=255)
        String title,

        @NotBlank
        String content
) { }
