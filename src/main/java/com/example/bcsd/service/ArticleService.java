package com.example.bcsd.service;

import com.example.bcsd.dto.request.ArticleCreateRequest;
import com.example.bcsd.dto.resopnse.ArticleResponse;
import com.example.bcsd.dto.request.ArticleUpdateRequest;
import com.example.bcsd.model.Article;
import com.example.bcsd.repository.ArticleRepositoryImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ArticleService {
    private final ArticleRepositoryImpl articleRepository;

    public List<ArticleResponse> getAllArticles() {
        return articleRepository.findAll()
                .stream()
                .map(ArticleResponse::fromEntity)
                .toList();
    }

    public ArticleResponse getArticleById(Long id) {
        return ArticleResponse.fromEntity(
                articleRepository.findById(id)
        );
    }

    public ArticleResponse createArticle(ArticleCreateRequest request) {
        return ArticleResponse.fromEntity(
                articleRepository.save(
                        request.toEntity()
                )
        );
    }

    public ArticleResponse updateArticleById(Long id, ArticleUpdateRequest request) {
        Article article = articleRepository
                .findById(id)
                .update(request.getTitle(), request.getContent());

        return ArticleResponse.fromEntity(
                articleRepository.save(id, article)
        );
    }

    public void deleteArticleById(Long id) {
        articleRepository.delete(id);
    }
}
