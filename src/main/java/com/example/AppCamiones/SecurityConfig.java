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
			request.requestMatchers("/login").permitAll();
			try {
				request.anyRequest().authenticated()
				.and().formLogin().loginPage("/login").defaultSuccessUrl("/inicio", true).permitAll()
				.and().logout().logoutUrl("/logout").logoutSuccessUrl("/login?logout").permitAll();
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		});
		
		return http.build();
	}
}
