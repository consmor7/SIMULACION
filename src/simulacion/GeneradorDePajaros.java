package simulacion;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class GeneradorDePajaros {
    
    public static void main(String[] args) {
        
        // Definir los rangos de probabilidad de cada tipo de pájaro
        double[][] rangos = {{0, 0.05}, {0.05, 0.25}, {0.25, 0.60}, {0.60, 0.80}, {0.80, 0.90}, {0.90, 1}};
        
        // Importar los números aleatorios del archivo de texto
        double[] array = readFiles("numeros4.txt");
        
        // Asignar cada número a un tipo de pájaro, según su rango de probabilidad
        for (int i = 0; i < array.length; i++) {
            int resultado = buscarRango(array[i], rangos);
            System.out.println(resultado);
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
    
    // Función para buscar el rango de probabilidad al que pertenece un número aleatorio
    public static int buscarRango(double numero, double[][] rangos) {
        for (int i = 0; i < rangos.length; i++) {
            if (numero >= rangos[i][0] && numero <= rangos[i][1]) {
                return i;
            }
        }
        return rangos.length;
    }
}
