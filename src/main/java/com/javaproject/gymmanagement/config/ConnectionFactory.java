package com.javaproject.gymmanagement.config;

import java.sql.Connection;
import java.sql.SQLException;

public interface ConnectionFactory {
    Connection openConnection() throws SQLException;
}
