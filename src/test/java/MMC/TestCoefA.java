import static org.junit.Assert.*;
import org.junit.Test;
import MMC.CoefA;

public class TestCoefA {

    @Test
    public void testCalcularA() {
        double[] x = {1.2, -2.5, 2.4, -2.52};
        double A = CoefA.calcularA(x);
        assertEquals(2.52, A, 0.001);
    }
}
