package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {

    static Connection con = null;

    public static Connection abrirConexion() {
        try {
            Class.forName("org.sqlite.JDBC");
            String urldb = "jdbc:sqlite:Cat Coffee CRUD.db";
            con = DriverManager.getConnection(urldb);
            System.out.println("!!!Conexión Exitosa!!!");
        } catch (ClassNotFoundException e) {
            System.out.println("Error >> Driver no Instalado!!");
        } catch (SQLException e) {
            System.out.println("Error >> de conexión con la BD");
        }
        return con;
    }

    public static void cerrarConexion() {
                try {
            if (con != null) {
                con.close();
                System.out.println("!!! La conexion se cerró con éxito !!!");
            }
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}


