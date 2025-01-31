package com.example.appointment.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.appointment.dto.AppointmentDTO;
import com.example.appointment.service.AppointmentService;


@RestController
@RequestMapping("/api/appointments")
public class AppointmentController {
	@Autowired
    private final AppointmentService service;

public AppointmentController(AppointmentService service) {
    this.service = service;
}
    @GetMapping
    public List<AppointmentDTO> getAllAppointments() {
        return service.getAllAppointments();
    }
}