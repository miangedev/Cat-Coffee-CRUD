package modelo;

import dao.CRUD;
import dao.Conexion;
import java.util.ArrayList;
import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AdminPrestamosActivoPersonasBD extends Conexion implements CRUD {

    @Override
    public Object insertar(Object obj) {
        Connection conex = abrirConexion();
        prestamosactivopersonas objPrestamo = (prestamosactivopersonas) obj;
        try {
            String sql = "INSERT INTO prestamos_activo_persona(fecha_inicio, fecha_fin_programa, fecha_entrega_real, estado, PERSONAS_id, ACTIVOS_id) VALUES(?,?,?,?,?,?)";
            PreparedStatement preparedStatement = conex.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, objPrestamo.getFecha_inicio());
            preparedStatement.setString(2, objPrestamo.getFecha_fin_programa());
            if (objPrestamo.getFecha_entrega_real() == null || objPrestamo.getFecha_entrega_real().isEmpty()) {
                preparedStatement.setNull(3, java.sql.Types.DATE);
            } else {
                preparedStatement.setString(3, objPrestamo.getFecha_entrega_real());
            }
            preparedStatement.setString(4, objPrestamo.getEstado());
            preparedStatement.setInt(5, objPrestamo.getPERSONAS_id());
            preparedStatement.setInt(6, objPrestamo.getACTIVOS_id());
            preparedStatement.execute();

            ResultSet rs = preparedStatement.getGeneratedKeys();
            while (rs.next()) {
                objPrestamo.setId(rs.getInt(1));
            }
            preparedStatement.close();
            System.out.println("La inserción del Prestamo fue exitosa.");
        } catch (Exception e) {
            System.out.println("Error al insertar el Prestamo: " + e.getMessage());
        }
        cerrarConexion();
        return objPrestamo;
    }

    @Override
    public boolean actualizar(Object obj) {
        prestamosactivopersonas objPrestamo = (prestamosactivopersonas) obj;
        boolean flag = false;
        Connection conex = abrirConexion();
        try {
            String sql = "UPDATE prestamos_activo_persona SET fecha_inicio=?, fecha_fin_programa=?, fecha_entrega_real=?, estado=?, PERSONAS_id=?, ACTIVOS_id=? WHERE id=?";
            PreparedStatement preparedStatement = conex.prepareStatement(sql);
            preparedStatement.setString(1, objPrestamo.getFecha_inicio());
            preparedStatement.setString(2, objPrestamo.getFecha_fin_programa());
            if (objPrestamo.getFecha_entrega_real() == null || objPrestamo.getFecha_entrega_real().isEmpty()) {
                preparedStatement.setNull(3, java.sql.Types.DATE);
            } else {
                preparedStatement.setString(3, objPrestamo.getFecha_entrega_real());
            }
            preparedStatement.setString(4, objPrestamo.getEstado());
            preparedStatement.setInt(5, objPrestamo.getPERSONAS_id());
            preparedStatement.setInt(6, objPrestamo.getACTIVOS_id());
            preparedStatement.setInt(7, objPrestamo.getId());
            int totalFilasafectadas = preparedStatement.executeUpdate();
            if (totalFilasafectadas > 0) {
                flag = true;
            }
            preparedStatement.close();
        } catch (Exception e) {
            System.out.println("Error en la actualización del Prestamo: " + e.getMessage());
        }
        cerrarConexion();
        return flag;
    }

    @Override
    public boolean eliminar(Object obj) {
        prestamosactivopersonas objPrestamo = (prestamosactivopersonas) obj;
        boolean flag = false;
        Connection conex = abrirConexion();
        try {
            String sql = "DELETE FROM prestamos_activo_persona WHERE id=?";
            PreparedStatement preparedStatement = conex.prepareStatement(sql);
            preparedStatement.setInt(1, objPrestamo.getId());
            int totalFilasafectadas = preparedStatement.executeUpdate();
            if (totalFilasafectadas > 0) {
                flag = true;
            }
            preparedStatement.close();
        } catch (Exception e) {
            System.out.println("Error al eliminar el Prestamo: " + e.getMessage());
        }
        cerrarConexion();
        return flag;
    }

    @Override
    public List<Object> listarTodo() {
        List<Object> rowsQuery = new ArrayList<Object>();
        Connection conex = abrirConexion();
        prestamosactivopersonas objPrestamo;
        try {
            String sql = "SELECT * FROM prestamos_activo_persona ORDER BY id ASC";
            PreparedStatement preparedStatement = conex.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                objPrestamo = new prestamosactivopersonas();
                objPrestamo.setId(resultSet.getInt("id"));
                objPrestamo.setFecha_inicio(resultSet.getString("fecha_inicio"));
                objPrestamo.setFecha_fin_programa(resultSet.getString("fecha_fin_programa"));
                objPrestamo.setFecha_entrega_real(resultSet.getString("fecha_entrega_real"));
                objPrestamo.setEstado(resultSet.getString("estado"));
                objPrestamo.setPERSONAS_id(resultSet.getInt("PERSONAS_id"));
                objPrestamo.setACTIVOS_id(resultSet.getInt("ACTIVOS_id"));
                rowsQuery.add(objPrestamo);
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
        prestamosactivopersonas objPrestamo = (prestamosactivopersonas) obj;
        Connection conex = abrirConexion();
        try {
            String sql = "SELECT * FROM prestamos_activo_persona WHERE id=?";
            PreparedStatement preparedStatement = conex.prepareStatement(sql);
            preparedStatement.setInt(1, objPrestamo.getId());
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                objPrestamo.setFecha_inicio(resultSet.getString("fecha_inicio"));
                objPrestamo.setFecha_fin_programa(resultSet.getString("fecha_fin_programa"));
                objPrestamo.setFecha_entrega_real(resultSet.getString("fecha_entrega_real"));
                objPrestamo.setEstado(resultSet.getString("estado"));
                objPrestamo.setPERSONAS_id(resultSet.getInt("PERSONAS_id"));
                objPrestamo.setACTIVOS_id(resultSet.getInt("ACTIVOS_id"));
            }
            preparedStatement.close();
        } catch (SQLException ex) {
            System.out.println("Error en la adquisición de datos: " + ex.getMessage());
        }
        cerrarConexion();
        return objPrestamo;
    }
}