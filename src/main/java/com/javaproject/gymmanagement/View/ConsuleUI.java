package com.javaproject.gymmanagement.View;

import java.util.Scanner;

public class ConsuleUI {

    public static final String RESET = "\033[0m";
    public static final String BOLD = "\033[1m";
    public static final String RED = "\033[31m";
    public static final String BRIGHT_RED = "\033[91m";
    public static final String WHITE = "\033[97m";
    public static final String GREEN = "\033[32m";
    public static final String GRAY = "\033[90m";
    public static final String BG_BLACK = "\033[20m";

    public static void clearScreen() {
        for (int i = 0; i < 50; i++) {
            System.out.println();
        }
    }
    public static void resetTerminal(){
        System.out.println(RESET);
        System.out.flush();
    }

    public static void mainBanner() {
        System.out.println(RED + BOLD);
        System.out.println(RED + "  ================================================================================================================================================");
        System.out.println("                                                                        ");
        System.out.println("             ██████╗ ██╗   ██╗███╗   ███╗    ███╗   ███╗ █████╗ ███╗   ██╗ █████╗  ██████╗ ███████╗███╗   ███╗███████╗███╗   ██╗████████╗");
        System.out.println("            ██╔════╝ ╚██╗ ██╔╝████╗ ████║    ████╗ ████║██╔══██╗████╗  ██║██╔══██╗██╔════╝ ██╔════╝████╗ ████║██╔════╝████╗  ██║╚══██╔══╝");
        System.out.println("            ██║  ███╗ ╚████╔╝ ██╔████╔██║    ██╔████╔██║███████║██╔██╗ ██║███████║██║  ███╗█████╗  ██╔████╔██║█████╗  ██╔██╗ ██║   ██║   ");
        System.out.println("            ██║   ██║  ╚██╔╝  ██║╚██╔╝██║    ██║╚██╔╝██║██╔══██║██║╚██╗██║██╔══██║██║   ██║██╔══╝  ██║╚██╔╝██║██╔══╝  ██║╚██╗██║   ██║   ");
        System.out.println("            ╚██████╔╝   ██║   ██║ ╚═╝ ██║    ██║ ╚═╝ ██║██║  ██║██║ ╚████║██║  ██║╚██████╔╝███████╗██║ ╚═╝ ██║███████╗██║ ╚████║   ██║   ");
        System.out.println("             ╚═════╝    ╚═╝   ╚═╝     ╚═╝    ╚═╝     ╚═╝╚═╝  ╚═╝╚═╝  ╚═══╝╚═╝  ╚═╝ ╚═════╝ ╚══════╝╚═╝     ╚═╝╚══════╝╚═╝  ╚═══╝   ╚═╝   ");
        System.out.println("                                                                        ");
        System.out.println(WHITE + "                                                            G Y M   M A N A G E M E N T                      ");
        System.out.println("                                                                        ");
        System.out.println(RED + "  ================================================================================================================================================");
        System.out.println(RESET + BG_BLACK);
        System.out.println(RESET);
    }
    public static void loginHeader(){


    }

    public static void login(){
        System.out.println(RED + BOLD + "  ===================================" + RESET);
        System.out.println(WHITE + BOLD + "               LOGIN  " + RESET);
        System.out.println(RED + BOLD + "  ===================================" + RESET);
    }

    public static void usernameLabel(){
        System.out.print(WHITE + "  USERNAME : " + RESET);
    }

    public static void passwordLabel(){
        System.out.print(WHITE + "  PASSWORD : " + RESET);
    }




}