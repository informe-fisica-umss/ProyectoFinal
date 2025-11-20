package MMC;

import java.util.List;

public class Errores {

    public static double errorA(List<Double> x) {
        double mean = x.stream().mapToDouble(d -> d).average().orElse(0);
        double sum = 0;
        for (double xi : x) sum += Math.pow(xi - mean, 2);
        return Math.sqrt(sum / x.size());
    }

    public static double errorB(List<Double> x, List<Double> v) {
        double meanX = x.stream().mapToDouble(d -> d).average().orElse(0);
        double meanV = v.stream().mapToDouble(d -> d).average().orElse(0);
        double sum = 0;
        for (int i = 0; i < x.size(); i++)
            sum += Math.pow((v.get(i)/x.get(i)) - (meanV/meanX), 2);
        return Math.sqrt(sum / x.size());
    }
}
