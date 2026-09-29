package com.javaproject.gymmanagement.Service;

import com.javaproject.gymmanagement.Model.User;
import com.javaproject.gymmanagement.Repository.UserRepo;

public class AuthService {

    private final UserRepo userRepo;

    public AuthService(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    public User login(String username, String password) {

        User user = userRepo.findByUsername(username);

        if (user == null) {
            throw new RuntimeException("  Invalid username or password.");
        }

        if (!user.getPassword().equals(password)) {
            throw new RuntimeException("  Invalid username or password.");
        }

        if (!"ADMIN".equalsIgnoreCase(user.getRole())) {
            throw new RuntimeException("  Access denied. Admin account required.");
        }

        return user;
    }
}