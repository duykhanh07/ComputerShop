package MyDesign.MyTabPane;


import java.awt.Color;
import javax.swing.JTabbedPane;
import MyDesign.MyTabPane.*;

/**
 *
 * @author RAVEN
 */
public class MyTabbedPaneCustom extends JTabbedPane {

    /**
     * @return the selectedFontColor
     */
    public Color getSelectedFontColor() {
        return selectedFontColor;
    }

    /**
     * @param selectedFontColor the selectedFontColor to set
     */
    public void setSelectedFontColor(Color selectedFontColor) {
        this.selectedFontColor = selectedFontColor;
    }

    /**
     * @return the unselectedFontColor
     */
    public Color getUnselectedFontColor() {
        return unselectedFontColor;
    }

    /**
     * @param unselectedFontColor the unselectedFontColor to set
     */
    public void setUnselectedFontColor(Color unselectedFontColor) {
        this.unselectedFontColor = unselectedFontColor;
    }

    public Color getSelectedColor() {
        return selectedColor;
    }

    public void setSelectedColor(Color selectedColor) {
        this.selectedColor = selectedColor;
        repaint();
    }

    public Color getUnselectedColor() {
        return unselectedColor;
    }

    public void setUnselectedColor(Color unselectedColor) {
        this.unselectedColor = unselectedColor;
        repaint();
    }

    private Color selectedColor = Color.decode("#333333");
    private Color unselectedColor = Color.decode("#4d4d4d");
    private Color selectedFontColor = Color.decode("#00CCCC");
    private Color unselectedFontColor = Color.decode("#FFFFFF");

    public MyTabbedPaneCustom() {
        setBackground(new Color(250, 250, 250));
        setTabLayoutPolicy(javax.swing.JTabbedPane.SCROLL_TAB_LAYOUT);
        setUI(new TabbedPaneCustomUI(this));
    }
}
