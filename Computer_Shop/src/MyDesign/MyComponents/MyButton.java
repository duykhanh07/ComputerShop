package MyDesign.MyComponents;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;

public class MyButton extends JButton {

    public MyButton() {
        this.setContentAreaFilled(false);
        setColor(color);
        setFocusPainted(false);
        setBorderPainted(false);
        setForeground(Color.decode("#00CCCC"));
        setFont(new Font("Segoe UI", Font.BOLD, 14));
        addMouseListener(new MouseAdapter() {

            @Override
            public void mouseEntered(MouseEvent e) {
                setBackground(colorOver);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                setBackground(color);
            }
        });
    }

    @Override
    public void paintComponent(Graphics grphcs) {
        Graphics2D g2 = (Graphics2D) grphcs;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setColor(this.getBackground());
        g2.fillRoundRect(1, 1, this.getWidth() - 2, this.getHeight() - 2, this.radius, this.radius);
        super.paintComponent(grphcs);
    }

    /**
     * @return the color
     */
    public Color getColor() {
        return color;
    }

    /**
     * @param color the color to set
     */
    public void setColor(Color color) {
        this.color = color;
        this.setBackground(color);
    }

    /**
     * @return the colorOver
     */
    public Color getColorOver() {
        return colorOver;
    }

    /**
     * @param colorOver the colorOver to set
     */
    public void setColorOver(Color colorOver) {
        this.colorOver = colorOver;
    }

    private Color color = Color.decode("#FFFF66");
    private Color colorBorder = Color.decode("#000000");
    private Color colorOver = Color.decode("#CCCC00");
    private int radius = 10;

}
