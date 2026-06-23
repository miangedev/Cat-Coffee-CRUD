package modelo;

import dao.CRUD;
import dao.Conexion;
import java.util.ArrayList;
import java.util.List;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class AdminRolBD extends Conexion implements CRUD {

    @Override
    public Object insertar(Object obj) {
        Connection conex = abrirConexion();
        rol objRol = (rol) obj;
        try {
            String sql = "INSERT INTO rol(nombre_rol) VALUES(?)";
            PreparedStatement preparedStatement = conex.prepareStatement(sql, new String[]{"id"});
            preparedStatement.setString(1, objRol.getNombre_rol());
            preparedStatement.execute();

            ResultSet rs = preparedStatement.getGeneratedKeys();
            while (rs.next()) {
                objRol.setId(rs.getInt(1));
            }
            preparedStatement.close();
            System.out.println("La inserción del Rol fue exitosa.");
        } catch (Exception e) {
            System.out.println("Error al insertar el Rol: " + e.getMessage());
        }
        cerrarConexion();
        return objRol;
    }

    @Override
    public boolean actualizar(Object obj) {
        rol objRol = (rol) obj;
        boolean flag = false;
        Connection conex = abrirConexion();
        try {
            String sql = "UPDATE rol SET nombre_rol=? WHERE id=?";
            PreparedStatement preparedStatement = (PreparedStatement) conex.prepareStatement(sql);
            preparedStatement.setString(1, objRol.getNombre_rol());
            preparedStatement.setInt(2, objRol.getId());
            int totalFilasafectadas = preparedStatement.executeUpdate();
            if (totalFilasafectadas > 0) {
                flag = true;
            }
            preparedStatement.close();
        } catch (Exception e) {
            System.out.println("Error en la actualización de la rol: " + e.getMessage());
        }
        cerrarConexion();
        return flag;
    }

    @Override
    public boolean eliminar(Object obj) {
         rol objRol = (rol) obj;
         boolean flag = false;
        Connection conex = abrirConexion();
        try {
            String sql = "DELETE FROM rol WHERE id=?";
            PreparedStatement preparedStatement = (PreparedStatement) conex.prepareStatement(sql);
            preparedStatement.setInt(1, objRol.getId());
            int totalFilasafectadas = preparedStatement.executeUpdate();
            if(totalFilasafectadas>0){
                flag = true;
            }
            preparedStatement.close();
            
        } catch (Exception e) {
            //JOptionPane.showMessageDialog(null, "Error al eliminar el cliente: "+e.getMessage());
            System.out.println("Error al eliminar el cliente: "+e.getMessage());
        }
        cerrarConexion();
        return flag;

    }

    @Override
    public List<Object> listarTodo() {
        List<Object> rowsQuery = new ArrayList<Object>();
        Connection conex = abrirConexion();
        rol objRol;
        try {
            String sql = "SELECT * FROM rol ORDER BY id ASC";
            PreparedStatement preparedStatement = (PreparedStatement) conex.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                objRol = new rol();
                objRol.setId(resultSet.getInt("id"));
                objRol.setRol(resultSet.getString("nombre_rol"));
                
                rowsQuery.add(objRol);
            }
            preparedStatement.close();
        } catch (SQLException ex) {
            //JOptionPane.showMessageDialog(null, "Error en la adquisición de datos");
            System.out.println("Error en la adquisición de datos: "+ex.getMessage());
        }
        cerrarConexion();
        return rowsQuery;
    }

    @Override
    public Object listarUno(Object obj) {
        Connection conex = abrirConexion();
        rol objRol = (rol) obj;
        try {
            String sql = "SELECT * FROM rol WHERE id = ?";
            PreparedStatement preparedStatement = (PreparedStatement) conex.prepareStatement(sql);
            preparedStatement.setInt(1, objRol.getId());
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                objRol.setRol(resultSet.getString("nombre_rol"));              
            }

            preparedStatement.close();
        } catch (SQLException ex) {
            //JOptionPane.showMessageDialog(null, "Error en la adquisición de datos: "+ex.getMessage());
            System.out.println("Error en la adquisición de datos: "+ex.getMessage());
        }

        cerrarConexion();
        return objRol;

    }
    
}
