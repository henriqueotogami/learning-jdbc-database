import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DAO {

    private Connection connection;

    public int include(final String sqlCommand, Object ... attributes) {
        try{
            PreparedStatement preparedStatement =
                    FactoryConnection.getConnection().prepareStatement(sqlCommand,
                            PreparedStatement.RETURN_GENERATED_KEYS);
            addAttributes(preparedStatement, attributes);
            if(preparedStatement.executeUpdate() > 0) {
                ResultSet resultSet = preparedStatement.getGeneratedKeys();
                if (resultSet.next()) { return resultSet.getInt(1); }
            }
            return -1;
        } catch(final SQLException exception){
            throw new RuntimeException(exception);
        }
    }

    private void addAttributes(final PreparedStatement preparedStatement, final Object[] attributes) throws SQLException {
        int index = 1;
        for(Object attribute: attributes) {
            if(attribute instanceof String) {
                preparedStatement.setString(index, (String) attribute);
            } else {
                preparedStatement.setInt(index, (Integer) attribute);
            }
            index++;
        }
    }

    private Connection getConnection() {
        try{
            if(connection != null && !connection.isClosed()) {
                return connection;
            }
        } catch (SQLException sqlException){

        }
        connection = FactoryConnection.getConnection();
        return connection;
    }

    public void close() {
        try{
            getConnection().close();
        } catch (SQLException sqlException) {

        } finally {
            connection = null;
        }
    }
}
