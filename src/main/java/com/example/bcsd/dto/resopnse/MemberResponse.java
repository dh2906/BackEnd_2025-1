package com.example.bcsd.dto.resopnse;

import com.example.bcsd.model.Member;
import lombok.Builder;

@Builder
public record MemberResponse(
        Long id,
        String name,
        String email,
        String role
) {
    public static MemberResponse fromEntity(Member member) {
        return MemberResponse.builder()
                .id(member.getId())
                .name(member.getName())
                .email(member.getEmail())
                .role(member.getRole())
                .build();
    }
}
