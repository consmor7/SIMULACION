package variables_aleatorias;


import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
public class bernoulli {

    public static void main(String[] args) {
    // Importar los números aleatorios del archivo de texto
    //Genera un número aleatorio uniforme U en el rango [0, 1] 
    //utilizando un generador de números aleatorios.
     double[] array = readFiles("numeros4.txt");
     int[] Be = new int[array.length];
     double p = 0.49;

     for (int i = 0; i <=100; i++) {
        /*Si ri es menor o igual que p, donde p es la probabilidad de éxito
         deseada para la variable Bernoulli, entonces asigna el valor 1 
         a la variable. */
        if (array[i]<=p) {
            Be[i]=1;
        } else {
            /*De lo contrario, asigna el valor 0 a la variable. */
            Be[i]=0;
        }
        //Imprime las variables aleatorias benoulli
        System.out.println(Be[i]);
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
