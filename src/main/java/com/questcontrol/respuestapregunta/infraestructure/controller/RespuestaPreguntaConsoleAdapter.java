package com.questcontrol.respuestapregunta.infraestructure.controller;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import com.questcontrol.funtions.AditionalFuntions;
import com.questcontrol.respuestapregunta.app.CreateRespuestaPreguntaUseCase;
import com.questcontrol.respuestapregunta.app.DeleteRespuestaPreguntaUseCase;
import com.questcontrol.respuestapregunta.app.FindAllRespuestasPreguntaUseCase;
import com.questcontrol.respuestapregunta.app.FindRespuestaPreguntaByIdUseCase;
import com.questcontrol.respuestapregunta.app.UpdateRespuestaPreguntaUseCase;
import com.questcontrol.respuestapregunta.domain.entity.RespuestaPregunta;
import com.questcontrol.respuestapregunta.domain.service.RespuestaPreguntaService;
import com.questcontrol.respuestapregunta.infraestructure.repository.RespuestaPreguntaRepository;

public class RespuestaPreguntaConsoleAdapter {
    private RespuestaPreguntaService respuestapreguntaService;
    private CreateRespuestaPreguntaUseCase createRespuestaPregunta;
    private DeleteRespuestaPreguntaUseCase deleteRespuestaPregunta;
    private UpdateRespuestaPreguntaUseCase updateRespuestaPregunta;
    private FindAllRespuestasPreguntaUseCase allRespuestasPregunta;
    private FindRespuestaPreguntaByIdUseCase findRespuestaPregunta;
    Scanner scanner = new Scanner(System.in);

    public RespuestaPreguntaConsoleAdapter() {
        this.respuestapreguntaService = new RespuestaPreguntaRepository();
        this.createRespuestaPregunta= new CreateRespuestaPreguntaUseCase(respuestapreguntaService);
        this.deleteRespuestaPregunta = new DeleteRespuestaPreguntaUseCase(respuestapreguntaService);
        this.updateRespuestaPregunta= new UpdateRespuestaPreguntaUseCase(respuestapreguntaService);
        this.allRespuestasPregunta = new FindAllRespuestasPreguntaUseCase(respuestapreguntaService);
        this.findRespuestaPregunta = new FindRespuestaPreguntaByIdUseCase(respuestapreguntaService);
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
                int respuestaid =Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese el rol: "));
                String newrol = JOptionPane.showInputDialog(null, "Ingrese el rol: ");
                
                RespuestaPregunta rol = new RespuestaPregunta(respuestaid,respuestaid,respuestaid,newrol);
                createRespuestaPregunta.execute(rol);
                Start();

                break;
            case 2:
                try {
                    String idaeliminar = JOptionPane.showInputDialog(null, "Ingrese el id del rol para eliminar: ");
                    int ideliminado = Integer.parseInt(idaeliminar);
                    deleteRespuestaPregunta.execute(ideliminado);
                    Start();
                    
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null,  "Ocurrio un problema; intente nuevamente");
                    Start();
                }
                
                break;
            case 3:
                StringBuilder salida = new StringBuilder("Usuarios:\n");
                List<RespuestaPregunta> role = allRespuestasPregunta.execute();
                for (RespuestaPregunta rols : role) {
                    int id = rols.getId();
                    int respuesta_id = rols.getRespuesta_id();
                    

                    salida.append("ID: ").append(id).append("\n")
                    .append("Nombre: ").append(respuesta_id).append(", ");
     
                }
                JTextArea textArea = new JTextArea(salida.toString());
                textArea.setEditable(false);
                textArea.setCaretPosition(1); 

                JScrollPane scrollPane = new JScrollPane(textArea);
                scrollPane.setPreferredSize(new java.awt.Dimension(400, 300)); 
               
                JOptionPane.showMessageDialog(null, scrollPane, "RespuestaPreguntaes", JOptionPane.INFORMATION_MESSAGE);
                
                Start();
                break;
            case 4:
                try {
                    String idusuario = JOptionPane.showInputDialog(null, "Ingrese el id del rol pque desea buscar: ");
                    int idbuscar = Integer.parseInt(idusuario);
                    Optional<RespuestaPregunta> dato = findRespuestaPregunta.execute(idbuscar);
                    StringBuilder salidaid = new StringBuilder("roles:\n");
                    if (dato.isPresent()) {
                        RespuestaPregunta datopre = dato.get();
                        int id = datopre.getId();
                        int respuesta_id = datopre.getRespuesta_id();
    
                        
                        salidaid.append("ID: ").append(id).append("\n")
                            .append("Nombre: ").append(respuesta_id);
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
                Optional<RespuestaPregunta> valor = findRespuestaPregunta.execute(idactualizar);
                RespuestaPregunta rolActalizar = valor.get();
                while (bandera) {
                    
                    String opcionesActualizar = """
                        1. Nombre rol
                        2. Salir
                        """;
                    System.out.println(opcionesActualizar);
                    Integer opc = AditionalFuntions.menuValidator(1,2);

                   
                    switch (opc) {
                        case 1:
                            rolActalizar.setRespuesta_id(Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese el nuevo Nombre del rol")));
                            break;
                        case 2:
                            bandera = false;
                            break;
                        }
                        
                } 
                updateRespuestaPregunta.execute(rolActalizar,idactualizar); 
                
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
