package com.example.spring.service;

import com.example.spring.domain.Member;
import com.example.spring.repository.MemoryMemberRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

class MemberServiceTest {
    MemberService memberService;
    MemoryMemberRepository memberRepository;

    @BeforeEach
    public void beforeEach(){
        // DI
        memberRepository = new MemoryMemberRepository();
        memberService = new MemberService(memberRepository);

    }

    @AfterEach
    public void afterEach(){
        memberRepository.clearStore();
    }


    @Test
    void 회원가입() {
        Member member = new Member();
        member.setName("hello");

        Long memberId = memberService.join(member);

        Member findMember = memberService.findOne(memberId).get();
        Assertions.assertThat(member.getName()).isEqualTo(findMember.getName());

    }

    @Test
    void 중복_회원_예외(){
        Member member1 = new Member();
        member1.setName("spring1");

        Member member2 = new Member();
        member2.setName("spring1");

        memberService.join(member1);
        // if error same = test success
        assertThrows(IllegalStateException.class, ()->memberService.join(member2));

    }

    @Test
    void findMembers() {
    }

    @Test
    void findOne() {
    }
}