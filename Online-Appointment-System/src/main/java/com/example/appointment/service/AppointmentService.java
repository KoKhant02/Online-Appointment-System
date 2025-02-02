package com.example.appointment.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.appointment.entity.Appointment;
import com.example.appointment.mapper.AppointmentMapper;

@Service
public class AppointmentService {
    @Autowired
    private AppointmentMapper appointmentMapper;

    public List<Appointment> getAllAppointments() {
        return appointmentMapper.findAll();
    }
}
