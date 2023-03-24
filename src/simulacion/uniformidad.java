package simulacion;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class uniformidad {
    public static void main(String[] args) {
        /*Aqui se ingresan los números mediante un archivo txt 
        y estos son guardados en un arreglo.*/
  
        float[]array= readFiles("C:/Users/Angel/Documents/GitHub/SIMULACION/números aleatorios/muestras(64)/10.txt");
        System.out.println("NUMEROS INGRESADOS:");
        System.out.println(Arrays.toString(array));
        
        int size = 64; //Variable que especifica el tamaño del arreglo
        
        //aplicamos uniformidad al arreglo.
        for (int i = 0; i < size; i++) {
            array[i]= array[i]/256 ;
            System.out.println(array[i]);
        }


        
    } public static float[] readFiles(String file){
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