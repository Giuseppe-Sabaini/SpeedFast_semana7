package dao;

/**
 * Clase Data Access Object (DAO) para la entidad Pedido.
 * Gestiona las operaciones de lectura e inserción sobre la tabla pedido en la base de datos MySQL.
 *
 * @author Giuseppe Sabaini
 * @version 1.0
 */

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import controller.ConexionBD;
import model.Pedido;

public class PedidoDAO {


    public boolean guardar(Pedido pedido) {

        // Esto prepara la tabla los signos (?,?,?) son espacios vacios que se rellenan despues con valores.
        String sql = "INSERT INTO pedido (direccion, tipo, estado) VALUES (?,?,?)";

        // Abre la conexión a la base de datos y le pasa la plantilla sql
        try (Connection con = ConexionBD.conectar();
        PreparedStatement statement = con.prepareStatement(sql)) {

            // Esto Rellena los espacios en blanco antes puestos que eran (?,?,?) por los datos (direccion/tipo/estado).
            statement.setString(1, pedido.getDireccion());
            statement.setString(2, pedido.getTipo());
            statement.setString(3, pedido.getEstado());

            // Ejecuta la orden en MySQL para guardar los datos guardados en la plantilla
            int filasAfectadas = statement.executeUpdate();

            // Confirmar el éxito de la operación si el numero que regresa es mayor a 0 significa que se guardo la info.
            return filasAfectadas > 0;

         // Catch por si algo falla, que lo notifique en consola
        } catch (SQLException e) {
            System.err.println("Error al guardar el pedido: " + e.getMessage());
            return false;
        }

    }

    public List<Pedido> listarTodos() {
        List<Pedido> lista = new ArrayList<>();
        String sql = "SELECT id, direccion, tipo, estado FROM pedido";

        try (Connection con = ConexionBD.conectar();
             PreparedStatement statement = con.prepareStatement(sql);
             ResultSet rs = statement.executeQuery()) {

            while (rs.next()) {
                int id = rs.getInt("id");
                String direccion = rs.getString("direccion");
                String tipo = rs.getString("tipo");
                String estado = rs.getString("estado");

                Pedido pedido = new Pedido(id, direccion, tipo, estado);
                lista.add(pedido);
            }

        } catch (SQLException e) {
            System.err.println("Error al listar pedidos: " + e.getMessage());
        }

        return lista;
    }

}
