package simulacion;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class GuardarNumeros {

    public static void guardarNumeros(String nombreArchivo, float[] array_uniformes) {
        try {
            FileWriter archivo = new FileWriter(nombreArchivo);
            PrintWriter salida = new PrintWriter(archivo);

            // Escribimos los números en el archivo
            for (int i = 0; i < array_uniformes.length; i++) {
                salida.println(array_uniformes[i]);
            }

            salida.close();
            System.out.println("Los números se han guardado exitosamente en el archivo " + nombreArchivo);
        } catch (IOException e) {
            System.out.println("Error al guardar los números en el archivo " + nombreArchivo);
            e.printStackTrace();
        }
    }
}
