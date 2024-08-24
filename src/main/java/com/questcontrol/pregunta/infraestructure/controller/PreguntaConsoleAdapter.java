package com.questcontrol.pregunta.infraestructure.controller;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import com.questcontrol.funtions.AditionalFuntions;
import com.questcontrol.pregunta.app.CreatePreguntaUseCase;
import com.questcontrol.pregunta.app.DeletePreguntaUseCase;
import com.questcontrol.pregunta.app.FindAllPreguntasUseCase;
import com.questcontrol.pregunta.app.FindPreguntaByIdUseCase;
import com.questcontrol.pregunta.app.UpdatePreguntaUseCase;
import com.questcontrol.pregunta.domain.entity.Pregunta;
import com.questcontrol.pregunta.domain.service.PreguntaService;
import com.questcontrol.pregunta.infraestructure.repository.PreguntaRepository;

public class PreguntaConsoleAdapter {
    private PreguntaService preguntaService;
    private CreatePreguntaUseCase createPregunta;
    private DeletePreguntaUseCase deletePregunta;
    private UpdatePreguntaUseCase updatePregunta;
    private FindAllPreguntasUseCase allPreguntas;
    private FindPreguntaByIdUseCase findPregunta;
    Scanner scanner = new Scanner(System.in);

    public PreguntaConsoleAdapter() {
        this.preguntaService = new PreguntaRepository();
        this.createPregunta= new CreatePreguntaUseCase(preguntaService);
        this.deletePregunta = new DeletePreguntaUseCase(preguntaService);
        this.updatePregunta= new UpdatePreguntaUseCase(preguntaService);
        this.allPreguntas = new FindAllPreguntasUseCase(preguntaService);
        this.findPregunta = new FindPreguntaByIdUseCase(preguntaService);
    }

    public void Start(){
    String menu = """
                        1. Agregar pregunta
                        2. Eliminar pregunta
                        3. Listar todos los preguntas
                        4. Buscar pregunta por id
                        5. Actualizar pregunta
                        6. Salir
                        """;
    System.out.println(menu);
    Integer opcion = AditionalFuntions.menuValidator(1,6,menu);

    ejecutar(opcion);
    

  
    }
    public void ejecutar(int opcion) {
        switch (opcion) {
            case 1:
                int capitulo_id = Integer.parseInt(JOptionPane.showInputDialog(null, "ingrese el id del capitulo"));
                String numeroPregunta = JOptionPane.showInputDialog(null, "Ingrese el numero de pregunta: ");
                String tipo_respuesta = JOptionPane.showInputDialog(null, "Ingrese el tipo de pregunta: ");
                String comentario_pregunta = JOptionPane.showInputDialog(null, "Ingrese el numero de pregunta: ");
                String texto_pregunta = JOptionPane.showInputDialog(null, "Ingrese el numero de pregunta: ");
                
                Pregunta pregunta = new Pregunta(capitulo_id,numeroPregunta,tipo_respuesta,comentario_pregunta,texto_pregunta);
                createPregunta.execute(pregunta);
                Start();

                break;
            case 2:
                try {
                    String idaeliminar = JOptionPane.showInputDialog(null, "Ingrese el id de la pregunta para eliminar: ");
                    int ideliminado = Integer.parseInt(idaeliminar);
                    deletePregunta.execute(ideliminado);
                    Start();
                    
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null,  "Ocurrio un problema; intente nuevamente");
                    Start();
                }
                
                break;
            case 3:
                StringBuilder salida = new StringBuilder("preguntas:\n");
                List<Pregunta> role = allPreguntas.execute();
                for (Pregunta rols : role) {
                    int id = rols.getId();
                    int capitul_id = rols.getCapitulo_id();
                    String numero= rols.getNumero_pregunta();
                    String tipo=rols.getTexto_pregunta();
                    String comentario=rols.getComentario_pregunta();
                    String texto=rols.getTexto_pregunta();
                    

                    salida.append("ID: ").append(id).append("\n")
                    .append("Capitulo id: ").append(capitul_id).append("\n")
                    .append("Numero pregunta: ").append(numero).append("\n")
                    .append("Tipo de pregunta: ").append(tipo).append("\n")
                    .append("Coentarios: ").append(comentario).append("\n")
                    .append("Texto: ").append(texto);
     
                }
                JTextArea textArea = new JTextArea(salida.toString());
                textArea.setEditable(false);
                textArea.setCaretPosition(1); 

                JScrollPane scrollPane = new JScrollPane(textArea);
                scrollPane.setPreferredSize(new java.awt.Dimension(400, 300)); 
               
                JOptionPane.showMessageDialog(null, scrollPane, "Preguntaes", JOptionPane.INFORMATION_MESSAGE);
                
                Start();
                break;
            case 4:
                try {
                    String idusuario = JOptionPane.showInputDialog(null, "Ingrese el id de la pregunta que desea buscar: ");
                    int idbuscar = Integer.parseInt(idusuario);
                    Optional<Pregunta> dato = findPregunta.execute(idbuscar);
                    StringBuilder salidaid = new StringBuilder("roles:\n");
                    if (dato.isPresent()) {
                        Pregunta datopre = dato.get();
                        int id = datopre.getId();
                        int capitul_id = datopre.getCapitulo_id();
                        String numero= datopre.getNumero_pregunta();
                        String tipo=datopre.getTexto_pregunta();
                        String comentario=datopre.getComentario_pregunta();
                        String texto=datopre.getTexto_pregunta();
                        
                        salidaid.append("ID: ").append(id).append("\n")
                        .append("Capitulo id: ").append(capitul_id).append("\n")
                        .append("Numero pregunta: ").append(numero).append("\n")
                        .append("Tipo de pregunta: ").append(tipo).append("\n")
                        .append("Coentarios: ").append(comentario).append("\n")
                        .append("Texto: ").append(texto);
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
                String idrolf = JOptionPane.showInputDialog(null, "Ingrese el id de la pregunta que desea buscar: ");
                int idactualizar = Integer.parseInt(idrolf);
                Optional<Pregunta> valor = findPregunta.execute(idactualizar);
                Pregunta rolActalizar = valor.get();
                while (bandera) {
                    
                    String opcionesActualizar = """
                        1. Capitulo Id 
                        2. Comentario
                        3. Texto
                        4. Salir
                        """;
                    System.out.println(opcionesActualizar);
                    Integer opc = AditionalFuntions.menuValidator(1,4,opcionesActualizar);

                   
                    switch (opc) {
                        case 1:
                            rolActalizar.setCapitulo_id(Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese el nuevo id de capitulo")));
                            break;
                        case 2:
                            rolActalizar.setComentario_pregunta(JOptionPane.showInputDialog(null, "Ingrese el nuevo comentario"));
                            break;
                        case 3:
                            rolActalizar.setTexto_pregunta(JOptionPane.showInputDialog(null, "Ingrese el nuevo Texto"));
                            break;
                        case 4:
                            bandera = false;
                            break;
                        }
                        
                } 
                updatePregunta.execute(rolActalizar,idactualizar); 
                
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
