-- Authors
INSERT INTO authors (first_name, last_name, biography, publisher) VALUES
    ('John', 'Doe', 'John is a prolific writer...', 'Penguin Books'),
    ('Jane', 'Smith', 'Jane has been writing...', 'HarperCollins'),
    ('Emily', 'Johnson', 'Emily\'s works include...', 'Simon & Schuster'),
    ('Michael', 'Williams', 'Michael is known for...', 'Hachette Book Group'),
    ('Mary', 'Brown', 'Mary writes fiction...', 'Macmillan Publishers'),
    ('David', 'Jones', 'David\'s historical novels...', 'Random House'),
    ('Sarah', 'Garcia', 'Sarah explores themes...', 'Scholastic Corporation'),
    ('James', 'Martinez', 'James focuses on science fiction...', 'Penguin Random House'),
    ('Patricia', 'Robinson', 'Patricia\'s poetry and essays...', 'Bloomsbury'),
    ('Robert', 'Clark', 'Robert writes thriller novels...', 'Pan Macmillan');

-- Books
INSERT INTO books (isbn, name, description, price, author_id, genre, publisher, year_published, copies_sold, rating) VALUES
    (9780307277671, 'Book 1', 'A thrilling journey...', 19.99, 1, 'FICTION', 'Penguin Books', 2021, 5000, 5),
    (9780316277722, 'Book 2', 'An insightful exploration...', 24.99, 2, 'SCIENCE', 'HarperCollins', 2020, 3000, 4),
    (9780337277733, 'Book 3', 'A captivating novel...', 15.99, 3, 'MYSTERY', 'Simon & Schuster', 2019, 4000, 3),
    (9780348277744, 'Book 4', 'Adventure at its best...', 22.99, 4, 'ADVENTURE', 'Hachette Book Group', 2018, 3500, 5),
    (9780359277755, 'Book 5', 'A deep dive into science...', 18.99, 5, 'SCIENCE', 'Macmillan Publishers', 2022, 4500, 4),
    (9780366277766, 'Book 6', 'Exploring the depths of human emotion...', 16.99, 6, 'PSYCHOLOGY', 'Random House', 2017, 2000, 3),
    (9780377277777, 'Book 7', 'A guide to personal growth...', 21.99, 7, 'SELF_HELP', 'Scholastic Corporation', 2023, 1500, 5),
    (9780388277788, 'Book 8', 'Adventures in a fantastical world...', 25.99, 8, 'FANTASY', 'Penguin Random House', 2021, 6000, 4),
    (9780399277799, 'Book 9', 'Poetry for the modern soul...', 14.99, 9, 'POETRY', 'Bloomsbury', 2020, 1000, 3),
    (9780400277710, 'Book 10', 'A thrilling crime novel...', 17.99, 10, 'CRIME', 'Pan Macmillan', 2019, 3000, 5);

-- Users
INSERT INTO users (username, password, name, email, address) VALUES
    ('user1', 'pass1', 'User One', 'user1@example.com', '123 Main St'),
    ('user2', 'pass2', 'User Two', 'user2@example.com', '456 Elm St'),
    ('user3', 'pass3', 'User Three', 'user3@example.com', '789 Pine St'),
    ('user4', 'pass4', 'User Four', 'user4@example.com', '101 Oak St'),
    ('user5', 'pass5', 'User Five', 'user5@example.com', '202 Maple St'),
    ('user6', 'pass6', 'User Six', 'user6@example.com', '303 Birch St'),
    ('user7', 'pass7', 'User Seven', 'user7@example.com', '404 Cherry St'),
    ('user8', 'pass8', 'User Eight', 'user8@example.com', '505 Cedar St'),
    ('user9', 'pass9', 'User Nine', 'user9@example.com', '606 Dogwood St'),
    ('user10', 'pass10', 'User Ten', 'user10@example.com', '707 Fir St');

-- Credit Cards
INSERT INTO credit_cards (user_id, card_number, expiration_date, cvv) VALUES
    (1, '4111111111111111', '2025-12-31', '123'),
    (2, '4222222222222222', '2024-11-30', '234'),
    (3, '4333333333333333', '2023-10-31', '345'),
    (4, '4444444444444444', '2026-09-30', '456'),
    (5, '4555555555555555', '2027-08-31', '567'),
    (6, '4666666666666666', '2028-07-31', '678'),
    (7, '4777777777777777', '2029-06-30', '789'),
    (8, '4888888888888888', '2030-05-31', '890'),
    (9, '4999999999999999', '2031-04-30', '901'),
    (10, '5111111111111111', '2032-03-31', '012');

-- Book Ratings
INSERT INTO book_ratings (book_isbn, user_id, rating_value) VALUES
    (9780307277671, 1, 5),
    (9780316277722, 2, 4),
    (9780337277733, 3, 3),
    (9780348277744, 4, 5),
    (9780359277755, 5, 4),
    (9780366277766, 6, 3),
    (9780377277777, 7, 5),
    (9780388277788, 8, 4),
    (9780399277799, 9, 3),
    (9780400277710, 10, 5);

-- Book Comments
INSERT INTO book_comments (book_isbn, user_id, comment_text) VALUES
    (9780307277671, 1, 'Incredible book, must read!'),
    (9780316277722, 2, 'Very insightful, loved it.'),
    (9780337277733, 3, 'Interesting plot but slow at times.'),
    (9780348277744, 4, 'Fascinating historical context!'),
    (9780359277755, 5, 'Great for science enthusiasts.'),
    (9780366277766, 6, 'Deep and thought-provoking.'),
    (9780377277777, 7, 'A must-read for personal development.'),
    (9780388277788, 8, 'Magical and captivating!'),
    (9780399277799, 9, 'Poetry that touches the soul.'),
    (9780400277710, 10, 'Gripping crime story from start to finish.');

-- Shopping Carts
INSERT INTO shopping_carts (user_id) VALUES
(1),
(2),
(3),
(4),
(5),
(6),
(7),
(8),
(9),
(10);

-- Cart Items
INSERT INTO cart_items (shopping_cart_id, book_id, quantity) VALUES
    (1, 9780307277671, 1),
    (2, 9780316277722, 2),
    (3, 9780337277733, 1),
    (4, 9780348277744, 2),
    (5, 9780359277755, 1),
    (6, 9780366277766, 2),
    (7, 9780377277777, 1),
    (8, 9780388277788, 2),
    (9, 9780399277799, 1),
    (10, 9780400277710, 2);

-- Wishlists
INSERT INTO wishlists (user_id, wishlist_id, wishlist_name, book_id) VALUES
    (1, 1, 'My First Wishlist', 9780307277671),
    (2, 2, 'Summer Reads', 9780316277722),
    (3, 3, 'Fiction Faves', 9780337277733),
    (4, 4, 'Historical Picks', 9780348277744),
    (5, 5, 'Science Selections', 9780359277755),
    (6, 6, 'Psychology Reads', 9780366277766),
    (7, 7, 'Self-help Collection', 9780377277777),
    (8, 8, 'Fantasy Adventures', 9780388277788),
    (9, 9, 'Poetic Works', 9780399277799),
    (10, 10, 'Crime Thrillers', 9780400277710);