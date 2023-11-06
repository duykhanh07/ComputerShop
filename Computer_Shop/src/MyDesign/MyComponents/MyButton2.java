package MyDesign.MyComponents;


import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.border.LineBorder;

/**
 *
 * @author ACER
 */
public class MyButton2 extends JButton {
	private Color non_selected_bcolor = new Color(102,102,102);
	private Color selected_bcolor = new Color(77,77,77);
	private Color selected_color = new Color(0,255,255);
	private boolean selected;
	
    public MyButton2(){
    	setSelected(false);
        setFocusPainted(false);      
        setBorder(new LineBorder(Color.black, 1));
        setHorizontalAlignment(JButton.LEADING);
    }
    
    public MyButton2(String text) {
    	setText(text);
    	setSelected(false);
        setFocusPainted(false);
        setBorder(new LineBorder(Color.black, 1));
        setHorizontalAlignment(JButton.LEADING);
    }
    
    
    public void setSelected(boolean selected) {
    	this.selected = selected;
    	if(selected) {
    		setBackground(selected_bcolor);
    		setForeground(selected_color);
    	}else {
    		setBackground(non_selected_bcolor);
    		setForeground(Color.white);
    	}
    	repaint();
    }
    public boolean getIsClicked() {
    	return this.selected;
    }
    
}
