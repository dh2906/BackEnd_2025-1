package com.example.bcsd.repository;

import com.example.bcsd.controller.dto.ArticleResponse;
import com.example.bcsd.model.Article;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class ArticleRepository {
    private Long key = 1L;
    private final Map<Long, Article> articles = new HashMap<>();

    public List<Article> findAll() {
        List<Article> result = new ArrayList<>();

        articles.forEach((id, article) ->
                result.add(article));

        return result;
    }

    public Article findById(Long id) {
        Article article = articles.get(id);

        if (article == null) {
            throw new NoSuchElementException("해당 게시글을 찾을 수 없습니다.");
        }

        return article;
    }

    public Article save(Article article) {
        article.setId(key);
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
