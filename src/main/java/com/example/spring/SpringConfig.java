package com.example.spring;
/*
take one to DI 1. @Service Container Scan 2.@Configuration
*/
/*
import com.example.spring.repository.MemberRepository;
import com.example.spring.repository.MemoryMemberRepository;
import com.example.spring.service.MemberService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class SpringConfig {
    @Bean
    public MemberService memberService(){
        return new MemberService(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository(){
        return new MemoryMemberRepository();
    }
}
*/