package com.javaproject.gymmanagement.View;

import com.javaproject.gymmanagement.Controller.AuthController;
import com.javaproject.gymmanagement.Model.User;

import java.util.Scanner;

public class LoginView {

    private final AuthController authController;
    private final Scanner scanner;

    public LoginView(
            AuthController authController,
            Scanner scanner) {

        this.authController = authController;
        this.scanner = scanner;
    }

    public User login(){
        ConsuleUI.clearScreen();

        ConsuleUI.loginHeader() ;

        ConsuleUI.usernameLabel();
        String username = scanner.nextLine();

        ConsuleUI.passwordLabel();
        String password = scanner.nextLine();

        User user = authController.login(
                username,
                password
        );

        //Send Credentials to controller
        if (user == null){
            ConsuleUI.loginFailed();

            return null;
        }
        //Login Successfull
        ConsuleUI.loginSuccess(
                user.getFirstName()
                + " "
                + user.getLastName()
        );
        return user;
    }


}
