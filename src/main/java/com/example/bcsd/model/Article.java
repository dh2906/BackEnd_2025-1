package com.example.bcsd.model;

import com.example.bcsd.controller.dto.resopnse.ArticleResponse;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
public class Article {
    @Setter
    private Long id;

    private String title;
    private final Long authorId;
    private final Long boardId;
    private String content;
    private final LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public Article(String title, Long authorId, Long boardId, String content) {
        this.title = title;
        this.authorId = authorId;
        this.boardId = boardId;
        this.content = content;
        this.createdAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();
    }

    public Article update(String title, String content) {
        this.title = title;
        this.content = content;
        updatedAt = LocalDateTime.now();

        return this;
    }

    public ArticleResponse toResponse() {
        return new ArticleResponse(title, authorId, boardId, content, createdAt, updatedAt);
    }
}
