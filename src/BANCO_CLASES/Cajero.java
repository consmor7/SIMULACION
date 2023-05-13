package BANCO_CLASES;

import java.util.Random;

//Pendiente: Usar los num aleatorios del metodo GeneradorNumAleatoros

public class Cajero {
    private boolean ocupado;
    private double tiempoFinServicio;

    public Cajero() {
        ocupado = false;
    }

    public boolean isOcupado() {
        return ocupado;
    }

    public void ocupar(double tiempoActual) {
        ocupado = true;
        Random random = new Random();
        double tiempoServicio = random.nextDouble();
        tiempoFinServicio = tiempoActual + tiempoServicio;
    }

    public void desocupar() {
        ocupado = false;
    }

    public double getTiempoFinServicio() {
        return tiempoFinServicio;
    }
}
