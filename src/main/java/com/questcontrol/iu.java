package com.questcontrol;

import com.questcontrol.funtions.AditionalFuntions;
import com.questcontrol.usuario.infraestructure.controller.UsuarioConsoleAdapter;
import com.questcontrol.rol.infraestructure.controller.RolConsoleAdapter;
import com.questcontrol.rolusuario.infraestructure.controller.RolUsuarioConsoleAdapter;

import java.util.Scanner;

public class iu {
    public static void mainMenu(){
        System.out.println("Farmacy");
        Scanner scanner = new Scanner(System.in);

        boolean flag =true;
        String menu= " 1. Usuarios\n 2. Roles\n 3. Roles usuario\n 4. Categoria Catalogo\n 5. Active Principle\n 6. Unit Measurement\n 7. Mode Administration\n 8. Medicine\n 9. Farmacy\n 10. Laboratory\n 11. Farmacy Madicine\n 12. Salir";
        while (flag){
            AditionalFuntions.clearConsole();
            System.out.println(menu);
            int options= scanner.nextInt();

            switch (options){
                case 1:
                UsuarioConsoleAdapter csu = new UsuarioConsoleAdapter();
                    csu.Start();
                    break;
                case 2:
                RolConsoleAdapter csr = new RolConsoleAdapter();
                    csr.Start();
                    break;
                case 3:
                RolUsuarioConsoleAdapter csru = new RolUsuarioConsoleAdapter();
                    csru.Start();
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
