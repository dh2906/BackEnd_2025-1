package com.example.bcsd.controller.dto.resopnse;

import java.time.LocalDateTime;

public class ArticleResponse {
    private String title;
    private Long authorId;
    private Long boardId;
    private String content;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public ArticleResponse(String title, Long authorId, Long boardId, String content, LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.title = title;
        this.authorId = authorId;
        this.boardId = boardId;
        this.content = content;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
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
}

