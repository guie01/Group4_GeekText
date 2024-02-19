-- Authors
INSERT INTO authors (first_name, last_name, biography, publisher) VALUES
 ('John', 'Doe', 'John Doe is a fictional author.', 'Publisher A'),
 ('Jane', 'Smith', 'Jane Smith is a prolific writer with numerous publications.', 'Publisher B');

-- Books
INSERT INTO books (isbn, name, description, price, genre, year_published, copies_sold, author_id, publisher) VALUES
(123456789, 'Book One', 'Description of Book One', 19.99, 'HORROR', 2020, 1000, 1, 'Publisher A'),
(987654321, 'Book Two', 'Description of Book Two', 24.99, 'DRAMA', 2018, 1500, 2, 'Publisher B');

-- Users
INSERT INTO users (username, password, name, email, address) VALUES
('user1', 'password1', 'User One', 'user1@example.com', '123 Main St, City, Country'),
('user2', 'password2', 'User Two', 'user2@example.com', '456 Oak Ave, Town, Country');

-- Credit Cards
INSERT INTO credit_cards (user_id, card_number, expiration_date, cvv) VALUES
(1, '1234567890123456', '2024-12-31', '123'),
(2, '9876543210987654', '2025-06-30', '456');

-- Book Ratings
INSERT INTO book_ratings (book_isbn, user_id, rating_value) VALUES
(123456789, 1, 4),
(123456789, 2, 5),
(987654321, 1, 5),
(987654321, 2, 4);

-- Book Comments
INSERT INTO book_comments (book_isbn, user_id, comment_text) VALUES
(123456789, 1, 'Great book! Really enjoyed it.'),
(123456789, 2, 'The plot was captivating.'),
(987654321, 1, 'Interesting read.'),
(987654321, 2, 'Could not put it down!');

-- Shopping Carts
INSERT INTO shopping_carts (user_id) VALUES
(1),
(2);

-- Cart Items
INSERT INTO cart_items (shopping_cart_id, book_id, quantity) VALUES
(1, 123456789, 2),
(2, 987654321, 1);

-- Wishlists
INSERT INTO wishlists (user_id, wishlist_id, wishlist_name, book_id) VALUES
(1, 1, 'Fiction Wishlist', 123456789),
(2, 1, 'Non-Fiction Wishlist', 987654321);