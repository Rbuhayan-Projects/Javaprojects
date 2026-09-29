package com.javaproject.gymmanagement;

import com.javaproject.gymmanagement.Controller.AttendanceController;
import com.javaproject.gymmanagement.Controller.AuthController;
import com.javaproject.gymmanagement.Model.User;
import com.javaproject.gymmanagement.Repository.AttendanceRepo;
import com.javaproject.gymmanagement.Repository.AttendanceRepoImpl;
import com.javaproject.gymmanagement.Repository.UserRepo;
import com.javaproject.gymmanagement.Repository.UserRepoImpl;
import com.javaproject.gymmanagement.Service.AttendanceService;
import com.javaproject.gymmanagement.Service.AuthService;
import com.javaproject.gymmanagement.View.AdminDashboard;
import com.javaproject.gymmanagement.View.AttendanceView;
import com.javaproject.gymmanagement.View.ConsuleUI;
import com.javaproject.gymmanagement.View.LoginView;
import com.javaproject.gymmanagement.config.ConnectionFactory;
import com.javaproject.gymmanagement.config.DbConnection;

import java.util.Scanner;

public class GymManagementApplication {

    public static void main(String[] args) {

        ConnectionFactory connectionFactory =
                new DbConnection();


        UserRepo userRepo =
                new UserRepoImpl(connectionFactory);

        AttendanceRepo attendanceRepo =
                new AttendanceRepoImpl(connectionFactory);

        AuthService authService =
                new AuthService(userRepo);

        AttendanceService attendanceService =
                new AttendanceService(attendanceRepo);

        AuthController authController =
                new AuthController(authService);

        AttendanceController attendanceController =
                new AttendanceController(attendanceService);

        Scanner scanner = new Scanner(System.in);

        LoginView loginView =
                new LoginView(
                        authController,
                        scanner
                );

        AttendanceView attendanceView =
                new AttendanceView(
                        scanner,
                        attendanceController
                );

        User user = loginView.show();

        if (user != null) {

            scanner.nextLine();

            ConsuleUI.clearScreen();

            AdminDashboard dashboard =
                    new AdminDashboard(
                            scanner,
                            user,
                                attendanceView
                    );

            dashboard.show(user);
        }

        scanner.close();
    }
}
