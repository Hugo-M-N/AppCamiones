package com.example.AppCamiones;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.DefaultSecurityFilterChain;

@Configuration
public class SecurityConfig {

	@Bean
	public DefaultSecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		http.authorizeHttpRequests(request ->{
			request.requestMatchers("/").permitAll();
			request.anyRequest().permitAll();
		});
		
		return http.build();
	}
}
