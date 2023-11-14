package GUI.ThongKe.BarChart;

public class ModelBarChart {

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public long getValues() {
        return values;
    }

    public void setValues(long values) {
        this.values = values;
    }

    public ModelBarChart(String label, long values) {
        this.label = label;
        this.values = values;
    }

    public ModelBarChart() {
    }

    private String label;
    private long values;

}
