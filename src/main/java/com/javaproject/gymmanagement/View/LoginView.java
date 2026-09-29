package com.javaproject.gymmanagement.View;

import com.javaproject.gymmanagement.Controller.AuthController;
import com.javaproject.gymmanagement.Model.User;

import java.io.Console;
import java.util.Arrays;
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

    public User show() {

        while (true) {

            ConsuleUI.clearScreen();
            ConsuleUI.mainBanner();
            System.out.println(ConsuleUI.RED + ConsuleUI.BOLD + "  ===================================" + ConsuleUI.RESET);
            System.out.println(ConsuleUI.WHITE + ConsuleUI.BOLD + "             LOGIN PAGE " + ConsuleUI.RESET);
            System.out.println(ConsuleUI.RED + ConsuleUI.BOLD + "  ===================================" + ConsuleUI.RESET);
            System.out.println("  [1] Login");
            System.out.println("  [2] Exit");
            System.out.println();
            System.out.print("  Enter your choice : ");
            String choice = scanner.nextLine().trim();

            switch (choice) {

                case "1":
                    while (true){
                        ConsuleUI.clearScreen();
                        ConsuleUI.login();
                        try {
                            User user = attemptLogin();
                            if (user != null){
                                System.out.println();
                                System.out.println(ConsuleUI.GREEN + "  LOGIN SUCCESSFULLY" + ConsuleUI.RESET);
                                System.out.print("  Press enter to continue....");
                                return user;

                            }else {
                                System.out.println();
                                System.out.println(ConsuleUI.RED + "  Invalid Username or Password" + ConsuleUI.RESET);
                                System.out.print("  Press enter to try again...");
                                scanner.nextLine();
                            }

                        }catch (RuntimeException e){
                            System.out.println();
                            System.out.println(e.getMessage());
                            System.out.println();
                            System.out.println("Press enter to try again...");
                            scanner.nextLine();
                        }
                    }


                case "2":
                    System.out.println();
                    System.out.println(ConsuleUI.WHITE + "Exiting..." + ConsuleUI.RESET);
                    break;

                default:

                    System.out.println();
                    System.out.println(
                            ConsuleUI.RED +
                                    "  Invalid choice!" +
                                    ConsuleUI.RESET
                    );

                    return show();
            }
        }
    }

    private User attemptLogin() {

        System.out.println();

        ConsuleUI.usernameLabel();
        String username = scanner.nextLine().trim();

        char[] password = readPassword();

        try {

            return authController.login(
                    username,
                    new String(password)
            );

        }catch (RuntimeException e){
            return null;
        }
        finally {

            Arrays.fill(password, '\0');
        }
    }

    private char[] readPassword() {

        Console console = System.console();

        if (console != null) {

            char[] password =
                    console.readPassword("  PASSWORD : ");

            return password == null
                    ? new char[0]
                    : password;
        }

        ConsuleUI.passwordLabel();

        return scanner.nextLine().toCharArray();
    }
}