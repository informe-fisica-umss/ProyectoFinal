package Graficas;

import org.knowm.xchart.XYChart;
import org.knowm.xchart.SwingWrapper;
import org.knowm.xchart.XYChartBuilder;

public class PlotV {

    public static void graficarV(String archivo) throws Exception {
        CSVReaderUtil.Data data = CSVReaderUtil.read(archivo);

        XYChart chart = new XYChartBuilder()
                .width(600)
                .height(400)
                .title("v(t) - " + archivo)
                .xAxisTitle("t")
                .yAxisTitle("v")
                .build();

        chart.addSeries("v(t)", data.t, data.v);

        new SwingWrapper<>(chart).displayChart();
    }
}
