package com.example.bcsd.repository.jpa;

import com.example.bcsd.model.Article;
import com.example.bcsd.repository.ArticleRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ArticleJPARepositoryImpl implements ArticleRepository {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Article> findAllByBoardId(Long boardId) {
        return entityManager
                .createQuery("SELECT a FROM Article a WHERE boardId = :boardId", Article.class)
                .setParameter("boardId", boardId)
                .getResultList();
    }

    @Override
    public List<Article> findAll() {
        return entityManager
                .createQuery("SELECT a FROM Article a", Article.class)
                .getResultList();
    }

    @Override
    public Optional<Article> findById(Long id) {
        return Optional.ofNullable(entityManager.find(Article.class, id));
    }

    @Override
    public Article save(Article entity) {
        entityManager.persist(entity);

        return entity;
    }

    @Override
    public Article save(Long id, Article entity) {
        return null;
    }

    @Override
    public void delete(Long id) {
        Article article = entityManager.find(Article.class, id);

        entityManager.remove(article);
    }
}
