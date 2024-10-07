package com.crud.products.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

//@Configuration
//@EnableWebSecurity
public class SecurityConfig {

	/*
	 * @SuppressWarnings("deprecation")
	 * 
	 * @Bean public SecurityFilterChain securityFilterChain(HttpSecurity http)
	 * throws Exception { http.authorizeRequests( authorize ->
	 * authorize.requestMatchers("/").authenticated().anyRequest().permitAll())
	 * .httpBasic().and().csrf().disable(); // Disable CSRF for testing purposes
	 * 
	 * return http.build(); }
	 */
}
