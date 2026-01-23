package com.example.membersystem.service;

import com.example.membersystem.entity.Member;
import com.example.membersystem.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MemberService {


    private final MemberRepository memberRepository;

    //회원가입
    public Long join(Member member) {
        // 같은 이메일이 있는지 중복 회원 검증
        validateDuplicateMember(member);

        memberRepository.save(member);
        return member.getId();
    }

    private void validateDuplicateMember(Member member) {
        memberRepository.findByEmail(member.getEmail())
                .ifPresent(m -> {
                    throw new IllegalStateException("이미 존재하는 회원");
                });
    }


    public List<Member> findMembers() {
        return memberRepository.findAll();
    }
}