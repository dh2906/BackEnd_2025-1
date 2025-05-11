package com.example.bcsd.repository;

import com.example.bcsd.model.Member;

import java.util.List;
import java.util.Optional;

public interface MemberRepository {
    List<Member> findAll();
    Optional<Member> findById(Long id);
    Member save(Member member);
    Member save(Long id, Member member);
    void delete(Long id);
}
