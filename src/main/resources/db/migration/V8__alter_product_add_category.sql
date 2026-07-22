ALTER TABLE product
ADD COLUMN category_id BIGINT NULL;

ALTER TABLE product
ADD CONSTRAINT fk_product_category
FOREIGN KEY(category_id)
REFERENCES category(id);

CREATE INDEX idx_product_category
ON product(category_id);