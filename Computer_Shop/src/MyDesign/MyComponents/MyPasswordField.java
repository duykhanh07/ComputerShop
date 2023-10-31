package MyDesign.MyComponents;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.JPasswordField;

public class MyPasswordField extends JPasswordField{
	
	public MyPasswordField(){
        setForeground(Color.decode("#00CCCC"));
        setFont(new Font("Segoe UI", Font.BOLD, 16));
        setOpaque(false);
        addFocusListener(new FocusListener() {
			
			@Override
			public void focusLost(FocusEvent e) {
				// TODO Auto-generated method stub
				focus_border_color = Color.black;
				repaint();
			}
			
			@Override
			public void focusGained(FocusEvent e) {
				// TODO Auto-generated method stub
				focus_border_color = Color.decode("#00CCCC");
				repaint();
			}
		});
    }
	
	@Override
    public void paintComponent(Graphics grphcs) {   
        Graphics2D g2 = (Graphics2D) grphcs;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setColor(focus_border_color);      
        g2.fillRoundRect(0, 0, this.getWidth(), this.getHeight(), this.radius, this.radius);
        g2.setColor(Color.decode("#4d4d4d"));
        g2.fillRoundRect(2, 2, this.getWidth() - 4, this.getHeight() - 4, this.radius, this.radius);
        super.paintComponent(grphcs);
    }
    private int radius = 10;
    private Color focus_border_color = Color.black;
}
