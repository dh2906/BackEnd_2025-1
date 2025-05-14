package com.example.bcsd.repository;

import com.example.bcsd.model.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class MemberJDBCRepositoryImpl implements MemberRepository {
    private final JdbcTemplate jdbcTemplate;

    @Override
    public List<Member> findAll() {
        String sql = "SELECT * FROM Member";

        return jdbcTemplate.query(sql, memberRowMapper());
    }

    @Override
    public Optional<Member> findById(Long id) {
        String sql = "SELECT * FROM Member WHERE id = ?";

        return Optional.ofNullable(
                jdbcTemplate.queryForObject(
                        sql,
                        memberRowMapper(),
                        id
                )
        );
    }

    @Override
    public Member save(Member member) {
        String sql = "INSERT INTO Member (name, email, password) VALUES (?, ?, ?)";

        jdbcTemplate.update(
                sql,
                member.getName(),
                member.getEmail(),
                member.getPassword()
        );

        return member;
    }

    @Override
    public Member save(Long id, Member member) {
        String sql = "UPDATE Member SET name = ?, email = ? password = ?, WHERE id = ?";

        jdbcTemplate.update(
                sql,
                member.getName(),
                member.getEmail(),
                member.getPassword(),
                id
        );

        return member;
    }

    @Override
    public void delete(Long id) {
        String sql = "DELETE from Member WHERE id = ?";

        jdbcTemplate.update(sql, id);
    }

    private RowMapper<Member> memberRowMapper() {
        return ((rs, rowNum) -> {
            return Member.builder()
                         .name(rs.getString("name"))
                         .email(rs.getString("email"))
                         .password(rs.getString("password"))
                         .build();
        });
    }
}
