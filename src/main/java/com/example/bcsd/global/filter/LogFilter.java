package com.example.bcsd.global.filter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
import org.springframework.web.util.ContentCachingRequestWrapper;

import java.io.IOException;

@Slf4j
@Component
public class LogFilter extends OncePerRequestFilter {
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        ContentCachingRequestWrapper wrappedRequest = new ContentCachingRequestWrapper(request);

        log.info("-----------------------------------------");

        filterChain.doFilter(wrappedRequest, response);

        String method = wrappedRequest.getMethod();

        if (method.equals("POST") || method.equals("PUT")) {
            String body = new String(wrappedRequest.getContentAsByteArray(), wrappedRequest.getCharacterEncoding());

            log.info("[요청 Body] : {}", body.replaceAll("\\s{2,}", ""));
        }

        log.info("-----------------------------------------");
    }
}
