import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DisplayDB {

    private int userID;
    private Connection conn;

    public DisplayDB() {

    }

    public DisplayDB(int userID) {

        this.userID = userID;

    }

    public void selectHealth() {

        PreparedStatement statement = null;
        ResultSet resultSet = null;
        String bloodPressure;
        double weight;
        String date;

        try {

            Class.forName("org.sqlite.JDBC");

            String directoryPath = "D:\\CodingProjects\\HealthTracker\\src\\";
            String dbFileName = "health.db";
            String fullpath = directoryPath + dbFileName;
            String url = "jdbc:sqlite:" + fullpath;

            conn = DriverManager.getConnection(url);

            String SELECT = "SELECT bloodPressure, weight, date FROM HEALTH WHERE userID = ?";
            statement = conn.prepareStatement(SELECT);
            statement.setInt(1, userID);
            resultSet = statement.executeQuery();

            while (resultSet.next()) {

                bloodPressure = resultSet.getString("bloodPressure");
                weight = resultSet.getDouble("weight");
                date = resultSet.getString("date");

                System.out.println("Blood Pressure: " + bloodPressure + ", Weight: " + weight + ", Date: " + date);

            }

        } catch (ClassNotFoundException | SQLException e) {

            e.printStackTrace();

        } finally {

            try {
                if (resultSet != null)
                    resultSet.close();

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

