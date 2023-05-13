package BANCO_APLICACIONES;

import BANCO_CLASES.GeneradorNumerosAleatorios;
import BANCO_CLASES.PoissonGenerator;
import java.util.List;

/**
 *
 * @author Angel
 */
public class SIMULADOR {
    
    private int reloj=0;//Minutos 

    public static void main(String[] args) {
        
        
        /*Generar numeros aleatorios 
        GeneradorNumerosAleatorios generator = new GeneradorNumerosAleatorios(165, 32768, 149);//a=165,m=32768,s=149.
        for (int i = 0; i < 32768/4; i++) {
            double randomNumber = generator.nextDouble();
            System.out.println(randomNumber);
        }
        */
        
        
        //Generar variables poisson de una hora 
        PoissonGenerator poissonGenerator = new PoissonGenerator(40);
        List<Float> tiemposEntreArribos = poissonGenerator.nextFloat();

        for (Float tiempoEntreArribos : tiemposEntreArribos) {
        System.out.println(tiempoEntreArribos);
        }



     
        
        
       
        
     
        
    }
}

