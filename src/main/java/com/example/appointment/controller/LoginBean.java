package com.example.appointment.controller;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;

@Component
@Scope(WebApplicationContext.SCOPE_REQUEST)  
public class LoginBean {

    private String username;
    private String password;
    private boolean rememberMe;  
    private String token;
    private String refreshToken;

    // Getters and Setters
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isRememberMe() {
        return rememberMe;
    }

    public void setRememberMe(boolean rememberMe) {
        this.rememberMe = rememberMe;
    }

    public String getToken() {
        return token;
    }

    public String getRefreshToken() {
        return refreshToken;
    }

    // Login method with token simulation
    public String login() {
        if ("admin".equals(username) && "password123".equals(password)) {
            // Simulate token generation
            token = "fakeAccessToken123456";
            refreshToken = "fakeRefreshToken987654";

            // Store user session
            HttpSession session = (HttpSession) FacesContext.getCurrentInstance()
                    .getExternalContext().getSession(true);
            session.setAttribute("username", username);
            session.setAttribute("token", token);

            return "admin-dashboard.xhtml?faces-redirect=true"; 
        } else {
            FacesContext.getCurrentInstance().addMessage("loginForm:messages",
                    new FacesMessage(FacesMessage.SEVERITY_ERROR, 
                                     "Invalid username or password", 
                                     "Please enter correct credentials"));
            return null; 
        }
    }

    // Logout method
    public String logout() {
        FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
        return "login.xhtml?faces-redirect=true"; 
    }
}
