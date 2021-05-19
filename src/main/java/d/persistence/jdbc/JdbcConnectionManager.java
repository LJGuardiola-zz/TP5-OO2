package d.persistence.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class JdbcConnectionManager {

    private static final JdbcConnectionManager INSTANCE = new JdbcConnectionManager();

    public static JdbcConnectionManager getInstance() {
        return INSTANCE;
    }

    public Connection getConnection() throws SQLException {
        Connection connection;
        try {
            connection = DriverManager.getConnection("jdbc:derby:db");
        } catch (SQLException e) {
            connection = DriverManager.getConnection("jdbc:derby:db;create=true");
            setupDB(connection);
        }
        return connection;
    }

    private void setupDB(Connection connection) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(
                "CREATE TABLE POSTS ( " +
                        "ID INT NOT NULL CONSTRAINT POSTS_PK PRIMARY KEY, " +
                        "USER_ID INT NOT NULL, " +
                        "TITLE VARCHAR(255) NOT NULL, " +
                        "BODY LONG VARCHAR NOT NULL " +
                    ")"
        );
        preparedStatement.executeUpdate();
        preparedStatement.close();
    }

}