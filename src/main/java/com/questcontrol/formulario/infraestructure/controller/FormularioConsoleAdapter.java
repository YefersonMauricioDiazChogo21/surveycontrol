package com.questcontrol.formulario.infraestructure.controller;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import com.questcontrol.funtions.AditionalFuntions;
import com.questcontrol.rol.app.CreateRolUseCase;
import com.questcontrol.rol.app.DeleteRolUseCase;
import com.questcontrol.rol.app.FindAllRolesUseCase;
import com.questcontrol.rol.app.FindRolByIdUseCase;
import com.questcontrol.rol.app.UpdateRolUseCase;
import com.questcontrol.rol.domain.entity.Rol;
import com.questcontrol.rol.domain.service.RolService;
import com.questcontrol.rol.infraestructure.repository.RolRepository;

public class FormularioConsoleAdapter {
    private RolService rolService;
    private CreateRolUseCase createRol;
    private DeleteRolUseCase deleteRol;
    private UpdateRolUseCase updateRol;
    private FindAllRolesUseCase allRoles;
    private FindRolByIdUseCase findRol;
    Scanner scanner = new Scanner(System.in);

    public RolConsoleAdapter() {
        this.rolService = new RolRepository();
        this.createRol= new CreateRolUseCase(rolService);
        this.deleteRol = new DeleteRolUseCase(rolService);
        this.updateRol= new UpdateRolUseCase(rolService);
        this.allRoles = new FindAllRolesUseCase(rolService);
        this.findRol = new FindRolByIdUseCase(rolService);
    }

    public void Start(){
    String menu = """
                        1. Agregar rol
                        2. Eliminar rol
                        3. Listar todos los roles
                        4. Buscar rol por id
                        5. Actualizar rol
                        6. Salir
                        """;
    System.out.println(menu);
    Integer opcion =scanner.nextInt();

    ejecutar(opcion);
    

  
    }
    public void ejecutar(int opcion) {
        switch (opcion) {
            case 1:

                String newrol = JOptionPane.showInputDialog(null, "Ingrese el rol: ");
                
                Rol rol = new Rol(newrol);
                createRol.execute(rol);
                Start();

                break;
            case 2:
                try {
                    String idaeliminar = JOptionPane.showInputDialog(null, "Ingrese el id del rol para eliminar: ");
                    int ideliminado = Integer.parseInt(idaeliminar);
                    deleteRol.execute(ideliminado);
                    Start();
                    
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null,  "Ocurrio un problema; intente nuevamente");
                    Start();
                }
                
                break;
            case 3:
                StringBuilder salida = new StringBuilder("Usuarios:\n");
                List<Rol> role = allRoles.execute();
                for (Rol rols : role) {
                    int id = rols.getId();
                    String namerol = rols.getRol();
                    

                    salida.append("ID: ").append(id).append("\n")
                    .append("Nombre: ").append(namerol).append(", ");
     
                }
                JTextArea textArea = new JTextArea(salida.toString());
                textArea.setEditable(false);
                textArea.setCaretPosition(1); 

                JScrollPane scrollPane = new JScrollPane(textArea);
                scrollPane.setPreferredSize(new java.awt.Dimension(400, 300)); 
               
                JOptionPane.showMessageDialog(null, scrollPane, "Roles", JOptionPane.INFORMATION_MESSAGE);
                
                Start();
                break;
            case 4:
                try {
                    String idusuario = JOptionPane.showInputDialog(null, "Ingrese el id del rol pque desea buscar: ");
                    int idbuscar = Integer.parseInt(idusuario);
                    Optional<Rol> dato = findRol.execute(idbuscar);
                    StringBuilder salidaid = new StringBuilder("roles:\n");
                    if (dato.isPresent()) {
                        Rol datopre = dato.get();
                        int id = datopre.getId();
                        String namerol = datopre.getRol();
    
                        
                        salidaid.append("ID: ").append(id).append("\n")
                            .append("Nombre: ").append(namerol);
                    } 
                    JOptionPane.showMessageDialog(null, salidaid);
                    Start();
    
                    
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null,  "Ocurrio un problema; intente nuevamente");
                    Start();
                }
               
                break;
            case 5:
            try {
                boolean bandera = true;
                String idrolf = JOptionPane.showInputDialog(null, "Ingrese el id del usuario que desea buscar: ");
                int idactualizar = Integer.parseInt(idrolf);
                Optional<Rol> valor = findRol.execute(idactualizar);
                Rol rolActalizar = valor.get();
                while (bandera) {
                    
                    String opcionesActualizar = """
                        1. Nombre rol
                        2. Salir
                        """;
                    System.out.println(opcionesActualizar);
                    Integer opc = AditionalFuntions.menuValidator(1,2);

                   
                    switch (opc) {
                        case 1:
                            rolActalizar.setRol(JOptionPane.showInputDialog(null, "Ingrese el nuevo Nombre del rol"));
                            break;
                        case 2:
                            bandera = false;
                            break;
                        }
                        
                } 
                updateRol.execute(rolActalizar,idactualizar); 
                
            } catch (Exception e) {
                e.printStackTrace();
                Start();
            }
                break;
            case 6:
                break;
            default:
                break;
        }
    }
}
