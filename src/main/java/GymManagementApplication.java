package com.javaproject.gymmanagement;

import com.javaproject.gymmanagement.config.ConnectionFactory;
import com.javaproject.gymmanagement.config.DbConnection;
import com.javaproject.gymmanagement.Controller.AuthController;
import com.javaproject.gymmanagement.Model.User;
import com.javaproject.gymmanagement.Repository.UserRepo;
import com.javaproject.gymmanagement.Repository.UserRepoImpl;
import com.javaproject.gymmanagement.Service.AuthService;
import com.javaproject.gymmanagement.View.LoginView;
import com.javaproject.gymmanagement.View.ConsuleUI;

import java.util.Scanner;

public class GymManagementApplication {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        ConsuleUI.clearScreen();
        ConsuleUI.mainBanner();

        ConnectionFactory connectionFactory =
                new DbConnection();

        UserRepo userRepo =
                new UserRepoImpl(connectionFactory);

        AuthService authService =
                new AuthService(userRepo);

        AuthController authController =
                new AuthController(authService);

        LoginView loginView = new LoginView(authController,scanner);

        User user = loginView.login();

        //After Login
        if (user == null){
            System.out.println("Opening Admin Dashboard");
        }
        scanner.close();
    }

}