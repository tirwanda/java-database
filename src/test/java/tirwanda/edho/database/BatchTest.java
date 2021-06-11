package tirwanda.edho.database;

import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class BatchTest {

    @Test
    void testStatement() throws SQLException {
        Connection connection = ConnectionUtil.getDataSource().getConnection();
        Statement statement = connection.createStatement();

        String sql = "INSERT INTO comments(email, comment) values('test@gmail.com', 'hello')";

        for (int i = 0; i < 1000; i++) {
            statement.addBatch(sql);
        }

        statement.executeBatch();

        statement.close();
        connection.close();
    }

    @Test
    void testPreparedStatement() throws SQLException {
        Connection connection = ConnectionUtil.getDataSource().getConnection();

        String sql = "INSERT INTO comments(email, comment) values(?, ?)";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);

        for (int i = 0; i < 100; i++) {
            preparedStatement.clearParameters();
            preparedStatement.setString(1, "edho@gmail.com");
            preparedStatement.setString(2, "Hai..");
            preparedStatement.addBatch();
        }
        preparedStatement.executeBatch();

        preparedStatement.close();
        connection.close();
    }
}
