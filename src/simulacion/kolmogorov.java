package simulacion;
import java.lang.Math;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class kolmogorov {
    
    /*La siguiente prueba de Kolmogorov Smirnov 
    se puede aplicar a muestras de 10 numeros pseudoaleatorios
    si se desea ampliar esta posibilidad,es necesario cambiar los parametros*/

    public static void main(String[] args) {
        
        /*Aqui se ingresan los números mediante un archivo txt 
        y estos son guardados en un arreglo.*/
  
        float[]array= readFiles("C:/Users/Angel/Documents/GitHub/SIMULACION/números aleatorios/muestras(10)/5.txt");
        System.out.println("NUMEROS INGRESADOS:");
        System.out.println(Arrays.toString(array));
        
        int size = 10; //Variable que especifica el tamaño del arreglo
        
        //aplicamos uniformidad al arreglo.
        for (int i = 0; i < size; i++) {
            array[i]= array[i]/256 ;
        }
         System.out.println("NUMEROS CON UNIFORMIDAD :");
         System.out.println(Arrays.toString(array));
        
        // Acumulada observada
        //Orden de los numeros, usando metodo de la burbuja 
        float aux=0; //Variable auxiliar  
        for (int j = 0; j < size; j++) {
            for (int i = 0; i < size-1; i++) {
                if (array[i]>array[i+1]) {
                    aux=array[i];
                    array[i]=array[i+1];
                    array[i+1]=aux;
                } 
            }
        }
         System.out.println("NUMEROS ORDENADOS ASCENDENTEMENTE:");
         System.out.println(Arrays.toString(array));
        /*HASTA AQUI LOS N NUMEROS SE ENCUENTRAN UNIFORMEMENTE DISTRIBUIDOS (0,1)
         Y ORDENADOS ACENDENTEMENTE. */
       
        //Acumulada especifica 
        float numeros [] ={1,2,3,4,5,6,7,8,9,10};
        float array_especifica []= new float[size];
        
        for (int i = 0; i < 10; i++) {
            array_especifica[i]= numeros[i]/10;
            
        }  
         System.out.println("ACUMULADA ESPECIFICA:");
         System.out.println(Arrays.toString(array_especifica));
       
        //Declaracion de arreglo para la Dif absoluta 

        float array_absoluta []= new float[size];
        
        for (int i = 0; i < size; i++) {
            array_absoluta[i]= Math.abs(array[i]-array_especifica[i]);
            
        }
         System.out.println("DIFERENCIA ABSOLUTA :");
         System.out.println(Arrays.toString(array_absoluta));

        //Prueba para encontrar D maxima 
        float dmax =0;
        for (int x = 0; x < array_absoluta.length; x++) {
            if (array_absoluta[x]>dmax) {
                dmax=array_absoluta[x];
            }
  
        }
        System.out.println("Diferencia maxima es :" + dmax);
        float dcritico = (float) 0.409;
        if (dmax<dcritico) {
            System.out.println("No se rechaza Ho");
            System.out.println("Ho: Los numeros generados estan U(0,1) con un marco de error de 0.05");
            
        }else{
            System.out.println("Se rechara Ho");
            System.out.println("Ho: Los numeros generados no estan U(0,1), por lo tanto no pueden usarsse");
        }
                   
    } //Clase main acaba aqui
        
        /*Este método nos ayuda a leer los numeros que se 
        encuentran en un archivo con extensión txt y agrega los numeros 
        a un arreglo del tamaño del total de la muestra 
         */
    public static float[] readFiles(String file){
       try{
           File f = new File(file);
           Scanner s = new Scanner(f);
           int ctr = 0;
           while (s.hasNextDouble()){
               ctr++;
               s.nextDouble();
           }
           float[] arr = new float[ctr];
           
           Scanner s1 = new Scanner(f);
           
           for (int i = 0; i < arr.length; i++) 
               arr[i]= s1.nextFloat();
           return arr;
               
       } //Si el archivo txt se encuentra vacío,lanza una excepción. 
       catch(FileNotFoundException e){
           return null;
       }
       
    }
}