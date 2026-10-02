package com.example;

import java.util.Scanner;

public class App {

    public static String getWelcomeMessage(String username) {
        return "Welcome, " + username + "!";
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("================================");
        System.out.println("       USER APPLICATION");
        System.out.println("================================");

        System.out.print("Enter your name: ");
        String username = scanner.nextLine();

        System.out.println();
        System.out.println(getWelcomeMessage(username));
        System.out.println("You have successfully logged in.");
        System.out.println("================================");

        scanner.close();
    }
}
