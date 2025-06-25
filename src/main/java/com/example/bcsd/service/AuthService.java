package com.example.bcsd.service;

import com.example.bcsd.dto.request.MemberRequest;
import com.example.bcsd.dto.resopnse.MemberResponse;
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

        return MemberResponse.fromEntity(
                memberRepository.save(
                        request.toEntity()
                )
        );
    }
}
