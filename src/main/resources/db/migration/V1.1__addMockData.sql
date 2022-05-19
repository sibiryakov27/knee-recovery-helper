INSERT INTO usrs (id, first_name, second_name, patronymic, email, password, enabled)
VALUES
    (1, 'Ivan', 'Ivanov', 'Ivanovich', 'ivan.ivanov@mail.ru', 'password', true);

INSERT INTO patients (id, start_recovery_date, medical_card_number)
VALUES
    (1, '2022-05-19', '123123123');

INSERT INTO roles (id, roles)
VALUES
    (1, 'PATIENT');
