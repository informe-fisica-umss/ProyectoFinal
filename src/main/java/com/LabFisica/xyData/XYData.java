package com.LabFisica.xyData;

import java.util.List;

public class XYData {
    private List<Double> x;
    private List<Double> y;
    private String xName;
    private String yName;

    public XYData(List<Double> x, List<Double> y, String xName, String yName) {
        this.x = x;
        this.y = y;
        this.xName = xName;
        this.yName = yName;
    }

    public List<Double> getX() {
        return x;
    }

    public List<Double> getY() {
        return y;
    }

    public String getxName() {
        return xName;
    }

    public String getyName() {
        return yName;
    }
}
