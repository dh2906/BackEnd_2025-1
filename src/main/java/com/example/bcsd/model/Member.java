package com.example.bcsd.model;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.ColumnDefault;

import java.util.List;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 100, nullable = false)
    private String name;

    @Column(length = 100, nullable = false)
    private String email;

    @Column(nullable = false)
    private String password;

    @Column(length = 100)
    @ColumnDefault("user")
    private String role;

    @OneToMany(mappedBy = "author")
    private List<Article> articles;

    public Member updatePersonalInformation(String name, String email, String password) {
        this.name = name;
        this.email = email;
        this.password = password;

        return this;
    }
}
