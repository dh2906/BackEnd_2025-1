package com.example.bcsd.controller.dto.request;

import com.example.bcsd.model.Article;

public class ArticleCreateRequest {
    private String title;
    private Long authorId;
    private Long boardId;
    private String content;

    public ArticleCreateRequest(String title, Long authorId, Long boardId, String content) {
        this.title = title;
        this.authorId = authorId;
        this.boardId = boardId;
        this.content = content;
    }

    public Article toEntity() {
        return new Article(title, authorId, boardId, content);
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    public Long getAuthorId() {
        return authorId;
    }
}
