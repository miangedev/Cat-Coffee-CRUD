package modelo;

import dao.CRUD;
import dao.Conexion;
import java.util.ArrayList;
import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AdminCategoriasBD extends Conexion implements CRUD {

    @Override
    public Object insertar(Object obj) {
        Connection conex = abrirConexion();
        categorias objCategoria = (categorias) obj;
        try {
            String sql = "INSERT INTO categorias(nombre, dias_prestamo, porcentaje_penalizacion) VALUES(?,?,?)";
            PreparedStatement preparedStatement = conex.prepareStatement(sql, new String[]{"id"});
            preparedStatement.setString(1, objCategoria.getNombre());
            preparedStatement.setInt(2, objCategoria.getDias_prestamo());
            preparedStatement.setDouble(3, objCategoria.getPorcentaje_penalizacion());
            preparedStatement.execute();

            ResultSet rs = preparedStatement.getGeneratedKeys();
            while (rs.next()) {
                objCategoria.setId(rs.getInt(1));
            }
            preparedStatement.close();
            System.out.println("La inserción de la Categoria fue exitosa.");
        } catch (Exception e) {
            System.out.println("Error al insertar la Categoria: " + e.getMessage());
        }
        cerrarConexion();
        return objCategoria;
    }

    @Override
    public boolean actualizar(Object obj) {
        categorias objCategoria = (categorias) obj;
        boolean flag = false;
        Connection conex = abrirConexion();
        try {
            String sql = "UPDATE categorias SET nombre=?, dias_prestamo=?, porcentaje_penalizacion=? WHERE id=?";
            PreparedStatement preparedStatement = conex.prepareStatement(sql);
            preparedStatement.setString(1, objCategoria.getNombre());
            preparedStatement.setInt(2, objCategoria.getDias_prestamo());
            preparedStatement.setDouble(3, objCategoria.getPorcentaje_penalizacion());
            preparedStatement.setInt(4, objCategoria.getId());
            int totalFilasafectadas = preparedStatement.executeUpdate();
            if (totalFilasafectadas > 0) {
                flag = true;
            }
            preparedStatement.close();
        } catch (Exception e) {
            System.out.println("Error en la actualización de la Categoria: " + e.getMessage());
        }
        cerrarConexion();
        return flag;
    }

    @Override
    public boolean eliminar(Object obj) {
        categorias objCategoria = (categorias) obj;
        boolean flag = false;
        Connection conex = abrirConexion();
        try {
            String sql = "DELETE FROM categorias WHERE id=?";
            PreparedStatement preparedStatement = conex.prepareStatement(sql);
            preparedStatement.setInt(1, objCategoria.getId());
            int totalFilasafectadas = preparedStatement.executeUpdate();
            if (totalFilasafectadas > 0) {
                flag = true;
            }
            preparedStatement.close();
        } catch (Exception e) {
            System.out.println("Error al eliminar la Categoria: " + e.getMessage());
        }
        cerrarConexion();
        return flag;
    }

    @Override
    public List<Object> listarTodo() {
        List<Object> rowsQuery = new ArrayList<Object>();
        Connection conex = abrirConexion();
        categorias objCategoria;
        try {
            String sql = "SELECT * FROM categorias ORDER BY id ASC";
            PreparedStatement preparedStatement = conex.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                objCategoria = new categorias();
                objCategoria.setId(resultSet.getInt("id"));
                objCategoria.setNombre(resultSet.getString("nombre"));
                objCategoria.setDias_prestamo(resultSet.getInt("dias_prestamo"));
                objCategoria.setPorcentaje_penalizacion(resultSet.getDouble("porcentaje_penalizacion"));
                rowsQuery.add(objCategoria);
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
        categorias objCategoria = (categorias) obj;
        Connection conex = abrirConexion();
        try {
            String sql = "SELECT * FROM categorias WHERE id=?";
            PreparedStatement preparedStatement = conex.prepareStatement(sql);
            preparedStatement.setInt(1, objCategoria.getId());
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                objCategoria.setNombre(resultSet.getString("nombre"));
                objCategoria.setDias_prestamo(resultSet.getInt("dias_prestamo"));
                objCategoria.setPorcentaje_penalizacion(resultSet.getDouble("porcentaje_penalizacion"));
            }
            preparedStatement.close();
        } catch (SQLException ex) {
            System.out.println("Error en la adquisición de datos: " + ex.getMessage());
        }
        cerrarConexion();
        return objCategoria;
    }
}