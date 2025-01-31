package com.example.appointment.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.example.appointment.entity.Appointment;

@Mapper
public interface AppointmentMapper {
    @Select("SELECT * FROM appointments")
    List<Appointment> findAll();

    @Insert("INSERT INTO appointments(patient_name, appointment_time) VALUES(#{patientName}, #{appointmentTime})")
    void insert(Appointment appointment);
}