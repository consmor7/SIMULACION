package BANCO_CLASES;

public class variables_aleatorias {
    
    private static final int A = 165;//Constante multiplicativa 
    private float Xn = 149;//Semilla 
    static final int M = 32768;//Modulo
    private static float xn1 = 0;

    
    //Works 
    float generarNumeroAleatorio() {
        xn1 = (A * Xn) % M; //Modelo matematico del metodo congruencial multiplicativo
        Xn = xn1; //Se le asigna el valor de la semilla a la variable xn1
        
        return  Xn/M; //Se divide entre M para aplicar uniformidad.
        
    }
    
    //Metodo que genera variables poisson de 1 hora 
    public double generarVariablePoisson() {

        double to = 0;
        double t1 = 0;
        int poisson = 0;
        
        
        while (t1 <= 1) {
            
            t1 = (to-(1.0/40.0)*Math.log(generarNumeroAleatorio()));
            to = t1;
            poisson++;
  
        }return  t1;
                
        }
    
    //Metodo que genera variables uniformes entre (0,1).
    public double generarVariableUniforme() {
        int a = 0, b = 1; 
        return (double) a+(b-a)*generarNumeroAleatorio();
    }
}

