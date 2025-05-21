package com.example.bcsd.validation;

import com.example.bcsd.dto.request.ArticleCreateRequest;
import com.example.bcsd.exception.CustomException;
import com.example.bcsd.exception.ExceptionMessage;
import com.example.bcsd.service.BoardService;
import com.example.bcsd.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ArticleValidation {
    private final BoardService boardService;
    private final MemberService memberService;

    public void validateCreateArticle(ArticleCreateRequest request) {
        try {
            memberService.getMemberById(request.authorId());
            boardService.getBoardById(request.boardId());
        } catch(CustomException ex) {
            throw new CustomException(ExceptionMessage.REFERENCED_RESOURCE_NOT_FOUND);
        }
    }
}
