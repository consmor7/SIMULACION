package BANCO_CLASES;

import BANCO_CLASES.GeneradorNumerosAleatorios;

public class uniforme {
    private double a;
    private double b;
    private GeneradorNumerosAleatorios random;

    public uniforme(double a, double b, GeneradorNumerosAleatorios random) {
        this.a = a;
        this.b = b;
        this.random = random;
    }

    public double nextDouble() {
        return a + (b - a) * random.nextDouble();
    }
}

