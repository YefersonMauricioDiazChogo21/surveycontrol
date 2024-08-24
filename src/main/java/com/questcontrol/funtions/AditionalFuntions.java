package com.questcontrol.funtions;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

import javax.swing.JOptionPane;

public class AditionalFuntions {
    public static void clearConsole(){
    try {
        if (System.getProperty("os.name").contains("Windows")) {
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        } else {
            new ProcessBuilder("clear").inheritIO().start().waitFor();
        }
    } catch (IOException |InterruptedException ex) {
        ex.printStackTrace();
    }
}

public static int menuValidator(int start, int end,String menu){
    Scanner scanner = new Scanner(System.in);
    boolean isValid = false;
    while (!isValid) {
        try {
            Integer number =Integer.parseInt(JOptionPane.showInputDialog(null,menu));
            
            if (number >= start && number <= end) {
                isValid = true;
                return number;
            } else {
                clearConsole();
                System.out.println("Error, número fuera de rango. Ingrese un número entre " + start + " y " + end + ":");
            }
        } catch (InputMismatchException e) {
            clearConsole();
            System.out.println("Error, por favor ingrese solo números. Intente nuevamente:");
            scanner.next(); 
        }
    }
    scanner.close();
    return end;
   
}

    public static void pauseConsole(){
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Press enter to continue...");
            scanner.nextLine();
        }
    }
}
