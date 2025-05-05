package com.example.bcsd.repository;

import com.example.bcsd.model.Article;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class ArticleRepository {
    private Long key = 1L;
    private final Map<Long, Article> articles = new HashMap<>();

    public Article findById(Long id) {
        return articles.get(id);
    }

    public Article save(Article article) {
        articles.put(key++, article);

        return article;
    }
}
