package com.example.bcsd.repository;

import com.example.bcsd.model.Article;

import java.util.List;

public interface ArticleRepository extends CRUDRepository<Long, Article> {
    public List<Article> findAllByBoardId(Long boardId);
}
