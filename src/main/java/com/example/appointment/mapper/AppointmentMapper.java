package com.example.appointment.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.example.appointment.entity.Appointment;

@Mapper
public interface AppointmentMapper {
    @Insert("INSERT INTO appointment(patient_name, doctor_name, appointment_date, status) VALUES (#{patientName}, #{doctorName}, #{appointmentDate}, #{status})")
    void insert(Appointment appointment);

    @Select("SELECT * FROM appointment")
    List<Appointment> findAll();
}
