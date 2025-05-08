package com.example.bcsd.controller.dto;

import com.example.bcsd.model.Article;

public class ArticleCreateRequest {
    private String title;
    private String author;
    private String content;

    public ArticleCreateRequest(String title, String author, String content) {
        this.title = title;
        this.author = author;
        this.content = content;
    }

    public Article toEntity() {
        return new Article(title, author, content);
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    public String getAuthor() {
        return author;
    }
}
