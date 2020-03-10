package com.game;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ScannerUtils {
    private static final Scanner scanner = new Scanner(System.in);
    public static String readline() {
        return scanner.nextLine();
    }

    public static int readInt() {
        Integer num = null;
        while(num == null){
            try {
                num = scanner.nextInt();
                scanner.nextLine();
            }catch (InputMismatchException e){
                System.out.println("This is not a number input");
            }
        }
        return num;
    }

    public static void closeScanner(){
        scanner.close();
    }
}
