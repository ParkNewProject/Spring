package com.example.spring;
/*
설정 방법 두가지중 선택 DI 1. @Service 어노테이션 (Container Scan) 2.@Configuration
*/

import com.example.spring.repository.JdbcTemplateMemberRepository;
import com.example.spring.repository.MemberRepository;
import com.example.spring.repository.MemoryMemberRepository;
import com.example.spring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;


@Configuration
public class SpringConfig {

    private DataSource dataSource;

    @Autowired
    public SpringConfig(DataSource dataSource){
        this.dataSource = dataSource;
    }

    @Bean
    public MemberService memberService(){
        return new MemberService(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository(){
//        return new MemoryMemberRepository();
        // 다형성, 개방-폐쇄원칙 OCP
        // 기존 코드를 수정하지 않고 설정만으로 구현 클래스 변경가능
        return new JdbcTemplateMemberRepository(dataSource);
    }
}