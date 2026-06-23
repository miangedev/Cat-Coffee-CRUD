package modelo;

import dao.CRUD;
import dao.Conexion;
import java.util.ArrayList;
import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AdminPenalizacionPrestamosBD extends Conexion implements CRUD {

    @Override
    public Object insertar(Object obj) {
        Connection conex = abrirConexion();
        penalizacionprestamos objPenali = (penalizacionprestamos) obj;
        try {
            String sql = "INSERT INTO penalizacion_prestamos(dias_retraso, valor_penali, fecha_generacion, pagada, PRESTAMOS_ACTIVO_PERSONA_id) VALUES(?,?,?,?,?)";
            PreparedStatement preparedStatement = conex.prepareStatement(sql, new String[]{"id"});
            preparedStatement.setInt(1, objPenali.getDias_retraso());
            preparedStatement.setDouble(2, objPenali.getValor_penali());
            preparedStatement.setString(3, objPenali.getFecha_generacion());
            preparedStatement.setInt(4, objPenali.getPagada());
            preparedStatement.setInt(5, objPenali.getPRESTAMOS_ACTIVO_PERSONA_id());
            preparedStatement.execute();

            ResultSet rs = preparedStatement.getGeneratedKeys();
            while (rs.next()) {
                objPenali.setId(rs.getInt(1));
            }
            preparedStatement.close();
            System.out.println("La inserción de la Penalización fue exitosa.");
        } catch (Exception e) {
            System.out.println("Error al insertar la Penalización: " + e.getMessage());
        }
        cerrarConexion();
        return objPenali;
    }

    @Override
    public boolean actualizar(Object obj) {
        penalizacionprestamos objPenali = (penalizacionprestamos) obj;
        boolean flag = false;
        Connection conex = abrirConexion();
        try {
            String sql = "UPDATE penalizacion_prestamos SET dias_retraso=?, valor_penali=?, fecha_generacion=?, pagada=?, PRESTAMOS_ACTIVO_PERSONA_id=? WHERE id=?";
            PreparedStatement preparedStatement = conex.prepareStatement(sql);
            preparedStatement.setInt(1, objPenali.getDias_retraso());
            preparedStatement.setDouble(2, objPenali.getValor_penali());
            preparedStatement.setString(3, objPenali.getFecha_generacion());
            preparedStatement.setInt(4, objPenali.getPagada());
            preparedStatement.setInt(5, objPenali.getPRESTAMOS_ACTIVO_PERSONA_id());
            preparedStatement.setInt(6, objPenali.getId());
            int totalFilasafectadas = preparedStatement.executeUpdate();
            if (totalFilasafectadas > 0) {
                flag = true;
            }
            preparedStatement.close();
        } catch (Exception e) {
            System.out.println("Error en la actualización de la Penalización: " + e.getMessage());
        }
        cerrarConexion();
        return flag;
    }

    @Override
    public boolean eliminar(Object obj) {
        penalizacionprestamos objPenali = (penalizacionprestamos) obj;
        boolean flag = false;
        Connection conex = abrirConexion();
        try {
            String sql = "DELETE FROM penalizacion_prestamos WHERE id=?";
            PreparedStatement preparedStatement = conex.prepareStatement(sql);
            preparedStatement.setInt(1, objPenali.getId());
            int totalFilasafectadas = preparedStatement.executeUpdate();
            if (totalFilasafectadas > 0) {
                flag = true;
            }
            preparedStatement.close();
        } catch (Exception e) {
            System.out.println("Error al eliminar la Penalización: " + e.getMessage());
        }
        cerrarConexion();
        return flag;
    }

    @Override
    public List<Object> listarTodo() {
        List<Object> rowsQuery = new ArrayList<Object>();
        Connection conex = abrirConexion();
        penalizacionprestamos objPenali;
        try {
            String sql = "SELECT * FROM penalizacion_prestamos ORDER BY id ASC";
            PreparedStatement preparedStatement = conex.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                objPenali = new penalizacionprestamos();
                objPenali.setId(resultSet.getInt("id"));
                objPenali.setDias_retraso(resultSet.getInt("dias_retraso"));
                objPenali.setValor_penali(resultSet.getDouble("valor_penali"));
                objPenali.setFecha_generacion(resultSet.getString("fecha_generacion"));
                objPenali.setPagada(resultSet.getInt("pagada"));
                objPenali.setPRESTAMOS_ACTIVO_PERSONA_id(resultSet.getInt("PRESTAMOS_ACTIVO_PERSONA_id"));
                rowsQuery.add(objPenali);
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
        penalizacionprestamos objPenali = (penalizacionprestamos) obj;
        Connection conex = abrirConexion();
        try {
            String sql = "SELECT * FROM penalizacion_prestamos WHERE id=?";
            PreparedStatement preparedStatement = conex.prepareStatement(sql);
            preparedStatement.setInt(1, objPenali.getId());
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                objPenali.setDias_retraso(resultSet.getInt("dias_retraso"));
                objPenali.setValor_penali(resultSet.getDouble("valor_penali"));
                objPenali.setFecha_generacion(resultSet.getString("fecha_generacion"));
                objPenali.setPagada(resultSet.getInt("pagada"));
                objPenali.setPRESTAMOS_ACTIVO_PERSONA_id(resultSet.getInt("PRESTAMOS_ACTIVO_PERSONA_id"));
            }
            preparedStatement.close();
        } catch (SQLException ex) {
            System.out.println("Error en la adquisición de datos: " + ex.getMessage());
        }
        cerrarConexion();
        return objPenali;
    }
}