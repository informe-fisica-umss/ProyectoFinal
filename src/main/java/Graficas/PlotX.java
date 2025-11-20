package Graficas;

import org.knowm.xchart.XYChart;
import org.knowm.xchart.SwingWrapper;
import org.knowm.xchart.XYChartBuilder;

public class PlotX {

    public static void graficarX(String archivo) throws Exception {
        CSVReaderUtil.Data data = CSVReaderUtil.read(archivo);

        XYChart chart = new XYChartBuilder()
                .width(600)
                .height(400)
                .title("x(t) - " + archivo)
                .xAxisTitle("t")
                .yAxisTitle("x")
                .build();

        chart.addSeries("x(t)", data.t, data.x);

        new SwingWrapper<>(chart).displayChart();
    }
}
