package MMC;

public class MMCMain {
    public static void main(String[] args) {
        String[] archivosCSV = {
            "src/main/resources/tabla1.csv",
            "src/main/resources/tabla2.csv",
            "src/main/resources/tabla3.csv",
            "src/main/resources/tabla4.csv",
            "src/main/resources/tabla5.csv",
            "src/main/resources/tabla6.csv"
        };

        for (String archivoCSV : archivosCSV) {
            CSVReaderMMC.Data data = CSVReaderMMC.readCSV(archivoCSV);

            double A = coefA.calcularA(data.x);
            double B = coefB.calcularB(data.x, data.v);
            double errorA = Errores.errorA(data.x);
            double errorB = Errores.errorB(data.x, data.v);

            System.out.println("Archivo: " + archivoCSV);
            System.out.println("Coeficiente A: " + A);
            System.out.println("Coeficiente B: " + B);
            System.out.println("Error A: " + errorA);
            System.out.println("Error B: " + errorB);
            System.out.println("-----------------------------");
        }
    }
}
