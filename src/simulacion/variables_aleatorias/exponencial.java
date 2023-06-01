package simulacion.variables_aleatorias;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class exponencial {
    
    /**
     * @param args
     */
    public static void main(String[] args) {
         // Importar los números aleatorios del archivo de texto
         double[] array = readFiles("numeros4.txt");
         double exponencial=0;
        int minuto = 1;
        //Generar variable aleatoria exponencial
        for (int i = 0; i <=100; i++) {
            exponencial= -minuto*Math.log(1-array[i]) ;
            System.out.println(exponencial);
        }

    }

    // Función para importar los números aleatorios desde un archivo de texto
    public static double[] readFiles(String file) {
        try {
            File f = new File(file);
            Scanner s = new Scanner(f);
            int ctr = 0;
            while (s.hasNextDouble()) {
                ctr++;
                s.nextDouble();
            }
            double[] arr = new double[ctr];
            Scanner s1 = new Scanner(f);
            for (int i = 0; i < arr.length; i++) {
                arr[i] = s1.nextDouble();
            }
            return arr;
        } catch (FileNotFoundException e) {
            System.err.println("El archivo no se encuentra.");
            return null;
        }
    }
}
