import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class QueryPeopleOne {

    public static void main(String[] args) throws SQLException {

        Connection factoryConnection = FactoryConnection.getConnection();
        String sqlCommand = "SELECT * FROM people";

        Statement statementFactoryConnection = factoryConnection.createStatement();
        ResultSet queryResult = statementFactoryConnection.executeQuery(sqlCommand);

        List<Person> people = new ArrayList<>();
        while(queryResult.next()) {
            int code = queryResult.getInt("person_code");
            String name = queryResult.getString("person_name");
            people.add(new Person(code, name));
        }

        for(Person person: people) {
            System.out.println(person.getCode() + " ==> " + person.getName());
        }

        statementFactoryConnection.close();
        factoryConnection.close();


    }
}
