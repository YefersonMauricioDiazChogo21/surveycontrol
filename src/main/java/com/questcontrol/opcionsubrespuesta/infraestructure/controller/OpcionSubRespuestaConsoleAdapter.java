package com.questcontrol.opcionsubrespuesta.infraestructure.controller;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import com.questcontrol.funtions.AditionalFuntions;
import com.questcontrol.opcionsubrespuesta.app.CreateOpcionSubRespuestaUseCase;
import com.questcontrol.opcionsubrespuesta.app.DeleteOpcionSubRespuestaUseCase;
import com.questcontrol.opcionsubrespuesta.app.FindAllOpcionesSubRespuestaUseCase;
import com.questcontrol.opcionsubrespuesta.app.FindOpcionSubRespuestaByIdUseCase;
import com.questcontrol.opcionsubrespuesta.app.UpdateOpcionSubRespuestaUseCase;
import com.questcontrol.opcionsubrespuesta.domain.entity.OpcionSubRespuesta;
import com.questcontrol.opcionsubrespuesta.domain.service.OpcionSubRespuestaService;
import com.questcontrol.opcionsubrespuesta.infraestructure.repository.OpcionSubRespuestaRepository;

public class OpcionSubRespuestaConsoleAdapter {
    private OpcionSubRespuestaService opcionsubrespuestaService;
    private CreateOpcionSubRespuestaUseCase createOpcionSubRespuesta;
    private DeleteOpcionSubRespuestaUseCase deleteOpcionSubRespuesta;
    private UpdateOpcionSubRespuestaUseCase updateOpcionSubRespuesta;
    private FindAllOpcionesSubRespuestaUseCase allOpcionesSubRespuesta;
    private FindOpcionSubRespuestaByIdUseCase findOpcionSubRespuesta;
    Scanner scanner = new Scanner(System.in);

    public OpcionSubRespuestaConsoleAdapter() {
        this.opcionsubrespuestaService = new OpcionSubRespuestaRepository();
        this.createOpcionSubRespuesta= new CreateOpcionSubRespuestaUseCase(opcionsubrespuestaService);
        this.deleteOpcionSubRespuesta = new DeleteOpcionSubRespuestaUseCase(opcionsubrespuestaService);
        this.updateOpcionSubRespuesta= new UpdateOpcionSubRespuestaUseCase(opcionsubrespuestaService);
        this.allOpcionesSubRespuesta = new FindAllOpcionesSubRespuestaUseCase(opcionsubrespuestaService);
        this.findOpcionSubRespuesta = new FindOpcionSubRespuestaByIdUseCase(opcionsubrespuestaService);
    }

