package com.example.appointment.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.jsf.el.SpringBeanFacesELResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
public class JSFConfig {

    @Bean
    public SpringBeanFacesELResolver springBeanFacesELResolver() {
        return new SpringBeanFacesELResolver();
    }

    @Bean
    public InternalResourceViewResolver jsfViewResolver() {
        InternalResourceViewResolver resolver = new InternalResourceViewResolver();
        resolver.setPrefix("/webapp/"); 
        resolver.setSuffix(".xhtml");
        return resolver;
    }
}
