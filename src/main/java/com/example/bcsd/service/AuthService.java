package com.example.bcsd.service;

import com.example.bcsd.dto.request.LoginRequest;
import com.example.bcsd.dto.request.MemberRequest;
import com.example.bcsd.dto.resopnse.MemberResponse;
import com.example.bcsd.global.exception.CustomException;
import com.example.bcsd.global.exception.ExceptionMessage;
import com.example.bcsd.global.util.PasswordEncoder;
import com.example.bcsd.model.Member;
import com.example.bcsd.repository.MemberRepository;
import com.example.bcsd.validation.MemberValidation;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {
    private final MemberRepository memberRepository;
    private final MemberValidation memberValidation;

    public MemberResponse register(MemberRequest request) {
        memberValidation.validateEmailDuplicate(request.email());

        String encodedPassword = PasswordEncoder.encode(request.password());

        return MemberResponse.fromEntity(
                memberRepository.save(
                        request.toEntity(encodedPassword)
                )
        );
    }

    public MemberResponse login(LoginRequest request) {
        String email = request.email();

        Member member = memberRepository
                .findByEmail(email)
                .orElseThrow(() -> new CustomException(ExceptionMessage.MEMBER_NOT_FOUND));

        if (!PasswordEncoder.matches(request.password(), member.getPassword())) {
            throw new CustomException(ExceptionMessage.INVALID_PASSWORD);
        }

        return MemberResponse.fromEntity(member);
    }
}
