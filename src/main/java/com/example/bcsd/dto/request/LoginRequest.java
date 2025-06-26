package com.example.bcsd.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record LoginRequest(
        @NotNull(message = "이메일이 누락되었습니다.")
        @Size(max = 100, message = "이메일의 최대 길이를 벗어났습니다. (최대 길이 : 100자)")
        @Email
        String email,

        @NotNull(message = "비밀번호가 누락되었습니다.")
        @Size(max = 255, message = "비밀번호의 최대 길이를 벗어났습니다. (최대 길이 : 100자)")
        String password
) {

}
