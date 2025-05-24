package com.example.bcsd.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record ArticleUpdateRequest (
        @NotNull(message = "작성자 ID가 누락되었습니다.")
        Long authorId,

        @NotNull(message = "게시판 ID가 누락되었습니다.")
        Long boardId,

        @NotBlank(message = "제목이 누락되었습니다.")
        @Size(max=255, message = "제목의 최대 길이를 벗어났습니다. (최대 길이 : 255자)")
        String title,

        @NotBlank(message = "본문이 누락되었습니다.")
        String content
) { }
