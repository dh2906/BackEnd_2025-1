package com.example.bcsd.repository;

import com.example.bcsd.model.Article;
import org.springframework.stereotype.Repository;

import java.util.*;
import java.util.concurrent.atomic.AtomicLong;

@Repository
public class ArticleRepositoryImpl implements ArticleRepository {
    private final AtomicLong key = new AtomicLong(1);
    private final Map<Long, Article> articles = new HashMap<>();

    public List<Article> findAll() {
        List<Article> result = new ArrayList<>();

        articles.forEach((id, article) ->
                result.add(article));

        return result;
    }

    public Optional<Article> findById(Long id) {
        Article article = articles.get(id);

        return Optional.ofNullable(article);
    }

    public Article save(Article article) {
        article.setId(key.get());
        articles.put(key.getAndIncrement(), article);

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
