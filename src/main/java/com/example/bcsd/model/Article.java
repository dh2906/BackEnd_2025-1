package com.example.bcsd.model;

import com.example.bcsd.controller.dto.ArticleResponse;

import java.time.LocalDateTime;

public class Article {
    private Long id;
    private String title;
    private Long authorId;
    private Long boardId;
    private String content;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public Article(String title, Long authorId, Long boardId, String content) {
        this.title = title;
        this.authorId = authorId;
        this.boardId = boardId;
        this.content = content;
        this.createdAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();
    }

    public String getTitle() {
        return title;
    }

    public Long getAuthorId() {
        return authorId;
    }

    public Long getBoardId() {
        return boardId;
    }

    public String getContent() {
        return content;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public Article update(String title, String content) {
        this.title = title;
        this.content = content;
        updatedAt = LocalDateTime.now();

        return this;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ArticleResponse toResponse() {
        return new ArticleResponse(title, authorId, boardId, content, createdAt, updatedAt);
    }
}
