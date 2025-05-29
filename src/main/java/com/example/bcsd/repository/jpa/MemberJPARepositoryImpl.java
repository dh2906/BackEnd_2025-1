package com.example.bcsd.repository.jpa;

import com.example.bcsd.model.Member;
import com.example.bcsd.repository.MemberRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class MemberJPARepositoryImpl implements MemberRepository {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Member> findAll() {
        return entityManager
                .createQuery("SELECT m FROM Member m", Member.class)
                .getResultList();
    }

    @Override
    public Optional<Member> findById(Long id) {
        return Optional.ofNullable(entityManager.find(Member.class, id));
    }

    @Override
    public Member save(Member entity) {
        entityManager.persist(entity);

        return entity;
    }

    @Override
    public Member save(Long id, Member entity) {
        return null;
    }

    @Override
    public void delete(Long id) {
        entityManager.remove(id);
    }
}
