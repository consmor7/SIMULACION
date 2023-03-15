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
        //Se leen los numeros de un archivo txt y se guardan en un arreglo
        float[]array= readFiles("C:/Users/Angel/Documents/numeros15.txt");
        System.out.println(Arrays.toString(array));

        int n = array.length;

        //Ordenas ascendentemente los números, usamos el método de la burbuja
        BubbleSort(array);
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]+ ""); 
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
