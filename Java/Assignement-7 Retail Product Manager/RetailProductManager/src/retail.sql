use retaildb;

CREATE TABLE product (
 productId int AUTO_INCREMENT PRIMARY KEY,
 name VARCHAR(100) NOT NULL,
 category VARCHAR(50) NOT NULL,
 price DOUBLE NOT NULL,
 stockQuantity INT NOT NULL
)AUTO_INCREMENT = 101;