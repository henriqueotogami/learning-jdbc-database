import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class NewPerson {

    public static void main(String[] args) throws SQLException {

        Scanner inputTypedUser = new Scanner(System.in);

        System.out.println("Enter the name: ");
        final String personName = inputTypedUser.next();

        Connection factoryConnection = FactoryConnection.getConnection();
        final String sqlCommand = "INSERT INTO people (person_name) VALUES (?)";
        PreparedStatement factoryPreparedStatement = factoryConnection.prepareStatement(sqlCommand);
        factoryPreparedStatement.setString(1, personName);

        factoryPreparedStatement.execute();

        System.out.println("Person successfully added.");
        inputTypedUser.close();
    }
}
