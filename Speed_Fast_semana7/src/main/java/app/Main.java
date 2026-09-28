package app;

/**
 * Clase principal que actúa como punto de entrada (Main) de la aplicación SpeedFast.
 * Se encarga de inicializar y desplegar la interfaz gráfica de usuario en el hilo de ejecución adecuado.
 *
 * @author Giuseppe Sabaini
 * @version 1.0
 */

import vista.VentanaPrincipal;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

public class Main {
    public static void main(String[] args) {

        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                VentanaPrincipal ventana = new VentanaPrincipal();
                ventana.setVisible(true);
            }
        });
    }
}