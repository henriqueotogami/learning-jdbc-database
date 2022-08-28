import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class QueryPeopleOne {

    static List<Person> people = new ArrayList<>();

    public static List<Person> getPeople() { return people; }

    public static void setPeople(final Person people) { QueryPeopleOne.people.add(people);}

    public static void main(String[] args) throws SQLException {

        processQueryPeopleOne();
    }

    public static void processQueryPeopleOne() throws SQLException {
        System.out.println("QueryPeopleOne: BEGIN");
        Connection factoryConnection = FactoryConnection.getConnection();
        String sqlCommand = "SELECT * FROM people";

        Statement statementFactoryConnection = factoryConnection.createStatement();
        ResultSet queryResult = statementFactoryConnection.executeQuery(sqlCommand);


        while(queryResult.next()) {
            int code = queryResult.getInt("person_code");
            String name = queryResult.getString("person_name");
            setPeople(new Person(code, name));
        }

        for(Person person: getPeople()) {
            System.out.println(person.getCode() + " ==> " + person.getName());
        }

        statementFactoryConnection.close();
        factoryConnection.close();
        System.out.println("QueryPeopleOne: END");
    }
}
