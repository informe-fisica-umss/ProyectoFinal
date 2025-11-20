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

    public static void main(String[] args) {
        List<Double> ejemploX = List.of(1.0, 0.951, 0.809, 0.588, 0.309, 0.0);
        List<Double> ejemploV = List.of(0.0, -0.485, -0.923, -1.271, -1.494, -1.571);
        System.out.println("Error A: " + errorA(ejemploX));
        System.out.println("Error B: " + errorB(ejemploX, ejemploV));
    }
}
