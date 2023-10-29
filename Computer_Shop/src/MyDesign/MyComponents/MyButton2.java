package MyDesign.MyComponents;


import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import javax.swing.JButton;

/**
 *
 * @author ACER
 */
public class MyButton2 extends JButton {
    public MyButton2(){
        setContentAreaFilled(false);
        setBorderPainted(false);
        setFocusPainted(false);
    }
    @Override
    public void paintComponent(Graphics grphcs) {
        Graphics2D g2 = (Graphics2D) grphcs;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setColor(this.getBackground());
        g2.fillRect(1, 1, this.getWidth() - 2, this.getHeight() - 2);
        super.paintComponent(grphcs);
    }
}
