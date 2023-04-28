package variables_aleatorias;


public class Poisson {
    /**
     * @param args
     */
    public static void main(String[] args) {
        
        // Generar un número aleatorio uniforme U en el intervalo (0,1).
        String rutaArchivo = "numeros6.txt";
        LectorArchivo lector = new LectorArchivo(rutaArchivo);
        float[] numeros = lector.leerNumeros();

        //Inicializar variables.
        float to;
        int poisson=0;
        float ti ;
        boolean stop; 
        float limite = 1;
        

       int ultimoIndice = 0;
       //Ciclo externo, para generar 100 variables Poisson.
        for (int k = 0; k < 100; k++) {
        to = 0; //Se reinicia To con el fin de generar nuevamente Ti
        poisson = 0;//Se reinicia la variable poisson con el fin de obtener una nueva
        stop = false;
    
        //Este ciclo interno comienza en el ultimo numero aleatorio utilizado.
    for (int i = ultimoIndice; i < numeros.length; i++) {
        //Formula a usar 
        ti = (float) (to - (1.0/40.0) * Math.log(numeros[i]));
        //Imprimir ti para ver el comportamiento
        System.out.println(ti);
        //Si ti es menor que 1 entonces le pasa el valor a to y la variable aleatoria aumenta un valor.
        if (ti <= limite) {
            to = ti;
            poisson++;
            //De lo contrario se obtiene el indice del ultimo numero aleatorio usado.
            //Ademas se rompe el ciclo.
        } else {
            stop = true;
            ultimoIndice = i; // Actualizamos el último índice utilizado.
            break;
        }
    }
    
    if (!stop) {
        ultimoIndice = numeros.length; // Si no se detuvo, significa que se utilizaron todos los números.
    }
    //Imprime la variable Poisson.
    System.out.println("Variable poisson "+ (k+1) + ": "+ poisson);
}

    }

}
        