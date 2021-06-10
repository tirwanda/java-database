package tirwanda.edho.database;

import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PrepareStatementTest {

    @Test
    void testPrepareStatement() throws SQLException {
        Connection connection = ConnectionUtil.getDataSource().getConnection();

        String username = "admin";
        String password = "rahasia";

        String sql = "SELECT * FROM admin WHERE username = ? AND password = ?";
        PreparedStatement prepareStatement = connection.prepareStatement(sql);
        prepareStatement.setString(1, username);
        prepareStatement.setString(2, password);

        ResultSet resultSet = prepareStatement.executeQuery();

        if (resultSet.next()) {
            System.out.println("Success to Login : " + resultSet.getString("username"));
        } else {
            System.out.println("Wrong Username or Password");
        }
        prepareStatement.close();
        connection.close();
    }
}
