package com.example.bcsd.model;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter
    private Long id;

    @Column
    private String name;

    @Column
    private String email;

    @Column
    private String password;

    public Member updatePersonalInformation(String name, String email, String password) {
        this.name = name;
        this.email = email;
        this.password = password;

        return this;
    }
}
