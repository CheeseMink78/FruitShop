
package controller;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Input {
    public static int getInt(String name) {
        Scanner sc = new Scanner(System.in);
        int input;
        System.out.print("Enter " + name + ":");
        while (true) {
            try {
                input = sc.nextInt();
                break;
            } catch (InputMismatchException e) {
                System.err.println("Not integer!");
                sc.next();
            }
        }
        return input;
    }
    public static String getString(String name) {
        Scanner sc = new Scanner(System.in);
        String s = null;
        while (s == null || s.isEmpty()) {
            System.out.print("Enter " + name + ":");
            s = sc.nextLine();
        }
        return s;
    }
    public static String getNextString() {
        Scanner sc= new Scanner(System.in);
        return sc.nextLine();
    }
}
