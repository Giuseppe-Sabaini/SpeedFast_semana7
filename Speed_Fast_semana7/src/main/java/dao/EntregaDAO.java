package dao;

/**
 * Clase Data Access Object (DAO) para la entidad Entrega
 * Realiza la persistencia de las asignaciones de entregas en la tabla entrega.
 *
 * @author Giuseppe Sabaini
 * @version 1.0
 */

import controller.ConexionBD;
import model.Entrega;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class EntregaDAO {

    public boolean guardar(Entrega entrega) {
        // Usa los nombres exactos de tu tabla MySQL: id_pedido e id_repartidor
        String sql = "INSERT INTO entrega (id_pedido, id_repartidor, fecha, hora) VALUES (?, ?, ?, ?)";

        try (Connection con = ConexionBD.conectar();
             PreparedStatement statement = con.prepareStatement(sql)) {

            statement.setInt(1, entrega.getPedidoId());
            statement.setInt(2, entrega.getRepartidorId());

            // Conversión de java.time a java.sql para la BD
            statement.setDate(3, java.sql.Date.valueOf(entrega.getFecha()));
            statement.setTime(4, java.sql.Time.valueOf(entrega.getHora()));

            int filasAfectadas = statement.executeUpdate();
            return filasAfectadas > 0;

        } catch (SQLException e) {
            System.err.println("Error al guardar la entrega: " + e.getMessage());
            e.printStackTrace(); // Imprime el error exacto en la consola por si acaso
            return false;
        }
    }
}