package com.example.bcsd.validation;

import com.example.bcsd.global.exception.CustomException;
import com.example.bcsd.global.exception.ExceptionMessage;
import com.example.bcsd.repository.ArticleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class BoardValidation {
    private final ArticleRepository articleRepository;

    public void validateBoardHasNoArticles(Long boardId) {
        if (!articleRepository.findAllByBoardId(boardId).isEmpty())
            throw new CustomException(ExceptionMessage.BOARD_HAS_ARTICLES);
    }
}
