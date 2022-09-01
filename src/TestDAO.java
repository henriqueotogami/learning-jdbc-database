public class TestDAO {
    public static void main(String[] args) {
        DAO dao = new DAO();
        final String sqlCommand = "INSERT INTO people (person_name) VALUES (?)";
        System.out.println(dao.include(sqlCommand, "João da Silva"));
        System.out.println(dao.include(sqlCommand, "Julia Algoz"));
        System.out.println(dao.include(sqlCommand, "Joana Bones"));
        dao.close();
    }
}
