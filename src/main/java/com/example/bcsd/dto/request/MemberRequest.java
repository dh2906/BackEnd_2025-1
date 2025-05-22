package com.example.bcsd.dto.request;

import com.example.bcsd.dto.deserializer.PasswordBcryptDeserializer;
import com.example.bcsd.model.Member;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

public record MemberRequest(
        String name,
        String email,

        @JsonDeserialize(using = PasswordBcryptDeserializer.class )
        String password
) {
    public MemberRequest(String name, String email, String password) {
        this.name = name;
        this.email = email;
        this.password = password;
    }
    public Member toEntity() {
        return Member.builder()
                .name(name)
                .email(email)
                .password(password)
                .build();
    }
}
