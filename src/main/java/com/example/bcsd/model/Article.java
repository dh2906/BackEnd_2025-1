package com.example.bcsd.model;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Article {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String title;

    @Column
    private Long authorId;

    @Column
    private Long boardId;

    @Column
    private String content;

    @Column
    @CreationTimestamp
    private LocalDateTime createdAt;

    @Column
    private LocalDateTime updatedAt;


    public Article updateDetails(
            Long authorId,
            Long boardId,
            String title,
            String content
    ) {
        this.authorId = authorId;
        this.boardId = boardId;
        this.title = title;
        this.content = content;
        updatedAt = LocalDateTime.now();

        return this;
    }
}
