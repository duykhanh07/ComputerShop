package MyDesign.MyTable;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

import javax.swing.JComponent;
import javax.swing.plaf.basic.BasicTableHeaderUI;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumnModel;

public class CustomTableHeaderUI extends BasicTableHeaderUI {
	@Override
    public void installUI(JComponent c) {
        super.installUI(c);
    }

	@Override
    public void paint(Graphics g, JComponent c) {
        JTableHeader header = (JTableHeader) c;
        TableColumnModel columnModel = header.getColumnModel();
        int columnCount = columnModel.getColumnCount();

        Rectangle clipBounds = g.getClipBounds();
        if (clipBounds == null) {
            clipBounds = new Rectangle(0, 0, header.getWidth(), header.getHeight());
        }

        g.setColor(new Color(255, 255, 102)); // Set your desired background color
        g.fillRect(clipBounds.x, clipBounds.y, clipBounds.width, clipBounds.height);

        // Paint the column headers and split lines
        for (int col = 0; col < columnCount; col++) {
            Rectangle cellRect = header.getHeaderRect(col);
            if (cellRect.intersects(clipBounds)) {
                g.setColor(Color.black); // Set the split line color
                g.drawLine(cellRect.x + cellRect.width - 1, cellRect.y, cellRect.x + cellRect.width - 1, cellRect.y + cellRect.height);
            }
        }
        super.paint(g, c);
    }

}