package connect;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class BkConnection {

	public static Connection connection;
    private static final String DRIVER = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
    private static final String URL = "jdbc:sqlserver://localhost:1433;databaseName=Test_2;";
    private static final String USERNAME = "sa";
    private static final String PASSWORD = "18122002";

    private BkConnection() {}

    public static Connection GetConnection() {
        if(connection == null) {
            try {
                // Check library jar
                Class.forName(DRIVER);

                // Open connection
                connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);

            } catch (ClassNotFoundException e) {
                System.err.println("Library can be not found !");
                e.printStackTrace();
            }  catch (SQLException e) {
                System.err.println("Connect DB failed !");
                e.printStackTrace();
            }
        }

        return connection;
    }
}
