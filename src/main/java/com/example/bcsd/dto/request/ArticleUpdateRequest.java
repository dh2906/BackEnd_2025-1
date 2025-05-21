package com.example.bcsd.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record ArticleUpdateRequest (
        @NotBlank
        @Size(max=255)
        String title,

        @NotBlank
        String content
) { }
