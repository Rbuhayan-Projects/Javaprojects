package com.javaproject.gymmanagement.Controller;

import com.javaproject.gymmanagement.Model.User;
import com.javaproject.gymmanagement.Service.AuthService;

public class AuthController {

    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    public User login(String username, String password) {

        if (username == null || username.isBlank()) {
            return null;
        }

        if (password == null || password.isBlank()) {
            return null;
        }

        return authService.login(username, password);
    }
}