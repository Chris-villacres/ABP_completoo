package Models;

public class Restricciones {
    private double presupuesto;
    private int espacioAlmacenamiento;
    private int tiempoEntregaDias;

    public Restricciones(double presupuesto, int espacioAlmacenamiento, int tiempoEntregaDias) {
        this.presupuesto = presupuesto;
        this.espacioAlmacenamiento = espacioAlmacenamiento;
        this.tiempoEntregaDias = tiempoEntregaDias;
    }

    public double getPresupuesto() {
        return presupuesto;
    }

    public void setPresupuesto(double presupuesto) {
        this.presupuesto = presupuesto;
    }

    public int getEspacioAlmacenamiento() {
        return espacioAlmacenamiento;
    }

    public void setEspacioAlmacenamiento(int espacioAlmacenamiento) {
        this.espacioAlmacenamiento = espacioAlmacenamiento;
    }

    public int getTiempoEntregaDias() {
        return tiempoEntregaDias;
    }

    public void setTiempoEntregaDias(int tiempoEntregaDias) {
        this.tiempoEntregaDias = tiempoEntregaDias;
    }
}