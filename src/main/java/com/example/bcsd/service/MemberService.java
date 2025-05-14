package com.example.bcsd.service;

import com.example.bcsd.dto.request.MemberRequest;
import com.example.bcsd.dto.resopnse.MemberResponse;
import com.example.bcsd.exception.CustomException;
import com.example.bcsd.exception.ExceptionMessage;
import com.example.bcsd.model.Member;
import com.example.bcsd.repository.MemberRepositoryImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MemberService {
    private final MemberRepositoryImpl memberRepository;

    public List<MemberResponse> getAllMembers() {
        return memberRepository.findAll()
                .stream()
                .map(MemberResponse::fromEntity)
                .toList();
    }

    public MemberResponse getMemberById(Long id) {
        return MemberResponse.fromEntity(
                memberRepository.findById(id)
                        .orElseThrow(() ->
                                new CustomException(ExceptionMessage.MEMBER_NOT_FOUND)
                        )
        );
    }

    public MemberResponse createMember(MemberRequest request) {
        return MemberResponse.fromEntity(
                memberRepository.save(
                        request.toEntity()
                )
        );
    }

    public MemberResponse updateMember(Long id, MemberRequest request) {
        Member member = memberRepository.findById(id)
                .orElseThrow(() ->
                        new CustomException(ExceptionMessage.MEMBER_NOT_FOUND)
                )
                .updatePersonalInformation(request.name(), request.email(), request.pw());

        return MemberResponse.fromEntity(
                memberRepository.save(id, member)
        );
    }

    public void deleteMember(Long id) {
        memberRepository.findById(id)
                .orElseThrow(() ->
                        new CustomException(ExceptionMessage.MEMBER_NOT_FOUND)
                );

        memberRepository.delete(id);
    }
}
