package com.api_arcade.api_arcade.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.config.Customizer;

@Configuration
@EnableWebSecurity
public class java_security_config {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .csrf(csrf -> csrf.disable()) // Disable CSRF for development 
            .authorizeHttpRequests(authorize -> authorize
                .requestMatchers("/users").permitAll() 
                .anyRequest().authenticated()
            )
            .httpBasic(Customizer.withDefaults());
      

        return http.build();
    }
    
}
