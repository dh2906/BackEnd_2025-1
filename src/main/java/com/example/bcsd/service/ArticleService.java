package com.example.bcsd.service;

import com.example.bcsd.model.Article;
import com.example.bcsd.repository.ArticleRepository;
import org.springframework.stereotype.Service;

@Service
public class ArticleService {
    private final ArticleRepository articleRepository;

    public ArticleService(ArticleRepository articleRepository) {
        this.articleRepository = articleRepository;
    }

    public Article getArticleById(Long id) {
        return articleRepository.findById(id);
    }
}
