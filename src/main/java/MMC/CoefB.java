package MMC;

public class CoefB {

    public static double calcularB(double[] x, double[] t, double A, double w) {
        double sumaB = 0;
        int n = x.length;

        for (int i = 0; i < n; i++) {
            double xi = x[i];
            double ti = t[i];

            double argumento = xi / A;
            if (argumento > 1) argumento = 1;
            if (argumento < -1) argumento = -1;

            double arccos = Math.acos(argumento);
            double Bi = arccos - w * ti;

            sumaB += Bi;
        }

        return sumaB / n;
    }

    public static void main(String[] args) {
        double[] x = {1, 0.7, 0}; 
        double[] t = {0, 0.1, 0.2};
        double A = 1;
        double w = 5;

        double B = calcularB(x, t, A, w);
        System.out.println("Coeficiente B = " + B);
    }
}
