package com.example.membersystem.repository;

import com.example.membersystem.entity.Member;
import java.util.List;
import java.util.Optional;

public interface MemberRepository {
    Member save(Member member);
    Optional<Member> findByEmail(String email);
    List<Member> findAll();
}