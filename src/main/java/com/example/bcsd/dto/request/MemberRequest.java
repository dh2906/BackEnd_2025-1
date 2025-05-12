package com.example.bcsd.dto.request;

import com.example.bcsd.model.Member;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class MemberRequest {
    private String name;
    private String email;
    private String pw;

    public Member toEntity() {
        return Member.builder()
                .name(name)
                .email(email)
                .pw(pw)
                .build();
    }
}
