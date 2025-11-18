package Graficas;

public class Main {

    public static void main(String[] args) throws Exception {

        if (args.length == 0) {
            System.out.println("Debes elegir: x ó v");
            System.out.println("Ejemplo: java -jar graficas.jar x");
            System.exit(0);
        }

        String modo = args[0]; // "x" o "v"

        String[] archivos = {
                "tabla1.csv",
                "tabla2.csv",
                "tabla3.csv",
                "tabla4.csv",
                "tabla5.csv",
                "tabla6.csv"
        };

        switch (modo.toLowerCase()) {

            case "x":
                System.out.println("======== MOSTRANDO x(t) ========");
                for (String a : archivos)
                    PlotX.graficarX(a);
                break;

            case "v":
                System.out.println("======== MOSTRANDO v(t) ========");
                for (String a : archivos)
                    PlotV.graficarV(a);
                break;

            default:
                System.out.println("Modo no válido. Usa: x o v");
        }
    }
}
