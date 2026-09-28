package dao;

/**
 * Clase Data Access Object (DAO) para la entidad Repartidor
 * Gestiona las operaciones CRUD sobre la tabla repartidor en la base de datos.
 *
 * @author  Giuseppe Sabaini
 * @version 1.0
 */

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import controller.ConexionBD;
import model.Repartidor;

public class RepartidorDAO {

    public List<Repartidor> listarTodos() {

        // Aca creo el ArrayList que almacenara la lista de Repartidores
        List<Repartidor> listarRepartidores = new ArrayList<>();

        // Esta parte selecciona el nombre de la tabla repartidor y el id
        String sql = "SELECT id, nombre FROM repartidor";

        try (Connection con = ConexionBD.conectar();
             PreparedStatement statement = con.prepareStatement(sql);
             ResultSet rs = statement.executeQuery()) {

            while (rs.next()){
                int id = rs.getInt("id");
                String nombre = rs.getString("nombre");


                Repartidor repartidor = new Repartidor(id, nombre);

                listarRepartidores.add(repartidor);
            }

        } catch (SQLException e) {
            System.err.println("Error al listar los repartidores: " + e.getMessage());
        }

        return listarRepartidores;
    }

    public boolean guardar(Repartidor repartidor) {
        String sql = "INSERT INTO repartidor (nombre) VALUES (?)";

        try (Connection con = ConexionBD.conectar();
             PreparedStatement statement = con.prepareStatement(sql)) {

            // Asigna el nombre al signo '?'
            statement.setString(1, repartidor.getNombre());

            // Ejecuta la inserción
            int filasAfectadas = statement.executeUpdate();

            return filasAfectadas > 0;

        } catch (SQLException e) {
            System.err.println("Error al guardar el repartidor: " + e.getMessage());
            return false;
        }
    }
}
