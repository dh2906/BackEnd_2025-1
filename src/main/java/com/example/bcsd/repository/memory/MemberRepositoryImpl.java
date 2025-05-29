//package com.example.bcsd.repository.memory;
//
//import com.example.bcsd.model.Member;
//import com.example.bcsd.repository.MemberRepository;
//
//import java.util.*;
//import java.util.concurrent.atomic.AtomicLong;
//
//public class MemberRepositoryImpl implements MemberRepository {
//    private final AtomicLong key = new AtomicLong(1);
//    private final Map<Long, Member> members = new HashMap<>();
//
//    public List<Member> findAll() {
//        List<Member> result = new ArrayList<>();
//
//        members.forEach((id, member) ->
//                result.add(member));
//
//        return result;
//    }
//
//    public Optional<Member> findById(Long id) {
//        Member member = members.get(id);
//
//        return Optional.ofNullable(member);
//    }
//
//    public Member save(Member member) {
//        member.setId(key.get());
//        members.put(key.getAndIncrement(), member);
//
//        return member;
//    }
//
//    public Member save(Long id, Member member) {
//        members.put(id, member);
//
//        return member;
//    }
//
//    public void delete(Long id) {
//        members.remove(id);
//    }
//}
