
import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

/* Cuando el array de entrada está vacío y no tiene ningún carácter, pero es distinto de null, hay que comprobar antes de acceder a la posición [0]: 
 * 
 *  if (entrada.length > 0) {
 * 
 * }
 * La versión corregida está en Prueba_UD3Corregida.java
 * Este bug se detecta con el testC4
 */
public class Prueba_UD3Test {

    // Camino 1: 7-13,34,36
    @Test
    void testC1() throws NumberFormatException, Exception {

        Exception exception = assertThrows(Exception.class, () -> Prueba_UD3.convertToEnteroPositivo(null));
        assertEquals(exception.getMessage(), Prueba_UD3.NULL_MESSAGE);
    }

    // Camino 2: 7-13, 15, 21, 22, 36
    @Test
    void testC2() throws NumberFormatException, Exception {
        char[] entrada = { '-', '5', '4' };
        Exception exception = assertThrows(Exception.class, () -> Prueba_UD3.convertToEnteroPositivo(entrada));
        assertEquals(exception.getMessage(), Prueba_UD3.NEGATIVE_INT_MESSAGE);
    }

    // Camino 3: 7-13, 15, 16-18, 21, 22, 36

    @Test
    void testC3() throws NumberFormatException, Exception {
        char[] entrada = { '+', '-', '5', '4' };
        Exception exception = assertThrows(Exception.class, () -> Prueba_UD3.convertToEnteroPositivo(entrada));
        assertEquals(exception.getMessage(), Prueba_UD3.NEGATIVE_INT_MESSAGE);
    }

    /* El testC4 falla con una excepción:
     * java.lang.ArrayIndexOutOfBoundsException: Index 0 out of bounds for length 0
     * at Prueba_UD3.convertToEnteroPositivo(Prueba_UD3.java:15)
     */

    // Camino 4: 7-13, 15, 21, 24, 25, 32, 36
    @Test
    void testC4() throws NumberFormatException, Exception {
        char[] entrada = new char[0];
        int resultado = Prueba_UD3.convertToEnteroPositivo(entrada);
        assertEquals(resultado, 0);
    }

    // Camino 5: 7-13, 15, 21, 24, 25, 28, 29, 25, 32, 36
    @Test
    void testC5() throws NumberFormatException, Exception {
        char[] entrada = { '5' };
        int resultado = Prueba_UD3.convertToEnteroPositivo(entrada);
        assertEquals(resultado, 5);
    }

    // Variante de camino 5, pero con 2 iteraciones en el bucle. (Este caso no se pedía)
    @Test
    void testC5bis() throws NumberFormatException, Exception {
        char[] entrada = { '5', '4' };
        int resultado = Prueba_UD3.convertToEnteroPositivo(entrada);
        assertEquals(resultado, 54);
    }

    // Camino 6: 7-13, 15, 21, 24, 25, 28, 36
    @Test
    void testC6() throws NumberFormatException, Exception {
        char[] entrada = { 'f' };
        Exception exception = assertThrows(Exception.class, () -> Prueba_UD3.convertToEnteroPositivo(entrada));
        assertEquals(exception.getClass(), NumberFormatException.class);
    }
}
