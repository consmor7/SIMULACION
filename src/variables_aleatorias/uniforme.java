package variables_aleatorias;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


public class uniforme {
    public static void main(String[] args) {
     // Importar los números aleatorios del archivo de texto
     double[] array = readFiles("numeros4.txt");
   
     double uniforme;
     int a=1 ; int b=8;
    
     

     for (int i = 0; i < array.length; i++) {
       
        uniforme=a+(b-a)*array[i];
        System.out.println(uniforme);
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
