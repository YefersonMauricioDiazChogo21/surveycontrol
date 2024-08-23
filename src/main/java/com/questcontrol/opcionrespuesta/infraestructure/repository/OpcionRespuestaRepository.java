package com.questcontrol.opcionrespuesta.infraestructure.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

import com.questcontrol.Database;
import com.questcontrol.opcionrespuesta.domain.entity.OpcionRespuesta;
import com.questcontrol.opcionrespuesta.domain.service.OpcionRespuestaService;

public class OpcionRespuestaRepository implements OpcionRespuestaService{
    Scanner scanner= new Scanner(System.in);

    @Override
    public void createOpcionRespuesta(OpcionRespuesta opcionRespuesta) {
        String sql ="INSERT INTO opcion_respuesta(valor_opcion,catalogo_id,respuesta_padre_id,pregunta_id,tipo_componente_html,comentario_pregunta,opcion_text) VALUES (?,?,?,?,?,?,?)";
        try(Connection connection = Database.getConnection();
        PreparedStatement ps= connection.prepareStatement(sql)){
            ps.setInt(1, opcionRespuesta.getValor_opcion());
            ps.setInt(2, opcionRespuesta.getCatalogo_id());
            ps.setInt(3, opcionRespuesta.getRespuesta_padre_id());
            ps.setInt(4, opcionRespuesta.getPregunta_id());
            ps.setString(5, opcionRespuesta.getTipo_componente_html());
            ps.setString(6, opcionRespuesta.getComentario_pregunta());
            ps.setString(7, opcionRespuesta.getOpcion_text());
            ps.executeUpdate();
            System.out.println("Carga de opcion de Respuesta exitoso");
        }catch(SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public OpcionRespuesta deleteOpcionRespuesta(int id) {
        String sql ="DELETE FROM opcion_respuesta WHERE id = ?";
        try(Connection connection = Database.getConnection();
        PreparedStatement ps= connection.prepareStatement(sql)){
            ps.setInt(1, id);
            ps.executeUpdate();
            System.out.println("Eliminacion de opcion de respuesta exitoso");
        }catch(SQLException e){
            e.printStackTrace();
            System.out.println("Id no encontrado");
        }
        return null;
    }

    @Override
    public void updateOpcionRespuesta(OpcionRespuesta opcionRespuesta, int id) {
        String sql ="UPDATE opcion_respuesta SET valor_opcion=?,catalogo_id=?,fecha_actualizacion= CURRENT_TIMESTAMP,respuesta_padre_id=? ,pregunta_id=? ,tipo_componente_html=? ,comentario_pregunta=? ,opcion_text=? WHERE id=?";
        try(Connection connection = Database.getConnection();
        PreparedStatement ps= connection.prepareStatement(sql)){
            int valor_opcion= scanner.nextInt();
            int catalogo_id= scanner.nextInt();
            int respuesta_padre_id= scanner.nextInt();
            int pregunta_id= scanner.nextInt();
            String tipo_componente_html= scanner.nextLine();
            String comentario_pregunta= scanner.nextLine();
            String opcion_text= scanner.nextLine();

            ps.setInt(1,valor_opcion );
            ps.setInt(2,catalogo_id );
            ps.setInt(3,respuesta_padre_id );
            ps.setInt(4,pregunta_id );
            ps.setString(5, tipo_componente_html);
            ps.setString(6, comentario_pregunta);
            ps.setString(7, opcion_text);
            ps.setInt(8, id);
            ps.executeUpdate();
            System.out.print("Actualizacion de opcion de respuesta exitosa");
        }catch(SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public Optional<OpcionRespuesta> findOpcionRespuestaById(int id) {
        String sql ="SELECT id,valor_opcion,catalogo_id,,fecha_creacion, fecha_actualizacion, respuesta_padre_id,pregunta_id,tipo_componente_html,comentario_pregunta,opcion_text FROM opcion_respuesta WHERE id=?";
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
                return Optional.of(opcionRespuesta);
            }
        } catch(SQLException e){
            e.printStackTrace();
        }
		return Optional.empty();
    }

    @Override
    public List<OpcionRespuesta> findAllOpcionesRespuesta() {
        String sql ="SELECT id,valor_opcion,catalogo_id,,fecha_creacion, fecha_actualizacion, respuesta_padre_id,pregunta_id,tipo_componente_html,comentario_pregunta,opcion_text FROM opcion_respuesta WHERE id=?";
        List<OpcionRespuesta> opcionesRespuesta =new ArrayList<>();

        try(Connection connection = Database.getConnection();
        PreparedStatement ps =connection.prepareStatement(sql)){
            
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

}
