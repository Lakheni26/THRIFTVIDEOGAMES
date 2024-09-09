CREATE DATABASE thriftvideogames;
USE thriftvideogames;

CREATE TABLE instockvideogames (
    id INT AUTO_INCREMENT PRIMARY KEY,
    names VARCHAR(255) NOT NULL,
    price VARCHAR(255) NOT NULL
);

INSERT INTO instockvideogames (names, price) 
VALUES
('The Last of Us Part II', '59.99'),
('Red Dead Redemption 2', '39.99'),
('Assassin’s Creed Valhalla', '49.99'),
('Cyberpunk 2077', '29.99'),
('Call of Duty: Modern Warfare', '59.99'),
('FIFA 22', '39.99'),
('Halo Infinite', '59.99'),
('Resident Evil Village', '49.99'),
('Spider-Man: Miles Morales', '49.99'),
('Far Cry 6', '59.99'),
('Ghost of Tsushima', '39.99'),
('Elden Ring', '59.99'),
('Forza Horizon 5', '49.99'),
('Battlefield 2042', '59.99'),
('Grand Theft Auto V', '29.99'),
('NBA 2K22', '39.99'),
('Hitman 3', '49.99'),
('Mortal Kombat 11', '39.99'),
('Horizon Forbidden West', '59.99'),
('Ratchet & Clank: Rift Apart', '59.99');

CREATE TABLE bids (
    id INT AUTO_INCREMENT PRIMARY KEY,
    game_id INT,
    user_id INT,
    bid_amount DECIMAL(10, 2),
    bid_time TIMESTAMP,
    FOREIGN KEY (game_id) REFERENCES instockvideogames(id)
);

select * FROM instockvideogames;
SELECT * FROM bids;
