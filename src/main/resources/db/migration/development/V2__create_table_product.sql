CREATE TABLE Product (
    id BIGINT PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
    name VARCHAR(100) NOT NULL,
    price NUMERIC(10, 2) NOT NULL,
    description TEXT,
    product_size VARCHAR(50) ,
    color VARCHAR(30),
    material VARCHAR(30),
    product_type VARCHAR(50) NOT NULL
);