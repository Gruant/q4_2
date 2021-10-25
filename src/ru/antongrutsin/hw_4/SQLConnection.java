package ru.antongrutsin.hw_4;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class SQLConnection {

    private Connection connection;
    private Properties properties;

    public Connection connect() {
        if (connection == null) {
            try {
                Class.forName( "com.mysql.cj.jdbc.Driver");
                connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/cinema", getProperties());
            } catch (ClassNotFoundException | SQLException e) {
                e.printStackTrace();
            }
        }
        return connection;
    }

    public void disconnect() {
        if (connection != null) {
            try {
                connection.close();
                connection = null;
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    private Properties getProperties() {
        if (properties == null) {
            properties = new Properties();
            properties.setProperty("user", "root");
            properties.setProperty("password", "");
        }
        return properties;
    }
}