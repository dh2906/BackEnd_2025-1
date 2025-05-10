package com.example.bcsd.service;

import com.example.bcsd.controller.dto.ArticleViewResponse;
import com.example.bcsd.model.Article;
import com.example.bcsd.repository.ArticleRepository;
import com.example.bcsd.repository.MemberRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArticleViewService {
    private final ArticleRepository articleRepository;
    private final MemberRepository memberRepository;

    public ArticleViewService(ArticleRepository articleRepository, MemberRepository memberRepository) {
        this.articleRepository = articleRepository;
        this.memberRepository = memberRepository;
    }

    public List<ArticleViewResponse> getAllPostViews() {
        List<Article> articles = articleRepository.findAll();

        return articles.stream()
                .map(article -> new ArticleViewResponse(
                        article.getTitle(),
                        memberRepository.findById(article.getAuthorId()).getName(),
                        article.getContent(),
                        article.getCreatedAt(),
                        article.getUpdatedAt())
                ).toList();
    }
}
