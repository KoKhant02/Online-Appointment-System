package com.example.appointment.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.appointment.dao.AppointmentMapper;
import com.example.appointment.entity.Appointment;

@Service
public class AppointmentService {

    @Autowired
    private AppointmentMapper appointmentMapper;

    public List<Appointment> getAllAppointments() {
        return appointmentMapper.getAllAppointments();
    }

    public void addAppointment(Appointment appointment) {
        appointmentMapper.addAppointment(appointment);
    }

    public void deleteAppointment(int id) {
        appointmentMapper.deleteAppointment(id);
    }
}
