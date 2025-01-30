package com.example.appointment.config;

import javax.sql.DataSource;

@Configuration
@ComponentScan(basePackages = "com.example.appointment")
public class ApplicationConfig {

    @Bean
    public DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("org.postgresql.Driver");
        dataSource.setUrl("jdbc:postgresql://localhost:5432/appointment_db");
        dataSource.setUsername("postgres");
        dataSource.setPassword("password");
        return dataSource;
    }
}
