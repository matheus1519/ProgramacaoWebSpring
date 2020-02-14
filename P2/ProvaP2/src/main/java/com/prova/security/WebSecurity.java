/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.prova.security;

import java.lang.reflect.Method;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@EnableWebSecurity
public class WebSecurity extends WebSecurityConfigurerAdapter{
    
    @Autowired
    private UserDetailsService userService;
    
    @Override
    public void configure(HttpSecurity http) throws Exception{
        http.authorizeRequests()
                .antMatchers("/funcionarios").hasAnyRole("ADMIN", "COMUM")
                .antMatchers(HttpMethod.POST,"/funcionarios/cadastrar").hasRole("ADMIN")
                .antMatchers("/funcionarios/**").hasRole("ADMIN")
                .antMatchers("/login/").permitAll()
                .antMatchers("/logout/").permitAll()
                .and().formLogin().defaultSuccessUrl("/funcionarios");
                
                
    }
    
    @Override
    public void configure(AuthenticationManagerBuilder auth) throws Exception{
        auth.userDetailsService(userService).passwordEncoder(new BCryptPasswordEncoder());
    }
}
