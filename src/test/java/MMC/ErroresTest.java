package MMC;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ErroresTest {

    @Test
    void testErrores() {
        Errores e = new Errores();
        double res = e.calcularError(2.0, 3.0); // Ajusta según tu método real
        assertEquals(0.1, res, 1e-6); // Cambia 0.1 por el valor esperado correcto
    }
}
