package com.example.bcsd.validation;

import com.example.bcsd.global.exception.CustomException;
import com.example.bcsd.global.exception.ExceptionMessage;
import com.example.bcsd.model.Article;
import com.example.bcsd.repository.ArticleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ArticleValidation {
    private final ArticleRepository articleRepository;

    public Article validateArticleExistAndGet(Long articleId) {
        return articleRepository
                .findById(articleId)
                .orElseThrow(() ->
                        new CustomException(ExceptionMessage.ARTICLE_NOT_FOUND)
                );
    }

    public void validateArticleExist(Long articleId) {
        validateArticleExistAndGet(articleId);
    }
}
