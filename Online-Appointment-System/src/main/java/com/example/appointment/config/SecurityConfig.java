package com.example.appointment.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.authentication.AuthenticationManager;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.csrf().disable()
            .authorizeHttpRequests()
                .requestMatchers("/login.xhtml", "/").permitAll()  // Allow login.xhtml and root access
                .requestMatchers("/admin-dashboard.xhtml", "/appointment-list.xhtml").authenticated() // Require authentication for secure pages
            .and()
            .formLogin()
                .loginPage("/login.xhtml")  // Ensure Spring uses login.xhtml as the login page
                .loginProcessingUrl("/perform_login") // Custom login processing URL
                .defaultSuccessUrl("/admin-dashboard.xhtml", true) // Redirect to dashboard on success
                .failureUrl("/login.xhtml?error=true") // Redirect to login page on failure
            .and()
            .logout()
                .logoutUrl("/logout")
                .logoutSuccessUrl("/login.xhtml"); // Redirect to login.xhtml after logout
        
        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public AuthenticationManager authenticationManager(HttpSecurity http) throws Exception {
        return http.getSharedObject(AuthenticationManagerBuilder.class)
                   .build();
    }
}
