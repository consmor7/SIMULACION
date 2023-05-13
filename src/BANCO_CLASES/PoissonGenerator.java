
package BANCO_CLASES;
import java.lang.Math;
import BANCO_CLASES.GeneradorNumerosAleatorios;
import java.util.ArrayList;
import java.util.List;

public class PoissonGenerator {
    
    private GeneradorNumerosAleatorios generator;
    private int lamda;

    public PoissonGenerator(int lamda) {
        this.generator = new GeneradorNumerosAleatorios(165, 32768, 149);
        this.lamda = lamda;
    }

    public List<Float> nextFloat() {
        float To = 0.0f;
        float Ti = 0.0f;
        int n = 0;
        int poisson = 0;
        List<Float> tiemposEntreArribos = new ArrayList<Float>();

        while (true) {
            double randomNumber = generator.nextDouble();
            Ti = To - (1.0f / lamda) * (float) Math.log(randomNumber);
            if (Ti > 1.0f) {
                break;
            }
            To = Ti;
            poisson = n;
            n++;
            tiemposEntreArribos.add(Ti);
        }

        return tiemposEntreArribos;
    }
}
