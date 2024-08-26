package com.questcontrol;

import javax.swing.JOptionPane;

import com.questcontrol.usuario.infraestructure.controller.UsuarioConsoleAdapter;
import com.questcontrol.formulariousuario.infraestructure.controller.GeneradorFormularioConsoleAdapter;


public class Main {
    public static void main(String[] args) {
        UsuarioConsoleAdapter usuario= new UsuarioConsoleAdapter();
        GeneradorFormularioConsoleAdapter forms = new GeneradorFormularioConsoleAdapter();

        String login= """
                1. SING IN
                2. LOGIN
                3. EXIT
                """;
        
        int opcion= Integer.parseInt(JOptionPane.showInputDialog(null,login));

        if (opcion>0 && opcion<4){
            do{
                switch (opcion) {
                    case 1:
                        usuario.addUser();
                        forms.Start();
                        break;
                    case 2:
                        iu.mainMenu();
                        break;
                    default:
                        break;
                }
            }while(opcion==3);
        }
        

    }
}