    public void Start(){
    String menu = """
                        1. Agregar Sub-respuesta
                        2. Eliminar Sub-respuesta
                        3. Listar todos los Sub-respuestas
                        4. Buscar Sub-respuesta por id
                        5. Actualizar Sub-respuesta
                        6. Salir
                        """;
    System.out.println(menu);
    Integer opcion = AditionalFuntions.menuValidator(1,6,menu);

    ejecutar(opcion);
    

  
    }
    public void ejecutar(int opcion) {
        switch (opcion) {
            case 1: 

                int numero = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese el numero de subrespuesta: "));
                int opcion_respuesta_id = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese el ide dela opcion de respuesta: "));
                String tipo_componente_html = JOptionPane.showInputDialog(null, "Ingrese el tipo de componente html: ");
                String subrespueta_text = JOptionPane.showInputDialog(null, "Ingrese el texto de la subrespuesta: ");
                
                OpcionSubRespuesta rol = new OpcionSubRespuesta(numero,opcion_respuesta_id,tipo_componente_html,subrespueta_text);
                createOpcionSubRespuesta.execute(rol);
                Start();

                break;
            case 2:
                try {
                    String idaeliminar = JOptionPane.showInputDialog(null, "Ingrese el id de la subrespuesta para eliminar: ");
                    int ideliminado = Integer.parseInt(idaeliminar);
                    deleteOpcionSubRespuesta.execute(ideliminado);
                    Start();
                    
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null,  "Ocurrio un problema; intente nuevamente");
                    Start();
                }
                
                break;
            case 3:
                StringBuilder salida = new StringBuilder("Sub respuestas:\n");
                List<OpcionSubRespuesta> role = allOpcionesSubRespuesta.execute();
                for (OpcionSubRespuesta rols : role) {
                    int id = rols.getId();
                    int numerosubrespuesta = rols.getNumero_subrespuesta();
                    int opcionresid = rols.getOpcion_respuesta_id();
                    String tipohtml = rols.getTipo_componente_html();
                    String text = rols.getSubrespueta_text();

                    salida.append("ID: ").append(id).append("\n")
                    .append("Numero subrespuesta: ").append(numerosubrespuesta).append("\n")
                    .append("Id opcion respuessta: ").append(opcionresid).append("\n")
                    .append("Tipo html: ").append(tipohtml).append("\n")
                    .append("Texto: ").append(text);
     
                }
                JTextArea textArea = new JTextArea(salida.toString());
                textArea.setEditable(false);
                textArea.setCaretPosition(1); 

                JScrollPane scrollPane = new JScrollPane(textArea);
                scrollPane.setPreferredSize(new java.awt.Dimension(400, 300)); 
               
                JOptionPane.showMessageDialog(null, scrollPane, "OpcionSubRespuestaes", JOptionPane.INFORMATION_MESSAGE);
                
                Start();
                break;
            case 4:
                try {
                    String idusuario = JOptionPane.showInputDialog(null, "Ingrese el id de la sub respuesta que desea buscar: ");
                    int idbuscar = Integer.parseInt(idusuario);
                    Optional<OpcionSubRespuesta> dato = findOpcionSubRespuesta.execute(idbuscar);
                    StringBuilder salidaid = new StringBuilder("roles:\n");
                    if (dato.isPresent()) {
                        OpcionSubRespuesta datopre = dato.get();
                        int id = datopre.getId();
                        int numerosubrespuesta = datopre.getNumero_subrespuesta();
                        int opcionresid = datopre.getOpcion_respuesta_id();
                        String tipohtml = datopre.getTipo_componente_html();
                        String text = datopre.getSubrespueta_text();
    
                        
                        salidaid.append("ID: ").append(id).append("\n")
                        .append("Numero subrespuesta: ").append(numerosubrespuesta).append("\n")
                        .append("Id opcion respuessta: ").append(opcionresid).append("\n")
                        .append("Tipo html: ").append(tipohtml).append("\n")
                        .append("Texto: ").append(text);
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
                Optional<OpcionSubRespuesta> valor = findOpcionSubRespuesta.execute(idactualizar);
                OpcionSubRespuesta rolActalizar = valor.get();
                while (bandera) {
                    
                    String opcionesActualizar = """
                        1. Id de la opcion de respuesta
                        2. Tipo de html
                        3. Texto
                        4. Salir
                        """;
                    System.out.println(opcionesActualizar);
                    Integer opc = AditionalFuntions.menuValidator(1,2,opcionesActualizar);

                   
                    switch (opc) {
                        case 1:
                            rolActalizar.setOpcion_respuesta_id(Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese el nuevo id de la opcion de respuesta asosiado")));
                            break;
                        case 2:
                            rolActalizar.setTipo_componente_html(JOptionPane.showInputDialog(null, "Ingrese el nuevo tipo de componente html"));
                            break;
                        case 3:
                            rolActalizar.setSubrespueta_text(JOptionPane.showInputDialog(null, "Ingrese el nuevo texto de la subrespuesta"));
                            break;
                        case 4:
                            bandera = false;
                            break;
                        }
                        
                } 
                updateOpcionSubRespuesta.execute(rolActalizar,idactualizar); 
                
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
