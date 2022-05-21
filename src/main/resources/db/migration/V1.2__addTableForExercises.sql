CREATE TABLE exercises_status (
    id SERIAL PRIMARY KEY,
    first_exercise INTEGER NOT NULL,
    second_exercise BOOLEAN,
    third_exercise BOOLEAN,
    fourth_exercise BOOLEAN,
    fifth_exercise BOOLEAN,
    sixth_exercise BOOLEAN,
    seventh_exercise BOOLEAN,
    patient_id INTEGER NOT NULL,
    exercise_date DATE NOT NULL,
    week_number INTEGER NOT NULL,
    FOREIGN KEY (patient_id) REFERENCES patients(id)
)
