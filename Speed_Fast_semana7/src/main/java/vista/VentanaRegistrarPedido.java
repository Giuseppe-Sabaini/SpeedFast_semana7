package vista;

/**
 * Interfaz gráfica Swing para el registro de nuevos pedidos en el sistema SpeedFast.
 * Captura la dirección, tipo y estado del pedido para almacenarlos en la base de datos MySQL.
 *
 * @author Giuseppe Sabaini
 * @version 1.0
 */

import dao.PedidoDAO;
import model.Pedido;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VentanaRegistrarPedido  extends  JFrame {
    private JComboBox cbTipo;
    private JTextField txtDireccion;
    private JComboBox cbEstado;
    private JButton btnGuardar;
    private JPanel mainPanel;

    public VentanaRegistrarPedido (){
        setContentPane(mainPanel);
        setTitle("Registrar Nuevo Pedido");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        pack();
        setLocationRelativeTo(null);

        cbTipo.setModel(new DefaultComboBoxModel<>(new String[]{"COMIDA", "ENCOMIENDA", "EXPRESS"}));
        cbEstado.setModel(new DefaultComboBoxModel<>(new String[]{"PENDIENTE", "EN_REPARTO", "ENTREGADO"}));

        btnGuardar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                guardarPedido();
            }
        });
    }

    private void guardarPedido(){
        String direccion = txtDireccion.getText().trim();
        String tipo = cbTipo.getSelectedItem().toString();
        String estado = cbEstado.getSelectedItem().toString();

        // Esto Valida que la direccion No este vacia.
        if (direccion.isEmpty()){
            JOptionPane.showMessageDialog(this, "Porfavor Ingrese una direccion", "Campo Requerido", JOptionPane.WARNING_MESSAGE);
            return;
        }
        // Crea el Objeto Pedido y lo envia a el DAO
        Pedido pedido = new Pedido(direccion, tipo, estado);
        PedidoDAO pedidoDAO = new PedidoDAO();

        if (pedidoDAO.guardar(pedido)){
            JOptionPane.showMessageDialog(this, "Pedido Registrado Con Exito En La Base De Datos!");
            txtDireccion.setText("");
        } else {
            JOptionPane.showMessageDialog(this, "Error Al Guardar Pedido", "Error", JOptionPane.WARNING_MESSAGE);
        }
    }
}
