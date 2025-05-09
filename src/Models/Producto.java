package Models;

public class Producto {
    private String nombre;
    private double preciounitario;
    private int cantidad;
    private int precioventa;
    private String fecha;


    public Producto(String nombre, double preciounitario, int cantidad, int precioventa, String fecha) {
        this.nombre = nombre;
        this.preciounitario = preciounitario;
        this.cantidad = cantidad;
        this.precioventa = precioventa;
        this.fecha = fecha;
    }

    public String getNombre() {
        return nombre;
    }

    public double getPrecio() {
        return preciounitario;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setPrecio(double preciounitario) {
        this.preciounitario = this.preciounitario;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
    public int getPrecioventa() {
        return precioventa;
    }
    public void setPrecioventa(int precioventa) {
        this.precioventa = precioventa;
    }
    public String getFecha() {
        return fecha;
    }
    public void setFecha(String fecha) {
        this.fecha = fecha;
    }
}
