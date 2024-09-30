package org.example;

import java.util.Scanner;

public class Console {
    private Scanner scan = new Scanner(System.in);

    public String readString() {
        System.out.print("Enter a string: ");
        return scan.nextLine();
    }

    public void closeScanner() {
        scan.close();
    }
}
