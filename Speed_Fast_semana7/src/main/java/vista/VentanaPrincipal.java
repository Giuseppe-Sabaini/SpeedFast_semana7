package vista;

/**
 * Ventana principal y menú del sistema SpeedFast.
 * Sirve como panel de navegación para acceder a las distintas funcionalidades del sistema:
 * registrar pedidos, registrar repartidores, consultar la lista de pedidos y asignar entregas.
 *
 * @author Giuseppe Sabaini
 * @version 1.0
 */

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VentanaPrincipal extends JFrame  {
    private JButton btnRegistrarPedido;
    private JButton btnAsignarRepartidor;
    private JButton btnListaPedidos;
    private JButton btnRegistrarRepartidor;
    private JPanel mainPanel;


    public VentanaPrincipal(){

        setTitle("SpeedFast - Sistema de Gestion");
        setContentPane(mainPanel);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Agrega los botones para cerrar la Ventana
        setSize(500, 400); // Ajusta el tamaño de la ventana Alto/ancho
        setLocationRelativeTo(null); // Centra la ventana



        btnRegistrarPedido.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                VentanaRegistrarPedido ventana = new VentanaRegistrarPedido();
                ventana.setVisible(true);
            }
        });

        btnRegistrarRepartidor.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                VentanaRegistrarRepartidor ventana = new VentanaRegistrarRepartidor();
                ventana.setVisible(true);
            }
        });

        btnListaPedidos.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                VentanaListaPedidos ventana = new VentanaListaPedidos();
                ventana.setVisible(true);
            }
        });

        btnAsignarRepartidor.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                VentanaAsignarRepartidor ventana = new VentanaAsignarRepartidor();
                ventana.setVisible(true);
            }
        });
    }
}
