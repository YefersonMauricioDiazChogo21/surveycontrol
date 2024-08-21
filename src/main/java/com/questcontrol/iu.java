package com.questcontrol;

import com.questcontrol.funtions.AditionalFuntions;
import com.questcontrol.usuario.infraestructure.controller.UsuarioConsoleAdapter;

import java.util.Scanner;

public class iu {
    public static void mainMenu(){
        System.out.println("Farmacy");
        Scanner scanner = new Scanner(System.in);

        boolean flag =true;
        String menu= " 1. Usuarios\n 2. Region\n 3. City\n 4. Customer\n 5. Active Principle\n 6. Unit Measurement\n 7. Mode Administration\n 8. Medicine\n 9. Farmacy\n 10. Laboratory\n 11. Farmacy Madicine\n 12. Salir";
        while (flag){
            AditionalFuntions.clearConsole();
            System.out.println(menu);
            int options= scanner.nextInt();

            switch (options){
                case 1:
                UsuarioConsoleAdapter cs = new UsuarioConsoleAdapter();
                    cs.Start();
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 5:
                    break;
                case 6:
                    break;
                case 7:
                    break;
                case 8:
                    break;
                case 9:
                    break;
                case 10:
                    break;
                case 11:
                    break;
                case 12:
                    flag=false;
                    System.out.println("Good Bye");
                    break;
                default:
                    System.out.println("Invalid Option, Try again.");
            }
        }
        scanner.close();
    }
}
