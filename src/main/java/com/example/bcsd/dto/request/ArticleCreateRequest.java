package com.example.bcsd.dto.request;

import com.example.bcsd.model.Article;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record ArticleCreateRequest (
        @NotNull
        Long authorId,

        @NotNull
        Long boardId,

        @NotBlank
        @Size(max=255)
        String title,

        @NotBlank
        String content
) {
    public Article toEntity() {
        return Article.builder()
                .title(title)
                .authorId(authorId)
                .boardId(boardId)
                .content(content)
                .build();
    }
}
