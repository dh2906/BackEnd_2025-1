package com.example.bcsd.exception;

import lombok.Getter;

@Getter
public enum ExceptionMessage {
    ARTICLE_NOT_FOUND("해당 게시글을 찾을 수 없습니다."),
    MEMBER_NOT_FOUND("해당 멤버를 찾을 수 없습니다.");

    private final String message;

    ExceptionMessage(String message) {
        this.message = message;
    }
}
