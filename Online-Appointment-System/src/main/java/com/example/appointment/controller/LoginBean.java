package com.example.appointment.controller;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;


@Component
@Scope(WebApplicationContext.SCOPE_REQUEST) // Use request scope
public class LoginBean {

    private String username;
    private String password;

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

    // Method to handle login
    public String login() {
        if ("admin".equals(username) && "password123".equals(password)) {
            return "admin-dashboard.xhtml";  
        } else {
            FacesContext.getCurrentInstance().addMessage(null, 
                    new FacesMessage(FacesMessage.SEVERITY_ERROR, 
                                     "Invalid username or password", 
                                     "Please enter correct credentials"));
            return "login.xhtml";  
        }
    }

    // Logout method
    public String logout() {
        FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
        return "login.xhtml";
    }
}
