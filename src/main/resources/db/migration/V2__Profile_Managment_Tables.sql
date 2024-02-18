-- User Table
CREATE TABLE users (
                       id INT AUTO_INCREMENT PRIMARY KEY,
                       username VARCHAR(50) NOT NULL,
                       password VARCHAR(100) NOT NULL,
                       name VARCHAR(100),
                       email VARCHAR(100),
                       address VARCHAR(255)
);

-- CreditCard Table
CREATE TABLE credit_cards (
                       id INT AUTO_INCREMENT PRIMARY KEY,
                       user_id INT NOT NULL,
                       card_number VARCHAR(20) NOT NULL,
                       expiration_date DATE NOT NULL,
                       cvv VARCHAR(4) NOT NULL,
                       FOREIGN KEY (user_id) REFERENCES users(id)
);