package com.LabFisica.plots;

import com.LabFisica.xyData.XYData;
import com.LabFisica.io.CsvXYReader;
import org.knowm.xchart.XYChart;
import org.knowm.xchart.XYChartBuilder;
import org.knowm.xchart.SwingWrapper;
import org.knowm.xchart.BitmapEncoder;
import org.knowm.xchart.BitmapEncoder.BitmapFormat;
import org.knowm.xchart.XYSeries;
import org.knowm.xchart.style.markers.SeriesMarkers;

import java.nio.file.Path;

public class CsvScatterPlot {
    public static void main(String[] args) throws Exception {
        if (args.length < 1) {
            System.err.println("Uso: CsvScatterPlot <archivo.csv>");
            System.exit(2);
        }

        XYData data = CsvXYReader.read(Path.of(args[0]));
        XYChart chart = makePlot(data);
        showChart(chart);
    }

    public static XYChart makePlot(XYData data) {
        XYChart chart = new XYChartBuilder()
                .width(800)
                .height(600)
                .title("Scatter Plot")
                .xAxisTitle(data.getxName())   // 👈 usando getter
                .yAxisTitle(data.getyName())   // 👈 usando getter
                .build();

        XYSeries series = chart.addSeries("Datos", data.getX(), data.getY()); // 👈 usando getters
        series.setXYSeriesRenderStyle(XYSeries.XYSeriesRenderStyle.Scatter);
        series.setMarker(SeriesMarkers.CIRCLE);

        return chart;
    }

    public static void showChart(XYChart chart) {
        new SwingWrapper<>(chart).displayChart();
    }

    public static void saveChart(XYChart chart, String filename) throws Exception {
        BitmapEncoder.saveBitmap(chart, filename, BitmapFormat.PNG);
    }
}

