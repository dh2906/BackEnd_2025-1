package com.example.bcsd.global.filter;

import com.example.bcsd.global.exception.CustomException;
import com.example.bcsd.global.exception.ExceptionMessage;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

public class LoginCheckFilter extends OncePerRequestFilter {
    private boolean isOpenAPI(HttpServletRequest httpServletRequest) {
        String method = httpServletRequest.getMethod();

        if (method.equals("GET")) {
            return true;
        }

        return false;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        if (isOpenAPI(request)) {
            filterChain.doFilter(request, response);
            return;
        }

        HttpSession session = request.getSession(false);

        if (session == null || session.getAttribute("SESSION_ID") == null)
            throw new CustomException(ExceptionMessage.UNAUTHORIZED_USER);

        filterChain.doFilter(request, response);
    }
}
