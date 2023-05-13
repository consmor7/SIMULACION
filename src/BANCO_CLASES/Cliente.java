package BANCO_CLASES;

public class Cliente {
    private double tiempoLlegada;
    private double tiempoInicioServicio;
    private double tiempoFinServicio;

    public Cliente(double tiempoLlegada) {
        this.tiempoLlegada = tiempoLlegada;
    }

    public double getTiempoLlegada() {
        return tiempoLlegada;
    }

    public void setTiempoInicioServicio(double tiempoInicioServicio) {
        this.tiempoInicioServicio = tiempoInicioServicio;
    }

    public double getTiempoInicioServicio() {
        return tiempoInicioServicio;
    }

    public void setTiempoFinServicio(double tiempoFinServicio) {
        this.tiempoFinServicio = tiempoFinServicio;
    }

    public double getTiempoFinServicio() {
        return tiempoFinServicio;
    }

    public double getTiempoEnSistema() {
        return tiempoFinServicio - tiempoLlegada;
    }
}
