package Models;

import java.util.ArrayList;
import java.util.List;

public class Inventario {
    private List<Producto> productos;
    private double presupuesto;

    public Inventario(double presupuestoInicial) {
        this.productos = new ArrayList<>();
        this.presupuesto = presupuestoInicial;
    }

    public void agregarProducto(Producto producto) {
        productos.add(producto);
    }

    public void eliminarProducto(String nombre) {
        productos.removeIf(p -> p.getNombre().equalsIgnoreCase(nombre));
    }

    public Producto buscarProducto(String nombre) {
        return productos.stream()
                .filter(p -> p.getNombre().equalsIgnoreCase(nombre))
                .findFirst()
                .orElse(null);
    }

    public List<Producto> getProductos() {
        return productos;
    }

    public double getPresupuesto() {
        return presupuesto;
    }

    private void actualizarPresupuesto(double monto) {
        this.presupuesto += monto;
    }

    public void registrarEntrada(String nombre, int cantidad, double precioUnitario) {
        Producto producto = buscarProducto(nombre);
        if (producto != null) {
            producto.setCantidad(producto.getCantidad() + cantidad);
        } else {
            producto = new Producto(nombre, precioUnitario, cantidad, 0, "N/A");
            agregarProducto(producto);
        }
        double costoEntrada = cantidad * precioUnitario;
        actualizarPresupuesto(-costoEntrada); // Reduce presupuesto por compra
    }

    public void registrarSalida(String nombre, int cantidad, String tipoSalida) {
        Producto producto = buscarProducto(nombre);
        if (producto != null && producto.getCantidad() >= cantidad) {
            producto.setCantidad(producto.getCantidad() - cantidad);
            double montoSalida = cantidad * producto.getPrecioventa();
            if ("venta".equalsIgnoreCase(tipoSalida)) {
                actualizarPresupuesto(montoSalida); // Aumenta presupuesto por venta
            }
            // Si es desperdicio, no se modifica el presupuesto
        } else {
            System.out.println("No hay suficiente cantidad del producto o no existe.");
        }
    }
}