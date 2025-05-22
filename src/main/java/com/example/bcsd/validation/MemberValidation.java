package com.example.bcsd.validation;

import com.example.bcsd.exception.CustomException;
import com.example.bcsd.exception.ExceptionMessage;
import com.example.bcsd.repository.ArticleRepository;
import com.example.bcsd.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class MemberValidation {
    private final MemberRepository memberRepository;
    private final ArticleRepository articleRepository;

    public void validateEmailDuplicate(String email) {
        memberRepository.findAll()
                .stream()
                .filter(member ->
                        email.equals(member.getEmail()))
                .findFirst()
                .ifPresent(member -> {
                    throw new CustomException(ExceptionMessage.EMAIL_DUPLICATE);
                });
    }

    public void validateMemberExist(Long memberId) {
        memberRepository.findById(memberId)
                .orElseThrow(() ->
                        new CustomException(ExceptionMessage.MEMBER_NOT_FOUND)
                );
    }

    public void validateMemberHasNoArticles(Long memberId) {
        articleRepository.findAll()
                .stream()
                .filter(article -> article.getAuthorId() == memberId)
                .findFirst()
                .ifPresent(article -> {
                    throw new CustomException(ExceptionMessage.MEMBER_HAS_ARTICLES);
                });
    }
}
