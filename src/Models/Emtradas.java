package Models;

public class Emtradas {
    private double total;
    private double costo;
    private double ganancia;

    public Emtradas(double total, double costo, double ganancia) {
        this.total = total;
        this.costo = costo;
        this.ganancia = ganancia;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public double getCosto() {
        return costo;
    }

    public void setCosto(double costo) {
        this.costo = costo;
    }

    public double getGanancia() {
        return ganancia;
    }

    public void setGanancia(double ganancia) {
        this.ganancia = ganancia;
    }
}
