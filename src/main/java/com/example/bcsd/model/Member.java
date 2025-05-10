package com.example.bcsd.model;

import com.example.bcsd.controller.dto.resopnse.MemberResponse;

public class Member {
    private Long id;
    private String name;
    private String email;
    private String pw;

    public Member(String name, String email, String pw) {
        this.name = name;
        this.email = email;
        this.pw = pw;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPw() {
        return pw;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Member update(String name, String email, String pw) {
        this.name = name;
        this.email = email;
        this.pw = pw;

        return this;
    }

    public MemberResponse toResponse() {
        return new MemberResponse(id, name, email);
    }
}
