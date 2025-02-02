package com.example.appointment.entity;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class Appointment {
    private int id;
    private String patientName;
    private String doctorName;
    private LocalDateTime appointmentDate;
    private String status;
}
