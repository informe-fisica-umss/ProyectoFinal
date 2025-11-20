package MMC;

public class MMCMain {
    public static void main(String[] args) {
        String archivoCSV = "src/main/resources/tabla1.csv";
        CSVReaderMMC.Data data = CSVReaderMMC.readCSV(archivoCSV);

        double A = coefA.calcularA(data.x, data.v);
        System.out.println("Coeficiente A: " + A);

        double B = coefB.calcularB(data.x, data.v);
        System.out.println("Coeficiente B: " + B);

        double errorA = Errores.errorA(data.x);
        double errorB = Errores.errorB(data.x, data.v);
        System.out.println("Error A: " + errorA);
        System.out.println("Error B: " + errorB);
    }
}
