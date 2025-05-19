package com.example.bcsd.repository;

import com.example.bcsd.model.Board;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class BoardJDBCRepositoryImpl implements BoardRepository {
    private final JdbcTemplate jdbcTemplate;

    @Override
    public List<Board> findAll() {
        String sql = "SELECT * FROM Board";

        return jdbcTemplate.query(sql, boardRowMapper());
    }

    @Override
    public Optional<Board> findById(Long id) {
        String sql = "SELECT * FROM Board WHERE id = ?";

        return jdbcTemplate.query(
                        sql,
                        boardRowMapper(),
                        id
                )
                .stream()
                .findFirst();
    }

    @Override
    public Board save(Board board) {
        String sql = "INSERT INTO Board (name) VALUES (?)";

        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(connection -> {
            PreparedStatement ps = connection.prepareStatement(sql, new String[]{"id"});

            ps.setString(1, board.getName());

            return ps;
        }, keyHolder);

        board.setId(keyHolder.getKey().longValue());

        return board;
    }

    @Override
    public Board save(Long id, Board board) {
        String sql = "UPDATE Board SET name = ? WHERE id = ?";

        jdbcTemplate.update(
                sql,
                board.getName(),
                id
        );

        return board;
    }

    @Override
    public void delete(Long id) {
        String sql = "DELETE from Board WHERE id = ?";

        jdbcTemplate.update(sql, id);
    }

    private RowMapper<Board> boardRowMapper() {
        return ((rs, rowNum) -> {
            return Board.builder()
                          .id(rs.getLong("id"))
                          .name(rs.getString("name"))
                          .build();
        });
    }
}
