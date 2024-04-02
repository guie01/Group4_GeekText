

-- Author Table
CREATE TABLE authors (
                         id INT PRIMARY KEY AUTO_INCREMENT,
                         first_name TEXT NOT NULL,
                         last_name TEXT NOT NULL,
                         biography TEXT NOT NULL,
                         publisher TEXT NOT NULL
);

-- Book Table
CREATE TABLE books (
                       isbn BIGINT PRIMARY KEY,
                       name TEXT NOT NULL,
                       description TEXT NOT NULL,
                       price FLOAT NOT NULL,
                       genre TEXT NOT NULL,
                       year_published INT NOT NULL,
                       copies_sold INT NOT NULL,
                       author_id INT NOT NULL,
                       publisher TEXT NOT NULL,
                       FOREIGN KEY (author_id) REFERENCES authors(id)
);

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

-- Book Rating Table
CREATE TABLE book_ratings (
                              rating_id INT AUTO_INCREMENT PRIMARY KEY,
                              book_isbn BIGINT NOT NULL,
                              user_id INT NOT NULL,
                              rating_value INT NOT NULL,
                              datestamp TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                              FOREIGN KEY (book_isbn) REFERENCES books(isbn),
                              FOREIGN KEY (user_id) REFERENCES users(id)
);

-- Comment Table
CREATE TABLE book_comments (
                               comment_id INT AUTO_INCREMENT PRIMARY KEY,
                               book_isbn BIGINT NOT NULL,
                               user_id INT NOT NULL,
                               comment_text TEXT NOT NULL,
                               datestamp TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                               FOREIGN KEY (book_isbn) REFERENCES books(isbn),
                               FOREIGN KEY (user_id) REFERENCES users(id)
);

-- Shopping Cart Table
CREATE TABLE shopping_carts (
                                id INT AUTO_INCREMENT PRIMARY KEY,
                                user_id INT NOT NULL,
                                book_id BIGINT NOT NULL,
                                quantity INT NOT NULL,
                                FOREIGN KEY (user_id) REFERENCES users(id),
                                FOREIGN KEY (book_id) REFERENCES books(isbn)
);


-- Wishlist Table
CREATE TABLE wishlists (
                           id INT PRIMARY KEY AUTO_INCREMENT,
                           user_id INT NOT NULL,
                           w_id INT NOT NULL,
                           wishlist_name TEXT NOT NULL,
                           FOREIGN KEY(user_id) REFERENCES users (id),
                           INDEX idx_wishlists_w (w_id)
);

CREATE TABLE wishlists_books (
                           id INT PRIMARY KEY AUTO_INCREMENT,
                           w INT NOT NULL,
                           isbn BIGINT NOT NULL,
                           FOREIGN KEY (w) REFERENCES wishlists(w_id),
                           FOREIGN KEY (isbn) REFERENCES books(isbn)
);