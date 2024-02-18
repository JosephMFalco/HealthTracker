import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class DeleteHealth {

    private int healthID;
    private Connection conn;
    private PreparedStatement statement;

    public DeleteHealth(int ID) {

        healthID = ID;

        try {

            Class.forName("org.sqlite.JDBC");

            String directoryPath = "D:\\CodingProjects\\HealthTracker\\src\\";
            String dbFileName = "health.db";
            String fullpath = directoryPath + dbFileName;
            String url = "jdbc:sqlite:" + fullpath;

            conn = DriverManager.getConnection(url);

            String query = "DELETE FROM HEALTH WHERE ID = ?";
            statement = conn.prepareStatement(query);
            statement.setInt(1, healthID);

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


