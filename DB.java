import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DB {

    public static void main(String[] args) {

        Connection conn = null;

        try {

            Class.forName("org.sqlite.JDBC");

            String directoryPath = "D:\\CodingProjects\\HealthTracker\\src\\",
                    dbFileName = "health.db",
                    fullpath = directoryPath + dbFileName,
                    url = "jdbc:sqlite:" + fullpath;

            conn = DriverManager.getConnection(url);

            Statement statement = conn.createStatement();

            String healthTable =
                    "CREATE TABLE IF NOT EXISTS health (\n"
                            + "ID INTEGER PRIMARY KEY, \n"
                            + "userID INTEGER NOT NULL, \n"  // Added missing comma
                            + "weight DOUBLE NULL, \n"
                            + "bloodPressure TEXT NULL, \n"  // Added missing comma
                            + "date DATE NULL, \n"
                            + "FOREIGN KEY (userID) REFERENCES user(ID)\n"  // Corrected "TABEL" to "TABLE" and added missing semicolon
                            + ");";

            String userTable =
                    "CREATE TABLE IF NOT EXISTS user (\n"
                            + "ID INTEGER PRIMARY KEY, \n"
                            + "firstName TEXT NULL, \n"
                            + "lastName TEXT NULL\n"
                            + ");";

            System.out.println("Creating health and user tables...");
            statement.execute(healthTable);
            statement.execute(userTable);

            System.out.println("Tables created successfully.");

            statement.close();

        } catch (ClassNotFoundException | SQLException e) {

            e.printStackTrace();

        } finally {

            try {

                if (conn != null)
                    conn.close();

            } catch (SQLException e) {

                e.printStackTrace();

            }
        }
    }
}
