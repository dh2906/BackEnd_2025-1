package com.example.bcsd.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Builder
@AllArgsConstructor
public class Member {
    @Setter
    private Long id;

    private String name;
    private String email;
    private String pw;

    public Member updatePersonalInformation(String name, String email, String pw) {
        this.name = name;
        this.email = email;
        this.pw = pw;

        return this;
    }
}
