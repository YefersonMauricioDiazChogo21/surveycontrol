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
    Integer opcion =scanner.nextInt();

    ejecutar(opcion);
    

  
    }
    public void ejecutar(int opcion) {
        switch (opcion) {
            case 1:
                int capitulo_id = Integer.parseInt(JOptionPane.showInputDialog(null, "ingrese"));
                String newrol = JOptionPane.showInputDialog(null, "Ingrese el rol: ");
                
                Pregunta rol = new Pregunta(capitulo_id,newrol,newrol,newrol,newrol);
                createPregunta.execute(rol);
                Start();

                break;
            case 2:
                try {
                    String idaeliminar = JOptionPane.showInputDialog(null, "Ingrese el id del rol para eliminar: ");
                    int ideliminado = Integer.parseInt(idaeliminar);
                    deletePregunta.execute(ideliminado);
                    Start();
                    
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null,  "Ocurrio un problema; intente nuevamente");
                    Start();
                }
                
                break;
            case 3:
                StringBuilder salida = new StringBuilder("Usuarios:\n");
                List<Pregunta> role = allPreguntas.execute();
                for (Pregunta rols : role) {
                    int id = rols.getId();
                    int capid = rols.getCapitulo_id();
                    

                    salida.append("ID: ").append(id).append("\n")
                    .append("Nombre: ").append(capid).append(", ");
     
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
                    String idusuario = JOptionPane.showInputDialog(null, "Ingrese el id del rol pque desea buscar: ");
                    int idbuscar = Integer.parseInt(idusuario);
                    Optional<Pregunta> dato = findPregunta.execute(idbuscar);
                    StringBuilder salidaid = new StringBuilder("roles:\n");
                    if (dato.isPresent()) {
                        Pregunta datopre = dato.get();
                        int id = datopre.getId();
                        int capid = datopre.getCapitulo_id();
    
                        
                        salidaid.append("ID: ").append(id).append("\n")
                            .append("Nombre: ").append(capid);
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
                Optional<Pregunta> valor = findPregunta.execute(idactualizar);
                Pregunta rolActalizar = valor.get();
                while (bandera) {
                    
                    String opcionesActualizar = """
                        1. Nombre rol
                        2. Salir
                        """;
                    System.out.println(opcionesActualizar);
                    Integer opc = AditionalFuntions.menuValidator(1,2);

                   
                    switch (opc) {
                        case 1:
                            rolActalizar.setCapitulo_id(Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese el nuevo Nombre del rol")));
                            break;
                        case 2:
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
