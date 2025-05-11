package com.example.bcsd.service;

import com.example.bcsd.dto.request.MemberRequest;
import com.example.bcsd.dto.resopnse.MemberResponse;
import com.example.bcsd.model.Member;
import com.example.bcsd.repository.MemberRepositoryImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

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
                                new NoSuchElementException("해당 멤버를 찾을 수 없습니다.")
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
                        new NoSuchElementException("해당 멤버를 찾을 수 없습니다.")
                )
                .update(request.getName(), request.getEmail(), request.getPw());

        return MemberResponse.fromEntity(
                memberRepository.save(id, member)
        );
    }

    public void deleteMember(Long id) {
        memberRepository.delete(id);
    }
}
