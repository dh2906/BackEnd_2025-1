package com.example.bcsd.dto.request;

import com.example.bcsd.model.Board;

public record BoardRequest(
        String name
) {
    public Board toEntity() {
        return Board.builder()
                .name(name)
                .build();
    }
}
