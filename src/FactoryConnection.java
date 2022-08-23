import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class FactoryConnection {

    public static Connection getConnection(){
        final String addressJdbcConnection = "jdbc:mysql://localhost/course_java?verifyServerCertificate=false&useSSL" +
                "=true";
        final String userJdbcConnection = "root";
        final String passwordJdbcConnection = "";

        try {
            Connection connectionDriverManager =
                    DriverManager.getConnection(addressJdbcConnection, userJdbcConnection, passwordJdbcConnection);
            System.out.println("Connection made successfully.");
            return connectionDriverManager;
        } catch (SQLException sqlException) {
            throw new RuntimeException(sqlException);
        }
    }
}
