package com.example.bcsd.global.exception;

import lombok.Getter;

@Getter
public enum ExceptionMessage {
    ARTICLE_NOT_FOUND(404, "해당 게시글을 찾을 수 없습니다."),
    MEMBER_NOT_FOUND(404, "해당 멤버를 찾을 수 없습니다."),
    BOARD_NOT_FOUND(404, "해당 게시판을 찾을 수 없습니다."),
    REFERENCED_RESOURCE_NOT_FOUND(400, "존재하지 않는 자원을 참조하고 있습니다."),
    EMAIL_DUPLICATE(409, "이미 존재하는 이메일입니다."),
    MEMBER_HAS_ARTICLES(400, "작성한 게시글이 존재하여 삭제할 수 없습니다."),
    BOARD_NAME_DUPLICATE(409, "이미 존재하는 게시판 이름입니다."),
    INVALID_PASSWORD(400, "비밀번호가 일치하지 않습니다."),
    UNAUTHORIZED_USER(401, "로그인이 필요합니다."),
    ACCESS_DENIED(404, "접근 권한이 없습니다.");

    private final int status;
    private final String message;

    ExceptionMessage(int status, String message) {
        this.status = status;
        this.message = message;
    }
}
