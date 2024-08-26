package com.questcontrol.formulario.infraestructure.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

import com.questcontrol.Database;
import com.questcontrol.formulario.domain.entity.Formulario;
import com.questcontrol.formulario.domain.service.FormularioService;

public class FormularioRepository implements FormularioService {
    Scanner scanner= new Scanner(System.in);

    @Override
    public void createFormulario(Formulario formulario) {
        String sql ="INSERT INTO formulario(descripcion,nombre) VALUES (?,?)";
        try(Connection connection = Database.getConnection();
        PreparedStatement ps= connection.prepareStatement(sql)){
            ps.setString(1, formulario.getDescripcion());
            ps.setString(2, formulario.getNombre());
            ps.executeUpdate();
            System.out.println("Carga de usuario exitoso");
        }catch(SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public Formulario deleteFormulario(int id) {
        String sql ="DELETE FROM formulario WHERE id = ?";
        try(Connection connection = Database.getConnection();
        PreparedStatement ps= connection.prepareStatement(sql)){
            ps.setInt(1, id);
            ps.executeUpdate();
            System.out.println("Eliminacion de usuario exitoso");
        }catch(SQLException e){
            e.printStackTrace();
            System.out.println("Id no encontrado");
        }
        return null;
    }

    @Override
    public void updateFormulario(Formulario formulario, int id) {
        String sql ="UPDATE formulario SET descripcion=?, nombre=?,fecha_actualizacion= CURRENT_TIMESTAMP WHERE id=?";
        try(Connection connection = Database.getConnection();
        PreparedStatement ps= connection.prepareStatement(sql)){
            String descripcion= scanner.nextLine();
            String nombre= scanner.nextLine();

            ps.setString(1, descripcion);
            ps.setString(2, nombre);
            ps.setInt(3, id);
            ps.executeUpdate();
            System.out.print("Actualizacion de usuario exitosa");
        }catch(SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public Optional<Formulario> findFormularioById(int id) {
        String sql ="SELECT id,fecha_creacion,fecha_actualizacion,descripcion,nombre FROM formulario WHERE id=?";
        try(Connection connection = Database.getConnection();
        PreparedStatement ps =connection.prepareStatement(sql)){
            ps.setInt(1,id);
            ResultSet rs=ps.executeQuery();

            while(rs.next()){
                int idu=rs.getInt("id");
                java.sql.Timestamp fechaCreacion = rs.getTimestamp("fecha_creacion");
                java.sql.Timestamp fechaActualizacion = rs.getTimestamp("fecha_actualizacion");
                String descripcion=rs.getString("descripcion");
                String nombre =rs.getString("nombre_usuario");
                
                Formulario formulario =new Formulario(idu,fechaCreacion,fechaActualizacion,descripcion,nombre);
                return Optional.of(formulario);
            }
        } catch(SQLException e){
            e.printStackTrace();
        }
		return Optional.empty();
    }

    @Override
    public List<Formulario> findAllFormularios() {
        String sql ="SELECT id,fecha_creacion,fecha_actualizacion, descripcion,nombre FROM formulario";
        List<Formulario> formularios =new ArrayList<>();

        try(Connection connection = Database.getConnection();
        PreparedStatement ps =connection.prepareStatement(sql)){
            ResultSet rs=ps.executeQuery();

            while(rs.next()){
                int idu=rs.getInt("id");
                java.sql.Timestamp fechaCreacion = rs.getTimestamp("fecha_creacion");
                java.sql.Timestamp fechaActualizacion = rs.getTimestamp("fecha_actualizacion");
                String descripcion=rs.getString("descripcion");
                String nombre =rs.getString("nombre");
                Formulario formulario =new Formulario(idu,fechaCreacion,fechaActualizacion,descripcion,nombre);
                formularios.add(formulario);
            }
        } catch(SQLException e){
            e.printStackTrace();
        }
		return formularios;
    }

}
