package com.example.appointment;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@MapperScan("com.example.appointment.mapper")
@ComponentScan(basePackages = "com.example.appointment")
public class OnlineAppointmentSystemApplication {
    public static void main(String[] args) {
        SpringApplication.run(OnlineAppointmentSystemApplication.class, args);
    }
}