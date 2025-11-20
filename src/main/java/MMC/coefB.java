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

    public static void main(String[] args) {
        List<Double> ejemploX = List.of(1.0, 0.951, 0.809, 0.588, 0.309, 0.0);
        List<Double> ejemploV = List.of(0.0, -0.485, -0.923, -1.271, -1.494, -1.571);
        System.out.println("Coeficiente B: " + calcularB(ejemploX, ejemploV));
    }
}
