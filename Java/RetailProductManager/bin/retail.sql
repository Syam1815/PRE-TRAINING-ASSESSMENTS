use retaildb;
CREATE TABLE product (
 productId VARCHAR(5) PRIMARY KEY,
 name VARCHAR(100) NOT NULL,
 category VARCHAR(50) NOT NULL,
 price DOUBLE NOT NULL,
 stockQuantity INT NOT NULL
);