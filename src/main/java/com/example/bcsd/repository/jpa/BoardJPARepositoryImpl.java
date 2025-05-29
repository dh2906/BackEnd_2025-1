package com.example.bcsd.repository.jpa;

import com.example.bcsd.model.Board;
import com.example.bcsd.repository.BoardRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class BoardJPARepositoryImpl implements BoardRepository {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Board> findAll() {
        return entityManager
                .createQuery("SELECT b FROM Board b", Board.class)
                .getResultList();
    }

    @Override
    public Optional<Board> findById(Long id) {
        return Optional.ofNullable(entityManager.find(Board.class, id));
    }

    @Override
    public Board save(Board entity) {
        entityManager.persist(entity);

        return entity;
    }

    @Override
    public Board save(Long id, Board entity) {
        return null;
    }

    @Override
    public void delete(Long id) {
        Board board = entityManager.find(Board.class, id);

        entityManager.remove(id);
    }
}
