import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Integral {
    public static void main(String[] args) {
        // Declaración e inicialización de variables
        float[] x = new float[5000];
        float[] f_x = new float[5000];
        float[] y = new float[5000];
        float[] condicional = new float[5000];
        int tamaño = 0;

        // Importar números aleatorios desde un archivo txt para tener x 
        try {
            Scanner scanner = new Scanner(new File("numeros4.txt"));
            for (int i = 0; i < 5000; i++) {
                if (scanner.hasNextFloat()) {
                    x[i] = scanner.nextFloat();
                    //Se calcula el cuadrado de x y lo guarda en f_x
                    f_x[i] = x[i] * x[i];
                    tamaño++;
                }
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        // Importar números desde otro archivo txt
        try {
            Scanner scanner = new Scanner(new File("numeros6.txt"));
            for (int i = 0; i < 5000; i++) {
                if (scanner.hasNextFloat()) {
                    y[i] = scanner.nextFloat();
                    if (y[i] <= f_x[i]) {
                        condicional[i] = y[i];
                    } else {
                        condicional[i] = 0;
                    }
                }
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        
        //Contamos cuentos numeros estan por debajo de la curva 
        int bajolacurva = 0;
        for (int i = 0; i < condicional.length; i++) {
        if (condicional[i] > 0.000000) {
        bajolacurva++;  
         }
        }
        System.out.println("El total de números para calcular la integral son: " + bajolacurva);

        int area = 1; //Los limites son de 0 a 1 por eso el area es total a 1.
        double integral = (bajolacurva)/5000.0*1.0 ;
        
        
        System.out.println("El valor de la integral es :" + integral);


    }
}
