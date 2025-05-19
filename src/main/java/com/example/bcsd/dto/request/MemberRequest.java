package com.example.bcsd.dto.request;

import com.example.bcsd.model.Member;
import org.mindrot.jbcrypt.BCrypt;

public record MemberRequest(
        String name,
        String email,
        String password
) {
    public MemberRequest(String name, String email, String password) {
        this.name = name;
        this.email = email;
        this.password = BCrypt.hashpw(password, BCrypt.gensalt());
    }
    public Member toEntity() {
        return Member.builder()
                .name(name)
                .email(email)
                .password(password)
                .build();
    }
}
