package Models;

public class Emtradas {
    private double total;
    private double costo;
    private double gasto;

    public Emtradas(double total, double costo, double gasto) {
        this.total = total;
        this.costo = costo;
        this.gasto = gasto;
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
        return gasto;
    }

    public void setGanancia(double ganancia) {
        this.gasto = ganancia;
    }
}
