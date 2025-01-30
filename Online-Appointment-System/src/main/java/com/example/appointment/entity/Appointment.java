package com.example.appointment.entity;

import java.util.Date;

public class Appointment {
    private int id;
    private String patientName;
    private Date appointmentDate;
    private String doctor;

    // Constructors
    public Appointment() {}

    public Appointment(int id, String patientName, Date appointmentDate, String doctor) {
        this.id = id;
        this.patientName = patientName;
        this.appointmentDate = appointmentDate;
        this.doctor = doctor;
    }

    // Getters and Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getPatientName() { return patientName; }
    public void setPatientName(String patientName) { this.patientName = patientName; }

    public Date getAppointmentDate() { return appointmentDate; }
    public void setAppointmentDate(Date appointmentDate) { this.appointmentDate = appointmentDate; }

    public String getDoctor() { return doctor; }
    public void setDoctor(String doctor) { this.doctor = doctor; }
}
