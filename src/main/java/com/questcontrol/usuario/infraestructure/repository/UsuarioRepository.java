package com.questcontrol.usuario.infraestructure.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

import com.questcontrol.Database;
import com.questcontrol.usuario.domain.entity.Usuario;
import com.questcontrol.usuario.domain.service.UsuarioService;

public class UsuarioRepository implements UsuarioService{
    Scanner scanner= new Scanner(System.in);

    @Override
    public void createusuario(Usuario usuario) {
        String sql ="INSERT INTO usuario(habilidato,nombre_usuario,contraseña) VALUES (?,?,?)";
        try(Connection connection = Database.getConnection();
        PreparedStatement ps= connection.prepareStatement(sql)){
            ps.setBoolean(1, usuario.isHabilitado());
            ps.setString(2, usuario.getNombre_usuario());
            ps.setString(3, usuario.getContraseña());
            ps.executeUpdate();
            System.out.println("Carga de usuario exitoso");
        }catch(SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public Usuario deleteusuario(int id) {
        String sql ="DELETE FROM usuario WHERE id = ?";
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
    public void updateusuario(Usuario usuario,int id) {
        String sql ="UPDATE usuario SET habilidato=? ,nombre_usuario=?,contraseña=? WHERE id=?";
        try(Connection connection = Database.getConnection();
        PreparedStatement ps= connection.prepareStatement(sql)){
            Boolean habilitado =scanner.nextBoolean();
            String nombre= scanner.nextLine();
            String contraseña= scanner.nextLine();
            ps.setBoolean(1, habilitado);
            ps.setString(2, nombre);
            ps.setString(3, contraseña);
            ps.setInt(4, id);
            ps.executeUpdate();
            System.out.print("Actualizacion de usuario exitosa");
        }catch(SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public Optional<Usuario> findusuariobyid(int id){
        String sql ="SELECT id,habilitado,nombre_usuario,contraseña FROM usuario WHERE id=?";
        try(Connection connection = Database.getConnection();
        PreparedStatement ps =connection.prepareStatement(sql)){
            ps.setInt(1,id);
            ResultSet rs=ps.executeQuery();

            while(rs.next()){
                int idu=rs.getInt("id");
                Boolean habilitado =rs.getBoolean("habilitado");
                String nombre =rs.getString("nombre_usuario");
                String contraseña =rs.getString("contraseña");
                Usuario usuario =new Usuario(idu,habilitado,nombre,contraseña);
                return Optional.of(usuario);
            }
        } catch(SQLException e){
            e.printStackTrace();
        }
		return Optional.empty();
    }

    @Override
    public List<Usuario> findallusuarios() {
        String sql ="SELECT id,habilitado,nombre_usuario,contraseña FROM usuario";
        List<Usuario> usuarios =new ArrayList<>();

        try(Connection connection = Database.getConnection();
        PreparedStatement ps =connection.prepareStatement(sql)){
            ResultSet rs=ps.executeQuery();

            while(rs.next()){
                int idu=rs.getInt("id");
                Boolean habilitado =rs.getBoolean("habilitado");
                String nombre =rs.getString("nombre_usuario");
                String contraseña =rs.getString("contraseña");
                Usuario usuario =new Usuario(idu,habilitado,nombre,contraseña);
                usuarios.add(usuario);
            }
        } catch(SQLException e){
            e.printStackTrace();
        }
		return usuarios;
    }

}
