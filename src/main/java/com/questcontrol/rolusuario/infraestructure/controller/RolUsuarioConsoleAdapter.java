package com.questcontrol.rolusuario.infraestructure.controller;

import java.util.List;
import java.util.Optional;

import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import com.questcontrol.funtions.AditionalFuntions;
import com.questcontrol.rolusuario.app.CreateRolUsuarioUseCase;
import com.questcontrol.rolusuario.app.DeleteRolUsuarioUseCase;
import com.questcontrol.rolusuario.app.FindAllRolesUsuarioUseCase;
import com.questcontrol.rolusuario.app.FindRolUsuarioByIdUseCase;
import com.questcontrol.rolusuario.app.UpdateRolUsuarioUseCase;
import com.questcontrol.rolusuario.domain.entity.RolUsuario;
import com.questcontrol.rolusuario.domain.service.RolUsuarioService;
import com.questcontrol.rolusuario.infraestructure.repository.RolUsuarioRepository;

public class RolUsuarioConsoleAdapter {
    private RolUsuarioService rolusuarioService;
    private CreateRolUsuarioUseCase createRolUsuario;
    private DeleteRolUsuarioUseCase deleteRolUsuario;
    private UpdateRolUsuarioUseCase updateRolUsuario;
    private FindAllRolesUsuarioUseCase allRolUsuarios;
    private FindRolUsuarioByIdUseCase findRolUsuario;


    public  RolUsuarioConsoleAdapter() {
        this.rolusuarioService = new RolUsuarioRepository();
        this.createRolUsuario = new CreateRolUsuarioUseCase(rolusuarioService);
        this.deleteRolUsuario = new DeleteRolUsuarioUseCase(rolusuarioService);
        this.updateRolUsuario = new UpdateRolUsuarioUseCase(rolusuarioService);
        this.allRolUsuarios = new FindAllRolesUsuarioUseCase(rolusuarioService);
        this.findRolUsuario = new FindRolUsuarioByIdUseCase(rolusuarioService);
    }

    public void Start(){
    String menu = """
                        1. Agregar rol de usuario
                        2. Eliminar rol de usuario
                        3. Listar todos los rol de usuarios
                        4. Buscar rol de usuario por id
                        5. Actualizar rol de usuario
                        6. Salir
                        """;
    System.out.println(menu);
    Integer opcion = AditionalFuntions.menuValidator(1,6);

    ejecutar(opcion);
    

  
    }
    public void ejecutar(int opcion) {
        switch (opcion) {
            case 1:
            
                int usuario_id = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese el id del usuario: "));
                RolUsuario rolUsuario = new RolUsuario(usuario_id);
                createRolUsuario.execute(rolUsuario);
                Start();

                break;
            case 2:
                try {
                    String idaeliminar = JOptionPane.showInputDialog(null, "Ingrese el id del rol_usuario para eliminar: ");
                    int ideliminado = Integer.parseInt(idaeliminar);
                    deleteRolUsuario.execute(ideliminado);
                    Start();
                    
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null,  "Ocurrio un problema; intente nuevamente");
                    Start();
                }
                
                break;
            case 3:
                StringBuilder salida = new StringBuilder("Rol_Usuarios:\n");
                List<RolUsuario> rolUsuarios = allRolUsuarios.execute();
                for (RolUsuario rolUsser : rolUsuarios) {
                    int id = rolUsser.getRol_id();
                    int usuario_id_b = rolUsser.getUsuario_id();

                    salida.append("ID: ").append(id).append("\n")
                    .append("Id Usuario: ").append(usuario_id_b);
     
                }
                JTextArea textArea = new JTextArea(salida.toString());
                textArea.setEditable(false);
                textArea.setCaretPosition(1); 

                JScrollPane scrollPane = new JScrollPane(textArea);
                scrollPane.setPreferredSize(new java.awt.Dimension(400, 300)); 
               
                JOptionPane.showMessageDialog(null, scrollPane, "Usuarios", JOptionPane.INFORMATION_MESSAGE);
                
                Start();
                break;
            case 4:
                try {
                    String idusuario = JOptionPane.showInputDialog(null, "Ingrese el id del Rol_usuario que desea buscar buscar: ");
                    int idbuscar = Integer.parseInt(idusuario);
                    Optional<RolUsuario> dato = findRolUsuario.execute(idbuscar);
                    StringBuilder salidaid = new StringBuilder("Roles_usuarios:\n");
                    if (dato.isPresent()) {
                        RolUsuario datopre = dato.get();
                        int id = datopre.getRol_id();
                        int usuario_id_ba= datopre.getUsuario_id();
    
                        
                        salidaid.append("ID: ").append(id).append("\n")
                            .append("Nombre: ").append(usuario_id_ba);
                        
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
                String idusuariof = JOptionPane.showInputDialog(null, "Ingrese el id del usuario que desea buscar: ");
                int idactualizar = Integer.parseInt(idusuariof);
                Optional<RolUsuario> valor = findRolUsuario.execute(idactualizar);
                RolUsuario rolUsuarioActalizar = valor.get();
                while (bandera) {
                    
                    String opcionesActualizar = """
                        1. Usuario id
                        2. Salir
                        """;
                    System.out.println(opcionesActualizar);
                    Integer opc = AditionalFuntions.menuValidator(1,4);

                   
                    switch (opc) {
                        case 1:
                            rolUsuarioActalizar.setUsuario_id(Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese el nuevo id del usuario")));
                            break;
                        case 2:
                            bandera = false;
                            break;
                        }
                        
                } 
                updateRolUsuario.execute(rolUsuarioActalizar,idactualizar); 
                
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
