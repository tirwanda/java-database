package tirwanda.edho.database;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Map;

public class ConnectionTest {

//    static {
//        try {
//            Driver mysqlDriver = new com.mysql.cj.jdbc.Driver();
//            DriverManager.registerDriver(mysqlDriver);
//        } catch (SQLException exception) {
//            Assertions.fail(exception);
//        }
//    }

    @BeforeAll
    static void beforeAll() {
        try {
            Driver mysqlDriver = new com.mysql.cj.jdbc.Driver();
            DriverManager.registerDriver(mysqlDriver);
        } catch (SQLException exception) {
            Assertions.fail(exception);
        }
    }

    @Test
    void testConnection() {
        String jdbcUrl = "jdbc:mysql://localhost:3306/java_database";
        String username = "root";
        String password = System.getenv("password");

        try {
            Connection connection = DriverManager.getConnection(jdbcUrl, username, password);
            System.out.println("Success Connect to Database");
        } catch (SQLException exception) {
            Assertions.fail(exception);
        }
    }

    @Test
    void testConnectionClose() {
        String jdbcUrl = "jdbc:mysql://localhost:3306/java_database";
        String username = "root";
        String password = System.getenv("password");

        try {
            Connection connection = DriverManager.getConnection(jdbcUrl, username, password);
            System.out.println("Success Connect to Database");
        } catch (SQLException exception) {
            Assertions.fail(exception);
        }
    }

}
