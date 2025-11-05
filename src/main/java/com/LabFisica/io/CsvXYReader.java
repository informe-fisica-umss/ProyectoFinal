package com.LabFisica.io;

import com.LabFisica.xyData.XYData;
import org.knowm.xchart.*;
import org.knowm.xchart.style.markers.SeriesMarkers;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class CsvXYReader {

    // 👉 Método para leer un CSV con columnas X e Y
    public static XYData read(Path csvPath) throws IOException {
        List<Double> x = new ArrayList<>();
        List<Double> y = new ArrayList<>();
        String xName = "X";
        String yName = "Y";

        try (BufferedReader br = Files.newBufferedReader(csvPath)) {
            String header = br.readLine();
            if (header != null) {
                String[] cols = header.split(",");
                if (cols.length >= 2) {
                    xName = cols[0].trim();
                    yName = cols[1].trim();
                }
            }

            String line;
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
                if (values.length >= 2) {
                    try {
                        x.add(Double.parseDouble(values[0].trim()));
                        y.add(Double.parseDouble(values[1].trim()));
                    } catch (NumberFormatException e) {
                        System.out.println("⚠️ Línea ignorada (no numérica): " + line);
                    }
                }
            }
        }

        return new XYData(x, y, xName, yName);
    }

    // 👉 Método principal que grafica las 6 tablas
    public static void main(String[] args) throws IOException {
        String basePath = "src/test/resources/";

        for (int i = 1; i <= 6; i++) {
            String nombre = "Tabla" + i + ".csv";
            System.out.println("📄 Leyendo " + nombre + "...");

            XYData data = CsvXYReader.read(Path.of(basePath + nombre));

            XYChart chart = new XYChartBuilder()
                    .width(600)
                    .height(400)
                    .title("Tabla " + i)
                    .xAxisTitle(data.getxName())
                    .yAxisTitle(data.getyName())
                    .build();

            chart.addSeries("Datos " + i, data.getX(), data.getY())
                    .setMarker(SeriesMarkers.CIRCLE);

            new SwingWrapper<>(chart).displayChart();
            System.out.println("✅ Tabla " + i + " graficada correctamente.");
        }

        System.out.println("🎉 Todas las tablas fueron procesadas.");
    }
}

