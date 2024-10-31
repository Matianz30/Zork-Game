package org.example;

import java.util.Scanner;

public class Console {
    private static Scanner scan = new Scanner(System.in);

    public static String readString() {
        System.out.print(": ");
        return scan.nextLine();
    }

    public static void print(String message) {
        System.out.println(message);
    }
}
