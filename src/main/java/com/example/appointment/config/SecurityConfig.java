package com.example.appointment.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.csrf().disable()
            .authorizeHttpRequests()
                .requestMatchers("/faces/login.xhtml", "/faces/").permitAll()  // Allow public access to login and home pages
                .requestMatchers("/faces/admin-dashboard.xhtml", "/faces/appointment-list.xhtml").authenticated()  // Require authentication for these pages
            .and()
            .formLogin()
                .loginPage("/faces/login.xhtml")  // Specify the login page within the faces directory
                .loginProcessingUrl("/perform_login")
                .defaultSuccessUrl("/faces/admin-dashboard.xhtml", true)  // Redirect to the admin dashboard after successful login
                .failureUrl("/faces/login.xhtml?error=true")  // Redirect to login with an error if authentication fails
            .and()
            .logout()
                .logoutUrl("/logout")
                .logoutSuccessUrl("/faces/login.xhtml");  // Redirect to login page after logout
        
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
