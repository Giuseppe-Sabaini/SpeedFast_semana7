package vista;

/**
 * Interfaz gráfica Swing para el registro de nuevos repartidores en el sistema SpeedFast.
 * Captura el nombre del repartidor para almacenarlo en la base de datos MySQL.
 *
 * @author Giuseppe Sabaini
 * @version 1.0
 */

import dao.RepartidorDAO;
import model.Repartidor;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VentanaRegistrarRepartidor extends JFrame {
    private JPanel mainPanel;
    private JTextField txtNombre;
    private JButton btnGuardar;

    public VentanaRegistrarRepartidor(){
        setContentPane(mainPanel);
        setTitle("Registrar Repartidor");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // Cierra solo esta ventana
        pack();
        setLocationRelativeTo(null);

        // Evento del boton guardar
        btnGuardar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                guardarRepartidor();
            }
        });
    }

    private void guardarRepartidor(){
        String nombre = txtNombre.getText().trim();

        // validacion de campo vacio
        if (nombre.isEmpty()){
            JOptionPane.showMessageDialog(this, "Porfavor Ingrese el nombre del Repartidor", "Campo requerido", JOptionPane.WARNING_MESSAGE);
            return;
        }

        // Esto crea el objeto y lo envia a la base de datos
        Repartidor repartidor = new Repartidor(nombre);
        RepartidorDAO repartidorDAO = new RepartidorDAO();

        if (repartidorDAO.guardar(repartidor)){
            JOptionPane.showMessageDialog(this, "Repartidor registrado con éxito!");
            txtNombre.setText("");
        } else {
            JOptionPane.showMessageDialog(this, "Error al registrar el repartidor.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
