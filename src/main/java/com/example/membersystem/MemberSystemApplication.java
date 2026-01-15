package com.example.membersystem;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

// DB와 보안 설정을 제외하여 로그인 창이 뜨지 않게 합니다.
@SpringBootApplication(exclude = {
        DataSourceAutoConfiguration.class,
        SecurityAutoConfiguration.class
})
public class MemberSystemApplication {
    public static void main(String[] args) {
        SpringApplication.run(MemberSystemApplication.class, args);
    }
}