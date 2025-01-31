package com.example.appointment.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.appointment.entity.Appointment;
import com.example.appointment.mapper.AppointmentMapper;

@Repository
public class AppointmentRepository {
    private final AppointmentMapper appointmentMapper;
    public AppointmentRepository(AppointmentMapper appointmentMapper) {
        this.appointmentMapper = appointmentMapper;
    }

    public List<Appointment> getAllAppointments() {
        return appointmentMapper.findAll();
    }
}
