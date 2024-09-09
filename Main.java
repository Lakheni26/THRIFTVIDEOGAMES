import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Scanner;

public class Main {
    private static final String DB_URL = "jdbc:mysql://localhost/thriftvideogames";
    private static final String USER = "root";
    private static final String PASSWORD = "74172001"; // Your MySQL password

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Connection connection = null;

        try {
            // Connect to the database
            connection = DriverManager.getConnection(DB_URL, USER, PASSWORD);

            while (true) {
                System.out.println("Enter the game name you want to check: ");
                String gameName = scanner.nextLine();

                // Check if the game is in stock
                if (isGameInStock(connection, gameName)) {
                    System.out.println("The game is in stock. Enter your bid: ");
                    int bid = scanner.nextInt();
                    scanner.nextLine(); // Consume newline left-over

                    // Place the bid
                    placeBid(connection, gameName, bid);
                    System.out.println("Your bid has been placed.");
                } else {
                    System.out.println("Sorry, the game is not in stock.");
                }

                System.out.println("Do you want to check another game? (yes/no)");
                String answer = scanner.nextLine();
                if (!answer.equalsIgnoreCase("yes")) {
                    break; // Exit the loop if the user doesn't want to continue
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (connection != null) connection.close(); // Close the connection
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        scanner.close();
    }

    // Check if the game is available in the database
    private static boolean isGameInStock(Connection connection, String gameName) throws SQLException {
        String query = "SELECT id FROM instockvideogames WHERE names = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, gameName); // Set the game name in the query
            ResultSet rs = stmt.executeQuery();
            return rs.next(); // Returns true if game exists
        }
    }

    // Place a bid for the game
    private static void placeBid(Connection connection, String gameName, int bid) throws SQLException {
        // Get the game ID for the given game name
        int gameId;
        String gameIdQuery = "SELECT id FROM instockvideogames WHERE names = ?";
        try (PreparedStatement stmt = connection.prepareStatement(gameIdQuery)) {
            stmt.setString(1, gameName);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                gameId = rs.getInt("id");
            } else {
                throw new SQLException("Game not found");
            }
        }

        // Place the bid
        String bidQuery = "INSERT INTO bids (game_id, user_id, bid_amount, bid_time) VALUES (?, ?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(bidQuery)) {
            stmt.setInt(1, gameId);
            stmt.setInt(2, 1); // Example user_id; adjust as necessary
            stmt.setBigDecimal(3, new BigDecimal(bid));
            stmt.setTimestamp(4, new Timestamp(System.currentTimeMillis()));
            stmt.executeUpdate();
        }
    }
}
