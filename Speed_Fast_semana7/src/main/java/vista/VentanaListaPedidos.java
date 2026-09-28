package vista;

/**
 * Interfaz gráfica Swing para consultar y listar todos los pedidos registrados en el sistema SpeedFast.
 * Muestra la información obtenida desde la base de datos MySQL dentro de una tabla JTable
 * y permite refrescar los datos en tiempo real mediante un botón.
 *
 * @author Giuseppe Sabaini
 * @version 1.0
 */

import javax.swing.*;
import dao.PedidoDAO;
import model.Pedido;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class VentanaListaPedidos extends JFrame {
    private JPanel mainPanel;
    private JTable tablaPedidos;
    private JButton btnRefrescar;

    private DefaultTableModel modeloTabla;

    public VentanaListaPedidos(){
        setContentPane(mainPanel);
        setTitle("Consulta - Lista de Pedidos");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        pack();
        setLocationRelativeTo(null);

        configurarTabla();

        cargarPedidos();

        btnRefrescar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cargarPedidos();
            }
        });
    }

    private void configurarTabla(){
        modeloTabla = new DefaultTableModel();
        modeloTabla.addColumn("ID");
        modeloTabla.addColumn("Dirección");
        modeloTabla.addColumn("Tipo");
        modeloTabla.addColumn("Estado");

        tablaPedidos.setModel(modeloTabla);
    }

    private void cargarPedidos() {
        // Limpia filas previas para evitar duplicados al refrescar
        modeloTabla.setRowCount(0);

        PedidoDAO pedidoDAO = new PedidoDAO();
        List<Pedido> lista = pedidoDAO.listarTodos();

        // Recorre la lista de MySQL y agrega cada fila
        for (Pedido p : lista) {
            Object[] fila = new Object[]{
                    p.getId(),
                    p.getDireccion(),
                    p.getTipo(),
                    p.getEstado()
            };
            modeloTabla.addRow(fila);
        }
    }
}
