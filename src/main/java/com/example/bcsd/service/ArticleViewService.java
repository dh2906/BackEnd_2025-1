package com.example.bcsd.service;

import com.example.bcsd.dto.resopnse.ArticleViewResponse;
import com.example.bcsd.model.Article;
import com.example.bcsd.repository.ArticleRepository;
import com.example.bcsd.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ArticleViewService {
    private final ArticleRepository articleRepository;
    private final MemberRepository memberRepository;

    public List<ArticleViewResponse> getAllPostViews() {
        List<Article> articles = articleRepository.findAll();

        return articles.stream()
                .map(article ->
                        ArticleViewResponse.formEntity(
                                article, memberRepository.findById(article.getId()).getName()
                        )
                ).toList();
    }
}
