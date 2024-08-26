package com.questcontrol.funtions;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.InputMismatchException;
import java.util.Scanner;

import javax.swing.JOptionPane;

import com.questcontrol.Database;

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

    public static Boolean istAdmin(String name_usuario,String contraseña){
        String sql ="SELECT id,habilitado,nombre_usuario,contraseña FROM usuario";
        

        try(Connection connection = Database.getConnection();
        PreparedStatement ps =connection.prepareStatement(sql)){
            ResultSet rs=ps.executeQuery();

            while(rs.next()){
                int idu=rs.getInt("id");
                Boolean habilitado =rs.getBoolean("habilitado");
                String nombre =rs.getString("nombre_usuario");
                String contraseñau =rs.getString("contraseña");
                if (name_usuario == nombre && contraseña==contraseñau){
                    String sql2 ="SELECT rol_id,usuario_id FROM rol_usuario WHERE usuario_id=?";
                    try(Connection connection2 = Database.getConnection();
                    PreparedStatement ps2 =connection2.prepareStatement(sql2)){
                        ps2.setInt(1,idu);
                        ResultSet rs2=ps.executeQuery();

                        while(rs.next()){
                            int rol_id=rs2.getInt("rol_id");
                            int usuario_id =rs2.getInt("usuario_id");
                            if(rol_id==1){
                                if (habilitado==true){
                                    return true;
                                }else{
                                    return false;
                                }
                                
                            }else{
                                return false;
                            }  
                        }
                    } catch(SQLException e){
                        e.printStackTrace();
                    }
                }
            }
        } catch(SQLException e){
            e.printStackTrace();
        }
        return null;
    }
}
