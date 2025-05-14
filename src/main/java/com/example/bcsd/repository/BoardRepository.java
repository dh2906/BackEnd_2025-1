package com.example.bcsd.repository;

import com.example.bcsd.model.Board;

import java.util.List;
import java.util.Optional;

public interface BoardRepository {
    List<Board> findAll();
    Optional<Board> findById(Long id);
    Board save(Board board);
    Board save(Long id, Board board);
    void delete(Long id);
}
