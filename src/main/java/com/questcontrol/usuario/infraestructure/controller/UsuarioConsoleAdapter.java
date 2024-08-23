package com.questcontrol.usuario.infraestructure.controller;

import java.util.List;
import java.util.Optional;

import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import com.questcontrol.funtions.AditionalFuntions;
import com.questcontrol.usuario.app.CreateUsuarioUseCase;
import com.questcontrol.usuario.app.DeleteUsuarioUseCase;
import com.questcontrol.usuario.app.FindAllUsuariosUseCase;
import com.questcontrol.usuario.app.FindUsuarioByIdUseCase;
import com.questcontrol.usuario.app.UpdateUsuarioUseCase;
import com.questcontrol.usuario.domain.entity.Usuario;
import com.questcontrol.usuario.domain.service.UsuarioService;
import com.questcontrol.usuario.infraestructure.repository.UsuarioRepository;

public class UsuarioConsoleAdapter {

    private UsuarioService usuarioService;
    private CreateUsuarioUseCase createUsuario;
    private DeleteUsuarioUseCase deleteUsuario;
    private UpdateUsuarioUseCase updateUsuario;
    private FindAllUsuariosUseCase allUsuarios;
    private FindUsuarioByIdUseCase findUsuario;


    public UsuarioConsoleAdapter() {
        this.usuarioService = new UsuarioRepository();
        this.createUsuario = new CreateUsuarioUseCase(usuarioService);
        this.deleteUsuario = new DeleteUsuarioUseCase(usuarioService);
        this.updateUsuario = new UpdateUsuarioUseCase(usuarioService);
        this.allUsuarios = new FindAllUsuariosUseCase(usuarioService);
        this.findUsuario = new FindUsuarioByIdUseCase(usuarioService);
    }

    public void Start(){
    String menu = """
                        1. Agregar usuario
                        2. Eliminar usuario
                        3. Listar todos los usuarios
                        4. Buscar usuario por id
                        5. Actualizar usuario
                        6. Salir
                        """;
    System.out.println(menu);
    Integer opcion = AditionalFuntions.menuValidator(1,6);

    ejecutar(opcion);
  
    }
    public void addUser(){
        String nombre = JOptionPane.showInputDialog(null, "Ingrese su nombre: ");
        String contraseña = JOptionPane.showInputDialog(null, "Ingrese una contraseña: ");
        Usuario usuario = new Usuario(true, nombre, contraseña);
        createUsuario.execute(usuario);
        
    }
    public void ejecutar(int opcion) {
        switch (opcion) {
            case 1:
                addUser();
                Start();
                break;
            case 2:
                try {
                    String idaeliminar = JOptionPane.showInputDialog(null, "Ingrese el id del usuario para eliminar: ");
                    int ideliminado = Integer.parseInt(idaeliminar);
                    deleteUsuario.execute(ideliminado);
                    Start();
                    
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null,  "Ocurrio un problema; intente nuevamente");
                    Start();
                }
                
                break;
            case 3:
                StringBuilder salida = new StringBuilder("Usuarios:\n");
                List<Usuario> usuarios = allUsuarios.execute();
                for (Usuario usser : usuarios) {
                    int id = usser.getId();
                    String name = usser.getNombre_usuario();
                    boolean habil = usser.isHabilitado();
                    String password =  usser.getContraseña();

                    salida.append("ID: ").append(id).append("\n")
                    .append("Nombre: ").append(name).append(", ")
                    .append("Habilitado: ").append(habil ? "Sí" : "No").append(", ")
                    .append("Contraseña: ").append(password).append("\n\n");
     
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
                    String idusuario = JOptionPane.showInputDialog(null, "Ingrese el id del usuario pque desea buscar buscar: ");
                    int idbuscar = Integer.parseInt(idusuario);
                    Optional<Usuario> dato = findUsuario.execute(idbuscar);
                    StringBuilder salidaid = new StringBuilder("usuarios:\n");
                    if (dato.isPresent()) {
                        Usuario datopre = dato.get();
                        int id = datopre.getId();
                        String name = datopre.getNombre_usuario();
                        boolean habil = datopre.isHabilitado();
                        String password =  datopre.getContraseña();
    
                        
                        salidaid.append("ID: ").append(id).append("\n")
                            .append("Nombre: ").append(name).append("\n")
                            .append("Habilitado: ").append(habil ? "Sí" : "No").append("\n")
                            .append("Contraseña: ").append(password).append("\n");
                        
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
                Optional<Usuario> valor = findUsuario.execute(idactualizar);
                Usuario usuarioActalizar = valor.get();
                while (bandera) {
                    
                    String opcionesActualizar = """
                        1. Nombre
                        2. Contraseña
                        3. Habilitado
                        4. Salir
                        """;
                    System.out.println(opcionesActualizar);
                    Integer opc = AditionalFuntions.menuValidator(1,4);

                   
                    switch (opc) {
                        case 1:
                            usuarioActalizar.setNombre_usuario(JOptionPane.showInputDialog(null, "Ingrese el nuevo Nombre"));
                            break;
                        case 2:
                            usuarioActalizar.setContraseña(JOptionPane.showInputDialog(null, "Ingrese la nuevo contraseña"));
                            break;
                        case 3:
                            try {
                                int tipoEstado = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese 1 para habilitado y 0 para desabilitar"));
                                boolean estado = (tipoEstado == 1);
                                usuarioActalizar.setHabilitado(estado);
                            } catch (Exception e) {
                                JOptionPane.showMessageDialog(null,  "Ocurrio un problema; intente nuevamente");
                                Start();
                            }
                            
                            break;
                        case 4:
                            bandera = false;
                            break;
                        }
                        
                } 
                updateUsuario.execute(usuarioActalizar,idactualizar); 
                
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
