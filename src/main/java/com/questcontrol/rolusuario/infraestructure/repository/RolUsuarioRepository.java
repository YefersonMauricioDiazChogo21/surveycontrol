package com.questcontrol.rolusuario.infraestructure.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

import com.questcontrol.Database;
import com.questcontrol.rolusuario.domain.entity.RolUsuario;
import com.questcontrol.rolusuario.domain.service.RolUsuarioService;


public class RolUsuarioRepository implements RolUsuarioService{
    Scanner scanner= new Scanner(System.in);

    @Override
    public void createRolUsuario(RolUsuario rolusuario) {
         String sql ="INSERT INTO rol_id,rol_usuario(usuario_id) VALUES (?,?)";
        try(Connection connection = Database.getConnection();
        PreparedStatement ps= connection.prepareStatement(sql)){
            ps.setInt(1, rolusuario.getUsuario_id());
            ps.setInt(2, rolusuario.getRol_id());
            ps.executeUpdate();
            System.out.println("Carga de usuario exitoso");
        }catch(SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public RolUsuario deleteRolUsuario(int id) {
        String sql ="DELETE FROM rol_usuario WHERE id = ?";
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
    public void updateRolUsuario(RolUsuario rol, int id) {
        String sql ="UPDATE rol_usuario SET usuario_id=? WHERE id=?";
        try(Connection connection = Database.getConnection();
        PreparedStatement ps= connection.prepareStatement(sql)){
            int usuario_id= scanner.nextInt();
            ps.setInt(1, usuario_id);
            ps.setInt(2, id);
            ps.executeUpdate();
            System.out.print("Actualizacion de usuario exitosa");
        }catch(SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public Optional<RolUsuario> findRolUsuarioById(int id) {
        String sql ="SELECT id,usuario_id FROM rol_usuario WHERE id=?";
        try(Connection connection = Database.getConnection();
        PreparedStatement ps =connection.prepareStatement(sql)){
            ps.setInt(1,id);
            ResultSet rs=ps.executeQuery();

            while(rs.next()){
                int idu=rs.getInt("id");
                int usuario_id =rs.getInt("usuario_id");
                RolUsuario rolusuario =new RolUsuario(idu,usuario_id);
                return Optional.of(rolusuario);
            }
        } catch(SQLException e){
            e.printStackTrace();
        }
		return Optional.empty();
    }

    @Override
    public List<RolUsuario> findallRolesUsuario() {
        String sql ="SELECT id,habilitado,nombre_usuario,contraseña FROM usuario";
        List<RolUsuario> rolUsuarios =new ArrayList<>();

        try(Connection connection = Database.getConnection();
        PreparedStatement ps =connection.prepareStatement(sql)){
            ResultSet rs=ps.executeQuery();

            while(rs.next()){
                int idu=rs.getInt("id");
                int usuario_id=rs.getInt("usuario_id");
                RolUsuario rolUsuario =new RolUsuario(idu,usuario_id);
                rolUsuarios.add(rolUsuario);
            }
        } catch(SQLException e){
            e.printStackTrace();
        }
		return rolUsuarios;
    }

}
