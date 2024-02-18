import java.sql.*;

public class User {

    private int ID;
    private String firstName,
            lastName,
            userName,
            password;
    private Connection conn;
    private PreparedStatement statement;
    private ResultSet resultSet;


    public User(int ID, String firstName, String lastName, String user, String pass) {

        this.ID = ID;
        this.firstName = firstName;
        this.lastName = lastName;
        userName = user;
        password = pass;

        try {

            Class.forName("org.sqlite.JDBC");

            String directoryPath = "D:\\CodingProjects\\HealthTracker\\src\\";
            String dbFileName = "health.db";
            String fullpath = directoryPath + dbFileName;
            String url = "jdbc:sqlite:" + fullpath;

            conn = DriverManager.getConnection(url);

            String query = "INSERT INTO USER (ID, firstName, lastName, userName, password) VALUES (?, ?, ?, ?, ?)";
            statement = conn.prepareStatement(query);
            statement.setInt(1, ID);
            statement.setString(2, firstName);
            statement.setString(3, lastName);
            statement.setString(4, userName);
            statement.setString(5, password);

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

    public User(String firstName, String lastName, String user, String pass) {

        this.firstName = firstName;
        this.lastName = lastName;
        userName = user;
        password = pass;

        try {

            Class.forName("org.sqlite.JDBC");

            String directoryPath = "D:\\CodingProjects\\HealthTracker\\src\\";
            String dbFileName = "health.db";
            String fullpath = directoryPath + dbFileName;
            String url = "jdbc:sqlite:" + fullpath;

            conn = DriverManager.getConnection(url);

            String query = "INSERT INTO USER (firstName, lastName, userName, password) VALUES (?, ?, ?, ?)";
            statement = conn.prepareStatement(query);
            statement.setString(1, firstName);
            statement.setString(2, lastName);
            statement.setString(3, userName);
            statement.setString(4, password);

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

    public User(String user, String pass) {

        userName = user;
        password = pass;

        try {

            Class.forName("org.sqlite.JDBC");

            String directoryPath = "D:\\CodingProjects\\HealthTracker\\src\\";
            String dbFileName = "health.db";
            String fullpath = directoryPath + dbFileName;
            String url = "jdbc:sqlite:" + fullpath;

            conn = DriverManager.getConnection(url);

            String query = "INSERT INTO USER (userName, password) VALUES (?, ?)";
            statement = conn.prepareStatement(query);
            statement.setString(1, userName);
            statement.setString(2, password);

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

    public int getID () {

        try {

            String directoryPath = "D:\\CodingProjects\\HealthTracker\\src\\";
            String dbFileName = "health.db";
            String fullpath = directoryPath + dbFileName;
            String url = "jdbc:sqlite:" + fullpath;

            conn = DriverManager.getConnection(url);

            Statement state = conn.createStatement();

            String query = "SELECT last_insert_rowid()";
            resultSet = state.executeQuery(query);

            if (resultSet.next())
                ID = resultSet.getInt(1);


        } catch (SQLException e) {

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

        return ID;

    }
}

