package simulacion;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class kolmogorov {
    public static void main(String[] args) {
        //Se leen los numeros de un archivo txt y se guardan en un arreglo
        float[]array= readFiles("C:/Users/Angel/Documents/numeros15.txt");
        System.out.println(Arrays.toString(array));
        
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
