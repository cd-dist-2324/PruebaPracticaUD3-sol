
import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

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
        char[] entrada = {'5'};
        int resultado = Prueba_UD3.convertToEnteroPositivo(entrada);
        assertEquals(resultado, 5);
    }

     // Camino 5: 2 iteraciones en el bucle
     @Test
     void testC5bis() throws NumberFormatException, Exception {
         char[] entrada = {'5', '4'};
         int resultado = Prueba_UD3.convertToEnteroPositivo(entrada);
         assertEquals(resultado, 54);
     }


    
    // Camino 6: 7-13, 15, 21, 24, 25, 28,  36
    @Test
    void testC6() throws NumberFormatException, Exception {
        char[] entrada = {'f'};
        Exception exception = assertThrows(Exception.class, () -> Prueba_UD3.convertToEnteroPositivo(entrada));
        assertEquals(exception.getClass(), NumberFormatException.class);
    }
}
