package com.example.bcsd.model;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class Board {
    private Long id;
    private String name;

    public Board updateBoardName(String name) {
        this.name = name;

        return this;
    }
}
