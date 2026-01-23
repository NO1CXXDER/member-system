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

    // 생성자를 통해 MemberService를 주입받음
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    // localhost:8080/members/new 를 입력하면 get방식을 통해서 html 반환
    @GetMapping("/members/new")
    public String createForm() {
        return "members/createMemberForm"; // templates/members/createMemberForm.html
    }

    // post 방식으로 mebers/new에 매핑하면 다음과 같음
    @PostMapping("/members/new")
    public String create(MemberForm form) {

        Member member = new Member();
        member.setEmail(form.getEmail());
        member.setName(form.getName());
        member.setPassword(form.getPassword());

        memberService.join(member); // DB 저장 실행

        return "redirect:/home"; // 가입 완료 후 홈으로 이동
    }

    // 3. 홈 화면 (GET)
    @GetMapping("/home")
    public String home() {
        return "home"; // templates/home.html
    }
}