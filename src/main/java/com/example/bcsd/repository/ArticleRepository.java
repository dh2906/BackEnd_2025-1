package com.example.bcsd.repository;

import com.example.bcsd.model.Article;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class ArticleRepository {
    private final Map<Long, Article> articles = new HashMap<>();

    public Article findById(Long id) {
        return articles.get(id);
    }
}
