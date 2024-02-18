import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DB {

    public static void main(String[] args) {

        Connection conn = null;

        try {

            Class.forName("org.sqlite.JDBC");

            //How can I make this dynamic... how can I make this so that it can be different for other people?
            String directoryPath = "D:\\CodingProjects\\HealthTracker\\src\\",
                    dbFileName = "health.db",
                    fullpath = directoryPath + dbFileName,
                    url = "jdbc:sqlite:" + fullpath;

            conn = DriverManager.getConnection(url);

            Statement statement = conn.createStatement();

            String healthTable =
                    "CREATE TABLE IF NOT EXISTS HEALTH (\n"
                            + "ID INTEGER PRIMARY KEY AUTOINCREMENT, \n"
                            + "userID INTEGER NOT NULL, \n"
                            + "weight DOUBLE NULL, \n"
                            + "bloodPressure TEXT NULL, \n"
                            + "date DATE NULL, \n"
                            + "FOREIGN KEY (userID) REFERENCES USER(ID)\n"
                            + ");";

            String userTable =
                    "CREATE TABLE IF NOT EXISTS USER ("
                            + "ID INTEGER PRIMARY KEY AUTOINCREMENT,"
                            + "firstName TEXT NULL,"
                            + "lastName TEXT NULL,"
                            + "userName TEXT NOT NULL,"
                            + "password TEXT NOT NULL"
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
