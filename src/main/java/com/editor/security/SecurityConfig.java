package com.editor.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(csrf -> csrf.disable())  // ✅ Disable CSRF for WebSocket connections
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/collaborate").permitAll()  // ✅ Allow WebSocket access
                        .anyRequest().authenticated()
                );

        return http.build();
    }
}
