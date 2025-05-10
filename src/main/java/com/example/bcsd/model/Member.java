package com.example.bcsd.model;

import com.example.bcsd.controller.dto.resopnse.MemberResponse;
import lombok.Getter;
import lombok.Setter;

@Getter
public class Member {
    @Setter
    private Long id;

    private String name;
    private String email;
    private String pw;

    public Member(String name, String email, String pw) {
        this.name = name;
        this.email = email;
        this.pw = pw;
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
