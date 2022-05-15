CREATE TABLE users (
    username VARCHAR(32) PRIMARY KEY,
    password VARCHAR(32) NOT NULL,
    enabled BOOLEAN NOT NULL
);

CREATE TABLE authorities (
    username VARCHAR(32) PRIMARY KEY,
    authority VARCHAR(32),
    FOREIGN KEY (username) REFERENCES users(username)
);

INSERT INTO users (username, password, enabled)
VALUES
    ('ivan', '{noop}ivan', true),
    ('sanya', '{noop}sanya', false);

INSERT INTO authorities (username, authority)
VALUES
    ('ivan', 'ROLE_PATIENT'),
    ('sanya', 'ROLE_PATIENT');
