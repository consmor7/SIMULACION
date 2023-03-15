package simulacion;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;


public class kolmogorov {
    /**
     * @param args
     */
    public static void main(String[] args) {

         /*Aqui se ingresan los números mediante un archivo txt 
        y estos son guardados en un arreglo.*/
  
        float[]array= readFiles("C:/Users/Angel/Documents/numeros15.txt");
        System.out.println(Arrays.toString(array));
        
        int size = 10; //Variable que especifica el tamaño del arreglo
        
        //Aplicamos uniformidad al arreglo.
        Uniformidad(array);
        
        // Acumulada observada
        //Orden de los numeros, usando metodo de la burbuja 
        BubbleSort(array);

        //HASTA AQUI LOS N NUMEROS SE ENCUENTRAN UNIFORMEMENTE DISTRIBUIDOS (0,1) Y ORDENADOS ACENDENTEMENTE. 
       
        //Acumulada especifica 
        float numeros [] ={1,2,3,4,5,6,7,8,9,10};
        float array_especifica []= new float[size];
        
        for (int i = 0; i < 10; i++) {
            array_especifica[i]= numeros[i]/10;
            
        }       
       
        //Declaracion de arreglo para la absoluta o diferencia

        float array_absoluta []= new float[size];
        
        for (int i = 0; i < size; i++) {
            array_absoluta[i]= Math.abs(array[i]-array_especifica[i]);
            System.out.println(array_absoluta[i]);
        }

        //Prueba para visualizar D maxima 
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
            System.out.println("Ho: Los numeros generados estan U(0,1) con un marco de error de 0.5");
            
        }else{
            System.out.println("Se rechara Ho");
            System.out.println("Ho: Los numeros generados no estan U(0,1), por lo tanto no pueden usarsse");
        }
       
        

        
  
    }
    private static void Uniformidad(float[] array) {
        int n = array.length;
        for (int i = 0; i < n; i++) {
            array[i]= array[i]/256;
        }
        
    }
   
    private static void BubbleSort(float[] array) {
        int n =  array.length;
        for (int i = 0; i < n-1; i++) {
            for (int j = 0; j < n-i-1; j++) {
                if (array[j]>array[j+1]) {
                    int temp = (int) array[j];
                    array[j] = array[j+1];
                    array[j+1] = temp;
  
                }
                
            }
            
        }
    }

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
                
        }
        catch(FileNotFoundException e){
            return null;
        }
        
     }
}
