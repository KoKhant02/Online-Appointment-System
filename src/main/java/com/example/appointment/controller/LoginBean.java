package com.example.appointment.controller;

import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Named;
import java.io.Serializable;

import com.example.appointment.service.AuthService;

@Named 
@SessionScoped 
public class LoginBean implements Serializable {

    private String username;
    private String password;
    private boolean loggedIn;

    private AuthService authService;

    // Constructor (Inject Dependencies Manually if Needed)
    public LoginBean() {
        this.authService = new AuthService(); // Replace with real DI
    }

    public String login() {
        if (authService.authenticate(username, password)) {
            loggedIn = true;
            return "dashboard.xhtml?faces-redirect=true"; // Redirect after login
        }
        return null; // Stay on the same page if login fails
    }

    public String logout() {
        loggedIn = false;
        username = null;
        password = null;
        return "login.xhtml?faces-redirect=true"; // Redirect to login page
    }

    // Getters and Setters
    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }

    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }

    public boolean isLoggedIn() { return loggedIn; }
}
