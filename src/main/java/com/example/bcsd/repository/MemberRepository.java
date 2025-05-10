package com.example.bcsd.repository;

import com.example.bcsd.model.Member;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class MemberRepository {
    private Long key = 1L;
    private final Map<Long, Member> members = new HashMap<>();

    public List<Member> findAll() {
        List<Member> result = new ArrayList<>();

        members.forEach((id, member) ->
                result.add(member));

        return result;
    }

    public Member findById(Long id) {
        Member member = members.get(id);

        if (member == null) {
            throw new NoSuchElementException("해당 멤버를 찾을 수 없습니다.");
        }

        return member;
    }

    public Member save(Member member) {
        member.setId(key);
        members.put(key++, member);

        return member;
    }

    public Member save(Long id, Member member) {
        members.put(id, member);

        return member;
    }

    public void delete(Long id) {
        members.remove(id);
    }
}
