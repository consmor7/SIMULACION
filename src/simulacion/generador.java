package simulacion;
import java.util.Scanner;
public class generador {
    /**
     * @param args
     */
    public static void main(String[] args) {
         //Declaramos e inicializamos las variables a usar
        int a = 0; int m = 0; int xn = 0;int xn1 = 0;
        
        
        Scanner scanner = new Scanner(System.in) ;
            //Se inicia el ciclo 1
            for (int i = 0; i < 1; i++) {
                //Definición de las variables 
                System.out.println("Introduce la semilla (xn):");xn = scanner.nextInt();
                System.out.println("Introduce la constante multiplicativa (a):");a = scanner.nextInt();
                System.out.println("Introduce el modulo (m):");m = scanner.nextInt();
                float array_uniformes []= new float[m/4];
                //Se aplica el modelo matematico de el metodo congruencial multiplicativo.
                for (int j = 0; j < m/4; j++) {
                    xn1 = (xn* a)%m; 
                    xn = xn1;
                    //Aplica Uniformidad y crea un nuevo arreglo para ello
                    array_uniformes[j] = (float) xn1/m;
                    }
                    GuardarNumeros.guardarNumeros("numeros4.txt", array_uniformes);                                   
    }
        
        
}
}
