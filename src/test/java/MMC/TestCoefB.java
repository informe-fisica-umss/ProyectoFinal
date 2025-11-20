import static org.junit.Assert.*;
import org.junit.Test;
import MMC.CoefB;

public class TestCoefB {

    @Test
    public void testCalcularB() {
        double[] x = {1, 0.7};
        double[] t = {0, 0.1};
        double A = 1;
        double w = 5;

        double B = CoefB.calcularB(x, t, A, w);
        assertNotNull(B);
    }
}
