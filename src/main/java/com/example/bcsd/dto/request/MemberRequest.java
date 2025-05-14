package com.example.bcsd.dto.request;

import com.example.bcsd.model.Member;

public record MemberRequest(
        String name,
        String email,
        String pw
) {
    public Member toEntity() {
        return Member.builder()
                .name(name)
                .email(email)
                .pw(pw)
                .build();
    }
}
