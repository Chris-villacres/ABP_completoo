package Models;

import java.time.LocalDate;

public class Reabastecimiento {
    private LocalDate fecha;
    private double costo;

    public Reabastecimiento(LocalDate fecha, double costo) {
        this.fecha = fecha;
        this.costo = costo;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public double getCosto() {
        return costo;
    }

    public void setCosto(double costo) {
        this.costo = costo;
    }
}