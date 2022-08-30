import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class DeletePeople {

    public static void main(String[] args) throws SQLException {

        Scanner inputUserTyped = new Scanner(System.in);
        System.out.println("Type the person's code: ");
        int actualPersonCode = inputUserTyped.nextInt();

        Connection factoryConnection = FactoryConnection.getConnection();
        String sqlDeleteCommand = "DELETE FROM people WHERE person_code = ?";

        PreparedStatement prepStatFactoryConnection = factoryConnection.prepareStatement(sqlDeleteCommand);
        prepStatFactoryConnection.setInt(1, actualPersonCode);


        final int linesAffectedByChange = prepStatFactoryConnection.executeUpdate();
        if(linesAffectedByChange > 0) {
            System.out.println("Person successfully deleted.");
            System.out.println("Rows affected by the change: " + linesAffectedByChange);
        } else {
            System.out.println("Person not excluded.");
        }

        factoryConnection.close();
        inputUserTyped.close();
    }
}

