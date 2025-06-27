package com.example.bcsd.global.filter;

import com.example.bcsd.global.exception.CustomException;
import com.example.bcsd.global.exception.ExceptionMessage;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
@Order(2)
public class LoginCheckFilter extends OncePerRequestFilter {
    private boolean isOpenAPI(HttpServletRequest httpServletRequest) {
        String uri = httpServletRequest.getRequestURI();
        String method = httpServletRequest.getMethod();

        if (uri.startsWith("/auth")) {
            return true;
        }

        if (method.equals("GET") && (uri.startsWith("/articles") || uri.startsWith("/boards"))) {
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
