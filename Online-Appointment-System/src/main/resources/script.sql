CREATE TABLE admin (
    id SERIAL PRIMARY KEY,
    username VARCHAR(255) UNIQUE NOT NULL,
    password VARCHAR(255) NOT NULL
);

INSERT INTO admin (username, password) VALUES ('admin', 'admin123');

CREATE TABLE appointment (
    id SERIAL PRIMARY KEY,
    patient_name VARCHAR(255) NOT NULL,
    doctor_name VARCHAR(255) NOT NULL,
    appointment_date TIMESTAMP NOT NULL,
    status VARCHAR(50) DEFAULT 'Pending'
);
