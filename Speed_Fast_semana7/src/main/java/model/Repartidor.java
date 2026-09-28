package model;

/**
 * Representa la entidad Repartidor en el sistema SpeedFast.
 * Esta clase mapea la tabla repartidor de la base de datos MySQL.
 *
 * @author Giuseppe Sabaini
 * @version 1.0
 */

public class Repartidor {
    private int id;
    private String nombre;

    public Repartidor() {
    }

    public Repartidor(String nombre) {
        this.nombre = nombre;
    }

    public Repartidor(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "ID #" + id + " - " + nombre;
    }
}
