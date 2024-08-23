package com.questcontrol.capitulo.infraestructure.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

import com.questcontrol.Database;
import com.questcontrol.capitulo.domain.entity.Capitulo;
import com.questcontrol.capitulo.domain.service.CapituloService;

public class CapituloRepository implements CapituloService {
    Scanner scanner= new Scanner(System.in);
    
    @Override
    public void createCapitulo(Capitulo capitulo) {
        String sql ="INSERT INTO capitulo(formulario_id,numero_capitulo,titulo_capitulo) VALUES (?,?,?)";
        try(Connection connection = Database.getConnection();
        PreparedStatement ps= connection.prepareStatement(sql)){
            ps.setInt(1, capitulo.getFormulario_id());
            ps.setString(2, capitulo.getNumero_capitulo());
            ps.setString(3, capitulo.getTitulo_capitulo());
            ps.executeUpdate();
            System.out.println("Carga de usuario exitoso");
        }catch(SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public Capitulo deleteCapitulo(int id) {
        String sql ="DELETE FROM capitulo WHERE id = ?";
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
    public void updateCapitulo(Capitulo capitulo, int id) {
        String sql ="UPDATE formulario SET formulario_id=?,fecha_actualizacion= CURRENT_TIMESTAMP,numero_capitulo=?,titulo_capitulo=? WHERE id=?";
        try(Connection connection = Database.getConnection();
        PreparedStatement ps= connection.prepareStatement(sql)){
            int formulario_id= scanner.nextInt();
            String numero_capitulo= scanner.nextLine();
            String titulo_capitulo= scanner.nextLine();

            ps.setInt(1,formulario_id );
            ps.setString(2, numero_capitulo);
            ps.setString(3, titulo_capitulo);
            ps.setInt(4, id);
            ps.executeUpdate();
            System.out.print("Actualizacion de usuario exitosa");
        }catch(SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public Optional<Capitulo> findCapitulooById(int id) {
        String sql ="SELECT id,fecha_creacion,formulario_id, fecha_actualizacion,numero_capitulo,titulo_capitulo FROM formulario WHERE id=?";
        try(Connection connection = Database.getConnection();
        PreparedStatement ps =connection.prepareStatement(sql)){
            ps.setInt(1,id);
            ResultSet rs=ps.executeQuery();

            while(rs.next()){
                int idu=rs.getInt("id");
                java.sql.Timestamp fechaCreacion = rs.getTimestamp("fecha_creacion");
                int formulario_id= rs.getInt("formulario_id");
                java.sql.Timestamp fechaActualizacion = rs.getTimestamp("fecha_actualizacion");
                String numero_capitulo=rs.getString("descripcion");
                String titulo_capitulo =rs.getString("nombre_usuario");
                
                Capitulo capitulo =new Capitulo(idu,fechaCreacion,formulario_id,fechaActualizacion,numero_capitulo,titulo_capitulo);
                return Optional.of(capitulo);
            }
        } catch(SQLException e){
            e.printStackTrace();
        }
		return Optional.empty();
    }

    @Override
    public List<Capitulo> findAllCapitulos() {
        String sql ="SELECT id,fecha_creacion,formulario_id, fecha_actualizacion,numero_capitulo,titulo_capitulo FROM formulario WHERE id=?";
        List<Capitulo> capitulos =new ArrayList<>();
        try(Connection connection = Database.getConnection();
        PreparedStatement ps =connection.prepareStatement(sql)){
            ResultSet rs=ps.executeQuery();

            while(rs.next()){
                int idu=rs.getInt("id");
                java.sql.Timestamp fechaCreacion = rs.getTimestamp("fecha_creacion");
                int formulario_id= rs.getInt("formulario_id");
                java.sql.Timestamp fechaActualizacion = rs.getTimestamp("fecha_actualizacion");
                String numero_capitulo=rs.getString("descripcion");
                String titulo_capitulo =rs.getString("nombre_usuario");
                
                Capitulo capitulo =new Capitulo(idu,fechaCreacion,formulario_id,fechaActualizacion,numero_capitulo,titulo_capitulo);
                capitulos.add(capitulo);
            }
        } catch(SQLException e){
            e.printStackTrace();
        }
		return capitulos;
    }

}
