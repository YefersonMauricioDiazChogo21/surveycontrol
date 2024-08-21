package com.questcontrol.rol.infraestructure.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

import com.questcontrol.Database;
import com.questcontrol.rol.domain.entity.Rol;
import com.questcontrol.rol.domain.service.RolService;

public class RolRepository implements RolService {
    Scanner scanner= new Scanner(System.in);

    @Override
    public void createRol(Rol rol) {
        String sql ="INSERT INTO rol(rol) VALUES (?)";
        try(Connection connection = Database.getConnection();
        PreparedStatement ps= connection.prepareStatement(sql)){
            ps.setString(1, rol.getRol());
            ps.executeUpdate();
            System.out.println("Carga de rol exitoso");
        }catch(SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public Rol deleteRol(int id) {
        String sql ="DELETE FROM rol WHERE id = ?";
        try(Connection connection = Database.getConnection();
        PreparedStatement ps= connection.prepareStatement(sql)){
            ps.setInt(1, id);
            ps.executeUpdate();
            System.out.println("Eliminacion de rol exitoso");
        }catch(SQLException e){
            e.printStackTrace();
            System.out.println("Id no encontrado");
        }
        return null;
    }

    @Override
    public void updateRol(Rol rol, int id) {
        String sql ="UPDATE usuario SET rol=? WHERE id=?";
        try(Connection connection = Database.getConnection();
        PreparedStatement ps= connection.prepareStatement(sql)){
            String newrol= scanner.nextLine();
            ps.setString(1, newrol);
            ps.setInt(2, id);
            ps.executeUpdate();
            System.out.print("Actualizacion de rol exitosa");
        }catch(SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public Optional<Rol> findRolById(int id) {
        String sql ="SELECT id,rol FROM rol WHERE id=?";
        try(Connection connection = Database.getConnection();
        PreparedStatement ps =connection.prepareStatement(sql)){
            ps.setInt(1,id);
            ResultSet rs=ps.executeQuery();

            while(rs.next()){
                int idr=id;
                String rolr =rs.getString("rol");
                Rol rol = new Rol(idr,rolr);
                return Optional.of(rol);
            }
        } catch(SQLException e){
            e.printStackTrace();
        }
		return Optional.empty();
    }

    @Override
    public List<Rol> findallRoles() {
        String sql ="SELECT id,rol FROM rol";
        List<Rol> roles =new ArrayList<>();
        try(Connection connection = Database.getConnection();
        PreparedStatement ps =connection.prepareStatement(sql)){
            ResultSet rs=ps.executeQuery();

            while(rs.next()){
                int idr=rs.getInt("id");
                String rolr =rs.getString("rol");
                Rol rol = new Rol(idr,rolr);
                roles.add(rol);
            }
        } catch(SQLException e){
            e.printStackTrace();
        }
		return roles;
    }

}
