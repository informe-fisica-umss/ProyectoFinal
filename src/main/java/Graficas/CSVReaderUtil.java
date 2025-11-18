package Graficas;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class CSVReaderUtil {

    public static class Data {
        public List<Double> t = new ArrayList<>();
        public List<Double> x = new ArrayList<>();
        public List<Double> v = new ArrayList<>();
    }

    public static Data read(String fileName) throws Exception {
        Data data = new Data();

        InputStream is = CSVReaderUtil.class.getClassLoader().getResourceAsStream(fileName);
        if (is == null) throw new RuntimeException("No se encontró " + fileName);

        try (BufferedReader br = new BufferedReader(new InputStreamReader(is))) {
            String line;
            br.readLine(); // encabezado

            while ((line = br.readLine()) != null) {
                String[] p = line.split(",");
                data.t.add(Double.parseDouble(p[0]));
                data.x.add(Double.parseDouble(p[1]));
                data.v.add(Double.parseDouble(p[2]));
            }
        }

        return data;
    }
}

