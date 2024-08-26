package com.questcontrol.formulariousuario.infraestructure.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.questcontrol.Database;
import com.questcontrol.capitulo.domain.entity.Capitulo;
import com.questcontrol.catalogo.domain.entity.CategoriaCatalogo;
import com.questcontrol.formulario.domain.entity.Formulario;
import com.questcontrol.formulariousuario.domain.service.FormularioUsuarioService;
import com.questcontrol.opcionrespuesta.domain.entity.OpcionRespuesta;
import com.questcontrol.opcionsubrespuesta.domain.entity.OpcionSubRespuesta;
import com.questcontrol.pregunta.domain.entity.Pregunta;

public class FormularioUsuarioRepository implements FormularioUsuarioService{

    @Override
    public List<Formulario> findAllFormularios() {
        String sql ="SELECT id, descripcion,nombre FROM formulario";
        List<Formulario> formularios =new ArrayList<>();

        try(Connection connection = Database.getConnection();
        PreparedStatement ps =connection.prepareStatement(sql)){
            ResultSet rs=ps.executeQuery();

            while(rs.next()){
                int idu=rs.getInt("id");
                String descripcion=rs.getString("descripcion");
                String nombre =rs.getString("nombre");
                Formulario formulario =new Formulario(idu,descripcion,nombre);
                formularios.add(formulario);
            }
        } catch(SQLException e){
            e.printStackTrace();
        }
		return formularios;
    }

    @Override
    public List<CategoriaCatalogo> findCategoriaCatalogoByIdForm() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findCategoriaCatalogoByIdForm'");
    }

    @Override
    public List<Capitulo> findCapitulosByIdForm(int id) {
        String sql ="SELECT id,fecha_creacion,formulario_id, fecha_actualizacion,numero_capitulo,titulo_capitulo FROM capitulo WHERE formulario_id=?";
        List<Capitulo> capitulos =new ArrayList<>();
        
        try(Connection connection = Database.getConnection();
        PreparedStatement ps =connection.prepareStatement(sql)){
            ps.setInt(1,id);
            
            ResultSet rs=ps.executeQuery();

            while(rs.next()){
                int idu=rs.getInt("id");
                java.sql.Timestamp fechaCreacion = rs.getTimestamp("fecha_creacion");
                int formulario_id= rs.getInt("formulario_id");
                java.sql.Timestamp fechaActualizacion = rs.getTimestamp("fecha_actualizacion");
                String numero_capitulo=rs.getString("numero_capitulo");
                String titulo_capitulo =rs.getString("titulo_capitulo");
                
                Capitulo capitulo =new Capitulo(idu,fechaCreacion,formulario_id,fechaActualizacion,numero_capitulo,titulo_capitulo);
                capitulos.add(capitulo);
            }
        } catch(SQLException e){
            e.printStackTrace();
        }
		return capitulos;
    }

    @Override
    public List<Pregunta> findPreguntasByIdForm(int id) {
        String sql ="SELECT id,capitulo_id,fecha_creacion, fecha_actualizacion,numero_pregunta,tipo_respuesta,comentario_pregunta,texto_pregunta FROM pregunta WHERE capitulo_id=?";
        List<Pregunta> preguntas =new ArrayList<>();

        try(Connection connection = Database.getConnection();
        PreparedStatement ps =connection.prepareStatement(sql)){
            ps.setInt(1,id);
            ResultSet rs=ps.executeQuery();

            while(rs.next()){
                int idu=rs.getInt("id");
                int capitulo_id=rs.getInt("capitulo_id");
                java.sql.Timestamp fechaCreacion = rs.getTimestamp("fecha_creacion");
                java.sql.Timestamp fechaActualizacion = rs.getTimestamp("fecha_actualizacion");
                String numero_pregunta= rs.getString("numero_pregunta");
                String tipo_respuesta=rs.getString("tipo_respuesta");
                String comentario_pregunta =rs.getString("comentario_pregunta");
                String texto_pregunta =rs.getString("texto_pregunta");
                
                Pregunta pregunta =new Pregunta(idu,capitulo_id,fechaCreacion,fechaActualizacion,numero_pregunta,tipo_respuesta,comentario_pregunta,texto_pregunta);
                preguntas.add(pregunta);
            }
        } catch(SQLException e){
            e.printStackTrace();
        }
		return preguntas;
    }

    @Override
    public List<OpcionRespuesta> findOpcionRespuestaByIdCapitulo(int id) {
        String sql ="SELECT id,valor_opcion,catalogo_id,,fecha_creacion, fecha_actualizacion, respuesta_padre_id,pregunta_id,tipo_componente_html,comentario_pregunta,opcion_text FROM opcion_respuesta WHERE id=?";
        List<OpcionRespuesta> opcionesRespuesta =new ArrayList<>();

        try(Connection connection = Database.getConnection();
        PreparedStatement ps =connection.prepareStatement(sql)){
            ps.setInt(1,id);
            ResultSet rs=ps.executeQuery();

            while(rs.next()){
                int idu=rs.getInt("id");
                int valor_opcion=rs.getInt("valor_opcion");
                int catalogo_id=rs.getInt("catalogo_id");
                java.sql.Timestamp fechaCreacion = rs.getTimestamp("fecha_creacion");
                int respuesta_padre_id=rs.getInt("respuesta_padre_id");
                int pregunta_id=rs.getInt("pregunta_id");
                java.sql.Timestamp fechaActualizacion = rs.getTimestamp("fecha_actualizacion");
                String tipo_componente_html= rs.getString("tipo_componente_html");
                String comentario_pregunta =rs.getString("comentario_pregunta");
                String opcion_text =rs.getString("texto_pregunta");
                
                OpcionRespuesta opcionRespuesta =new OpcionRespuesta(idu,valor_opcion,catalogo_id,fechaCreacion,respuesta_padre_id,pregunta_id,fechaActualizacion,tipo_componente_html,comentario_pregunta,opcion_text);
                opcionesRespuesta.add(opcionRespuesta);
            }
        } catch(SQLException e){
            e.printStackTrace();
        }
		return opcionesRespuesta;
    }

    @Override
    public List<OpcionSubRespuesta> findOpcionesSubRespuestaoByIdCapitulo() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findOpcionesSubRespuestaoByIdCapitulo'");
    }

}
