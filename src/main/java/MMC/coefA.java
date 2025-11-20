package MMC;

public class CoefA {

    public static double calcularA(double[] x) {
        double xmax = 0;
        for (double xi : x) {
            if (Math.abs(xi) > xmax) {
                xmax = Math.abs(xi);
            }
        }
        return xmax;
    }

    // MAIN para pruebas rápidas
    public static void main(String[] args) {
        double[] x = {1.2, -1.5, 1.4, -1.52}; 
        double A = calcularA(x);
        System.out.println("Coeficiente A = " + A);
    }
}
