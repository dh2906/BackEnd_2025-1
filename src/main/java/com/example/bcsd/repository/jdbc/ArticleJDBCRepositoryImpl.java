package com.example.bcsd.repository.jdbc;

import com.example.bcsd.model.Article;
import com.example.bcsd.repository.ArticleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Repository
public class ArticleJDBCRepositoryImpl implements ArticleRepository {
    private final JdbcTemplate jdbcTemplate;

    @Override
    public List<Article> findAll() {
        String sql = "SELECT * FROM Article";

        return jdbcTemplate.query(sql, articleRowMapper());
    }

    @Override
    public Optional<Article> findById(Long id) {
        String sql = "SELECT * FROM Article WHERE id = ?";

        return jdbcTemplate.query(
                        sql,
                        articleRowMapper(),
                        id
                )
                .stream()
                .findFirst();
    }

    public List<Article> findAllByBoardId(Long boardId) {
        String sql = "SELECT * FROM Article WHERE board_id = ?";

        return jdbcTemplate.query(sql, articleRowMapper(), boardId);
    }

    @Override
    public Article save(Article article) {
        String sql = "INSERT INTO Article (author_id, board_id, title, content) VALUES (?, ?, ?, ?)";
        KeyHolder keyHolder = new GeneratedKeyHolder();

        jdbcTemplate.update(connection -> {
            PreparedStatement ps = connection.prepareStatement(sql, new String[]{"id"});

            ps.setLong(1, article.getAuthorId());
            ps.setLong(2, article.getBoardId());
            ps.setString(3, article.getTitle());
            ps.setString(4, article.getContent());

            return ps;
        }, keyHolder);

        Long id = keyHolder.getKey().longValue();
        article.setId(id);

        return findById(id).get();
    }

    @Override
    public Article save(Long id, Article article) {
        String sql = "UPDATE Article SET title = ?, content = ? WHERE id = ?";

        jdbcTemplate.update(
                sql,
                article.getTitle(),
                article.getContent(),
                id
        );

        return article;
    }

    @Override
    public void delete(Long id) {
        String sql = "DELETE from Article WHERE id = ?";

        jdbcTemplate.update(sql, id);
    }

    private RowMapper<Article> articleRowMapper() {
        return ((rs, rowNum) -> {
            return Article.builder()
                    .id(rs.getLong("id"))
                    .authorId(rs.getLong("author_id"))
                    .boardId(rs.getLong("board_id"))
                    .title(rs.getString("title"))
                    .content(rs.getString("content"))
                    .createdAt(rs.getTimestamp("created_at").toLocalDateTime())
                    .updatedAt(rs.getTimestamp("updated_at").toLocalDateTime())
                    .build();
        });
    }
}
