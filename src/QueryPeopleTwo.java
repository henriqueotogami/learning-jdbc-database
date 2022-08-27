import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class QueryPeopleTwo {

    public static void main(String[] args)  throws SQLException {

        new QueryPeopleOne();
        for(Person person: QueryPeopleOne.getPeople()) {
            System.out.println(person.getCode() + " ==> " + person.getName());
        }

        Connection factoryConnection = FactoryConnection.getConnection();
        String sqlCommand = "SELECT * FROM people WHERE person_name like ?";
        PreparedStatement prepStatFactoryConnection = factoryConnection.prepareStatement(sqlCommand);

        Scanner inputUserTyped = new Scanner(System.in);
        System.out.println("Enter the part of the name to be searched for: ");
        String searchName = inputUserTyped.nextLine();
        prepStatFactoryConnection.setString(1, "%" + searchName + "%");
        ResultSet queryResult = prepStatFactoryConnection.executeQuery();

        List<Person> people = new ArrayList<>();
        while(queryResult.next()) {
            int code = queryResult.getInt("person_code");
            String name = queryResult.getString("person_name");
            people.add(new Person(code, name));
        }

        for(Person person: people) {
            System.out.println(person.getCode() + " ==> " + person.getName());
        }

        prepStatFactoryConnection.close();
        factoryConnection.close();
    }
}
