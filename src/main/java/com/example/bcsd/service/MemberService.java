package com.example.bcsd.service;

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
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MemberService {
    private final MemberRepository memberRepository;
    private final MemberValidation memberValidation;

    @Transactional(readOnly = true)
    public List<MemberResponse> getAllMembers() {
        return memberRepository.findAll()
                .stream()
                .map(MemberResponse::fromEntity)
                .toList();
    }

    @Transactional(readOnly = true)
    public MemberResponse getMemberById(Long id) {
        return MemberResponse.fromEntity(
                memberRepository.findById(id)
                        .orElseThrow(() ->
                                new CustomException(ExceptionMessage.MEMBER_NOT_FOUND)
                        )
        );
    }

    @Transactional
    public MemberResponse createMember(MemberRequest request) {
        memberValidation.validateEmailDuplicate(request.email());

        String encodedPassword = PasswordEncoder.encode(request.password());

        return MemberResponse.fromEntity(
                memberRepository.save(
                        request.toEntity(encodedPassword)
                )
        );
    }

    @Transactional
    public MemberResponse updateMember(Long id, MemberRequest request) {
        memberValidation.validateEmailDuplicate(request.email());
        memberValidation.validateMemberExist(id);

        Member member = memberRepository.findById(id)
                .get()
                .updatePersonalInformation(
                        request.name(),
                        request.email(),
                        PasswordEncoder.encode(request.password())
                );

        return MemberResponse.fromEntity(member);
    }

    @Transactional
    public void deleteMember(Long id) {
        Member member = memberValidation.validateMemberExistAndGet(id);
        memberValidation.validateMemberHasNoArticles(id);

        memberRepository.delete(member);
    }
}
