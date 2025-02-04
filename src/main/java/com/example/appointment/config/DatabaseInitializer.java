package com.example.appointment.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

@Configuration
public class DatabaseInitializer {

    @Autowired
    private JdbcTemplate jdbcTemplate;
    
    @Autowired
    private PasswordEncoder passwordEncoder;

    // This method will run on application startup and execute the SQL script
    @Bean
    public CommandLineRunner runScriptOnStartup() {
        return args -> {
            // Check if the database exists, if not, proceed with initialization
            if (!isDatabaseInitialized()) {
                String scriptFile = "src/main/resources/script.sql"; // Path to your script.sql file
                executeSqlScript(scriptFile);
            } else {
                System.out.println("Database already exists, skipping initialization.");
            }
        };
    }

    // This method will execute the SQL script to initialize the database
    private void executeSqlScript(String scriptFile) {
        try (BufferedReader reader = new BufferedReader(new FileReader(scriptFile))) {
            String line;
            StringBuilder sql = new StringBuilder();
            while ((line = reader.readLine()) != null) {
                sql.append(line).append("\n");
            }
            jdbcTemplate.execute(sql.toString());
            System.out.println("Database initialized successfully.");
            updateAdminPasswordIfNeeded();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    // This method checks whether the database schema exists
    private boolean isDatabaseInitialized() {
        try {
            // Check if there are any tables in the 'public' schema (default PostgreSQL schema)
            String sql = "SELECT COUNT(*) FROM information_schema.tables WHERE table_schema = 'public'";
            Integer tableCount = jdbcTemplate.queryForObject(sql, Integer.class);
            return tableCount != null && tableCount > 0;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    // This method will update the admin password if needed
    private void updateAdminPasswordIfNeeded() {
        String query = "SELECT password FROM admin WHERE username = 'admin'";
        try {
            String existingPassword = jdbcTemplate.queryForObject(query, String.class);
            if (existingPassword != null && existingPassword.equals("admin123")) {
                String encodedPassword = passwordEncoder.encode("admin123");
                String updateQuery = "UPDATE admin SET password = ? WHERE username = 'admin'";
                jdbcTemplate.update(updateQuery, encodedPassword);
                System.out.println("Admin password has been updated to encoded version.");
            } else {
                System.out.println("Admin password is already encoded or does not need updating.");
            }
        } catch (Exception e) {
            System.out.println("Error checking or updating admin password: " + e.getMessage());
        }
    }
}
