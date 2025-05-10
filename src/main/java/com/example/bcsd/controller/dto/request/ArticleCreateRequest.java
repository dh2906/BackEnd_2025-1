package com.example.bcsd.controller.dto.request;

import com.example.bcsd.model.Article;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ArticleCreateRequest {
    private String title;
    private Long authorId;
    private Long boardId;
    private String content;

    public Article toEntity() {
        return new Article(title, authorId, boardId, content);
    }
}
