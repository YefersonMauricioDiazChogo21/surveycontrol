package com.questcontrol.opcionrespuesta.infraestructure.controller;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import com.questcontrol.funtions.AditionalFuntions;
import com.questcontrol.opcionrespuesta.app.CreateOpcionRespuestaUseCase;
import com.questcontrol.opcionrespuesta.app.DeleteOpcionRespuestaUseCase;
import com.questcontrol.opcionrespuesta.app.FindAllOpcionesRespuestaUseCase;
import com.questcontrol.opcionrespuesta.app.FindOpcionRespuestaByIdUseCase;
import com.questcontrol.opcionrespuesta.app.UpdateOpcionRespuestaUseCase;
import com.questcontrol.opcionrespuesta.domain.entity.OpcionRespuesta;
import com.questcontrol.opcionrespuesta.domain.service.OpcionRespuestaService;
import com.questcontrol.opcionrespuesta.infraestructure.repository.OpcionRespuestaRepository;

public class OpcionRespuestaConsoleAdapter {
    private OpcionRespuestaService opcionService;
    private CreateOpcionRespuestaUseCase createOpcionRespuesta;
    private DeleteOpcionRespuestaUseCase deleteOpcionRespuesta;
    private UpdateOpcionRespuestaUseCase updateOpcionRespuesta;
    private FindAllOpcionesRespuestaUseCase allOpcionesRespuesta;
    private FindOpcionRespuestaByIdUseCase findOpcionRespuesta;
    Scanner scanner = new Scanner(System.in);

    public OpcionRespuestaConsoleAdapter() {
        this.opcionService = new OpcionRespuestaRepository();
        this.createOpcionRespuesta= new CreateOpcionRespuestaUseCase(opcionService);
        this.deleteOpcionRespuesta = new DeleteOpcionRespuestaUseCase(opcionService);
        this.updateOpcionRespuesta= new UpdateOpcionRespuestaUseCase(opcionService);
        this.allOpcionesRespuesta = new FindAllOpcionesRespuestaUseCase(opcionService);
        this.findOpcionRespuesta = new FindOpcionRespuestaByIdUseCase(opcionService);
    }

    public void Start(){
    String menu = """
                        1. Agregar respuesta
                        2. Eliminar respuesta
                        3. Listar todas las respuestas
                        4. Buscar respuesta por id
                        5. Actualizar respuesta
                        6. Salir
                        """;
    System.out.println(menu);
    Integer opcion =scanner.nextInt();

    ejecutar(opcion);
    

  
    }
    public void ejecutar(int opcion) {
        switch (opcion) {
            case 1:
                int valor_opcion= Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese el valorde la opcion: "));
                int catalogoid= Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese el id del catalogo: "));
                int respuesta_padre_id= Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese el id de la respuesta padre si existe: "));
                int pregunta_id= Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese el id de la pregunta: "));
                String tipo_componente_html = JOptionPane.showInputDialog(null, "Ingrese el tipo de componente html: ");
                String comentario_pregunta = JOptionPane.showInputDialog(null, "Ingrese el comentario: ");
                String opcion_text = JOptionPane.showInputDialog(null, "Ingrese el texto de la opcion: ");
                
                OpcionRespuesta opcionrespuesta = new OpcionRespuesta(valor_opcion,catalogoid,respuesta_padre_id,pregunta_id,tipo_componente_html,comentario_pregunta,opcion_text);
                createOpcionRespuesta.execute(opcionrespuesta);
                Start();

                break;
            case 2:
                try {
                    String idaeliminar = JOptionPane.showInputDialog(null, "Ingrese el id de la opcion para eliminar: ");
                    int ideliminado = Integer.parseInt(idaeliminar);
                    deleteOpcionRespuesta.execute(ideliminado);
                    Start();
                    
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null,  "Ocurrio un problema; intente nuevamente");
                    Start();
                }
                
                break;
            case 3:
                StringBuilder salida = new StringBuilder("Usuarios:\n");
                List<OpcionRespuesta> opcions = allOpcionesRespuesta.execute();
                for (OpcionRespuesta opciones : opcions) {
                    int id = opciones.getId();
                    int namerol = opciones.getCatalogo_id();
                    

                    salida.append("ID: ").append(id).append("\n")
                    .append("Nombre: ").append(namerol).append(", ");
     
                }
                JTextArea textArea = new JTextArea(salida.toString());
                textArea.setEditable(false);
                textArea.setCaretPosition(1); 

                JScrollPane scrollPane = new JScrollPane(textArea);
                scrollPane.setPreferredSize(new java.awt.Dimension(400, 300)); 
               
                JOptionPane.showMessageDialog(null, scrollPane, "OpcionRespuestaes", JOptionPane.INFORMATION_MESSAGE);
                
                Start();
                break;
            case 4:
                try {
                    String idusuario = JOptionPane.showInputDialog(null, "Ingrese el id del rol pque desea buscar: ");
                    int idbuscar = Integer.parseInt(idusuario);
                    Optional<OpcionRespuesta> dato = findOpcionRespuesta.execute(idbuscar);
                    StringBuilder salidaid = new StringBuilder("roles:\n");
                    if (dato.isPresent()) {
                        OpcionRespuesta datopre = dato.get();
                        int id = datopre.getId();
                        int catalogo_id = datopre.getCatalogo_id();
    
                        
                        salidaid.append("ID: ").append(id).append("\n")
                            .append("Nombre: ").append(catalogo_id);
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
                Optional<OpcionRespuesta> valor = findOpcionRespuesta.execute(idactualizar);
                OpcionRespuesta rolActalizar = valor.get();
                while (bandera) {
                    
                    String opcionesActualizar = """
                        1. Id catalogo
                        2. Salir
                        """;
                    System.out.println(opcionesActualizar);
                    Integer opc = AditionalFuntions.menuValidator(1,2);

                   
                    switch (opc) {
                        case 1:
                            rolActalizar.setCatalogo_id(Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese el nuevo Nombre del rol")));
                            break;
                        case 2:
                            bandera = false;
                            break;
                        }
                        
                } 
                updateOpcionRespuesta.execute(rolActalizar,idactualizar); 
                
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
