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

            User user;
            Health health;
            DisplayDB display;

            //user = new User("Joey", "Falco", "Jfalco", "sh98");
            //health = new Health("120/70", 205.5, user.getID(), "2/18/19");


            user = new User("Jfalco", "sh98");
            //health = new Health("110/65", 200.1, user.getID(), "2/25/19");
            display = new DisplayDB(user.getID());
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

