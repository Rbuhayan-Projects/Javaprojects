package com.javaproject.gymmanagement.Repository;

import com.javaproject.gymmanagement.Model.User;
import com.javaproject.gymmanagement.config.ConnectionFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserRepoImpl implements UserRepo {

    private final ConnectionFactory connectionFactory;

    public UserRepoImpl(ConnectionFactory connectionFactory) {
        this.connectionFactory = connectionFactory;
    }

    private static final String FIND_BY_USERNAME_SQL = """
            SELECT 
            user_id,
            username,
            first_name,
            last_name,
            is_active,
            created_at,
            updated_at
            FROM users
            WHERE username = ?
            """;

    @Override
    public User findByUsername(String username) {
        try (Connection connection = connectionFactory.openConnection();

             PreparedStatement statement = connection.prepareStatement(FIND_BY_USERNAME_SQL)) {

            statement.setString(1, username);

            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    User user = new User();

                    user.setUserId(resultSet.getInt("user_id"));
                    user.setUsername(resultSet.getString("username"));
                    user.setFirstName(resultSet.getString("first_name"));
                    user.setLastName(resultSet.getString("last_name"));
                    user.setActive(resultSet.getBoolean("is_active"));

                    if (resultSet.getTimestamp("created_at") != null) {
                        user.setCreatedAt(
                                resultSet.getTimestamp("created_at")
                                        .toLocalDateTime()
                        );
                    }
                    if (resultSet.getTimestamp("updated_at") != null) {
                        user.setUpdateAt(
                                resultSet.getTimestamp("updated_at")
                                        .toLocalDateTime()
                        );
                    }
                    return user;
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(
                    "Error finding user : " + e.getMessage(),
                    e
            );
        }
        return null;
    }
}
