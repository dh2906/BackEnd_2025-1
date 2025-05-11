package com.example.bcsd.dto.resopnse;

import com.example.bcsd.model.Article;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
@Builder
public class ArticleViewResponse {
    private String title;
    private String author;
    private String content;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public static ArticleViewResponse formEntity(Article article, String authorName) {
        return ArticleViewResponse.builder()
                .title(article.getTitle())
                .author(authorName)
                .content(article.getContent())
                .createdAt(article.getCreatedAt())
                .updatedAt(article.getUpdatedAt())
                .build();
    }
}

