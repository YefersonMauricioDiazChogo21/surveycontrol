package com.questcontrol.formulariousuario.infraestructure.controller;

import com.questcontrol.formulariousuario.domain.service.FormularioUsuarioService;
import com.questcontrol.formulariousuario.infraestructure.repository.FormularioUsuarioRepository;
import com.questcontrol.pregunta.domain.entity.Pregunta;

import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import com.questcontrol.capitulo.domain.entity.Capitulo;
import com.questcontrol.formulario.domain.entity.Formulario;
import com.questcontrol.formulariousuario.app.FindAllFormulariosUseCase;
import com.questcontrol.formulariousuario.app.FindCapitulosByIdFormUseCase;
import com.questcontrol.formulariousuario.app.FindPreguntasByIdFormUseCase;

public class GeneradorFormularioConsoleAdapter {
    private FormularioUsuarioService formularioUsuarioServices;
    private FindAllFormulariosUseCase allFormularios;
    private FindCapitulosByIdFormUseCase allCapitulos;
    private FindPreguntasByIdFormUseCase allPreguntas;

    public GeneradorFormularioConsoleAdapter(){
        this.formularioUsuarioServices =new FormularioUsuarioRepository();
        this.allFormularios= new FindAllFormulariosUseCase(formularioUsuarioServices);
        this.allCapitulos= new FindCapitulosByIdFormUseCase(formularioUsuarioServices);
        this.allPreguntas = new FindPreguntasByIdFormUseCase(formularioUsuarioServices);
        
    }

    public void Start(){
    ejecutar();
    }

    public void ejecutar(){
        StringBuilder salida = new StringBuilder("Seleccione el formulario que desea realizar:\n");
        List<Formulario> form = allFormularios.execute();
        for (Formulario forms : form) {
            int id = forms.getId();
            String descripcion = forms.getDescripcion();
            String nameform = forms.getNombre();
            java.sql.Timestamp fechaCreacion = forms.getFecha_creacion();
            

            salida.append("ID: ").append(id).append("\n").append("Nombre: ").append(nameform).append("\n");

        }
        JTextArea textArea = new JTextArea(salida.toString());
        textArea.setEditable(false);
        textArea.setCaretPosition(1); 

        JScrollPane scrollPane = new JScrollPane(textArea);
        scrollPane.setPreferredSize(new java.awt.Dimension(400, 300)); 

        Integer opcion = Integer.parseInt(JOptionPane.showInputDialog(null, scrollPane, "Formularios", JOptionPane.INFORMATION_MESSAGE));
        mostrarCapitulos(opcion);
    }

    public void mostrarCapitulos(int id){
        StringBuilder salida = new StringBuilder("Seleccione el Capitulo:\n");
                List<Capitulo> role = allCapitulos.execute(id);
                for (Capitulo caps : role) {
                    int idc = caps.getId();
                    String numCapitulo = caps.getNumero_capitulo();
                    String tituloCapitulo = caps.getTitulo_capitulo();
                    

                    salida.append("ID: ").append(idc).append("\n").append(numCapitulo).append(", ").append("Titulo Capitulo: ").append(tituloCapitulo).append("\n");
     
                }
                JTextArea textArea = new JTextArea(salida.toString());
                textArea.setEditable(false);
                textArea.setCaretPosition(1); 

                JScrollPane scrollPane = new JScrollPane(textArea);
                scrollPane.setPreferredSize(new java.awt.Dimension(400, 300)); 
               
                int idCapitulo =Integer.parseInt(JOptionPane.showInputDialog(null, scrollPane, "Capitulos", JOptionPane.INFORMATION_MESSAGE));
                mostrarPreguntas(idCapitulo);
                
    }
    
    public void mostrarPreguntas(int id){
    		StringBuilder salida = new StringBuilder("Seleccione la pregunta:\n");
                List<Pregunta> pregunta = allPreguntas.execute(id);
                for (Pregunta preg : pregunta) {
                    int idp = preg.getId();
                    int capitul_id = preg.getCapitulo_id();
                    String numero= preg.getNumero_pregunta();
                    String texto=preg.getTexto_pregunta();
                    

                    salida.append("ID: ").append(idp).append("\n")
                    .append("Capitulo id: ").append(capitul_id).append("\n")
                    .append("Numero pregunta: ").append(numero).append("\n")
                    .append("Texto: ").append(texto).append("\n");
     
                }
                JTextArea textArea = new JTextArea(salida.toString());
                textArea.setEditable(false);
                textArea.setCaretPosition(1); 

                JScrollPane scrollPane = new JScrollPane(textArea);
                scrollPane.setPreferredSize(new java.awt.Dimension(400, 300)); 
               
                int idpregunta =Integer.parseInt(JOptionPane.showInputDialog(null, scrollPane, "Preguntas", JOptionPane.INFORMATION_MESSAGE));
                mostrarOpcionesPregunta( idpregunta);
                
   }
   
   public void mostrarOpcionesPregunta(int id){
   	
   }
}
