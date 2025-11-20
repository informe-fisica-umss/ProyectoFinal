package MMC;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CSVReaderMMC {

    public static class Data {
        public List<Double> t = new ArrayList<>();
        public List<Double> x = new ArrayList<>();
        public List<Double> v = new ArrayList<>();
    }

    public static Data readCSV(String filePath) {
        Data data = new Data();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            br.readLine(); // omitir encabezado
            while ((line = br.readLine()) != null) {
                String[] parts = line.trim().split("\s+|,");
                if (parts.length >= 3) {
                    data.t.add(Double.parseDouble(parts[0]));
                    data.x.add(Double.parseDouble(parts[1]));
                    data.v.add(Double.parseDouble(parts[2]));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return data;
    }
}
