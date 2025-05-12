package com.example.bcsd.dto.request;

import com.example.bcsd.model.Article;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ArticleCreateRequest {
    private String title;
    private Long authorId;
    private Long boardId;
    private String content;

    public Article toEntity() {
        return Article.builder()
                .title(title)
                .authorId(authorId)
                .boardId(boardId)
                .content(content)
                .build();
    }
}
