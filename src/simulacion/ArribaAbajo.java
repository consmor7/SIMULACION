package simulacion;

import java.util.ArrayList;
import org.apache.commons.math3.distribution.NormalDistribution;

public class ArribaAbajo {

    public static void main(String[] args){
        ArribaAbajo prueba01 = new ArribaAbajo();
        prueba01.pruebacorridas();
    }

    static double datos[] = {
            // Numeros obtenidos del Metodo Congruencial Multiplicativo
            // con xn = 111, a = 53, mod = 32768 (2 elveado a 15)
            0.5883,
            0.16887,
            0.10275,
            0.20287,
            0.26635,
            0.2631,
            0.8371,
            0.17679,
            0.19483,
            0.16791,
            0.5187,
            0.12767,
            0.21291,
            0.14311,
            0.4819
    };
    final static double confianza = .95;
    static  double alfa = 1-confianza;

    static public void pruebacorridas(){
        //Creamos una lista para guardar los ceros y unos.
        ArrayList<Integer> bits = new ArrayList<>();
        int i, corridas, dato;
        double  media, varianza, z;
        //Revisa si cada dato actual es menor al dato anterior.
        //Si es así, se guarda un 0, de lo contrario, se guarda un 1
        for (i=1; i<datos.length; i++){
            if (datos[i]<=datos[i-1]){
                bits.add(0);
            }
            else{
                bits.add(1);
            }
        }

        //Imprimimos la cadena de ceros y unos
        for (i=0; i<bits.size(); i++){
            System.out.print(bits.get(i));
        }

        //Contamos las corridas.
        corridas = 1;
        //Comenzamos observando el primer dígito
        dato= bits.get(0);
        //Comparamos cada dígito con el observado, cuando cambia es
        //una nueva corrida
        for (i=1; i<bits.size(); i++){
            if (bits.get(i) != dato){
                corridas++;
                dato = bits.get(i);
            }
        }
        System.out.println("Corridas " + corridas);

        //Aplicamos las fórmulas para media, varianza y Z.
        media = (2*datos.length-1)/ (double)3;
        System.out.println("Media: " +media);
        varianza = (16*datos.length-29)/(double) 90;
        System.out.println("Varianza: " + varianza);
        z= Math.abs((corridas-media)/Math.sqrt(varianza));
        System.out.println("Z=" + z);

        //Obtenemos el valor Z de la tabla de distribución normal
        NormalDistribution normal = new NormalDistribution();
        double  zn =  normal.inverseCumulativeProbability(1-alfa/2);
        //Comparamos: si es mayor mi valor Z al de la tabla, no pasa
        if (z < zn){
            System.out.println("No se rechaza que son independientes. " );
        }
        else{
            System.out.println("No Pasa la prueba de corridas");
        }

    }

}
