package com.questcontrol.catalogo.infraestructure.controller;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import com.questcontrol.funtions.AditionalFuntions;
import com.questcontrol.catalogo.app.CreateCatalogoUseCase;
import com.questcontrol.catalogo.app.DeleteCatalogoUseCase;
import com.questcontrol.catalogo.app.FindAllCatalogosUseCase;
import com.questcontrol.catalogo.app.FindCatalogoByIdUseCase;
import com.questcontrol.catalogo.app.UpdateCatalogoUseCase;
import com.questcontrol.catalogo.domain.entity.CategoriaCatalogo;
import com.questcontrol.catalogo.domain.service.CategoriaCatalogoService;
import com.questcontrol.catalogo.infraestructure.repository.CategorieaCatalogoRepository;

public class CategoriaCatalogoConsoleAdapter {
    private CategoriaCatalogoService categoriaCatalogoService;
    private CreateCatalogoUseCase createCatalogo;
    private DeleteCatalogoUseCase deleteCatalogo;
    private UpdateCatalogoUseCase updateCatalogo;
    private FindAllCatalogosUseCase allCatalogos;
    private FindCatalogoByIdUseCase findCatalogo;
    Scanner scanner = new Scanner(System.in);

    public CategoriaCatalogoConsoleAdapter() {
        this.categoriaCatalogoService = new CategorieaCatalogoRepository();
        this.createCatalogo= new CreateCatalogoUseCase(categoriaCatalogoService);
        this.deleteCatalogo = new DeleteCatalogoUseCase(categoriaCatalogoService);
        this.updateCatalogo= new UpdateCatalogoUseCase(categoriaCatalogoService);
        this.allCatalogos = new FindAllCatalogosUseCase(categoriaCatalogoService);
        this.findCatalogo = new FindCatalogoByIdUseCase(categoriaCatalogoService);
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

                String newcat = JOptionPane.showInputDialog(null, "Ingrese el nombre del catalogo: ");
                
                CategoriaCatalogo catalogo = new CategoriaCatalogo(newcat);
                createCatalogo.execute(catalogo);
                Start();

                break;
            case 2:
                try {
                    String idaeliminar = JOptionPane.showInputDialog(null, "Ingrese el id del catalogo para eliminar: ");
                    int ideliminado = Integer.parseInt(idaeliminar);
                    deleteCatalogo.execute(ideliminado);
                    Start();
                    
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null,  "Ocurrio un problema; intente nuevamente");
                    Start();
                }
                
                break;
            case 3:
                StringBuilder salida = new StringBuilder("Catalogos:\n");
                List<CategoriaCatalogo> catal = allCatalogos.execute();
                for (CategoriaCatalogo catalogos : catal) {
                    int id = catalogos.getId();
                    String nameCatalogo = catalogos.getNombre();
                    java.sql.Timestamp fechaCreacion = catalogos.getFecha_creacion();

                    salida.append("ID: ").append(id).append("\n")
                    .append("Nombre: ").append(nameCatalogo).append("Fecha Creacion: ").append(fechaCreacion);
     
                }
                JTextArea textArea = new JTextArea(salida.toString());
                textArea.setEditable(false);
                textArea.setCaretPosition(1); 

                JScrollPane scrollPane = new JScrollPane(textArea);
                scrollPane.setPreferredSize(new java.awt.Dimension(400, 300)); 
               
                JOptionPane.showMessageDialog(null, scrollPane, "Catalogos", JOptionPane.INFORMATION_MESSAGE);
                
                Start();
                break;
            case 4:
                try {
                    String idusuario = JOptionPane.showInputDialog(null, "Ingrese el id del catalogo que desea buscar: ");
                    int idbuscar = Integer.parseInt(idusuario);
                    Optional<CategoriaCatalogo> dato = findCatalogo.execute(idbuscar);
                    StringBuilder salidaid = new StringBuilder("roles:\n");
                    if (dato.isPresent()) {
                        CategoriaCatalogo datopre = dato.get();
                        int id = datopre.getId();
                        String namerol = datopre.getNombre();
                        java.sql.Timestamp fechaCreacion = datopre.getFecha_creacion();
                        
                        salidaid.append("ID: ").append(id).append("\n")
                            .append("Nombre: ").append(namerol).append("Fecha Creacion: ").append(fechaCreacion);
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
                Optional<CategoriaCatalogo> valor = findCatalogo.execute(idactualizar);
                CategoriaCatalogo rolActalizar = valor.get();
                while (bandera) {
                    
                    String opcionesActualizar = """
                        1. Nombre del catalogo
                        2. Salir
                        """;
                    System.out.println(opcionesActualizar);
                    Integer opc = AditionalFuntions.menuValidator(1,2,opcionesActualizar);

                   
                    switch (opc) {
                        case 1:
                            rolActalizar.setNombre(JOptionPane.showInputDialog(null, "Ingrese el nuevo Nombre del catalogo"));
                            break;
                        case 2:
                            bandera = false;
                            break;
                        }
                        
                } 
                updateCatalogo.execute(rolActalizar,idactualizar); 
                
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
