import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class UpdatePeople {
    public static void main(String[] args) throws SQLException {
        System.out.println("UpdatePeople: BEGIN");

        final Scanner inputUserTyped = new Scanner(System.in);
        System.out.println("Type the person's code: ");
        int typedPersonCode = inputUserTyped.nextInt();

        final String sqlSelectCommand = "SELECT person_code, person_name FROM people WHERE person_code = ?";
        final Connection factoryConnection = FactoryConnection.getConnection();
        PreparedStatement prepStatFactoryConnection = factoryConnection.prepareStatement(sqlSelectCommand);

        prepStatFactoryConnection.setInt(1, typedPersonCode);
        final ResultSet queryResult = prepStatFactoryConnection.executeQuery();

        if(queryResult.next()){
            final Person person = new Person(queryResult.getInt(1), queryResult.getString(2));
            System.out.println("Name: " + person.getName() + " | Code: " + person.getCode());


            System.out.println("Type the new name: ");
            final String newPersonName = inputUserTyped.nextLine();
            final String sqlUpdateCommand = "UPDATE people SET person_name = ? WHERE person_code = ?";
            prepStatFactoryConnection.close();
            prepStatFactoryConnection = factoryConnection.prepareStatement(sqlUpdateCommand);
            prepStatFactoryConnection.setString(1, newPersonName);
            prepStatFactoryConnection.setInt(2, typedPersonCode);

            System.out.println("UPDATE successfully. ");
        }

        factoryConnection.close();
        inputUserTyped.close();
        System.out.println("UpdatePeople: END");
    }
}
