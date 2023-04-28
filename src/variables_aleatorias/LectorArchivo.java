package variables_aleatorias;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class LectorArchivo {
    private String rutaArchivo;

    public LectorArchivo(String rutaArchivo) {
        this.rutaArchivo = rutaArchivo;
    }

    public float[] leerNumeros() {
        File archivo = new File(rutaArchivo);

        try {
            Scanner lector = new Scanner(archivo);

            int numElementos = 0;
            while (lector.hasNextFloat()) {
                lector.nextFloat();
                numElementos++;
            }

            float[] numeros = new float[numElementos];

            lector = new Scanner(archivo);
            int i = 0;
            while (lector.hasNextFloat()) {
                numeros[i] = lector.nextFloat();
                i++;
            }

            lector.close();
            return numeros;

        } catch (FileNotFoundException e) {
            return null;
        }
    }
}
