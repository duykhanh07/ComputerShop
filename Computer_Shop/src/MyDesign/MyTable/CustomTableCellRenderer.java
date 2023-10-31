package MyDesign.MyTable;

import java.awt.Color;
import java.awt.Component;

import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

public class CustomTableCellRenderer extends DefaultTableCellRenderer {
    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        Component component = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
        

        if (isSelected) {
            component.setForeground(Color.black);
            component.setBackground(new Color(0,200,200));
        } else {
            component.setForeground(new Color(0,255,255));
            component.setBackground(new Color(102,102,102));
        }

        return component;
    }
}