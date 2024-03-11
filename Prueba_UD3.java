
public class Prueba_UD3 {

    public static final String NULL_MESSAGE = "La entrada no puede ser null";
    public static final String NEGATIVE_INT_MESSAGE = "No se permiten enteros negativos";

    public static int convertToEnteroPositivo(char[] entrada) throws NumberFormatException, Exception {

        int digitoEntero = 0;
        int numero = 0;
        int longitud = 0;

        if (entrada != null) {

            if (entrada.length > 0) {
                if (entrada[0] == '+') {
                    char[] entradaCopia = new char[entrada.length - 1];
                    // Creamos una copia del array original quitando la primera posición
                    System.arraycopy(entrada, 1, entradaCopia, 0, entrada.length - 1);
                    entrada = entradaCopia;

                }
                if (entrada[0] == '-') {
                    throw new Exception(NEGATIVE_INT_MESSAGE);
                }
            }
            longitud = entrada.length;
            for (int i = 0; i < longitud; i++) {
                /*
                 * parseInt puede lanzar NumberFormatException -
                 * si la cadena de entrada no es convertible a un entero
                 */
                digitoEntero = Integer.parseInt(String.valueOf(entrada[i]));
                numero += digitoEntero * Math.pow(10, longitud - 1 - i);

            }
            return numero;
        } else {
            throw new Exception(NULL_MESSAGE);
        }
    }

    public static void main(String[] args) throws Exception {
        char[] charArray = { '0', '0', '0', '0', '0' };
        int entero = convertToEnteroPositivo(charArray);
        System.out.println("Se ha leído: " + entero);
    }
}
