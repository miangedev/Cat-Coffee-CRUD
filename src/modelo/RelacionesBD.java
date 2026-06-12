package modelo;

import dao.Conexion;
import static dao.Conexion.abrirConexion;
import static dao.Conexion.cerrarConexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RelacionesBD extends Conexion {

    public List<reporteactivoscategorias> reporteactivosporcategoria() {
        List<reporteactivoscategorias> rowsQuery = new ArrayList<reporteactivoscategorias>();
        Connection conex = abrirConexion();
        reporteactivoscategorias objRAC;
        try {
            String sql = "SELECT a.id, a.nombre, a.tipo, a.marca, a.modelo, a.ano_adquisicion, a.valor_comercial, a.estado, c.nombre AS categoria FROM activos a JOIN categorias c ON a.CATEGORIAS_id = c.id";
            PreparedStatement preparedStatement = conex.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                objRAC = new reporteactivoscategorias();
                objRAC.setId(resultSet.getInt("id"));
                objRAC.setNombre(resultSet.getString("nombre"));
                objRAC.setTipo(resultSet.getString("tipo"));
                objRAC.setMarca(resultSet.getString("marca"));
                objRAC.setModelo(resultSet.getString("modelo"));
                objRAC.setAno_adquisicion(resultSet.getString("ano_adquisicion"));
                objRAC.setValor_comercial(resultSet.getDouble("valor_comercial"));
                objRAC.setEstado(resultSet.getString("estado"));
                objRAC.setCategoria(resultSet.getString("categoria"));
                rowsQuery.add(objRAC);
            }
            preparedStatement.close();
        } catch (SQLException ex) {
            System.out.println("Error en la adquisición de datos: " + ex.getMessage());
        }
        cerrarConexion();
        return rowsQuery;
    }

    public List<reporteactivosprestados> reporteactivosprestados() {
        List<reporteactivosprestados> rowsQuery = new ArrayList<reporteactivosprestados>();
        Connection conex = abrirConexion();
        reporteactivosprestados objRAP;
        try {
            String sql = "SELECT p.id AS prestamo_id, per.nombre AS persona, a.nombre AS activo, a.tipo, a.marca, a.modelo, p.fecha_inicio, p.fecha_fin_programa, p.estado, pen.pagada FROM prestamos_activo_persona p JOIN personas per ON p.PERSONAS_id = per.id JOIN activos a ON p.ACTIVOS_id = a.id JOIN penalizacion_prestamos pen ON pen.PRESTAMOS_ACTIVO_PERSONA_id = p.id";
            PreparedStatement preparedStatement = conex.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                objRAP = new reporteactivosprestados();
                objRAP.setPrestamo_id(resultSet.getInt("prestamo_id"));
                objRAP.setPersona(resultSet.getString("persona"));
                objRAP.setActivo(resultSet.getString("activo"));
                objRAP.setTipo(resultSet.getString("tipo"));
                objRAP.setMarca(resultSet.getString("marca"));
                objRAP.setModelo(resultSet.getString("modelo"));
                objRAP.setFecha_inicio(resultSet.getString("fecha_inicio"));
                objRAP.setFecha_fin_programa(resultSet.getString("fecha_fin_programa"));
                objRAP.setEstado(resultSet.getString("estado"));
                objRAP.setPagada(resultSet.getInt("pagada"));
                rowsQuery.add(objRAP);
            }
            preparedStatement.close();
        } catch (SQLException ex) {
            System.out.println("Error en la adquisición de datos: " + ex.getMessage());
        }
        cerrarConexion();
        return rowsQuery;
    }

    public List<reportepenalizacioncliente> reportepenalizacionporcliente(String numero_documento) {
        List<reportepenalizacioncliente> rowsQuery = new ArrayList<reportepenalizacioncliente>();
        Connection conex = abrirConexion();
        reportepenalizacioncliente objRPC;
        try {
            String sql = "SELECT per.nombre, per.numero_documento, pen.dias_retraso, pen.valor_penali, pen.fecha_generacion FROM penalizacion_prestamos pen JOIN prestamos_activo_persona p ON pen.PRESTAMOS_ACTIVO_PERSONA_id = p.id JOIN personas per ON p.PERSONAS_id = per.id WHERE per.numero_documento = ?";
            PreparedStatement preparedStatement = conex.prepareStatement(sql);
            preparedStatement.setString(1, numero_documento);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                objRPC = new reportepenalizacioncliente();
                objRPC.setNombre(resultSet.getString("nombre"));
                objRPC.setNumero_documento(resultSet.getString("numero_documento"));
                objRPC.setDias_retraso(resultSet.getInt("dias_retraso"));
                objRPC.setValor_penali(resultSet.getDouble("valor_penali"));
                objRPC.setFecha_generacion(resultSet.getString("fecha_generacion"));
                rowsQuery.add(objRPC);
            }
            preparedStatement.close();
        } catch (SQLException ex) {
            System.out.println("Error en la adquisición de datos: " + ex.getMessage());
        }
        cerrarConexion();
        return rowsQuery;
    }
}