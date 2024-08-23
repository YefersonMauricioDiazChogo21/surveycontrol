package com.questcontrol.catalogo.infraestructure.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

import com.questcontrol.Database;
import com.questcontrol.catalogo.domain.entity.CategoriaCatalogo;
import com.questcontrol.catalogo.domain.service.CategoriaCatalogoService;

public class CategorieaCatalogoRepository implements CategoriaCatalogoService{
    Scanner scanner= new Scanner(System.in);

    @Override
    public void createCatalogo(CategoriaCatalogo categoriaCatalogo) {
        String sql ="INSERT INTO categoria_catalogo(nombre) VALUES (?)";
        try(Connection connection = Database.getConnection();
        PreparedStatement ps= connection.prepareStatement(sql)){
            ps.setString(1, categoriaCatalogo.getNombre());
            ps.executeUpdate();
            System.out.println("Carga de usuario exitoso");
        }catch(SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public CategoriaCatalogo deleteCatalogo(int id) {
        String sql ="DELETE FROM categoria_catalogo WHERE id = ?";
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
    public void updateCatalogo(CategoriaCatalogo categoriaCatalogo, int id) {
        String sql ="UPDATE categoria_catalogo SET  nombre=?,fecha_actualizacion= CURRENT_TIMESTAMP WHERE id=?";
        try(Connection connection = Database.getConnection();
        PreparedStatement ps= connection.prepareStatement(sql)){
            String nombre= scanner.nextLine();
            ps.setString(1, nombre);
            ps.setInt(2, id);
            ps.executeUpdate();
            System.out.print("Actualizacion de usuario exitosa");
        }catch(SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public Optional<CategoriaCatalogo> findCatalogoById(int id) {
        String sql ="SELECT id,fecha_creacion,fecha_actualizacion,nombre FROM categoria_catalogo WHERE id=?";
        try(Connection connection = Database.getConnection();
        PreparedStatement ps =connection.prepareStatement(sql)){
            ps.setInt(1,id);
            ResultSet rs=ps.executeQuery();

            while(rs.next()){
                int idu=rs.getInt("id");
                java.sql.Timestamp fechaCreacion = rs.getTimestamp("fecha_creacion");
                java.sql.Timestamp fechaActualizacion = rs.getTimestamp("fecha_actualizacion");
                String nombre =rs.getString("nombre_usuario");
                
                CategoriaCatalogo categoriaCatalogo =new CategoriaCatalogo(idu,fechaCreacion,fechaActualizacion,nombre);
                return Optional.of(categoriaCatalogo);
            }
        } catch(SQLException e){
            e.printStackTrace();
        }
		return Optional.empty();
    }

    @Override
    public List<CategoriaCatalogo> findAllCatalogos() {
        String sql ="SELECT id,fecha_creacion,fecha_actualizacion,nombre FROM categoria_catalogo";
        List<CategoriaCatalogo> catalogos =new ArrayList<>();

        try(Connection connection = Database.getConnection();
        PreparedStatement ps =connection.prepareStatement(sql)){
            ResultSet rs=ps.executeQuery();

            while(rs.next()){
                int idu=rs.getInt("id");
                java.sql.Timestamp fechaCreacion = rs.getTimestamp("fecha_creacion");
                java.sql.Timestamp fechaActualizacion = rs.getTimestamp("fecha_actualizacion");
                String nombre =rs.getString("nombre_usuario");
                CategoriaCatalogo catalogo =new CategoriaCatalogo(idu,fechaCreacion,fechaActualizacion,nombre);
                catalogos.add(catalogo);
            }
        } catch(SQLException e){
            e.printStackTrace();
        }
		return catalogos;
    }

}
