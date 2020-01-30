package com.trabalho.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@EnableWebSecurity
public class WebSecurity extends WebSecurityConfigurerAdapter{
    
    @Autowired
    private UserDetailsCustom userDetailsCustom;
    
    @Override
    public void configure(HttpSecurity http) throws Exception{
        http.authorizeRequests()
                .antMatchers("/produtos").hasAnyRole("ADMIN","COMUM")
                .antMatchers("/gerenciar").hasRole("ADMIN")
                .and()
                .formLogin().defaultSuccessUrl("/produtos");
    }
    
    @Override
    public void configure(AuthenticationManagerBuilder builder) throws Exception{
        builder.userDetailsService(userDetailsCustom)
                .passwordEncoder(new BCryptPasswordEncoder());
    }
}
