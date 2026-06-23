package modelo;

import dao.CRUD;
import dao.Conexion;
import java.util.ArrayList;
import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AdminPersonasBD extends Conexion implements CRUD {

    @Override
    public Object insertar(Object obj) {
        Connection conex = abrirConexion();
        personas objPersona = (personas) obj;
        try {
            String sql = "INSERT INTO personas(tipo_documento, numero_documento, razon_social, telefono, email, direccion, ROL_id, nombre) VALUES(?,?,?,?,?,?,?,?)";
            PreparedStatement preparedStatement = conex.prepareStatement(sql, new String[]{"id"});
            preparedStatement.setString(1, objPersona.getTipo_documento());
            preparedStatement.setString(2, objPersona.getNumero_documento());
            preparedStatement.setString(3, objPersona.getRazon_social());
            preparedStatement.setString(4, objPersona.getTelefono());
            preparedStatement.setString(5, objPersona.getEmail());
            preparedStatement.setString(6, objPersona.getDireccion());
            preparedStatement.setInt(7, objPersona.getROL_id());
            preparedStatement.setString(8, objPersona.getNombre());
            preparedStatement.execute();

            ResultSet rs = preparedStatement.getGeneratedKeys();
            while (rs.next()) {
                objPersona.setId(rs.getInt(1));
            }
            preparedStatement.close();
            System.out.println("La inserción de la Persona fue exitosa.");
        } catch (Exception e) {
            System.out.println("Error al insertar la Persona: " + e.getMessage());
        }
        cerrarConexion();
        return objPersona;
    }

    @Override
    public boolean actualizar(Object obj) {
        personas objPersona = (personas) obj;
        boolean flag = false;
        Connection conex = abrirConexion();
        try {
            String sql = "UPDATE personas SET tipo_documento=?, numero_documento=?, razon_social=?, telefono=?, email=?, direccion=?, ROL_id=?, nombre=? WHERE id=?";
            PreparedStatement preparedStatement = conex.prepareStatement(sql);
            preparedStatement.setString(1, objPersona.getTipo_documento());
            preparedStatement.setString(2, objPersona.getNumero_documento());
            preparedStatement.setString(3, objPersona.getRazon_social());
            preparedStatement.setString(4, objPersona.getTelefono());
            preparedStatement.setString(5, objPersona.getEmail());
            preparedStatement.setString(6, objPersona.getDireccion());
            preparedStatement.setInt(7, objPersona.getROL_id());
            preparedStatement.setString(8, objPersona.getNombre());
            preparedStatement.setInt(9, objPersona.getId());
            int totalFilasafectadas = preparedStatement.executeUpdate();
            if (totalFilasafectadas > 0) {
                flag = true;
            }
            preparedStatement.close();
        } catch (Exception e) {
            System.out.println("Error en la actualización de la Persona: " + e.getMessage());
        }
        cerrarConexion();
        return flag;
    }

    @Override
    public boolean eliminar(Object obj) {
        personas objPersona = (personas) obj;
        boolean flag = false;
        Connection conex = abrirConexion();
        try {
            String sql = "DELETE FROM personas WHERE id=?";
            PreparedStatement preparedStatement = conex.prepareStatement(sql);
            preparedStatement.setInt(1, objPersona.getId());
            int totalFilasafectadas = preparedStatement.executeUpdate();
            if (totalFilasafectadas > 0) {
                flag = true;
            }
            preparedStatement.close();
        } catch (Exception e) {
            System.out.println("Error al eliminar la Persona: " + e.getMessage());
        }
        cerrarConexion();
        return flag;
    }

    @Override
    public List<Object> listarTodo() {
        List<Object> rowsQuery = new ArrayList<Object>();
        Connection conex = abrirConexion();
        personas objPersona;
        try {
            String sql = "SELECT * FROM personas ORDER BY id ASC";
            PreparedStatement preparedStatement = conex.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                objPersona = new personas();
                objPersona.setId(resultSet.getInt("id"));
                objPersona.setTipo_documento(resultSet.getString("tipo_documento"));
                objPersona.setNumero_documento(resultSet.getString("numero_documento"));
                objPersona.setRazon_social(resultSet.getString("razon_social"));
                objPersona.setTelefono(resultSet.getString("telefono"));
                objPersona.setEmail(resultSet.getString("email"));
                objPersona.setDireccion(resultSet.getString("direccion"));
                objPersona.setROL_id(resultSet.getInt("ROL_id"));
                objPersona.setNombre(resultSet.getString("nombre"));
                rowsQuery.add(objPersona);
            }
            preparedStatement.close();
        } catch (SQLException ex) {
            System.out.println("Error en la adquisición de datos: " + ex.getMessage());
        }
        cerrarConexion();
        return rowsQuery;
    }

    @Override
    public Object listarUno(Object obj) {
        personas objPersona = (personas) obj;
        Connection conex = abrirConexion();
        try {
            String sql = "SELECT * FROM personas WHERE id=?";
            PreparedStatement preparedStatement = conex.prepareStatement(sql);
            preparedStatement.setInt(1, objPersona.getId());
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                objPersona.setTipo_documento(resultSet.getString("tipo_documento"));
                objPersona.setNumero_documento(resultSet.getString("numero_documento"));
                objPersona.setRazon_social(resultSet.getString("razon_social"));
                objPersona.setTelefono(resultSet.getString("telefono"));
                objPersona.setEmail(resultSet.getString("email"));
                objPersona.setDireccion(resultSet.getString("direccion"));
                objPersona.setROL_id(resultSet.getInt("ROL_id"));
                objPersona.setNombre(resultSet.getString("nombre"));
            }
            preparedStatement.close();
        } catch (SQLException ex) {
            System.out.println("Error en la adquisición de datos: " + ex.getMessage());
        }
        cerrarConexion();
        return objPersona;
    }

    public personas buscarPorDocumento(String numero_documento) {
        personas objPersona = new personas();
        Connection conex = abrirConexion();
        try {
            String sql = "SELECT * FROM personas WHERE numero_documento=?";
            PreparedStatement preparedStatement = conex.prepareStatement(sql);
            preparedStatement.setString(1, numero_documento);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                objPersona.setId(resultSet.getInt("id"));
                objPersona.setTipo_documento(resultSet.getString("tipo_documento"));
                objPersona.setNumero_documento(resultSet.getString("numero_documento"));
                objPersona.setRazon_social(resultSet.getString("razon_social"));
                objPersona.setTelefono(resultSet.getString("telefono"));
                objPersona.setEmail(resultSet.getString("email"));
                objPersona.setDireccion(resultSet.getString("direccion"));
                objPersona.setROL_id(resultSet.getInt("ROL_id"));
                objPersona.setNombre(resultSet.getString("nombre"));
                objPersona.setUsuario(resultSet.getString("usuario"));
                objPersona.setContrasena(resultSet.getString("contrasena"));
            }
            preparedStatement.close();
        } catch (SQLException ex) {
            System.out.println("Error al buscar persona: " + ex.getMessage());
        }
        cerrarConexion();
        return objPersona;
    }

    public boolean puedeAccederAlSistema(String usuario, String contrasena) {
        boolean acceso = false;
        Connection conex = abrirConexion();
        try {
            String sql = "SELECT * FROM personas WHERE usuario=? AND contrasena=?";
            PreparedStatement preparedStatement = conex.prepareStatement(sql);
            preparedStatement.setString(1, usuario);
            preparedStatement.setString(2, contrasena);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                acceso = true;
            }
            preparedStatement.close();
        } catch (SQLException ex) {
            System.out.println("Error en acceso al sistema: " + ex.getMessage());
        }
        cerrarConexion();
        return acceso;
    }
}