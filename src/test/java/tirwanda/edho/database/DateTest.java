package tirwanda.edho.database;

import org.junit.jupiter.api.Test;

import java.sql.*;

public class DateTest {
    @Test
    void testDate() throws SQLException {
        Connection connection = ConnectionUtil.getDataSource().getConnection();

        String sql = "INSERT INTO sample_time(sample_date, sample_time, sample_timestamp) values (?, ?, ?)";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);

        preparedStatement.setDate(1, new Date(System.currentTimeMillis()));
        preparedStatement.setTime(2, new Time(System.currentTimeMillis()));
        preparedStatement.setTimestamp(3, new Timestamp(System.currentTimeMillis()));
        preparedStatement.executeUpdate();

        preparedStatement.close();
        connection.close();
    }

    @Test
    void testDateQuery() throws SQLException {
        Connection connection = ConnectionUtil.getDataSource().getConnection();
        String sql = "SELECT * FROM sample_time";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);

        ResultSet resultSet = preparedStatement.executeQuery();

        if (resultSet.next()) {
            Date date = resultSet.getDate("sample_date");
            Time time = resultSet.getTime("sample_time");
            Timestamp timestamp = resultSet.getTimestamp("sample_timestamp");
            System.out.println(date + " | " + time + " | " + timestamp);
        }

        resultSet.close();
        preparedStatement.close();
        connection.close();
    }
}
