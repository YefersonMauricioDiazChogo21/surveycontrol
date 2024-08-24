package com.questcontrol.capitulo.infraestructure.controller;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import com.questcontrol.funtions.AditionalFuntions;
import com.questcontrol.capitulo.app.CreateCapituloUseCase;
import com.questcontrol.capitulo.app.DeleteCapituloUseCase;
import com.questcontrol.capitulo.app.FindAllCapitulosUseCase;
import com.questcontrol.capitulo.app.FindCapituloByIdUseCase;
import com.questcontrol.capitulo.app.UpdateCapituloUseCase;
import com.questcontrol.capitulo.domain.entity.Capitulo;
import com.questcontrol.capitulo.domain.service.CapituloService;
import com.questcontrol.capitulo.infraestructure.repository.CapituloRepository;

public class CapituloConsoleAdapter {
    private CapituloService capituloService;
    private CreateCapituloUseCase createCapitulo;
    private DeleteCapituloUseCase deleteCapitulo;
    private UpdateCapituloUseCase updateCapitulo;
    private FindAllCapitulosUseCase allCapitulos;
    private FindCapituloByIdUseCase findCapitulo;
    Scanner scanner = new Scanner(System.in);

    public CapituloConsoleAdapter() {
        this.capituloService = new CapituloRepository();
        this.createCapitulo= new CreateCapituloUseCase(capituloService);
        this.deleteCapitulo = new DeleteCapituloUseCase(capituloService);
        this.updateCapitulo= new UpdateCapituloUseCase(capituloService);
        this.allCapitulos = new FindAllCapitulosUseCase(capituloService);
        this.findCapitulo = new FindCapituloByIdUseCase(capituloService);
    }

    public void Start(){
    String menu = """
                        1. Agregar capitulo
                        2. Eliminar capitulo
                        3. Listar todos los capitulos
                        4. Buscar capitulo por id
                        5. Actualizar capitulo
                        6. Salir
                        """;
    System.out.println(menu);
    Integer opcion = AditionalFuntions.menuValidator(1,6,menu);

    ejecutar(opcion);
    

  
    }
    public void ejecutar(int opcion) {
        switch (opcion) {
            case 1:

                int idForm = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese el id del formulario del capitulo: "));
                String numcap = JOptionPane.showInputDialog(null, "Ingrese el numero del capitulo: ");
                String tiulocap = JOptionPane.showInputDialog(null, "Ingrese el titulo del  capitulo: ");
                Capitulo capitulo = new Capitulo(idForm,numcap,tiulocap);
                createCapitulo.execute(capitulo);
                Start();

                break;
            case 2:
                try {
                    String idaeliminar = JOptionPane.showInputDialog(null, "Ingrese el id del capitulo para eliminar: ");
                    int ideliminado = Integer.parseInt(idaeliminar);
                    deleteCapitulo.execute(ideliminado);
                    Start();
                    
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null,  "Ocurrio un problema; intente nuevamente");
                    Start();
                }
                
                break;
            case 3:
                StringBuilder salida = new StringBuilder("Usuarios:\n");
                List<Capitulo> role = allCapitulos.execute();
                for (Capitulo caps : role) {
                    int id = caps.getId();
                    int idform = caps.getFormulario_id();
                    java.sql.Timestamp fechaCreacion = caps.getFecha_creacion();
                    String numCapitulo = caps.getNumero_capitulo();
                    String tituloCapitulo = caps.getTitulo_capitulo();
                    

                    salida.append("ID: ").append(id).append("\n")
                    .append("Id formulario: ").append(idform).append(", ").append("Fecha Creacion: ").append(fechaCreacion).append(", ").append("Numero capitulo: ").append(numCapitulo).append(", ").append("Titulo Capitulo: ").append(tituloCapitulo);
     
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
                    Optional<Capitulo> dato = findCapitulo.execute(idbuscar);
                    StringBuilder salidaid = new StringBuilder("roles:\n");
                    if (dato.isPresent()) {
                        Capitulo datopre = dato.get();
                        int id = datopre.getId();
                        int idform = datopre.getFormulario_id();
                        java.sql.Timestamp fechaCreacion = datopre.getFecha_creacion();
                        String numCapitulo = datopre.getNumero_capitulo();
                        String tituloCapitulo = datopre.getTitulo_capitulo();
    
                        
                        salidaid.append("ID: ").append(id).append("\n")
                        .append("Id formulario: ").append(idform).append(", ").append("Fecha Creacion: ").append(fechaCreacion).append(", ").append("Numero capitulo: ").append(numCapitulo).append(", ").append("Titulo Capitulo: ").append(tituloCapitulo);
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
                Optional<Capitulo> valor = findCapitulo.execute(idactualizar);
                Capitulo rolActalizar = valor.get();
                while (bandera) {
                    
                    String opcionesActualizar = """
                        1. Id formulario
                        2. Numero capitulo
                        3. Titulo capitulo
                        4. Salir
                        """;
                    System.out.println(opcionesActualizar);
                    Integer opc = AditionalFuntions.menuValidator(1,4,opcionesActualizar);

                   
                    switch (opc) {
                        case 1:
                            rolActalizar.setFormulario_id(Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese el nuevo Nombre del rol")));
                            break;
                        case 2:
                            rolActalizar.setNumero_capitulo(JOptionPane.showInputDialog(null, "Ingrese el nuevo Nombre del rol"));
                            break;
                        case 3:
                            rolActalizar.setTitulo_capitulo(JOptionPane.showInputDialog(null, "Ingrese el nuevo Nombre del rol"));
                            break;
                        case 4:
                            bandera = false;
                            break;
                        }
                        
                } 
                updateCapitulo.execute(rolActalizar,idactualizar); 
                
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
