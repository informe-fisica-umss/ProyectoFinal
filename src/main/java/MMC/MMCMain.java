package MMC;

import java.util.List;

public class coefA {
    public static double calcularA(List<Double> x) {
        double sum = 0;
        for (double xi : x) sum += xi * xi;
        return Math.sqrt(sum / x.size());
    }
}
