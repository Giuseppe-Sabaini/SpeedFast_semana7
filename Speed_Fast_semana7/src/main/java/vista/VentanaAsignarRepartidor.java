package vista;

/**
 * Interfaz gráfica Swing para asignar un repartidor a un pedido en el sistema SpeedFast.
 * Permite seleccionar el pedido y repartidor mediante listas desplegables JComboBox
 * y guarda el registro de la entrega en la base de datos MySQL.
 *
 * @author Giuseppe Sabaini
 * @version 1.0
 */

import javax.swing.*;

import dao.EntregaDAO;
import dao.PedidoDAO;
import dao.RepartidorDAO;
import model.Entrega;
import model.Pedido;
import model.Repartidor;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class VentanaAsignarRepartidor extends JFrame {
    private JComboBox<Pedido> cbPedido;
    private JComboBox<Repartidor> cbRepartidor;
    private JTextField txtFecha;
    private JTextField txtHora;
    private JButton guardarButton;
    private JPanel mainPanel;

    public VentanaAsignarRepartidor() {
        setContentPane(mainPanel);
        setTitle("Asignar Repartidor a Pedido");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        pack();
        setLocationRelativeTo(null);


        txtFecha.setText(LocalDate.now().toString());
        txtHora.setText(LocalTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss")));

        cargarCombos();

        guardarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                guardarEntrega();
            }
        });
    }

    private void cargarCombos() {
        // Carga los pedidos desde la base de datos
        PedidoDAO pedidoDAO = new PedidoDAO();
        List<Pedido> pedidos = pedidoDAO.listarTodos();
        cbPedido.removeAllItems();
        for (Pedido p : pedidos) {
            cbPedido.addItem(p);
        }

        // Carga los repartidores desde la base de datos
        RepartidorDAO repartidorDAO = new RepartidorDAO();
        List<Repartidor> repartidores = repartidorDAO.listarTodos();
        cbRepartidor.removeAllItems();
        for (Repartidor r : repartidores) {
            cbRepartidor.addItem(r);
        }
    }

    private void guardarEntrega() {
        Pedido pedidoSeleccionado = (Pedido) cbPedido.getSelectedItem();
        Repartidor repartidorSeleccionado = (Repartidor) cbRepartidor.getSelectedItem();

        if (pedidoSeleccionado == null || repartidorSeleccionado == null) {
            JOptionPane.showMessageDialog(this, "Debe seleccionar un pedido y un repartidor.", "Atención", JOptionPane.WARNING_MESSAGE);
            return;
        }

        // Crear objeto Entrega con las ID seleccionadas fecha y hora
        Entrega entrega = new Entrega(
                pedidoSeleccionado.getId(),
                repartidorSeleccionado.getId(),
                LocalDate.now(),
                LocalTime.now()
        );

        EntregaDAO entregaDAO = new EntregaDAO();
        if (entregaDAO.guardar(entrega)) {
            JOptionPane.showMessageDialog(this, "Entrega registrada y asignada exitosamente");
            this.dispose();
        } else {
            JOptionPane.showMessageDialog(this, "Error al registrar la entrega en la base de datos.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
