package Models;

import java.time.LocalDate;
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

    public boolean eliminarProducto(String nombre) {
        Producto producto = buscarProducto(nombre);
        if (producto != null) {
            double costoTotal = producto.getPrecio() * producto.getCantidad();
            actualizarPresupuesto(costoTotal);
            return productos.remove(producto);
        }
        return false;
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

    public boolean registrarEntrada(String nombre, int cantidad, double precioUnitario) {
        Producto producto = buscarProducto(nombre);
        double costoEntrada = cantidad * precioUnitario;

        if (costoEntrada > presupuesto) {
            return false; // Presupuesto insuficiente
        }

        if (producto != null) {
            producto.setCantidad(producto.getCantidad() + cantidad);
        } else {
            producto = new Producto(nombre, precioUnitario, cantidad, 0, "N/A");
            agregarProducto(producto);
        }
        actualizarPresupuesto(-costoEntrada);
        return true;
    }

    public boolean registrarSalida(String nombre, int cantidad, String tipoSalida) {
        Producto producto = buscarProducto(nombre);
        if (producto != null && producto.getCantidad() >= cantidad) {
            producto.setCantidad(producto.getCantidad() - cantidad);
            double montoSalida = cantidad * producto.getPrecioventa();
            if ("venta".equalsIgnoreCase(tipoSalida)) {
                actualizarPresupuesto(montoSalida);
            }
            return true;
        }
        return false;
    }

    public boolean editarProducto(String nombre, double nuevoPrecioUnitario, int nuevaCantidad, double nuevoPrecioVenta, String nuevaFecha) {
        Producto producto = buscarProducto(nombre);
        if (producto != null) {
            double costoAnterior = producto.getPrecio() * producto.getCantidad();
            double costoNuevo = nuevoPrecioUnitario * nuevaCantidad;
            double diferencia = costoNuevo - costoAnterior;

            if (diferencia <= presupuesto) {
                producto.setPrecio(nuevoPrecioUnitario);
                producto.setCantidad(nuevaCantidad);
                producto.setPrecioventa((int) nuevoPrecioVenta);
                producto.setFecha(nuevaFecha);
                actualizarPresupuesto(-diferencia);
                return true;
            }
        }
        return false;
    }

    public double calcularCostoTotal(String nombre) {
        Producto producto = buscarProducto(nombre);
        if (producto != null) {
            return producto.getPrecio() * producto.getCantidad();
        }
        return 0.0;
    }

    public boolean validarPresupuesto(double costo) {
        return presupuesto >= costo;
    }

    public void mostrarInventario() {
        System.out.println("Inventario:");
        for (Producto producto : productos) {
            System.out.println("Nombre: " + producto.getNombre() + ", Precio Unitario: " + producto.getPrecio() +
                    ", Cantidad: " + producto.getCantidad() + ", Precio de Venta: " + producto.getPrecioventa() +
                    ", Fecha: " + producto.getFecha());
        }
    }

    public void mostrarPresupuesto() {
        System.out.println("Presupuesto disponible: " + presupuesto);
    }

    public void asignarproductoaproveedor(String nombre, String proveedor) {
        Producto producto = buscarProducto(nombre);
        if (producto != null) {
            System.out.println("El producto " + nombre + " ha sido asignado al proveedor " + proveedor);
        } else {
            System.out.println("El producto " + nombre + " no se encuentra en el inventario.");
        }
    }

    public void crearusuario(String nombreUsuario, String contrasena) {
        Usuario.crearUsuario(nombreUsuario, contrasena);
        System.out.println("Usuario " + nombreUsuario + " creado exitosamente.");
    }

    public void ingresar(String nombreUsuario, String contrasena) {
        if (Usuario.ingresar(nombreUsuario, contrasena)) {
            System.out.println("Ingreso exitoso como " + nombreUsuario);
        } else {
            System.out.println("Nombre de usuario o contraseña incorrectos.");
        }
    }

    public void fechareabastecimiento(String nombre, String fecha) {
        Producto producto = buscarProducto(nombre);
        if (producto != null) {
            Reabastecimiento reabastecimiento = new Reabastecimiento(LocalDate.parse(fecha), producto.getPrecio());
            System.out.println("Reabastecimiento registrado para el producto " + nombre + " en la fecha " + fecha);
        } else {
            System.out.println("El producto " + nombre + " no se encuentra en el inventario.");
        }
    }


    public void gananciasalida(String nombre, int cantidad, String tipoSalida) {
        Producto producto = buscarProducto(nombre);
        if (producto != null) {
            if (producto.getCantidad() >= cantidad) {
                double ganancia = cantidad * producto.getPrecioventa();
                System.out.println("Ganancia de la salida del producto " + nombre + ": " + ganancia);
            } else {
                System.out.println("No hay suficiente cantidad del producto " + nombre + " para calcular la ganancia.");
            }
        } else {
            System.out.println("El producto " + nombre + " no se encuentra en el inventario.");
        }
    }

    public void perdidaentrada(String nombre, int cantidad, double precioUnitario) {
        Producto producto = buscarProducto(nombre);
        if (producto != null) {
            double ganancia = cantidad * precioUnitario;
            System.out.println("Ganancia de la entrada del producto " + nombre + ": " + ganancia);
        } else {
            System.out.println("El producto " + nombre + " no se encuentra en el inventario.");
        }
    }
}