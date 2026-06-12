package modelo;

import dao.CRUD;
import dao.Conexion;
import java.util.ArrayList;
import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AdminActivosBD extends Conexion implements CRUD {

    @Override
    public Object insertar(Object obj) {
        Connection conex = abrirConexion();
        activos objActivo = (activos) obj;
        try {
            String sql = "INSERT INTO activos(nombre, tipo, marca, modelo, ano_adquisicion, valor_comercial, estado, CATEGORIAS_id) VALUES(?,?,?,?,?,?,?,?)";
            PreparedStatement preparedStatement = conex.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, objActivo.getNombre());
            preparedStatement.setString(2, objActivo.getTipo());
            preparedStatement.setString(3, objActivo.getMarca());
            preparedStatement.setString(4, objActivo.getModelo());
            preparedStatement.setString(5, objActivo.getAno_adquisicion());
            preparedStatement.setDouble(6, objActivo.getValor_comercial());
            preparedStatement.setString(7, objActivo.getEstado());
            preparedStatement.setInt(8, objActivo.getCATEGORIAS_id());
            preparedStatement.execute();

            ResultSet rs = preparedStatement.getGeneratedKeys();
            while (rs.next()) {
                objActivo.setId(rs.getInt(1));
            }
            preparedStatement.close();
            System.out.println("La inserción del Activo fue exitosa.");
        } catch (Exception e) {
            System.out.println("Error al insertar el Activo: " + e.getMessage());
        }
        cerrarConexion();
        return objActivo;
    }

    @Override
    public boolean actualizar(Object obj) {
        activos objActivo = (activos) obj;
        boolean flag = false;
        Connection conex = abrirConexion();
        try {
            String sql = "UPDATE activos SET nombre=?, tipo=?, marca=?, modelo=?, ano_adquisicion=?, valor_comercial=?, estado=?, CATEGORIAS_id=? WHERE id=?";
            PreparedStatement preparedStatement = conex.prepareStatement(sql);
            preparedStatement.setString(1, objActivo.getNombre());
            preparedStatement.setString(2, objActivo.getTipo());
            preparedStatement.setString(3, objActivo.getMarca());
            preparedStatement.setString(4, objActivo.getModelo());
            preparedStatement.setString(5, objActivo.getAno_adquisicion());
            preparedStatement.setDouble(6, objActivo.getValor_comercial());
            preparedStatement.setString(7, objActivo.getEstado());
            preparedStatement.setInt(8, objActivo.getCATEGORIAS_id());
            preparedStatement.setInt(9, objActivo.getId());
            int totalFilasafectadas = preparedStatement.executeUpdate();
            if (totalFilasafectadas > 0) {
                flag = true;
            }
            preparedStatement.close();
        } catch (Exception e) {
            System.out.println("Error en la actualización del Activo: " + e.getMessage());
        }
        cerrarConexion();
        return flag;
    }

    @Override
    public boolean eliminar(Object obj) {
        activos objActivo = (activos) obj;
        boolean flag = false;
        Connection conex = abrirConexion();
        try {
            String sql = "DELETE FROM activos WHERE id=?";
            PreparedStatement preparedStatement = conex.prepareStatement(sql);
            preparedStatement.setInt(1, objActivo.getId());
            int totalFilasafectadas = preparedStatement.executeUpdate();
            if (totalFilasafectadas > 0) {
                flag = true;
            }
            preparedStatement.close();
        } catch (Exception e) {
            System.out.println("Error al eliminar el Activo: " + e.getMessage());
        }
        cerrarConexion();
        return flag;
    }

    @Override
    public List<Object> listarTodo() {
        List<Object> rowsQuery = new ArrayList<Object>();
        Connection conex = abrirConexion();
        activos objActivo;
        try {
            String sql = "SELECT * FROM activos ORDER BY id ASC";
            PreparedStatement preparedStatement = conex.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                objActivo = new activos();
                objActivo.setId(resultSet.getInt("id"));
                objActivo.setNombre(resultSet.getString("nombre"));
                objActivo.setTipo(resultSet.getString("tipo"));
                objActivo.setMarca(resultSet.getString("marca"));
                objActivo.setModelo(resultSet.getString("modelo"));
                objActivo.setAno_adquisicion(resultSet.getString("ano_adquisicion"));
                objActivo.setValor_comercial(resultSet.getDouble("valor_comercial"));
                objActivo.setEstado(resultSet.getString("estado"));
                objActivo.setCATEGORIAS_id(resultSet.getInt("CATEGORIAS_id"));
                rowsQuery.add(objActivo);
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
        activos objActivo = (activos) obj;
        Connection conex = abrirConexion();
        try {
            String sql = "SELECT * FROM activos WHERE id=?";
            PreparedStatement preparedStatement = conex.prepareStatement(sql);
            preparedStatement.setInt(1, objActivo.getId());
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                objActivo.setNombre(resultSet.getString("nombre"));
                objActivo.setTipo(resultSet.getString("tipo"));
                objActivo.setMarca(resultSet.getString("marca"));
                objActivo.setModelo(resultSet.getString("modelo"));
                objActivo.setAno_adquisicion(resultSet.getString("ano_adquisicion"));
                objActivo.setValor_comercial(resultSet.getDouble("valor_comercial"));
                objActivo.setEstado(resultSet.getString("estado"));
                objActivo.setCATEGORIAS_id(resultSet.getInt("CATEGORIAS_id"));
            }
            preparedStatement.close();
        } catch (SQLException ex) {
            System.out.println("Error en la adquisición de datos: " + ex.getMessage());
        }
        cerrarConexion();
        return objActivo;
    }

    public boolean actualizarEstado(int id, String estado) {
        boolean flag = false;
        Connection conex = abrirConexion();
        try {
            String sql = "UPDATE activos SET estado=? WHERE id=?";
            PreparedStatement preparedStatement = conex.prepareStatement(sql);
            preparedStatement.setString(1, estado);
            preparedStatement.setInt(2, id);
            int totalFilasafectadas = preparedStatement.executeUpdate();
            if (totalFilasafectadas > 0) {
                flag = true;
            }
            preparedStatement.close();
        } catch (Exception e) {
            System.out.println("Error al actualizar estado del Activo: " + e.getMessage());
        }
        cerrarConexion();
        return flag;
    }
}