package com.questcontrol.opcionsubrespuesta.infraestructure.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

import com.questcontrol.Database;
import com.questcontrol.opcionsubrespuesta.domain.entity.OpcionSubRespuesta;
import com.questcontrol.opcionsubrespuesta.domain.service.OpcionSubRespuestaService;

public class OpcionSubRespuestaRepository implements OpcionSubRespuestaService{
    Scanner scanner= new Scanner(System.in);

    @Override
    public void createOpcionSubRespuesta(OpcionSubRespuesta opcionSubRespuesta) {
        String sql ="INSERT INTO opcion_subrespuesta(numero_subrespuesta,opcion_respuesta_id,tipo_componente_html,subrespueta_text) VALUES (?,?,?,?)";
        try(Connection connection = Database.getConnection();
        PreparedStatement ps= connection.prepareStatement(sql)){
            ps.setInt(1, opcionSubRespuesta.getNumero_subrespuesta());
            ps.setInt(2, opcionSubRespuesta.getOpcion_respuesta_id());
            ps.setString(3, opcionSubRespuesta.getTipo_componente_html());
            ps.setString(4, opcionSubRespuesta.getSubrespueta_text());
            ps.executeUpdate();
            System.out.println("Carga de opcion de Sub-Respuesta exitoso");
        }catch(SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public OpcionSubRespuesta deleteOpcionSubRespuesta(int id) {
        String sql ="DELETE FROM opcion_subrespuesta WHERE id = ?";
        try(Connection connection = Database.getConnection();
        PreparedStatement ps= connection.prepareStatement(sql)){
            ps.setInt(1, id);
            ps.executeUpdate();
            System.out.println("Eliminacion de opcion de sub-respuesta exitoso");
        }catch(SQLException e){
            e.printStackTrace();
            System.out.println("Id no encontrado");
        }
        return null;
    }

    @Override
    public void updateOpcionSubRespuesta(OpcionSubRespuesta opcionSubRespuesta, int id) {
        String sql ="UPDATE opcion_subrespuesta SET numero_subrespuesta=?,opcion_respuesta_id=?,fecha_actualizacion= CURRENT_TIMESTAMP,tipo_componente_html=?,subrespueta_text=? WHERE id=?";
        try(Connection connection = Database.getConnection();
        PreparedStatement ps= connection.prepareStatement(sql)){
            int numero_subrespuesta= scanner.nextInt();
            int opcion_respuesta_id= scanner.nextInt();
            String tipo_componente_html= scanner.nextLine();
            String subrespueta_text= scanner.nextLine();

            ps.setInt(1,numero_subrespuesta );
            ps.setInt(2,opcion_respuesta_id );
            ps.setString(3, tipo_componente_html);
            ps.setString(4, subrespueta_text);
            ps.setInt(5, id);
            ps.executeUpdate();
            System.out.print("Actualizacion de opcion de sub-respuesta exitosa");
        }catch(SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public Optional<OpcionSubRespuesta> findOpcionSubRespuestaById(int id) {
        String sql ="SELECT id,numero_subrespuesta,fecha_creacion, fecha_actualizacion, opcion_respuesta_id,tipo_componente_html,subrespueta_text FROM opcion_subrespuesta WHERE id=?";
        try(Connection connection = Database.getConnection();
        PreparedStatement ps =connection.prepareStatement(sql)){
            ps.setInt(1,id);
            ResultSet rs=ps.executeQuery();

            while(rs.next()){
                int idu=rs.getInt("id");
                int numero_subrespuesta=rs.getInt("numero_subrespuesta");
                java.sql.Timestamp fechaCreacion = rs.getTimestamp("fecha_creacion");
                int opcion_respuesta_id=rs.getInt("opcion_respuesta_id");
                java.sql.Timestamp fechaActualizacion = rs.getTimestamp("fecha_actualizacion");
                String tipo_componente_html= rs.getString("tipo_componente_html");
                String subrespueta_text =rs.getString("subrespueta_text");
                
                OpcionSubRespuesta opcionSubRespuesta =new OpcionSubRespuesta(idu,numero_subrespuesta,fechaCreacion,opcion_respuesta_id,fechaActualizacion,tipo_componente_html,subrespueta_text);
                return Optional.of(opcionSubRespuesta);
            }
        } catch(SQLException e){
            e.printStackTrace();
        }
		return Optional.empty();
    }

    @Override
    public List<OpcionSubRespuesta> findAllOpcionesSubRespuesta() {
        String sql ="SELECT id,numero_subrespuesta,fecha_creacion, fecha_actualizacion, opcion_respuesta_id,tipo_componente_html,subrespueta_text FROM opcion_subrespuesta WHERE id=?";
        List<OpcionSubRespuesta> opcionesSubRespuesta= new ArrayList<>();
        try(Connection connection = Database.getConnection();
        PreparedStatement ps =connection.prepareStatement(sql)){
            ResultSet rs=ps.executeQuery();

            while(rs.next()){
                int idu=rs.getInt("id");
                int numero_subrespuesta=rs.getInt("numero_subrespuesta");
                java.sql.Timestamp fechaCreacion = rs.getTimestamp("fecha_creacion");
                int opcion_respuesta_id=rs.getInt("opcion_respuesta_id");
                java.sql.Timestamp fechaActualizacion = rs.getTimestamp("fecha_actualizacion");
                String tipo_componente_html= rs.getString("tipo_componente_html");
                String subrespueta_text =rs.getString("subrespueta_text");
                
                OpcionSubRespuesta opcioneSubRespuesta =new OpcionSubRespuesta(idu,numero_subrespuesta,fechaCreacion,opcion_respuesta_id,fechaActualizacion,tipo_componente_html,subrespueta_text);
                opcionesSubRespuesta.add(opcioneSubRespuesta);
            }
        } catch(SQLException e){
            e.printStackTrace();
        }
		return opcionesSubRespuesta;
    }

}
