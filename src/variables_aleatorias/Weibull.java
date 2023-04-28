public class Weibull {
    /**
     * @param args
     */
    public static void main(String[] args) {

        // Generar un número aleatorio uniforme U en el intervalo (0,1).
        String rutaArchivo = "numeros4.txt";
        LectorArchivo lector = new LectorArchivo(rutaArchivo);
        float[] numeros = lector.leerNumeros();

        /*Calcular la variable aleatoria X a partir
         de la función inversa de la distribución Weibull, 
         dada por la expresión: X = a*(-ln(1-U))^1/β,
        donde a es el parámetro de escala y β es el parámetro
         de forma de la distribución Weibull.*/

         float alpha = 2 ,beta = 3;
         float Weibull = 0;

         //Si el archivo tiene numeros aleatorios
        if (numeros != null) {
            //Calcular la variable aleatoria Weibull 
            for (int i = 0; i<=100; i++) {
               Weibull=(float) (beta * Math.pow(-Math.log(1 - numeros[i]), 1/alpha));
               System.out.println(Weibull);
            }
            //De lo contrario no se genera 
        } else {
            System.out.println("No se pudo leer el archivo de números aleatorios.");
        }
    }
    }