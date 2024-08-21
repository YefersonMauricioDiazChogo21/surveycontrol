package com.questcontrol.funtions;

import java.util.Scanner;

public class AditionalFuntions {
    public static void clearConsole(){
        try{ 
            if (System.getProperty("os.name").contains("windows")){
                new ProcessBuilder("cmd","/c","cls").inheritIO().start().waitFor();
            }else{
                System.out.print("\033[h\033[2j");
                System.out.flush();
            }
        } catch (Exception e){
            System.out.println("Clear console error");
        }
    }

    public static int menuValidator(int start, int end){
        try (Scanner sc = new Scanner(System.in)) {
            int number;
            do{
                try{
                    number=sc.nextInt();
                    
                    if(number>=start && number <=end){
                        return number;
                    }else{
                        clearConsole();
                        System.out.println("Error, number out of range\n Digit a number: ");
                    }
                }catch(Exception e){
                    clearConsole();
                    System.out.println("Error, please only digit a number\n Digit a number: ");
                    sc.next();
                }
            }while(true);
        }
    }
    public static void pauseConsole(){
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Press enter to continue...");
            scanner.nextLine();
        }
    }
}
