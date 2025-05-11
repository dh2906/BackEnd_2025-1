package com.example.bcsd.service;

import com.example.bcsd.dto.resopnse.ArticleViewResponse;
import com.example.bcsd.model.Article;
import com.example.bcsd.model.Member;
import com.example.bcsd.repository.ArticleRepositoryImpl;
import com.example.bcsd.repository.MemberRepositoryImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ArticleViewService {
    private final ArticleRepositoryImpl articleRepository;
    private final MemberRepositoryImpl memberRepository;

    public List<ArticleViewResponse> getAllPostViews() {
        List<Article> articles = articleRepository.findAll();

        return articles.stream()
                .map(article ->
                        ArticleViewResponse.formEntity(
                                article, memberRepository.findById(article.getId())
                                        .map(Member::getName)
                                        .orElse("알 수 없음")
                        )
                ).toList();
    }
}
