package modelo;

import dao.CRUD;
import dao.Conexion;
import java.util.ArrayList;
import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AdminReservasActivosClientesBD extends Conexion implements CRUD {

    @Override
    public Object insertar(Object obj) {
        Connection conex = abrirConexion();
        reservasactivosclientes objReserva = (reservasactivosclientes) obj;
        try {
            String sql = "INSERT INTO reservas_activos_clientes(fecha_reserva, estado, ACTIVOS_id, PERSONAS_id) VALUES(?,?,?,?)";
            PreparedStatement preparedStatement = conex.prepareStatement(sql, new String[]{"id"});
            preparedStatement.setString(1, objReserva.getFecha_reserva());
            preparedStatement.setString(2, objReserva.getEstado());
            preparedStatement.setInt(3, objReserva.getACTIVOS_id());
            preparedStatement.setInt(4, objReserva.getPERSONAS_id());
            preparedStatement.execute();

            ResultSet rs = preparedStatement.getGeneratedKeys();
            while (rs.next()) {
                objReserva.setId(rs.getInt(1));
            }
            preparedStatement.close();
            System.out.println("La inserción de la Reserva fue exitosa.");
        } catch (Exception e) {
            System.out.println("Error al insertar la Reserva: " + e.getMessage());
        }
        cerrarConexion();
        return objReserva;
    }

    @Override
    public boolean actualizar(Object obj) {
        reservasactivosclientes objReserva = (reservasactivosclientes) obj;
        boolean flag = false;
        Connection conex = abrirConexion();
        try {
            String sql = "UPDATE reservas_activos_clientes SET fecha_reserva=?, estado=?, ACTIVOS_id=?, PERSONAS_id=? WHERE id=?";
            PreparedStatement preparedStatement = conex.prepareStatement(sql);
            preparedStatement.setString(1, objReserva.getFecha_reserva());
            preparedStatement.setString(2, objReserva.getEstado());
            preparedStatement.setInt(3, objReserva.getACTIVOS_id());
            preparedStatement.setInt(4, objReserva.getPERSONAS_id());
            preparedStatement.setInt(5, objReserva.getId());
            int totalFilasafectadas = preparedStatement.executeUpdate();
            if (totalFilasafectadas > 0) {
                flag = true;
            }
            preparedStatement.close();
        } catch (Exception e) {
            System.out.println("Error en la actualización de la Reserva: " + e.getMessage());
        }
        cerrarConexion();
        return flag;
    }

    @Override
    public boolean eliminar(Object obj) {
        reservasactivosclientes objReserva = (reservasactivosclientes) obj;
        boolean flag = false;
        Connection conex = abrirConexion();
        try {
            String sql = "DELETE FROM reservas_activos_clientes WHERE id=?";
            PreparedStatement preparedStatement = conex.prepareStatement(sql);
            preparedStatement.setInt(1, objReserva.getId());
            int totalFilasafectadas = preparedStatement.executeUpdate();
            if (totalFilasafectadas > 0) {
                flag = true;
            }
            preparedStatement.close();
        } catch (Exception e) {
            System.out.println("Error al eliminar la Reserva: " + e.getMessage());
        }
        cerrarConexion();
        return flag;
    }

    @Override
    public List<Object> listarTodo() {
        List<Object> rowsQuery = new ArrayList<Object>();
        Connection conex = abrirConexion();
        reservasactivosclientes objReserva;
        try {
            String sql = "SELECT * FROM reservas_activos_clientes ORDER BY id ASC";
            PreparedStatement preparedStatement = conex.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                objReserva = new reservasactivosclientes();
                objReserva.setId(resultSet.getInt("id"));
                objReserva.setFecha_reserva(resultSet.getString("fecha_reserva"));
                objReserva.setEstado(resultSet.getString("estado"));
                objReserva.setACTIVOS_id(resultSet.getInt("ACTIVOS_id"));
                objReserva.setPERSONAS_id(resultSet.getInt("PERSONAS_id"));
                rowsQuery.add(objReserva);
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
        reservasactivosclientes objReserva = (reservasactivosclientes) obj;
        Connection conex = abrirConexion();
        try {
            String sql = "SELECT * FROM reservas_activos_clientes WHERE id=?";
            PreparedStatement preparedStatement = conex.prepareStatement(sql);
            preparedStatement.setInt(1, objReserva.getId());
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                objReserva.setFecha_reserva(resultSet.getString("fecha_reserva"));
                objReserva.setEstado(resultSet.getString("estado"));
                objReserva.setACTIVOS_id(resultSet.getInt("ACTIVOS_id"));
                objReserva.setPERSONAS_id(resultSet.getInt("PERSONAS_id"));
            }
            preparedStatement.close();
        } catch (SQLException ex) {
            System.out.println("Error en la adquisición de datos: " + ex.getMessage());
        }
        cerrarConexion();
        return objReserva;
    }
}