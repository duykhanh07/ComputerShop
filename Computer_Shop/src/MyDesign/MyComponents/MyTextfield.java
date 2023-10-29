package MyDesign.MyComponents;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import javax.swing.BorderFactory;
import javax.swing.JTextField;

/**
 *
 * @author ACER
 */
public class MyTextfield extends JTextField{
    public MyTextfield(){
        setForeground(Color.decode("#00CCCC"));
        setBackground(Color.decode("#4D4D4D"));
        setFont(new Font("Segoe UI", Font.BOLD, 16));
        setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
    }
   @Override
    public void paintComponent(Graphics grphcs) {
        Graphics2D g2 = (Graphics2D) grphcs;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setColor(Color.BLACK);      
        g2.fillRoundRect(0, 0, this.getWidth(), this.getHeight(), this.radius, this.radius);
        g2.setColor(this.getBackground());
        g2.fillRoundRect(2, 2, this.getWidth() - 4, this.getHeight() - 4, this.radius, this.radius);
        super.paintComponent(grphcs);
        
    }
    private int radius = 10;
}
