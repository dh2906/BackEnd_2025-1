package com.example.bcsd.controller;

import com.example.bcsd.dto.request.LoginRequest;
import com.example.bcsd.dto.request.MemberRequest;
import com.example.bcsd.dto.resopnse.MemberResponse;
import com.example.bcsd.service.AuthService;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {
    private final AuthService authService;

    @PostMapping("/register")
    public ResponseEntity<MemberResponse> registerMember(@RequestBody MemberRequest request) {
        MemberResponse response = authService.register(request);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(response);
    }

    @PostMapping("/login")
    public ResponseEntity<MemberResponse> loginMember(
            @RequestBody LoginRequest request,
            HttpServletRequest httpServletRequest
    ) {
        MemberResponse response = authService.login(request);

        HttpSession session = httpServletRequest.getSession(true);

        session.setAttribute("SESSION_ID", response.id());

        return ResponseEntity
                .ok(response);
    }

    @PostMapping("/logout")
    public ResponseEntity<Void> logoutMember(
            HttpServletRequest httpServletRequest,
            HttpServletResponse httpServletResponse
    ) {
        HttpSession session = httpServletRequest.getSession(false);

        if (session != null) {
            session.invalidate();

            Cookie cookie = new Cookie("JSESSIONID", null);
            cookie.setMaxAge(0);
            cookie.setPath("/");
            cookie.setHttpOnly(true);
            httpServletResponse.addCookie(cookie);
        }

        return ResponseEntity.ok().build();
    }
}
