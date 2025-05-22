package com.example.bcsd.validation;

import com.example.bcsd.exception.CustomException;
import com.example.bcsd.exception.ExceptionMessage;
import com.example.bcsd.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class MemberValidation {
    private final MemberRepository memberRepository;

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
}
