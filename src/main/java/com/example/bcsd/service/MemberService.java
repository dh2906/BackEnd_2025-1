package com.example.bcsd.service;

import com.example.bcsd.dto.request.MemberRequest;
import com.example.bcsd.dto.resopnse.MemberResponse;
import com.example.bcsd.model.Member;
import com.example.bcsd.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MemberService {
    private final MemberRepository memberRepository;

    public List<MemberResponse> getAllMembers() {
        return memberRepository.findAll()
                .stream()
                .map(MemberResponse::fromEntity)
                .toList();
    }

    public MemberResponse getMemberById(Long id) {
        return MemberResponse.fromEntity(
                memberRepository.findById(id)
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
                .update(request.getName(), request.getEmail(), request.getPw());

        return MemberResponse.fromEntity(
                memberRepository.save(id, member)
        );
    }

    public void deleteMember(Long id) {
        memberRepository.delete(id);
    }
}
