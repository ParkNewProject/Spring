package com.example.spring.service;

import com.example.spring.domain.Member;
import com.example.spring.repository.MemberRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
// 트랜잭션 실행 후 롤백해 데이터가 남지 않아 다음 테스트에 영향을 주지 않는다
@Transactional
class IntegrationTest {
    @Autowired MemberService memberService;
    @Autowired MemberRepository memberRepository;

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
        // 같은 이름의 회원이므로 오류 발생하면 성공
        assertThrows(IllegalStateException.class, ()->memberService.join(member2));

    }

}