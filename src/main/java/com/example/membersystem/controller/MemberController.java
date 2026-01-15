package com.example.membersystem.controller;

import com.example.membersystem.entity.Member;
import com.example.membersystem.service.MemberService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MemberController {

    private final MemberService memberService;

    // 생성자를 통해 MemberService를 주입받음 (DI)
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    // 1. 회원가입 화면을 보여주는 기능 (GET)
    @GetMapping("/members/new")
    public String createForm() {
        return "members/createMemberForm"; // templates/members/createMemberForm.html을 찾아감
    }

    // 2. 실제 가입 데이터를 처리하는 기능 (POST)
    @PostMapping("/members/new")
    public String create(MemberForm form) {
        Member member = new Member();
        member.setEmail(form.getEmail());
        member.setName(form.getName());
        member.setPassword(form.getPassword());

        memberService.join(member);

        return "redirect:/"; // 가입 완료 후 홈 화면으로 이동
    }
}