package com.example.spring.controller;

import com.example.spring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;

@Controller
public class MemberController {
    private final MemberService memberService;
    // DI
    @Autowired
    public MemberController(MemberService memberService){
        this.memberService = memberService;
    }
}
