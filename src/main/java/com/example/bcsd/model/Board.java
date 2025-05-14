package com.example.bcsd.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
public class Board {
    @Setter
    private Long id;

    private String name;

    public Board updateBoardName(String name) {
        this.name = name;

        return this;
    }
}
