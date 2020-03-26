package com.game;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Util class to make the scanner easier to use.
 */
public class ScannerUtils {
    /**
     * Creates a new scanner instance to work with
     */
    private static final Scanner scanner = new Scanner(System.in);
    public static String readline() {
        return scanner.nextLine();
    }

    /**
     * Method to read integer value from console
     * @return the integer value written in System.in
     */
    public static int readInt() {
        Integer num = null;
        while(num == null){
            try {
                num = scanner.nextInt();
                scanner.nextLine();
            }catch (InputMismatchException e){
                System.out.println("This is not a number input");
                scanner.nextLine();
            }
        }
        return num;
    }

    /**
     * Closes the scanner
     */
    public static void closeScanner(){
        scanner.close();
    }
}
