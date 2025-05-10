package com.example.bcsd.controller.dto.request;

import com.example.bcsd.model.Member;

public class MemberRequest {
    private String name;
    private String email;
    private String pw;

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPw() {
        return pw;
    }

    public Member toEntity() {
        return new Member(name, email, pw);
    }
}
