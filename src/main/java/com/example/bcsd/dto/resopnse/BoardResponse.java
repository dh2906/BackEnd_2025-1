package com.example.bcsd.dto.resopnse;

import com.example.bcsd.model.Board;
import lombok.Builder;

@Builder
public record BoardResponse(
        Long id,
        String name
) {
    public static BoardResponse fromEntity(Board board) {
        return BoardResponse.builder()
                .id(board.getId())
                .name(board.getName())
                .build();
    }
}
