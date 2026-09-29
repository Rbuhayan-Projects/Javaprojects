package com.javaproject.gymmanagement.View;

import com.javaproject.gymmanagement.Controller.AttendanceController;
import com.javaproject.gymmanagement.Model.Attendance;

import java.util.List;
import java.util.Scanner;

public class AttendanceView {

    private final Scanner scanner;
    private final AttendanceController attendanceController;

    public AttendanceView(
            Scanner scanner,
            AttendanceController attendanceController) {

        this.scanner = scanner;
        this.attendanceController = attendanceController;
    }

    public void show() {

        boolean running = true;

        while (running) {

            ConsuleUI.clearScreen();

            System.out.println();
            System.out.println(
                    ConsuleUI.RED +
                            ConsuleUI.BOLD +
                            "  ===================================" +
                            ConsuleUI.RESET
            );

            System.out.println(
                    ConsuleUI.WHITE +
                            ConsuleUI.BOLD +
                            "       ATTENDANCE DASHBOARD" +
                            ConsuleUI.RESET
            );

            System.out.println(
                    ConsuleUI.RED +
                            ConsuleUI.BOLD +
                            "  ===================================" +
                            ConsuleUI.RESET
            );

            System.out.println();

            System.out.println("  [1] Check In Member");
            System.out.println("  [2] Check Out Member");
            System.out.println("  [3] View All Attendance");
            System.out.println("  [4] View Member Attendance");
            System.out.println();
            System.out.println("  [0] Back");

            System.out.println();
            System.out.print("  Enter Your Choice: ");

            String input = scanner.nextLine().trim();

            switch (input) {

                case "1":
                    checkIn();
                    break;

                case "2":
                    checkOut();
                    break;

                case "3":
                    viewAllAttendance();
                    break;

                case "4":
                    viewMemberAttendance();
                    break;

                case "0":
                    running = false;
                    break;

                default:
                    System.out.println(
                            "  Invalid choice."
                    );
                    pressEnter();
                    break;
            }
        }
    }

    private void checkIn() {

        System.out.println();
        System.out.print("  Enter Member ID: ");

        try {

            int memberId =
                    Integer.parseInt(scanner.nextLine().trim());

            attendanceController.checkIn(memberId);

            System.out.println();
            System.out.println(
                    "  Member checked in successfully."
            );

        } catch (NumberFormatException e) {

            System.out.println();
            System.out.println(
                    "  Please enter a valid member ID."
            );

        } catch (IllegalArgumentException e) {

            System.out.println();
            System.out.println(
                    "  " + e.getMessage()
            );
        }

        pressEnter();
    }

    private void checkOut() {

        System.out.println();
        System.out.print("  Enter Member ID: ");

        try {

            int memberId =
                    Integer.parseInt(scanner.nextLine().trim());

            attendanceController.checkOut(memberId);

            System.out.println();
            System.out.println(
                    "  Member checked out successfully."
            );

        } catch (NumberFormatException e) {

            System.out.println();
            System.out.println(
                    "  Please enter a valid member ID."
            );

        } catch (IllegalArgumentException e) {

            System.out.println();
            System.out.println(
                    "  " + e.getMessage()
            );
        }

        pressEnter();
    }

    private void viewAllAttendance() {

        System.out.println();

        try {

            List<Attendance> attendances =
                    attendanceController.findAll();

            if (attendances.isEmpty()) {

                System.out.println(
                        "  No attendance records found."
                );

                pressEnter();
                return;
            }

            System.out.println(
                    "  ================= ATTENDANCE RECORDS ================="
            );

            System.out.printf(
                    "  %-12s %-12s %-15s %-15s%n",
                    "ID",
                    "MEMBER ID",
                    "TIME IN",
                    "TIME OUT"
            );

            System.out.println(
                    "  --------------------------------------------------------"
            );

            for (Attendance attendance : attendances) {

                String timeIn =
                        attendance.getTimeIn() != null
                                ? attendance.getTimeIn().toString()
                                : "--";

                String timeOut =
                        attendance.getTimeOut() != null
                                ? attendance.getTimeOut().toString()
                                : "--";

                System.out.printf(
                        "  %-12d %-12d %-15s %-15s%n",
                        attendance.getAttendanceId(),
                        attendance.getMemberId(),
                        timeIn,
                        timeOut
                );
            }

        } catch (Exception e) {

            System.out.println(
                    "  Error: " + e.getMessage()
            );
        }

        pressEnter();
    }

    private void viewMemberAttendance() {

        System.out.println();
        System.out.print("  Enter Member ID: ");

        try {

            int memberId =
                    Integer.parseInt(scanner.nextLine().trim());

            List<Attendance> attendances =
                    attendanceController.findByMemberId(memberId);

            if (attendances.isEmpty()) {

                System.out.println();
                System.out.println(
                        "  No attendance records found for this member."
                );

                pressEnter();
                return;
            }

            System.out.println();
            System.out.println(
                    "  ============ MEMBER ATTENDANCE ============"
            );

            System.out.printf(
                    "  %-12s %-15s %-15s%n",
                    "ID",
                    "TIME IN",
                    "TIME OUT"
            );

            System.out.println(
                    "  --------------------------------------------"
            );

            for (Attendance attendance : attendances) {

                String timeIn =
                        attendance.getTimeIn() != null
                                ? attendance.getTimeIn().toString()
                                : "--";

                String timeOut =
                        attendance.getTimeOut() != null
                                ? attendance.getTimeOut().toString()
                                : "--";

                System.out.printf(
                        "  %-12d %-15s %-15s%n",
                        attendance.getAttendanceId(),
                        timeIn,
                        timeOut
                );
            }

        } catch (NumberFormatException e) {

            System.out.println();
            System.out.println(
                    "  Please enter a valid member ID."
            );

        } catch (IllegalArgumentException e) {

            System.out.println();
            System.out.println(
                    "  " + e.getMessage()
            );
        }

        pressEnter();
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

