package simulacion;

import java.io.*;
import java.util.*;

public class TransformadaInversa {

    public static void main(String[] args) {
        // Leer los números aleatorios desde un archivo de texto
        ArrayList<Double> numeros = new ArrayList<Double>();
        try {
            BufferedReader reader = new BufferedReader(new FileReader("numeros4.txt"));
            String linea;
            while ((linea = reader.readLine()) != null) {
                numeros.add(Double.parseDouble(linea.trim()));
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        // Generar valores de la variable aleatoria X
        ArrayList<Double> valoresX = new ArrayList<Double>();
        for (double u : numeros) {
            double x = Math.pow(u, 1.0/3.0);
            valoresX.add(x);
        }
        
        // Imprimir los valores de la variable aleatoria X generados
        for (double x : valoresX) {
            System.out.println(x);
        }
    }

}
