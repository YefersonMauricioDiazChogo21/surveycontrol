package com.questcontrol.formulario.infraestructure.controller;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import com.questcontrol.funtions.AditionalFuntions;
import com.questcontrol.formulario.app.CreateFormularioUseCase;
import com.questcontrol.formulario.app.DeleteFormularioUseCase;
import com.questcontrol.formulario.app.FindAllFormulariosUseCase;
import com.questcontrol.formulario.app.FindFormularioByIdUseCase;
import com.questcontrol.formulario.app.UpdateFormularioUseCase;
import com.questcontrol.formulario.domain.entity.Formulario;
import com.questcontrol.formulario.domain.service.FormularioService;
import com.questcontrol.formulario.infraestructure.repository.FormularioRepository;

public class FormularioConsoleAdapter {
    private FormularioService rolService;
    private CreateFormularioUseCase createFormulario;
    private DeleteFormularioUseCase deleteFormulario;
    private UpdateFormularioUseCase updateFormulario;
    private FindAllFormulariosUseCase allFormularios;
    private FindFormularioByIdUseCase findFormulario;
    Scanner scanner = new Scanner(System.in);

    public FormularioConsoleAdapter() {
        this.rolService = new FormularioRepository();
        this.createFormulario= new CreateFormularioUseCase(rolService);
        this.deleteFormulario = new DeleteFormularioUseCase(rolService);
        this.updateFormulario= new UpdateFormularioUseCase(rolService);
        this.allFormularios = new FindAllFormulariosUseCase(rolService);
        this.findFormulario = new FindFormularioByIdUseCase(rolService);
    }

    public void Start(){
    String menu = """
                        1. Agregar formulario
                        2. Eliminar formulario
                        3. Listar todos los formularios
                        4. Buscar formulario por id
                        5. Actualizar formulario
                        6. Salir
                        """;
    System.out.println(menu);
    Integer opcion =scanner.nextInt();

    ejecutar(opcion);
    

  
    }
    public void ejecutar(int opcion) {
        switch (opcion) {
            case 1:

                String newdesc = JOptionPane.showInputDialog(null, "Ingrese la descripcion del formulario: ");
                String newform = JOptionPane.showInputDialog(null, "Ingrese el nombre del formulario: ");
                
                Formulario formulario = new Formulario(newdesc,newform);
                createFormulario.execute(formulario);
                Start();

                break;
            case 2:
                try {
                    String idaeliminar = JOptionPane.showInputDialog(null, "Ingrese el id del formulario para eliminar: ");
                    int ideliminado = Integer.parseInt(idaeliminar);
                    deleteFormulario.execute(ideliminado);
                    Start();
                    
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null,  "Ocurrio un problema; intente nuevamente");
                    Start();
                }
                
                break;
            case 3:
                StringBuilder salida = new StringBuilder("Formularios:\n");
                List<Formulario> form = allFormularios.execute();
                for (Formulario forms : form) {
                    int id = forms.getId();
                    String descripcion = forms.getDescripcion();
                    String nameform = forms.getNombre();
                    java.sql.Timestamp fechaCreacion = forms.getFecha_creacion();
                    

                    salida.append("ID: ").append(id).append("\n").append("Descripcion: ").append(descripcion)
                    .append("Nombre: ").append(nameform).append(", ").append("Fecha Creacion: ").append(fechaCreacion);
     
                }
                JTextArea textArea = new JTextArea(salida.toString());
                textArea.setEditable(false);
                textArea.setCaretPosition(1); 

                JScrollPane scrollPane = new JScrollPane(textArea);
                scrollPane.setPreferredSize(new java.awt.Dimension(400, 300)); 
               
                JOptionPane.showMessageDialog(null, scrollPane, "Formularios", JOptionPane.INFORMATION_MESSAGE);
                
                Start();
                break;
            case 4:
                try {
                    String idusuario = JOptionPane.showInputDialog(null, "Ingrese el id del formulario que desea buscar: ");
                    int idbuscar = Integer.parseInt(idusuario);
                    Optional<Formulario> dato = findFormulario.execute(idbuscar);
                    StringBuilder salidaid = new StringBuilder("Formularios:\n");
                    if (dato.isPresent()) {
                        Formulario datopre = dato.get();
                        int id = datopre.getId();
                        String descripcion = datopre.getDescripcion();
                        String nameform = datopre.getNombre();
                        java.sql.Timestamp fechaCreacion = datopre.getFecha_creacion();
    
                        
                        salidaid.append("ID: ").append(id).append("\n").append("Descripcion: ").append(descripcion)
                        .append("Nombre: ").append(nameform).append(", ").append("Fecha Creacion: ").append(fechaCreacion);
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
                String idForm = JOptionPane.showInputDialog(null, "Ingrese el id del formulario que desea buscar: ");
                int idactualizar = Integer.parseInt(idForm);
                Optional<Formulario> valor = findFormulario.execute(idactualizar);
                Formulario formularioActalizar = valor.get();
                while (bandera) {
                    
                    String opcionesActualizar = """
                        1. Nombre 
                        2. Descripcion del Folmulario
                        3. Salir
                        """;
                    System.out.println(opcionesActualizar);
                    Integer opc = AditionalFuntions.menuValidator(1,2);

                   
                    switch (opc) {
                        case 1:
                            formularioActalizar.setNombre(JOptionPane.showInputDialog(null, "Ingrese el nuevo Nombre del formulario"));
                            break;
                        case 2:
                            formularioActalizar.setDescripcion(JOptionPane.showInputDialog(null, "Ingrese la nueva descripcion del formulario"));
                            break;
                        case 3:
                            bandera = false;
                            break;
                        }
                        
                } 
                updateFormulario.execute(formularioActalizar,idactualizar); 
                
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
