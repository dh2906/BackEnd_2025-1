package com.example.bcsd.global.interceptor;

import com.example.bcsd.dto.resopnse.ArticleResponse;
import com.example.bcsd.dto.resopnse.MemberResponse;
import com.example.bcsd.global.exception.CustomException;
import com.example.bcsd.global.exception.ExceptionMessage;
import com.example.bcsd.service.ArticleService;
import com.example.bcsd.service.MemberService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

@Component
@RequiredArgsConstructor
public class AuthorizationInterceptor implements HandlerInterceptor {
    private final ArticleService articleService;
    private final MemberService memberService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String method = request.getMethod();
        String uri = request.getRequestURI();

        if (method.equalsIgnoreCase("GET") || method.equalsIgnoreCase("POST"))
            return true;

        HttpSession session = request.getSession(false);
        Long loginUserId = (Long)session.getAttribute("SESSION_ID");

        MemberResponse loginMember = memberService.getMemberById(loginUserId);
        Long targetId = extractIdFromUri(uri);

        if (loginMember.role().equals("admin"))
            return true;

        else if (uri.startsWith("/articles/")) {
            ArticleResponse article = articleService.getArticleById(targetId);

            if (!article.authorId().equals(loginUserId))
                throw new CustomException(ExceptionMessage.ACCESS_DENIED);

            return true;
        }

        else if (uri.startsWith("/members/")) {
            MemberResponse member = memberService.getMemberById(targetId);

            if (!member.id().equals(loginUserId))
                throw new CustomException(ExceptionMessage.ACCESS_DENIED);

            return true;
        }

        throw new CustomException(ExceptionMessage.ACCESS_DENIED);
    }

    public Long extractIdFromUri(String uri) {
        String[] segments = uri.split("/");
        return Long.parseLong(segments[segments.length - 1]);
    }
}
