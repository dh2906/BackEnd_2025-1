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
        Article article = articles.get(id);

        if (article == null) {
            throw new RuntimeException("Not Found");
        }

        return articles.get(id);
    }

    public Article save(Article article) {
        articles.put(key++, article);

        return article;
    }

    public Article save(Long id, Article article) {
        articles.put(id, article);

        return article;
    }

    public void delete(Long id) {
        articles.remove(id);
    }
}
