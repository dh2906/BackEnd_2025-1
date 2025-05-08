package com.example.bcsd.model;

import java.time.LocalDateTime;

public class Article {
    private String title;
    private String author;
    private String content;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public Article(String title, String author, String content) {
        this.title = title;
        this.author = author;
        this.content = content;
        this.createdAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
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
}
