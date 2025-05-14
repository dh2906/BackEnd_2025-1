package com.example.bcsd.dto.request;

import com.example.bcsd.model.Article;

public record ArticleCreateRequest (
        String title,
        Long authorId,
        Long boardId,
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
