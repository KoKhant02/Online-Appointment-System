package com.example.appointment.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.jsf.el.SpringBeanFacesELResolver;

@Configuration
public class JSFConfig {

    @Bean
    public SpringBeanFacesELResolver springBeanFacesELResolver() {
        return new SpringBeanFacesELResolver();
    }
}
