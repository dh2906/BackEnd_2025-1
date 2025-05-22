package com.example.bcsd.validation;

import com.example.bcsd.exception.CustomException;
import com.example.bcsd.exception.ExceptionMessage;
import com.example.bcsd.repository.ArticleRepository;
import com.example.bcsd.repository.BoardRepository;
import com.example.bcsd.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ArticleValidation {
    private final ArticleRepository articleRepository;
    private final BoardRepository boardRepository;
    private final MemberRepository memberRepository;

    public void validateAuthorExist(Long authorId) {
        memberRepository
                .findById(authorId)
                .orElseThrow(() ->
                        new CustomException(ExceptionMessage.REFERENCED_RESOURCE_NOT_FOUND)
                );
    }

    public void validateBoardExist(Long boardId) {
        boardRepository
                .findById(boardId)
                .orElseThrow(() ->
                        new CustomException(ExceptionMessage.REFERENCED_RESOURCE_NOT_FOUND)
                );
    }

    public void validateArticleExist(Long articleId) {
        articleRepository
                .findById(articleId)
                .orElseThrow(() ->
                        new CustomException(ExceptionMessage.ARTICLE_NOT_FOUND)
                );
    }
}
