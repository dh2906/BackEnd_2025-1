package com.example.bcsd.service;

import com.example.bcsd.controller.dto.request.MemberRequest;
import com.example.bcsd.controller.dto.resopnse.MemberResponse;
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
                .map(Member::toResponse)
                .toList();
    }

    public MemberResponse getMemberById(Long id) {
        return memberRepository.findById(id)
                .toResponse();
    }

    public MemberResponse createMember(MemberRequest request) {
        return memberRepository.save(request.toEntity())
                .toResponse();
    }

    public MemberResponse updateMember(Long id, MemberRequest request) {
        Member member = memberRepository.findById(id)
                .update(request.getName(), request.getEmail(), request.getPw());

        return memberRepository.save(id, member)
                .toResponse();
    }

    public void deleteMember(Long id) {
        memberRepository.delete(id);
    }
}
