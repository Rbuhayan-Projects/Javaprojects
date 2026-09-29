package com.javaproject.gymmanagement.View;

import com.javaproject.gymmanagement.Model.User;

import java.util.Scanner;


public class AdminDashboard {

    private final Scanner scanner;
    private final User user;
    private final AttendanceView attendanceView;


    public AdminDashboard(
            Scanner scanner,
            User user,
            AttendanceView attendanceView) {

        this.scanner = scanner;
        this.user = user;
        this.attendanceView = attendanceView;
    }
    public void show(User user) {

        boolean running = true;

        while (running) {

            ConsuleUI.clearScreen();

            System.out.println(
                    ConsuleUI.RED +
                            ConsuleUI.BOLD +
                            "  ===================================" +
                            ConsuleUI.RESET
            );

            System.out.println(
                    ConsuleUI.WHITE +
                            ConsuleUI.BOLD +
                            "            ADMIN DASHBOARD " +
                            ConsuleUI.RESET
            );

            System.out.println(
                    ConsuleUI.RED +
                            ConsuleUI.BOLD +
                            "  ===================================" +
                            ConsuleUI.RESET
            );

            System.out.println(
                    ConsuleUI.WHITE +
                            "  Welcome " +
                            user.getUsername() +
                            "!" +
                            ConsuleUI.RESET
            );

            System.out.println();

            showMenu();

            int choice = getChoice();

            switch (choice) {

                case 1:
                    manageMembers();
                    break;

                case 2:
                    manageMemberships();
                    break;

                case 3:
                    membershipPlans();
                    break;

                case 4:
                    attendanceView.show();
                    break;

                case 5:
                    payments();
                    break;

                case 0:
                    System.out.println("  Exiting...");
                    running = false;
                    break;

                default:
                    System.out.println("  Invalid choice.");
                    pressEnter();
                    break;
            }
        }
    }
    private void showMenu() {
        System.out.println(
                ConsuleUI.WHITE + "  [1] Manage Members" +
                        ConsuleUI.RESET
        );
        System.out.println(
                ConsuleUI.WHITE +
                        "  [2] Manage Membership" +
                        ConsuleUI.RESET
        );
        System.out.println(
                ConsuleUI.WHITE +
                        "  [3] Membership Plans" +
                        ConsuleUI.RESET
        );
        System.out.println(
                ConsuleUI.WHITE +
                        "  [4] Attendance " +
                        ConsuleUI.RESET
        );
        System.out.println(
                ConsuleUI.WHITE +
                        "  [5] Payments" +
                        ConsuleUI.RESET
        );
        System.out.println();
        System.out.println(
                ConsuleUI.WHITE +
                        "  [0] Logout" +
                        ConsuleUI.RESET
        );
        System.out.println();
    }
    private int getChoice() {
        System.out.print(
                ConsuleUI.BRIGHT_RED +
                        "  Enter your choice : " +
                        ConsuleUI.RESET
        );
        try {
            return Integer.parseInt(
                    scanner.nextLine()
            );
        } catch (NumberFormatException e) {
            return -1;
        }
    }

    private void manageMembers() {
        ConsuleUI.clearScreen();
        System.out.println();
        System.out.println(
                ConsuleUI.RED +
                        "  MANAGE MEMBERS" +
                        ConsuleUI.RESET
        );
        System.out.println();
        System.out.println(
                ConsuleUI.GRAY +
                        "  Member management will be implemented next." +
                        ConsuleUI.RESET
        );
        pressEnter();
    }
    private void manageMemberships() {
        ConsuleUI.clearScreen();
        System.out.println();
        System.out.println(
                ConsuleUI.RED +
                        "  MANAGE MEMBERSHIPS" +
                        ConsuleUI.RESET
        );
        System.out.println();
        System.out.println(
                ConsuleUI.GRAY +
                        "  Membership management will be implemented later." +
                        ConsuleUI.RESET
        );
        pressEnter();
    }
    public void membershipPlans(){
        ConsuleUI.clearScreen();
        System.out.println(
                ConsuleUI.RED +
                        " MEMBERSHIP PLANS" +
                        ConsuleUI.RESET
        );
    }
    public void payments(){
        ConsuleUI.clearScreen();
        System.out.println(
                ConsuleUI.RED +
                        " PAYMENTS" +
                        ConsuleUI.RESET
        );
    }
    private void pressEnter() {
        System.out.println();
        System.out.print(
                ConsuleUI.GRAY +
                        "  Press ENTER to continue..." +
                        ConsuleUI.RESET
        );
        scanner.nextLine();
    }

    }
