import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class CreateDataBase {

    public static void main(String[] args) throws SQLException {
        final String addressJdbcConnection = "jdbc:mysql://localhost?verifyServerCertificate=false&useSSL=true";
        final String userJdbcConnection = "root";
        final String passwordJdbcConnection = "";

        Connection connectionDriverManager =
                DriverManager.getConnection(addressJdbcConnection, userJdbcConnection, passwordJdbcConnection);

        Statement statement = connectionDriverManager.createStatement();
        statement.execute("CREATE DATABASE IF NOT EXISTS course_java");

        System.out.println("Database created successfully.");
        connectionDriverManager.close();
    }
}

