package com.example.bcsd.validation;

import com.example.bcsd.exception.CustomException;
import com.example.bcsd.exception.ExceptionMessage;
import com.example.bcsd.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class MemberValidation {
    private final MemberService memberService;

    public void validateEmailDuplicate(String email) {
        memberService.getAllMembers()
                .stream()
                .filter((member) ->
                        email.equals(
                                member.email()
                        )
                )
                .findFirst()
                .orElseThrow(() -> new CustomException(ExceptionMessage.EMAIL_DUPLICATE));
    }

    public void validateMemberExist(Long memberId) {
        memberService.getMemberById(memberId);
    }
}
