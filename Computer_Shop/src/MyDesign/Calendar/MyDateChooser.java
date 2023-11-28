package MyDesign.Calendar;

import MyDesign.*;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JWindow;

import MyDesign.MyComponents.*;


/**
 *
 * @author ACER
 */
public class MyDateChooser extends javax.swing.JPanel {
    
   public  CalendarButton myButton2;
    public MyCalendar myCalendar ; 
    private JWindow window;
    private CalendarInterface inter;
    private MyDateChooser mdc = this;
    /**
     * Creates new form MyDateChooser
     */
    public MyDateChooser() {
       
         inter = new CalendarInterface() {
            @Override
            public void changeDate(int value) {
                Date newDate = new Date(myCalendar.year,myCalendar.month,value);
                myCalendar.setDate(newDate);
                myCalendar.month = myCalendar.date.getMonth();
                myCalendar.year = myCalendar.date.getYear();
                myCalendar.initDates();
                window.setVisible(false);
                
                String stringFM = "dd/MM/yyyy";
                SimpleDateFormat df= new SimpleDateFormat(stringFM);
                myTextfield1.setText(df.format(myCalendar.date));
            }

            @Override
            public void setDate(Date date) {
                  myCalendar.date = date;
                  myCalendar.month = date.getMonth();
                  myCalendar.year = date.getYear();
            }

            @Override
            public void newMonth(int forward) {
                 if(forward == 0){
                   if ( myCalendar.month > 0){
                        myCalendar.month -= 1;
                   }else{
                        myCalendar.month = 11;
                        myCalendar.year -= 1;
                   }
               }else{
                   if ( myCalendar.month < 11){
                        myCalendar.month += 1;
                   }else{
                        myCalendar.month = 0;
                        myCalendar.year += 1;
                   }
               }
                myCalendar.getMonthYearLabel().setText( myCalendar.months[ myCalendar.month]+" - "+( myCalendar.year+1900));
                myCalendar.initDates();
            }
        };
        myCalendar = new MyCalendar(new Date(System.currentTimeMillis()), inter);
        init();
    }
    
    public MyDateChooser(Date date){
        inter = new CalendarInterface() {
            @Override
            public void changeDate(int value) {
                Date newDate = new Date(myCalendar.year,myCalendar.month,value);
                myCalendar.setDate(newDate);
                myCalendar.month = myCalendar.date.getMonth();
                myCalendar.year = myCalendar.date.getYear();
                myCalendar.initDates();
                window.setVisible(false);
            }

            @Override
            public void setDate(Date date) {
                  myCalendar.date = date;
                  myCalendar.month = date.getMonth();
                  myCalendar.year = date.getYear();
            }

            @Override
            public void newMonth(int forward) {
                 if(forward == 0){
                   if ( myCalendar.month > 0){
                        myCalendar.month -= 1;
                   }else{
                        myCalendar.month = 11;
                        myCalendar.year -= 1;
                   }
               }else{
                   if ( myCalendar.month < 11){
                        myCalendar.month += 1;
                   }else{
                        myCalendar.month = 0;
                        myCalendar.year += 1;
                   }
               }
                myCalendar.getMonthYearLabel().setText( myCalendar.months[ myCalendar.month]+" - "+( myCalendar.year+1900));
                myCalendar.initDates();
            }
        };
        myCalendar = new MyCalendar(date, inter);
        init();
    }
    
    
    public void init(){
        setBorder(null);
        myTextfield1 = new MyTextfield();
        myTextfield1.setBackground(new Color(77,77,77));
        myTextfield1.setEditable(false);
        String stringFM = "dd/MM/yyyy";
        SimpleDateFormat df= new SimpleDateFormat(stringFM);
        myTextfield1.setText(df.format(myCalendar.date));
        myTextfield1.setHorizontalAlignment(MyTextfield.CENTER) ;
        
        myButton2 = new MyDesign.Calendar.MyDateChooser.CalendarButton();
        
        
        myButton2.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                if (window != null && window.isVisible()){
                     window.setVisible(false);
                }else{
                     window = new JWindow();
                    window.getContentPane().setLayout(null);
                    window.getContentPane().setBackground(Color.red);
                    myCalendar = new MyCalendar(myCalendar.getDate(), inter);
                    myCalendar.setBounds(0,0,210,250);
                    window.getContentPane().removeAll();
                    window.getContentPane().add(myCalendar);
                    window.setSize(210, 250);
                    window.setLocation(getLocationOnScreen().x,getLocationOnScreen().y + getHeight());    
                    window.setVisible(true);
                }
                
            }
            
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(myTextfield1, javax.swing.GroupLayout.PREFERRED_SIZE, 90, Short.MAX_VALUE)
                .addComponent(myButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(myButton2, javax.swing.GroupLayout.Alignment.TRAILING, 40, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(myTextfield1, javax.swing.GroupLayout.Alignment.TRAILING, 40, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public MyTextfield myTextfield1;
    // End of variables declaration//GEN-END:variables
   
    public Date getDate() {
    	return myCalendar.date;
    }
    
    public void  setDate(Date date) {
    	myCalendar.setDate(date);
    }
    class CalendarButton extends MyButton{
        private Color calendar_color_1 = Color.decode("#FF0000");
        private Color calendar_color_2 = Color.decode("#FFFFFF");
        
        public CalendarButton(){
            setContentAreaFilled(false);
            setOpaque(true);
               addMouseListener(new MouseAdapter(){
              @Override
                public void mouseEntered(java.awt.event.MouseEvent evt){
                   setForeground(Color.decode("#00CCCC"));
                    calendar_color_1 = Color.decode("#AA0000");
                    calendar_color_2 = Color.decode("#AAAAAA");
                }
                @Override
                public void mouseExited(java.awt.event.MouseEvent evt){
                    setForeground(Color.decode("#000000"));
                    calendar_color_1 = Color.decode("#FF0000");
                    calendar_color_2 = Color.decode("#FFFFFF");
                }   
        });
        }

        @Override
        public void paintComponent(Graphics grphcs) {
             super.paintComponent(grphcs);
             
             Graphics2D g2 = (Graphics2D) grphcs;
             g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            

             g2.setColor(calendar_color_1);
             g2.fillRect(10,10, 20, 5);
             
             g2.setColor(calendar_color_2);
             g2.fillRect(10,15, 20, 15);
             
               
        }
    }
}
