package MMC;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CoefBTest {

    @Test
    void testCoefB() {
        CoefB b = new CoefB();
        double res = b.calcular(4.0, 5.0); // Ajusta según tu método real
        assertEquals(9.0, res, 1e-6); // Cambia 9.0 por el valor esperado correcto
    }
}
