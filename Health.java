import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Health {

    private String bloodPressure;
    private double weight;
    private String date;
    private int userID;
    private Connection conn;
    private PreparedStatement statement;

    public Health(String bloodPressure, double weight, int userID, String date) {

        this.bloodPressure = bloodPressure;
        this.weight = weight;
        this.userID = userID;
        this.date = date;

        try {

            Class.forName("org.sqlite.JDBC");

            String directoryPath = "D:\\CodingProjects\\HealthTracker\\src\\";
            String dbFileName = "health.db";
            String fullpath = directoryPath + dbFileName;
            String url = "jdbc:sqlite:" + fullpath;

            conn = DriverManager.getConnection(url);

            String query = "INSERT INTO HEALTH (UserID, date, bloodPressure, weight) VALUES (?, ?, ?, ?)";
            statement = conn.prepareStatement(query);
            statement.setInt(1, userID);
            statement.setString(2, date);
            statement.setString(3, bloodPressure);
            statement.setDouble(4, weight);

            statement.executeUpdate();

        } catch (ClassNotFoundException | SQLException e) {

            e.printStackTrace();

        } finally {

            try {
                if (statement != null)
                    statement.close();

                if (conn != null)
                    conn.close();

            } catch (SQLException e) {

                e.printStackTrace();

            }
        }
    }
}

