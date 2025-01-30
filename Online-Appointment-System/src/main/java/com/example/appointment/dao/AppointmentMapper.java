package com.example.appointment.dao;

import java.util.List;

import com.example.appointment.entity.Appointment;

public interface AppointmentMapper {

    @Select("SELECT * FROM appointments")
    List<Appointment> getAllAppointments();

    @Insert("INSERT INTO appointments (patientName, appointmentDate, doctor) VALUES (#{patientName}, #{appointmentDate}, #{doctor})")
    void addAppointment(Appointment appointment);

    @Delete("DELETE FROM appointments WHERE id = #{id}")
    void deleteAppointment(int id);
}
