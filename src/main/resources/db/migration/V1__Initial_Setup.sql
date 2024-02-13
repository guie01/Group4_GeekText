CREATE TABLE books (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    title TEXT NOT NULL,
    edition INT NOT NULL,
    year INT NOT NULL
)
CREATE TABLE wishlists (
    w_id PRIMARY KEY AUTO_INCREMENT,
    user_id INT NOT NULL,
    wishlist_id INT NOT NULL,
    wishlist_name TEXT NOT NULL,
    book_id INT NOT NULL
)