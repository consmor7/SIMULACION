package simulacion.variables_aleatorias;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


public class uniforme_discreta {
    public static void main(String[] args) {
     // Genera un número aleatorio uniforme U en el intervalo (0,1]
     double[] array = readFiles("numeros4.txt");
     int uniforme_discreta;
     /*a y b son los límites inferior 
     y superior de la distribución uniforme discreta*/
     int a=1 ; int b=5;
    
     

     for (int i = 0; i <= 100; i++) {
        uniforme_discreta = (int)Math.floor(a+array[i]*(b-a+1));
        System.out.println(uniforme_discreta);
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
