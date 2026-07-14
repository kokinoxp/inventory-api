CREATE TABLE warehouse (

    id BIGINT AUTO_INCREMENT PRIMARY KEY,

    code VARCHAR(30) NOT NULL UNIQUE,

    name VARCHAR(200) NOT NULL,

    location VARCHAR(300),

    description VARCHAR(500),

    status VARCHAR(20) NOT NULL DEFAULT 'ACTIVE',

    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,

    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
        ON UPDATE CURRENT_TIMESTAMP

);

CREATE INDEX idx_warehouse_code
ON warehouse(code);

CREATE INDEX idx_warehouse_name
ON warehouse(name);

CREATE INDEX idx_warehouse_status
ON warehouse(status);