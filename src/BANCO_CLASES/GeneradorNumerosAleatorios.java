package BANCO_CLASES;

public class GeneradorNumerosAleatorios {
    private long a;
    private long m;
    private long seed;

    public GeneradorNumerosAleatorios(long a, long m, long seed) {
        this.a = a;
        this.m = m;
        this.seed = seed;
    }

    //To change body of generated methods, choose Tools | Templates.
    public GeneradorNumerosAleatorios() {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

    public double nextDouble() {
        seed = (a * seed) % m;
        return (double) seed / m;
    }
}

