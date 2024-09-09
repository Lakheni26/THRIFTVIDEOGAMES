# THRIFTVIDEOGAMES
A video games thrifting program using JAVA and MY SQL Database to allow users to search and bid on avaliable games/


YOU MIGHT NEED: 

Java JDK 22 or later
MySQL Server (or any compatible database server)
MySQL Connector/J 9.0.0 (JDBC Driver for MySQL)


Getting Started
1. Set Up MySQL Database
Create the Database and Tables

Save the following SQL script into a file named setup.sql and run it using MySQL:

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

SELECT * FROM instockvideogames;
SELECT * FROM bids;

You can execute this script in MySQL Workbench or via the MySQL command line:

mysql -u <username> -p < setup.sql
2. Set Up Java Application
Download and Set Up the Project

Clone the repository to your local machine:

sh
Copy code
git clone https://github.com/<your-username>/THRIFTVIDEOGAMEAPP.git
cd THRIFTVIDEOGAMEAPP
Configure the Database Connection

Update the DB_URL, USER, and PASSWORD variables in the Main.java file to match your MySQL setup.

//java

private static final String DB_URL = "jdbc:mysql://localhost/thriftvideogames";
private static final String USER = "root";
private static final String PASSWORD = "your_mysql_password";
Compile and Run

Ensure you have the MySQL Connector/J in your classpath. Compile and run the Java application:

javac -cp .;path/to/mysql-connector-java.jar Main.java
java -cp .;path/to/mysql-connector-java.jar Main
Usage
Run the application to interact with the video game inventory and place bids.
