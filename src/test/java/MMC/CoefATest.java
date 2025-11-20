package MMC;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CoefATest {

    @Test
    void testCoefA() {
        CoefA a = new CoefA();
        double res = a.calcular(2.0, 3.0); // Ajusta según tu método real
        assertEquals(5.0, res, 1e-6); // Cambia 5.0 por el valor esperado correcto
    }
}
