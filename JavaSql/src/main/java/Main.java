import java.sql.*;

public class Main {
    public static void main(String[] args) throws ClassNotFoundException {
        String userName = "root";
        String password = "123456";
        String connectionURL = "jdbc:mysql://localhost:3306/organization";
        Class.forName("com.mysql.cj.jdbc.Driver");
        try (Connection connection = DriverManager.getConnection(connectionURL, userName, password);
             Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery("SELECT DEPARTMENT, sum(SALARY) FROM organization.employees GROUP BY DEPARTMENT");
            while (resultSet.next()) {
                System.out.println(resultSet.getString(1) + " " + resultSet.getString(2));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
