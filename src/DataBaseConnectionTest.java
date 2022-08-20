import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataBaseConnectionTest {

    public static void main(String[] args) throws SQLException {

        final String addressJdbcConnection = "jdbc:mysql://localhost?verifyServerCertificate=false&useSSL=true";
        final String userJdbcConnection = "root";
        final String passwordJdbcConnection = "";

        Connection connectionDriverManager =
                DriverManager.getConnection(addressJdbcConnection, userJdbcConnection, passwordJdbcConnection);


        System.out.println("Connection made successfully.");
        connectionDriverManager.close();
    }
}