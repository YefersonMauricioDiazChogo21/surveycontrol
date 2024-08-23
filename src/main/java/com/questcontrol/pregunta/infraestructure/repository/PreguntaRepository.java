package com.questcontrol.pregunta.infraestructure.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

import com.questcontrol.Database;
import com.questcontrol.pregunta.domain.entity.Pregunta;
import com.questcontrol.pregunta.domain.service.PreguntaService;

public class PreguntaRepository implements PreguntaService{
    Scanner scanner= new Scanner(System.in);

    @Override
    public void createPregunta(Pregunta pregunta) {
        String sql ="INSERT INTO pregunta(capitulo_id,numero_pregunta,tipo_respuesta,comentario_pregunta,texto_pregunta) VALUES (?,?,?,?,?)";
        try(Connection connection = Database.getConnection();
        PreparedStatement ps= connection.prepareStatement(sql)){
            ps.setInt(1, pregunta.getCapitulo_id());
            ps.setString(2, pregunta.getNumero_pregunta());
            ps.setString(3, pregunta.getTipo_respuesta());
            ps.setString(4, pregunta.getComentario_pregunta());
            ps.setString(5, pregunta.getTexto_pregunta());
            ps.executeUpdate();
            System.out.println("Carga de pregunta exitoso");
        }catch(SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public Pregunta deletePregunta(int id) {
        String sql ="DELETE FROM pregunta WHERE id = ?";
        try(Connection connection = Database.getConnection();
        PreparedStatement ps= connection.prepareStatement(sql)){
            ps.setInt(1, id);
            ps.executeUpdate();
            System.out.println("Eliminacion de pregunta exitoso");
        }catch(SQLException e){
            e.printStackTrace();
            System.out.println("Id no encontrado");
        }
        return null;
    }

    @Override
    public void updatePregunta(Pregunta pregunta, int id) {
        String sql ="UPDATE pregunta SET capitulo_id=?, fecha_actualizacion= CURRENT_TIMESTAMP,numero_pregunta=?,tipo_respuesta=?,comentario_pregunta=?,texto_pregunta=? WHERE id=?";
        try(Connection connection = Database.getConnection();
        PreparedStatement ps= connection.prepareStatement(sql)){
            int capitulo_id= scanner.nextInt();
            String numero_pregunta= scanner.nextLine();
            String tipo_respuesta= scanner.nextLine();
            String comentario_pregunta= scanner.nextLine();
            String texto_pregunta= scanner.nextLine();

            ps.setInt(1,capitulo_id );
            ps.setString(2, numero_pregunta);
            ps.setString(3, tipo_respuesta);
            ps.setString(4, comentario_pregunta);
            ps.setString(5, texto_pregunta);
            ps.setInt(6, id);
            ps.executeUpdate();
            System.out.print("Actualizacion de usuario exitosa");
        }catch(SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public Optional<Pregunta> findPreguntaById(int id) {
        String sql ="SELECT id,capitulo_id,fecha_creacion, fecha_actualizacion,numero_pregunta,tipo_respuesta,comentario_pregunta,texto_pregunta FROM pregunta WHERE id=?";
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
                return Optional.of(pregunta);
            }
        } catch(SQLException e){
            e.printStackTrace();
        }
		return Optional.empty();
    }

    @Override
    public List<Pregunta> findAllPreguntas() {
        String sql ="SELECT id,capitulo_id,fecha_creacion, fecha_actualizacion,numero_pregunta,tipo_respuesta,comentario_pregunta,texto_pregunta FROM pregunta WHERE id=?";
        List<Pregunta> preguntas =new ArrayList<>();

        try(Connection connection = Database.getConnection();
        PreparedStatement ps =connection.prepareStatement(sql)){
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

}
