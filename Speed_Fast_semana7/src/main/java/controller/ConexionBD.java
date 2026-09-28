package controller;
/**
 * Clase encargada de gestionar la conexión con la base de datos MySQL.
 * Proporciona el punto de acceso centralizado para interactuar con la base de datos 'speedfast'.
 *
 * @author Giuseppe Sabaini
 * @version 1.0
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class ConexionBD {

    private static final String URL = "jdbc:mysql://localhost:3306/speedfast";
    private static final String USER = "root";
    private static final String PASSWORD = "Jerrie1000._*";

    public static Connection conectar() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

}