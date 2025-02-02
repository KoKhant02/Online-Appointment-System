package com.example.appointment.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.appointment.entity.Admin;
import com.example.appointment.mapper.AdminMapper;

@Service
public class AdminService {
    @Autowired
    private AdminMapper adminMapper;

    public Admin findAdminByUsername(String username) {
        return adminMapper.findByUsername(username);
    }
}
