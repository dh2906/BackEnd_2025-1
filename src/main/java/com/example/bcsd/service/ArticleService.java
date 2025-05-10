package com.example.bcsd.service;

import com.example.bcsd.controller.dto.request.ArticleCreateRequest;
import com.example.bcsd.controller.dto.resopnse.ArticleResponse;
import com.example.bcsd.controller.dto.request.ArticleUpdateRequest;
import com.example.bcsd.model.Article;
import com.example.bcsd.repository.ArticleRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArticleService {
    private final ArticleRepository articleRepository;

    public ArticleService(ArticleRepository articleRepository) {
        this.articleRepository = articleRepository;
    }

    public List<ArticleResponse> getAllArticles() {
        return articleRepository.findAll()
                .stream()
                .map(Article::toResponse)
                .toList();
    }

    public ArticleResponse getArticleById(Long id) {
        return articleRepository.findById(id)
                .toResponse();
    }

    public ArticleResponse createArticle(ArticleCreateRequest request) {
        return articleRepository.save(request.toEntity())
                .toResponse();
    }

    public ArticleResponse updateArticleById(Long id, ArticleUpdateRequest request) {
        Article article = articleRepository
                .findById(id)
                .update(request.getTitle(), request.getContent());

        return articleRepository.save(id, article)
                .toResponse();
    }

    public void deleteArticleById(Long id) {
        articleRepository.delete(id);
    }
}
