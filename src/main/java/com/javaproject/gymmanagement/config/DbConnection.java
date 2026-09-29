package com.javaproject.gymmanagement.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnection implements ConnectionFactory {

    private final String URL = "jdbc:mysql://localhost:3306/gymmanagement";

    private static final String USERNAME = "root";

    private static final String PASSWORD = "";

    @Override
    public Connection openConnection() throws SQLException {

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new SQLException("MySQL JDBC Driver not found!", e);
        }

        return DriverManager.getConnection(
                URL,
                USERNAME,
                PASSWORD
        );
    }


}
