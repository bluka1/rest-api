package com.bluka1.rest.webservices.restfulwebservices.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import static org.springframework.security.config.Customizer.withDefaults;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SpringSecurityConfiguration {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        // All requests should be authenticated
        http.authorizeHttpRequests(auth -> auth.anyRequest().authenticated());

        // If request is not authenticated, show login page
        http.httpBasic(withDefaults());

        // Disable CSRF in order to allow POST/PUT requests
        http.csrf(csrf -> csrf.disable());

        return http.build();
    }
}
