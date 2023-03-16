package simulacion;
import java.util.Scanner;
/**
 *
 * @author EQUIPO 1
 */
public class SIMULACION {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        //Declaramos e inicializamos las variables a usar.
        //Constante multiplicativa, Modulo y Semilla Respectivamente 
        int a = 0; int m = 0; int xn = 0; 
        //Así mismo un contador y la variable a despejar xn1. 
        int contador = 0; int xn1 = 0;
        
        /*Inicialización de el metodo Scanner para permitir la entrada de datos 
                por el usuario.*/
        Scanner scanner = new Scanner(System.in) ;
            //Se inicia el ciclo 1
            for (int i = 0; i < 10; i++) {
                
                //Definición de las variables 
                System.out.println("Conjunto : " + i);
                System.out.println("Introduce la semilla (xn):");
                xn = scanner.nextInt();
                System.out.println("Introduce la constante multiplicativa (a):");
                a = scanner.nextInt();
                System.out.println("Introduce el modulo (m):");
                m = scanner.nextInt();
                
                
                /*Se guarda la semilla primeramente ingresada por el usuario
                a otra variable con el fin de poderla usar en la etapa de verificación
                ya que esta contiene el valor inicial de la semilla*/
                int semilla = xn;
                
                //Se aplica el modelo matematico de el metodo congruencial multiplicativo.
                for (int j = 0; j < m/4; j++) {
                    xn1 = (xn* a)%m;
                    xn = xn1;
                    
                    /*Se demuestra que si el valor actual en [j] es == semilla (inicial) 
                    se aumenta un valor en el contador, así podemos saber si esta se repite
                    mas de una vez*/
                    
                    if (xn1==semilla) {
                        contador++;  
                    }
                    System.out.println(xn1);
                    
                    /*Se verifica que los numeros tienen la caracteristica de periodo completo,
                    si el contador tiene el valor de 1, nos hace saber que la semilla solo se repitió 
                    una sola vez con lo cual son periodo completo, de lo contrario no lo son.
                    */
                    }//Termina el ciclo 2
                    
                    if (contador==1) {
                        System.out.println("El conjunto: " + i + "("+" a: " + a + " m: " + m + " xn: " + xn + ")");
                        System.out.println("Es periodo completo");
                    }else {
                        System.out.println("El conjunto: " + i + "("+" a: " + a + " m: " + m + " xn: " + xn + ")");
                        System.out.println("Es periodo incompleto");  
                    }
                    //Se reinicia el contador para una nueva corrida
                    contador = 0;
                
                
                
            }//Termina el ciclo 1
        
        
    }//Termina el programa 
    
}
