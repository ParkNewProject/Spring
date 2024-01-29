package com.example.spring.service;

import com.example.spring.domain.Member;
import com.example.spring.repository.MemberRepository;
import com.example.spring.repository.MemoryMemberRepository;

import java.util.List;
import java.util.Optional;
public class MemberService {

    private final MemberRepository memberRepository = new MemoryMemberRepository();
/*
* join
*/
    public Long join(Member member) {
        // same name member X
        validateDuplicateMember(member);
        memberRepository.save(member);
        return member.getId();
    }
/*
duplicate validation
 */
    private void validateDuplicateMember(Member member) {
        memberRepository.findByName(member.getName())
                .ifPresent(n -> {
                    throw new IllegalStateException("already exist member.");
                });
    }
/*
list all members
 */

    public List<Member> findMembers(){
        return memberRepository.findAll();
    }

    public Optional<Member> findOne(Long memberId){
        return memberRepository.findById(memberId);
    }
}
