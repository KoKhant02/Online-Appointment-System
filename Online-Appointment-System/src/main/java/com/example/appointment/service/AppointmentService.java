package com.example.appointment.service;

import java.util.List;

import com.example.appointment.dto.AppointmentDTO;

public interface AppointmentService {
    List<AppointmentDTO> getAllAppointments();
}