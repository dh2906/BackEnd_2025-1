package com.example.bcsd.repository.jpa;

import com.example.bcsd.model.Article;
import com.example.bcsd.repository.ArticleRepository;

import java.util.List;
import java.util.Optional;

public class ArticleJPARepositoryImpl implements ArticleRepository {
    @Override
    public List<Article> findAllByBoardId(Long boardId) {
        return List.of();
    }

    @Override
    public List<Article> findAll() {
        return List.of();
    }

    @Override
    public Optional<Article> findById(Long aLong) {
        return Optional.empty();
    }

    @Override
    public Article save(Article entity) {
        return null;
    }

    @Override
    public Article save(Long aLong, Article entity) {
        return null;
    }

    @Override
    public void delete(Long aLong) {

    }
}
