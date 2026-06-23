package modelo;

import dao.CRUD;
import dao.Conexion;
import java.util.ArrayList;
import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AdminCampanasBD extends Conexion implements CRUD {

    @Override
    public Object insertar(Object obj) {
        Connection conex = abrirConexion();
        campanas objCampana = (campanas) obj;
        try {
            String sql = "INSERT INTO campanas(nombre, descripcion, fecha_inicio, fecha_fin, estado, PERSONAS_id) VALUES(?,?,?,?,?,?)";
            PreparedStatement preparedStatement = conex.prepareStatement(sql, new String[]{"id"});
            preparedStatement.setString(1, objCampana.getNombre());
            preparedStatement.setString(2, objCampana.getDescripcion());
            preparedStatement.setString(3, objCampana.getFecha_inicio());
            preparedStatement.setString(4, objCampana.getFecha_fin());
            preparedStatement.setString(5, objCampana.getEstado());
            preparedStatement.setInt(6, objCampana.getPERSONAS_id());
            preparedStatement.execute();

            ResultSet rs = preparedStatement.getGeneratedKeys();
            while (rs.next()) {
                objCampana.setId(rs.getInt(1));
            }
            preparedStatement.close();
            System.out.println("La inserción de la Campaña fue exitosa.");
        } catch (Exception e) {
            System.out.println("Error al insertar la Campaña: " + e.getMessage());
        }
        cerrarConexion();
        return objCampana;
    }

    @Override
    public boolean actualizar(Object obj) {
        campanas objCampana = (campanas) obj;
        boolean flag = false;
        Connection conex = abrirConexion();
        try {
            String sql = "UPDATE campanas SET nombre=?, descripcion=?, fecha_inicio=?, fecha_fin=?, estado=?, PERSONAS_id=? WHERE id=?";
            PreparedStatement preparedStatement = conex.prepareStatement(sql);
            preparedStatement.setString(1, objCampana.getNombre());
            preparedStatement.setString(2, objCampana.getDescripcion());
            preparedStatement.setString(3, objCampana.getFecha_inicio());
            preparedStatement.setString(4, objCampana.getFecha_fin());
            preparedStatement.setString(5, objCampana.getEstado());
            preparedStatement.setInt(6, objCampana.getPERSONAS_id());
            preparedStatement.setInt(7, objCampana.getId());
            int totalFilasafectadas = preparedStatement.executeUpdate();
            if (totalFilasafectadas > 0) {
                flag = true;
            }
            preparedStatement.close();
        } catch (Exception e) {
            System.out.println("Error en la actualización de la Campaña: " + e.getMessage());
        }
        cerrarConexion();
        return flag;
    }

    @Override
    public boolean eliminar(Object obj) {
        campanas objCampana = (campanas) obj;
        boolean flag = false;
        Connection conex = abrirConexion();
        try {
            String sql = "DELETE FROM campanas WHERE id=?";
            PreparedStatement preparedStatement = conex.prepareStatement(sql);
            preparedStatement.setInt(1, objCampana.getId());
            int totalFilasafectadas = preparedStatement.executeUpdate();
            if (totalFilasafectadas > 0) {
                flag = true;
            }
            preparedStatement.close();
        } catch (Exception e) {
            System.out.println("Error al eliminar la Campaña: " + e.getMessage());
        }
        cerrarConexion();
        return flag;
    }

    @Override
    public List<Object> listarTodo() {
        List<Object> rowsQuery = new ArrayList<Object>();
        Connection conex = abrirConexion();
        campanas objCampana;
        try {
            String sql = "SELECT * FROM campanas ORDER BY id ASC";
            PreparedStatement preparedStatement = conex.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                objCampana = new campanas();
                objCampana.setId(resultSet.getInt("id"));
                objCampana.setNombre(resultSet.getString("nombre"));
                objCampana.setDescripcion(resultSet.getString("descripcion"));
                objCampana.setFecha_inicio(resultSet.getString("fecha_inicio"));
                objCampana.setFecha_fin(resultSet.getString("fecha_fin"));
                objCampana.setEstado(resultSet.getString("estado"));
                objCampana.setPERSONAS_id(resultSet.getInt("PERSONAS_id"));
                rowsQuery.add(objCampana);
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
        campanas objCampana = (campanas) obj;
        Connection conex = abrirConexion();
        try {
            String sql = "SELECT * FROM campanas WHERE id=?";
            PreparedStatement preparedStatement = conex.prepareStatement(sql);
            preparedStatement.setInt(1, objCampana.getId());
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                objCampana.setNombre(resultSet.getString("nombre"));
                objCampana.setDescripcion(resultSet.getString("descripcion"));
                objCampana.setFecha_inicio(resultSet.getString("fecha_inicio"));
                objCampana.setFecha_fin(resultSet.getString("fecha_fin"));
                objCampana.setEstado(resultSet.getString("estado"));
                objCampana.setPERSONAS_id(resultSet.getInt("PERSONAS_id"));
            }
            preparedStatement.close();
        } catch (SQLException ex) {
            System.out.println("Error en la adquisición de datos: " + ex.getMessage());
        }
        cerrarConexion();
        return objCampana;
    }
}