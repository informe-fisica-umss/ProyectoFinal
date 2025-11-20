<<<<<<< HEAD
import static org.junit.Assert.*;
import org.junit.Test;
import MMC.Errores;

public class TestErrores {

    @Test
    public void testErrorX() {
        double[] x = {1, 0.8};
        double[] t = {0, 0.1};
        double A = 1;
        double w = 5;
        double B = 0.2;

        double[] errores = Errores.errorX(x, t, A, w, B);
        assertEquals(2, errores.length);
    }
}
=======
import static org.junit.Assert.*;
import org.junit.Test;
import MMC.Errores;

public class TestErrores {

    @Test
    public void testErrorX() {
        double[] x = {1, 0.8};
        double[] t = {0, 0.1};
        double A = 1;
        double w = 5;
        double B = 0.2;

        double[] errores = Errores.errorX(x, t, A, w, B);
        assertEquals(2, errores.length);
    }
}
>>>>>>> 27b43ac76232356f6fcc61c90eedd548adc59264
