package MMC;

public class Errores {

    public static double[] errorX(double[] xexp, double[] t, double A, double w, double B) {
        double[] errores = new double[xexp.length];

        for (int i = 0; i < xexp.length; i++) {
            double xmod = A * Math.cos(w * t[i] + B);
            errores[i] = Math.abs(xexp[i] - xmod);
        }

        return errores;
    }

    public static double[] errorV(double[] vexp, double[] t, double A, double w, double B) {
        double[] errores = new double[vexp.length];

        for (int i = 0; i < vexp.length; i++) {
            double vmod = -w * A * Math.sin(w * t[i] + B);
            errores[i] = Math.abs(vexp[i] - vmod);
        }

        return errores;
    }

    public static void main(String[] args) {
        double[] x = {1, 0.8, 0.3};
        double[] v = {0, -2, -3};
        double[] t = {0, 0.1, 0.2};

        double A = 1;
        double w = 5;
        double B = 0.2;

        double[] ex = errorX(x, t, A, w, B);
        double[] ev = errorV(v, t, A, w, B);

        for (double e : ex) System.out.println("Error X = " + e);
        for (double e : ev) System.out.println("Error V = " + e);
    }
}
