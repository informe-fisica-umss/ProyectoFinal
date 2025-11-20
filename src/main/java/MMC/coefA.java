package MMC;

import java.util.List;

public class coefA {
    public static double calcularA(List<Double> x, List<Double> v) {
        double sum = 0;
        for (double xi : x) sum += xi * xi;
        return Math.sqrt(sum / x.size());
    }

    public static void main(String[] args) {
        List<Double> ejemploX = List.of(1.0, 0.951, 0.809, 0.588, 0.309, 0.0);
        List<Double> ejemploV = List.of(0.0, -0.485, -0.923, -1.271, -1.494, -1.571);
        System.out.println("Coeficiente A: " + calcularA(ejemploX, ejemploV));
    }
}
