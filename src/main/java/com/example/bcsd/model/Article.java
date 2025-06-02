package com.example.bcsd.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

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
    @CreatedDate
    private LocalDateTime createdAt;

    @Column
    @LastModifiedDate
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
