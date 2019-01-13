package pl.pawel.gaudziak.kalkulacja.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnector {

    public Connection connection() throws SQLException {
        return DriverManager.getConnection("jdbc:mysql://localhost/kalkulacja?useSSL=false", "root", "");
    }
}