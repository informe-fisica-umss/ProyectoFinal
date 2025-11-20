package MMC;

import java.util.List;

public class coefB {
    public static double calcularB(List<Double> x, List<Double> v) {
        double sumX = 0, sumV = 0;
        for (int i = 0; i < x.size(); i++) {
            sumX += x.get(i);
            sumV += v.get(i);
        }
        return sumV / sumX;
    }
}
