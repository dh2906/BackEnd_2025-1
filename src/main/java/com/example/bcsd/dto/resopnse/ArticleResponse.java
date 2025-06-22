package com.example.bcsd.dto.resopnse;

import com.example.bcsd.model.Article;
import lombok.Builder;

import java.time.LocalDateTime;

@Builder
public record ArticleResponse(
        Long id,
        String title,
        Long authorId,
        Long boardId,
        String content,
        LocalDateTime createdAt,
        LocalDateTime updatedAt
) {
    public static ArticleResponse fromEntity(Article article) {
        return ArticleResponse.builder()
                .id(article.getId())
                .title(article.getTitle())
                .authorId(article.getAuthor().getId())
                .boardId(article.getBoard().getId())
                .content(article.getContent())
                .createdAt(article.getCreatedAt())
                .updatedAt(article.getUpdatedAt())
                .build();
    }
}
