## SpeedFast
***

# 👤 Autor del proyecto

● Nombre: Giuseppe Sabaini

● Carrera: Programador Computacional

***

# Descripción general del sistema
Este proyecto corresponde a la evaluación de la semana 7 de la asignatura Desarrollo Orientado a Objetos. El proyecto es una evolución del sistema de gestión de entregas **SpeedFast**.

Aplica el patrón DAO (Data Access Object), conexión a base de datos relacional MySQL a través de JDBC y arquitectura orientada a objetos (OOP).
Todo el flujo de la aplicación se maneja a través de una interfaz gráfica Swing interactiva desarrollada en IntelliJ IDEA, que permite registrar pedidos, 
registrar repartidores, listar los pedidos guardados en una tabla (`JTable`), asignar repartidores a los pedidos y guardar todo directamente en MySQL.

***

# 🧱 Estructura General del Proyecto

```
📁 src/
├── app/          # Archivo con la clase de arranque (Main)
├── controller/   # Conexión a la base de datos (ConexionBD)
├── dao/          # Clases DAO para persistencia SQL (PedidoDAO, RepartidorDAO, EntregaDAO)
├── model/        # Clases de dominio (Pedido, Repartidor, Entrega)
└── vista/        # Interfaz gráfica Swing (VentanaPrincipal, VentanaRegistrarPedido, VentanaRegistrarRepartidor, VentanaListaPedidos, VentanaAsignarRepartidor)
```
