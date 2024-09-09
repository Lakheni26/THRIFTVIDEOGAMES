# THRIFTVIDEOGAMES
A video games thrifting program using JAVA and MY SQL Database to allow users to search and bid on avaliable games/


YOU MIGHT NEED: 

Java JDK 22 or later
MySQL Server (or any compatible database server)
MySQL Connector/J 9.0.0 (JDBC Driver for MySQL)


Getting Started
1. DOWNLOAD THE MY SQL SCRIPT & OPEN IN DBMS
You can execute thE script in MySQL Workbench or via the MySQL command line:

2. Set Up Java Application
Download and Set Up the Project

Clone the repository to your local machine:

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
