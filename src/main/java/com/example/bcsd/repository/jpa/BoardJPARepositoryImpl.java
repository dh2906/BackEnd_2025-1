package com.example.bcsd.repository.jpa;

import com.example.bcsd.model.Board;
import com.example.bcsd.repository.BoardRepository;

import java.util.List;
import java.util.Optional;

public class BoardJPARepositoryImpl implements BoardRepository {
    @Override
    public List<Board> findAll() {
        return List.of();
    }

    @Override
    public Optional<Board> findById(Long aLong) {
        return Optional.empty();
    }

    @Override
    public Board save(Board entity) {
        return null;
    }

    @Override
    public Board save(Long aLong, Board entity) {
        return null;
    }

    @Override
    public void delete(Long aLong) {

    }
}
