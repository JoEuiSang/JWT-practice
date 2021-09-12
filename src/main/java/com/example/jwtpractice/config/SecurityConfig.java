package com.example.jwtpractice.config;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    // h2 콘솔 하위 모든 요청들과 파비콘 관련 요청은 Spring Security 로직을 수행하지 않도록
    @Override
    public void configure(WebSecurity web) throws Exception {
        web
                .ignoring()
                .antMatchers(
                        "/h2-console/**"
                        ,"/favicon.ico"
                );
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()                                    //  HttpServletRequest를 사용하는 요청들에 대한 접근을 제한하겠다
                .antMatchers("/api/hello").permitAll()       //  "/api/hello" 에 대한 요청은 인증없이 접근하겠다
                .anyRequest().authenticated();                          //  나머지 요청들은 모두 인증되어야한다.
    }
}
