CREATE TABLE supplier (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,

    code VARCHAR(30) NOT NULL UNIQUE,
    name VARCHAR(200) NOT NULL,

    contact_name VARCHAR(200),
    phone VARCHAR(50),
    email VARCHAR(100),
    address VARCHAR(500),
    tax_no VARCHAR(30),

    status VARCHAR(20) NOT NULL DEFAULT 'ACTIVE',

    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
        ON UPDATE CURRENT_TIMESTAMP
);

CREATE INDEX idx_supplier_code ON supplier(code);
CREATE INDEX idx_supplier_name ON supplier(name);
CREATE INDEX idx_supplier_status ON supplier(status);