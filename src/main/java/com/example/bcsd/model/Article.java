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
    private Long authorId;
    private Long boardId;
    private String content;
    private final LocalDateTime createdAt;
    private LocalDateTime updatedAt;


    public Article updateDetails(
            Long authorId,
            Long boardId,
            String title,
            String content
    ) {
        this.authorId = authorId;
        this.boardId = boardId;
        this.title = title;
        this.content = content;
        updatedAt = LocalDateTime.now();

        return this;
    }
}
