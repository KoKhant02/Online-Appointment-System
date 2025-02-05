package com.example.appointment.config;

import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import jakarta.faces.webapp.FacesServlet;

@Configuration
public class JSFServletConfig {

    @Bean
    public ServletRegistrationBean<FacesServlet> facesServletRegistrationBean() {
        FacesServlet facesServlet = new FacesServlet();
        ServletRegistrationBean<FacesServlet> registrationBean = new ServletRegistrationBean<>(facesServlet, "*.xhtml");
        registrationBean.setName("FacesServlet"); // Optional but good practice
        return registrationBean;
    }
}
