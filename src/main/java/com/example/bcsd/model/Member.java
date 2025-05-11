package com.example.bcsd.model;

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
}
