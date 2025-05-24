package com.example.bcsd.dto.request;

import com.example.bcsd.model.Board;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record BoardRequest(
        @NotNull(message = "게시판 이름이 누락되었습니다.")
        @Size(max = 100, message = "게시판 이름의 최대 길이를 벗어났습니다. (최대 길이 : 100자)")
        String name
) {
    public Board toEntity() {
        return Board.builder()
                .name(name)
                .build();
    }
}
