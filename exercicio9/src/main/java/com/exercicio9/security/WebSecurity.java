package com.exercicio9.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import  org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@EnableWebSecurity
public class WebSecurity extends WebSecurityConfigurerAdapter {
	
	@Autowired
	private UsuarioService userDetails;
	
	@Override
	public void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
			.antMatchers(HttpMethod.GET,"/clientes").hasAnyRole("ADMIN","COMUM")
			.antMatchers("/clientes/**").hasRole("ADMIN")
			.antMatchers("/files/**").hasAnyRole("ADMIN","COMUM")
			.antMatchers("/login").permitAll()
			.antMatchers("/logout").permitAll()
			.and().formLogin().defaultSuccessUrl("/clientes");
	}
	
	@Override
	public void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetails)
			.passwordEncoder(new BCryptPasswordEncoder());
	}
	
}
