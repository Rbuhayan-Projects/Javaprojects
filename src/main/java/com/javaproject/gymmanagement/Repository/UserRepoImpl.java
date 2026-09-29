package com.javaproject.gymmanagement.Repository;

import com.javaproject.gymmanagement.config.ConnectionFactory;
import com.javaproject.gymmanagement.Model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UserRepoImpl implements UserRepo {

    private final ConnectionFactory connectionFactory;

    public UserRepoImpl(ConnectionFactory connectionFactory) {
        this.connectionFactory = connectionFactory;
    }

    @Override
    public User findByUsername(String username) {

        String sql = """
                SELECT user_id, username, password, role
                FROM users
                WHERE username = ?
                """;

        try (
                Connection connection = connectionFactory.openConnection();
                PreparedStatement statement = connection.prepareStatement(sql)
        ) {

            statement.setString(1, username);

            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {

                return new User(
                        resultSet.getString("username"),
                        resultSet.getString("password"),
                        resultSet.getString("role")
                );
            }

        } catch (Exception e) {
            throw new RuntimeException("Error finding user: " + e.getMessage(), e);
        }

        return null;
    }
}