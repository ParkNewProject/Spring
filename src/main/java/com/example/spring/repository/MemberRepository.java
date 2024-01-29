package com.example.spring.repository;

import com.example.spring.domain.Member;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

public interface MemberRepository {
    Member save(Member member);
    Optional<Member> findById(Long Id);
    Optional<Member> findByName(String name);
    List<Member> findAll();
}
