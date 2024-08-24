package com.questcontrol.formulariousuario.infraestructure.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.questcontrol.Database;
import com.questcontrol.formulario.domain.entity.Formulario;
import com.questcontrol.formulariousuario.domain.service.FormularioUsuarioService;

public class FormularioUsuarioRepository implements FormularioUsuarioService{

    @Override
    public List<Formulario> findAllFormularios() {
        String sql ="SELECT id, descripcion,nombre FROM formularios";
        List<Formulario> formularios =new ArrayList<>();

        try(Connection connection = Database.getConnection();
        PreparedStatement ps =connection.prepareStatement(sql)){
            ResultSet rs=ps.executeQuery();

            while(rs.next()){
                int idu=rs.getInt("id");
                String descripcion=rs.getString("descripcion");
                String nombre =rs.getString("nombre_usuario");
                Formulario formulario =new Formulario(idu,descripcion,nombre);
                formularios.add(formulario);
            }
        } catch(SQLException e){
            e.printStackTrace();
        }
		return formularios;
    }

    @Override
    public List<Formulario> findCategoriaCatalogoByIdForm() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findCategoriaCatalogoByIdForm'");
    }

    @Override
    public List<Formulario> findCapitulosByIdForm() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findCapitulosByIdForm'");
    }

    @Override
    public List<Formulario> findByIdForm() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findByIdForm'");
    }

    @Override
    public List<Formulario> findOpcionRespuestaByIdCapitulo() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findOpcionRespuestaByIdCapitulo'");
    }

    @Override
    public List<Formulario> findOpcionesSubRespuestaoByIdCapitulo() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findOpcionesSubRespuestaoByIdCapitulo'");
    }

}
