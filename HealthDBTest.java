import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class HealthDBTest {

    public static void main(String[] args) {
        Connection conn = null;

        try {

            Class.forName("org.sqlite.JDBC");

            String directoryPath = "D:\\CodingProjects\\HealthTracker\\src\\";
            String dbFileName = "health.db";
            String fullpath = directoryPath + dbFileName;
            String url = "jdbc:sqlite:" + fullpath;

            conn = DriverManager.getConnection(url);

            // Creating a user and health data
            //User user = new User("joey", "falco");
            //Health health = new Health("120/60", 208.5, user.getID(), "2/18/24");

            //DisplayDB display = new DisplayDB(user.getID());
            //display.selectHealth();

            User user = new User("George", "Johnson");
            Health health = new Health("120/60", 300.4, user.getID(), "2/18/24");
            health = new Health("140/90", 320.8, user.getID(), "2/19/25");

            DisplayDB display = new DisplayDB(user.getID());
            display.selectHealth();


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

