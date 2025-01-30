package com.example.appointment.controller;

import java.io.Serializable;
import java.util.List;


import com.example.appointment.entity.Appointment;
import com.example.appointment.service.AppointmentService;

@Component
@ViewScoped
public class AppointmentController implements Serializable {

    @Autowired
    private AppointmentService appointmentService;

    private Appointment appointment = new Appointment();

    public List<Appointment> getAppointments() {
        return appointmentService.getAllAppointments();
    }

    public void addAppointment() {
        appointmentService.addAppointment(appointment);
        appointment = new Appointment(); // Reset form
    }

    public void deleteAppointment(int id) {
        appointmentService.deleteAppointment(id);
    }

    public Appointment getAppointment() {
        return appointment;
    }

    public void setAppointment(Appointment appointment) {
        this.appointment = appointment;
    }
}
