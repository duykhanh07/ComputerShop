package GUI.ThongKe;

import java.awt.Color;

public class ModelPieChart {

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getValues() {
        return values;
    }

    public void setValues(long values) {
        this.values = values;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    
    public ModelPieChart(String name, long values, Color color) {
    	this.name = name;
        this.values = values;
        this.color = color;
    }

    public ModelPieChart() {
    }

    private String name;
    private long values;
    private Color color;
}