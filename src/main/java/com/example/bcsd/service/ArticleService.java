package com.example.bcsd.service;

import com.example.bcsd.controller.dto.ArticleRequest;
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

    public List<Article> getAllArticles() {
        return articleRepository.findAll();
    }

    public Article getArticleById(Long id) {
        return articleRepository.findById(id);
    }

    public Article createArticle(ArticleRequest request) {
        return articleRepository.save(request.toEntity());
    }

    public Article updateArticleById(Long id, ArticleRequest request) {
        Article article = articleRepository
                .findById(id)
                .update(request.getTitle(), request.getContent());

        return articleRepository.save(id, article);
    }

    public void deleteArticleById(Long id) {
        articleRepository.delete(id);
    }
}
