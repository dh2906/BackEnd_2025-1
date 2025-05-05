package com.example.bcsd.controller.dto;

import com.example.bcsd.model.Article;

public class ArticleRequest {
    private String title;
    private String content;

    public ArticleRequest(String title, String content) {
        this.title = title;
        this.content = content;
    }

    public Article toEntity() {
        return new Article(title, content);
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }
}
