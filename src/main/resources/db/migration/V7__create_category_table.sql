CREATE TABLE category (

    id BIGINT AUTO_INCREMENT PRIMARY KEY,

    code VARCHAR(30) NOT NULL UNIQUE,

    name VARCHAR(150) NOT NULL,

    description VARCHAR(500),

    status VARCHAR(20) NOT NULL DEFAULT 'ACTIVE',

    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,

    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
        ON UPDATE CURRENT_TIMESTAMP

);

CREATE INDEX idx_category_code
ON category(code);

CREATE INDEX idx_category_name
ON category(name);

CREATE INDEX idx_category_status
ON category(status);