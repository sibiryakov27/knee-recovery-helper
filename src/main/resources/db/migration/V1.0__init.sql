CREATE TABLE usrs (
     id SERIAL PRIMARY KEY,
     first_name VARCHAR(32),
     second_name VARCHAR(32),
     patronymic VARCHAR(32),
     email VARCHAR(64) NOT NULL UNIQUE,
     phone_number VARCHAR(16),
     password VARCHAR(32) NOT NULL,
     enabled BOOLEAN NOT NULL
);

CREATE TABLE patients (
    id SERIAL PRIMARY KEY,
    start_recovery_date DATE NOT NULL,
    medical_card_number VARCHAR(32),
    FOREIGN KEY (id) REFERENCES patients(id)
);

CREATE TABLE roles (
    id SERIAL PRIMARY KEY,
    roles VARCHAR(32),
    FOREIGN KEY (id) REFERENCES usrs(id)
);

create table reports (
    id SERIAL PRIMARY KEY,
    patient_id INTEGER NOT NULL,
    week_number INTEGER NOT NULL,
    report_path VARCHAR(128),
    report_date TIMESTAMP,
    FOREIGN KEY (patient_id) REFERENCES patients(id)
);

create table oks_result (
    id SERIAL PRIMARY KEY,
    points INTEGER NOT NULL,
    patient_id INTEGER NOT NULL,
    passage_date DATE NOT NULL,
    week_number INTEGER NOT NULL,
    FOREIGN KEY (patient_id) REFERENCES patients(id)
);

create table eq5d3l_result (
    id SERIAL PRIMARY KEY,
    points INTEGER NOT NULL,
    patient_id INTEGER NOT NULL,
    passage_date TIMESTAMP,
    week_number INTEGER NOT NULL,
    FOREIGN KEY (patient_id) REFERENCES patients(id)
);

create table oks_question_result (
    id SERIAL PRIMARY KEY,
    points INTEGER NOT NULL,
    oks_id INTEGER NOT NULL,
    question_number INTEGER NOT NULL,
    FOREIGN KEY (oks_id) REFERENCES oks_result(id)
);

create table eq5d3l_question_result (
    id SERIAL PRIMARY KEY,
    points INTEGER NOT NULL,
    eq5d3l_id INTEGER NOT NULL,
    question_number INTEGER NOT NULL,
    FOREIGN KEY (eq5d3l_id) REFERENCES eq5d3l_result(id)
);
