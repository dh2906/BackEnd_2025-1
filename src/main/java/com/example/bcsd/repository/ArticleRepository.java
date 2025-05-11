package com.example.bcsd.repository;

import com.example.bcsd.model.Article;

import java.util.List;
import java.util.Optional;

public interface ArticleRepository {
    List<Article> findAll();
    Optional<Article> findById(Long id);
    Article save(Article article);
    Article save(Long id, Article article);
    void delete(Long id);
}
