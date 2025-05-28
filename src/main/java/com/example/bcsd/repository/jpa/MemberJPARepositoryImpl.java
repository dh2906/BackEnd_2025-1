package com.example.bcsd.repository.jpa;

import com.example.bcsd.model.Member;
import com.example.bcsd.repository.MemberRepository;

import java.util.List;
import java.util.Optional;

public class MemberJPARepositoryImpl implements MemberRepository {
    @Override
    public List<Member> findAll() {
        return List.of();
    }

    @Override
    public Optional<Member> findById(Long aLong) {
        return Optional.empty();
    }

    @Override
    public Member save(Member entity) {
        return null;
    }

    @Override
    public Member save(Long aLong, Member entity) {
        return null;
    }

    @Override
    public void delete(Long aLong) {

    }
}
