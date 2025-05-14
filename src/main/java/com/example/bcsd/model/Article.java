package com.example.bcsd.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Builder
@AllArgsConstructor
public class Article {
    @Setter
    private Long id;

    private String title;
    private final Long authorId;
    private final Long boardId;
    private String content;
    private final LocalDateTime createdAt;
    private LocalDateTime updatedAt;


    public Article updateDetails(String title, String content) {
        this.title = title;
        this.content = content;
        updatedAt = LocalDateTime.now();

        return this;
    }
}
