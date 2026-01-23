package com.example.membersystem;

import com.example.membersystem.repository.JdbcMemberRepository;
import com.example.membersystem.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.boot.jdbc.DataSourceBuilder;
import javax.sql.DataSource;

@Configuration
public class SpringConfig {

    @Value("${spring.datasource.url}")
    private String url;


    @Bean
    public DataSource dataSource() {
        return DataSourceBuilder.create()
                .driverClassName("com.mysql.cj.jdbc.Driver")
                .url(url)
                .username("root")
                .password("")
                .build();
    }


    @Bean
    public MemberRepository memberRepository() {
        return new JdbcMemberRepository(dataSource());
    }
}