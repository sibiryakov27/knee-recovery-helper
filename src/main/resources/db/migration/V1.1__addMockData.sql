INSERT INTO patients (id, first_name, second_name, patronymic, email, password, enabled)
VALUES
    (1, 'Ivan', 'Ivanov', 'Ivanovich', 'ivan.ivanov@mail.ru', 'password', true);

INSERT INTO roles (roles, user_id)
VALUES
    ('PATIENT', 1);
