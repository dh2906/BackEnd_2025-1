package com.example.bcsd.validation;

import com.example.bcsd.global.exception.CustomException;
import com.example.bcsd.global.exception.ExceptionMessage;
import com.example.bcsd.model.Member;
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

    public Member validateMemberExistAndGet(Long memberId) {
        return memberRepository
                .findById(memberId)
                .orElseThrow(() ->
                        new CustomException(ExceptionMessage.REFERENCED_RESOURCE_NOT_FOUND)
                );
    }

    public void validateMemberExist(Long memberId) {
        validateMemberExistAndGet(memberId);
    }

    public void validateMemberHasNoArticles(Long memberId) {
        articleRepository.findAll()
                .stream()
                .filter(article -> article.getAuthor().getId() == memberId)
                .findFirst()
                .ifPresent(article -> {
                    throw new CustomException(ExceptionMessage.MEMBER_HAS_ARTICLES);
                });
    }
}
