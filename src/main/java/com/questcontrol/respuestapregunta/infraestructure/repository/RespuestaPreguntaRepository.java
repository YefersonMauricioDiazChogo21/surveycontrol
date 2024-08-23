package com.questcontrol.respuestapregunta.infraestructure.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

import com.questcontrol.Database;
import com.questcontrol.respuestapregunta.domain.entity.RespuestaPregunta;
import com.questcontrol.respuestapregunta.domain.service.RespuestaPreguntaService;

public class RespuestaPreguntaRepository implements RespuestaPreguntaService{
    Scanner scanner= new Scanner(System.in);

    @Override
    public void createRespuestaPregunta(RespuestaPregunta respuestaPregunta) {
        String sql ="INSERT INTO respuesta_pregunta(respuesta_id,subrespuesta_id,respuesta_text) VALUES (?,?,?)";
        try(Connection connection = Database.getConnection();
        PreparedStatement ps= connection.prepareStatement(sql)){
            ps.setInt(1, respuestaPregunta.getRespuesta_id());
            ps.setInt(2, respuestaPregunta.getSubrespuesta_id());
            ps.setString(3, respuestaPregunta.getRespuesta_text());
            ps.executeUpdate();
            System.out.println("Carga de Respuesta Pregunta exitoso");
        }catch(SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public RespuestaPregunta deleteRespuestaPregunta(int id) {
        String sql ="DELETE FROM respuesta_pregunta WHERE id = ?";
        try(Connection connection = Database.getConnection();
        PreparedStatement ps= connection.prepareStatement(sql)){
            ps.setInt(1, id);
            ps.executeUpdate();
            System.out.println("Eliminacion de respuesta de pregunta exitoso");
        }catch(SQLException e){
            e.printStackTrace();
            System.out.println("Id no encontrado");
        }
        return null;
    }

    @Override
    public void updateRespuestaPregunta(RespuestaPregunta respuestaPregunta, int id) {
        String sql ="UPDATE respuesta_pregunta SET respuesta_id=? ,subrespuesta_id=?,respuesta_text=? WHERE id=?";
        try(Connection connection = Database.getConnection();
        PreparedStatement ps= connection.prepareStatement(sql)){
            int respuesta_id =scanner.nextInt();
            int subrespuesta_id= scanner.nextInt();
            String respuesta_text= scanner.nextLine();
            ps.setInt(1, respuesta_id);
            ps.setInt(2, subrespuesta_id);
            ps.setString(3, respuesta_text);
            ps.setInt(4, id);
            ps.executeUpdate();
            System.out.print("Actualizacion de respuesta de pregunta exitosa");
        }catch(SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public Optional<RespuestaPregunta> findRespuestaPreguntaById(int id) {
        String sql ="SELECT id,respuesta_id,subrespuesta_id,respuesta_text FROM respuesta_pregunta WHERE id=?";
        try(Connection connection = Database.getConnection();
        PreparedStatement ps =connection.prepareStatement(sql)){
            ps.setInt(1,id);
            ResultSet rs=ps.executeQuery();

            while(rs.next()){
                int idu=rs.getInt("id");
                int respuesta_id =rs.getInt("respuesta_id");
                int subrespuesta_id =rs.getInt("subrespuesta_id");
                String respuesta_text =rs.getString("respuesta_text");
                RespuestaPregunta respuestaPregunta =new RespuestaPregunta(idu,respuesta_id,subrespuesta_id,respuesta_text);
                return Optional.of(respuestaPregunta);
            }
        } catch(SQLException e){
            e.printStackTrace();
        }
		return Optional.empty();
    }

    @Override
    public List<RespuestaPregunta> findAllRespuestasPregunta() {
        String sql ="SELECT id,respuesta_id,subrespuesta_id,respuesta_text FROM respuesta_pregunta";
        List<RespuestaPregunta> respuestasPregunta=new ArrayList<>();

        try(Connection connection = Database.getConnection();
        PreparedStatement ps =connection.prepareStatement(sql)){
            ResultSet rs=ps.executeQuery();

            while(rs.next()){
                int idu=rs.getInt("id");
                int respuesta_id =rs.getInt("respuesta_id");
                int subrespuesta_id =rs.getInt("subrespuesta_id");
                String respuesta_text =rs.getString("respuesta_text");
                RespuestaPregunta respuestaPregunta =new RespuestaPregunta(idu,respuesta_id,subrespuesta_id,respuesta_text);
                respuestasPregunta.add(respuestaPregunta);
            }
        } catch(SQLException e){
            e.printStackTrace();
        }
		return respuestasPregunta;
    }

}
