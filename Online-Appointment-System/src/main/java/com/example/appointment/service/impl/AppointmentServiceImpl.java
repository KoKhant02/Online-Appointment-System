package com.example.appointment.service.impl;

import com.example.appointment.dto.AppointmentDTO;
import com.example.appointment.repository.AppointmentRepository;
import com.example.appointment.service.AppointmentService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class AppointmentServiceImpl implements AppointmentService {
	@Autowired
    private final AppointmentRepository repository;

    public AppointmentServiceImpl(AppointmentRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<AppointmentDTO> getAllAppointments() {
        return repository.getAllAppointments().stream()
                .map(entity -> new AppointmentDTO(entity.getId(), entity.getPatientName(), entity.getAppointmentTime()))
                .collect(Collectors.toList());
    }
}
