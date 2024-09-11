This is a Java-based console application for a thrift video game store, where users can view available games and place bids. The system is connected to an SQLite database to store game and bid information.

**Features**

        View a list of available video games.
        Place bids on games.
        Search for games by name.
        
**Prerequisites**

        Java JDK 17 (or later).
        SQLite (already included in the project as a dependency).
        IntelliJ IDEA (or any Java IDE).

**Getting Started**

1. Clone the Repository

        git clone https://github.com/Lakheni26/THRIFTVIDEOGAMES.git
        cd THRIFTVIDEOGAMES


2. Set Up SQLite Database
The SQLite database is included in the project. If you want to recreate it, you can use the provided thriftvideogames.sql script to set up the necessary tables:
        
        -- SQL setup script for thriftvideogames database
        
        CREATE TABLE instockvideogames (
            id INTEGER PRIMARY KEY,
            names TEXT NOT NULL,
            price REAL NOT NULL
        );
        
        CREATE TABLE bids (
            id INTEGER PRIMARY KEY,
            game_id INTEGER NOT NULL,
            bidder_name TEXT NOT NULL,
            bid_amount REAL NOT NULL,
            FOREIGN KEY (game_id) REFERENCES instockvideogames (id)
        );
   
**4. Running the Application**

        Open the project in your Java IDE (e.g., IntelliJ IDEA).
        
        Ensure you have the SQLite JDBC connector properly configured.
        
        Run the ThriftGameStoreApp.java class to start the application.

**5. Using the Application**
   
        View Games: The app will display a list of available games.
        Place a Bid: Users can place a bid by selecting a game and entering their bid amount.
        Search: You can search for games if you don’t find what you're looking for.
        
Future Enhancements
Add a GUI interface.
Implement a more dynamic bidding system.
