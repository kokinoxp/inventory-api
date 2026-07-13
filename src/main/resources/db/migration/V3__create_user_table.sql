CREATE TABLE users (

    id BIGINT PRIMARY KEY AUTO_INCREMENT,

    username VARCHAR(50) NOT NULL UNIQUE,

    password VARCHAR(255) NOT NULL,

    full_name VARCHAR(200),

    email VARCHAR(150),

    enabled BOOLEAN DEFAULT TRUE,

    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,

    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
        ON UPDATE CURRENT_TIMESTAMP

);

INSERT INTO users
(
    username,
    password,
    full_name,
    email
)
VALUES
(
    'admin',
    '$2a$10$o9gB0rkBAIKfTETTf/np6eaQ02alEck6HlIxDxWSJW4ZPkRhJMR8q',
    'System Administrator',
    'admin@example.com'
);