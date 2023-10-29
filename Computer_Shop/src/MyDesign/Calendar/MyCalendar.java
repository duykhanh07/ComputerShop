
package MyDesign.Calendar;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.LayoutManager;
import java.awt.Panel;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseListener;
import java.util.Date;
import javax.swing.Action;
import javax.swing.JApplet;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.SwingConstants;

/**
 *
 * @author ACER
 */
public class MyCalendar extends javax.swing.JPanel implements CalendarInterface{
     
    private CalendarInterface inter;
    
    public  Date date;
    public int month;
    public int year;
    public int dateNumOfMonth;
    public int firstDayOfMonthInWeek;
    
    String[] months = {"January","February","March","April","May","June","July","August","Septemper","October","November","December"};
    
    @Override
    public void setDate(Date date){
        this.inter.setDate(date);
    }
    
    public Date getDate(){
        return this.date;
    }
    
    @Override
    public void changeDate(int value){
        this.inter.changeDate(value);
    }
    @Override
    public void newMonth(int forward){
        this.inter.newMonth(forward);
    }
    
    public void initCalendar(){
        initMonthYear();
        initDates();
    }
    
    public void initMonthYear(){
        previousMonth_btn.setContentAreaFilled(false);
        previousMonth_btn.addMouseListener(new MouseAdapter(){
                @Override
                public void mouseEntered(java.awt.event.MouseEvent evt){
                    previousMonth_btn.setForeground(Color.decode("#00CCCC"));
                }
                @Override
                public void mouseExited(java.awt.event.MouseEvent evt){
                    previousMonth_btn.setForeground(Color.decode("#000000"));
                }   
        });
        previousMonth_btn.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                newMonth(0);
            } 
        });
        
        
        nextMonth_btn.setContentAreaFilled(false);
        nextMonth_btn.addMouseListener(new MouseAdapter(){
                @Override
                public void mouseEntered(java.awt.event.MouseEvent evt){
                    nextMonth_btn.setForeground(Color.decode("#00CCCC"));
                }
                @Override
                public void mouseExited(java.awt.event.MouseEvent evt){
                   nextMonth_btn.setForeground(Color.decode("#000000"));
                }   
        });
        nextMonth_btn.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                newMonth(1);
               
            } 
        });
        
        
        monthYear_label.setText(months[this.month]+" - "+(this.year+1900));
    }
    
    public void initDates(){
    	System.out.println("initDates");
    	
        this.jPanel2.removeAll();
        this.jPanel2 = new JPanel();
        this.jPanel2.setLayout(null);
        this.jPanel2.setBounds(0, 70, 210, 290);
        this.add(jPanel2);

        int start_blank_count = 0;
        
        this.dateNumOfMonth = getDatesNumOfMonth();
        this.firstDayOfMonthInWeek = new Date(this.year, this.month, 1).getDay();
        
        if ( this.firstDayOfMonthInWeek == 0){
             start_blank_count = 6;
            for(int i = 0; i< 6; i++){
                DayButton button = new DayButton(0, this);
                button.setBounds(i*30,0,30,30);
                this.jPanel2.add(button);
            }
        } else{
            start_blank_count = this.firstDayOfMonthInWeek-1;
             for(int i = 0; i< this.firstDayOfMonthInWeek-1; i++){
               DayButton button = new DayButton(0, this);
                button.setBounds(i*30,0,30,30);
                this.jPanel2.add(button);
            }
        }
        
        for(int i =0; i<this.dateNumOfMonth; i++){
             DayButton button = new DayButton(i+1, this);
              button.setBounds((start_blank_count + i)%7 *30, (int)((start_blank_count + i)/7)*30,30,30);
              this.jPanel2.add(button);
        }
        
        while((this.dateNumOfMonth + start_blank_count)%7!=0){
                DayButton button = new DayButton(0, this);
                button.setBounds((this.dateNumOfMonth + start_blank_count)%7*30,(this.dateNumOfMonth + start_blank_count)/7*30,30,30);
                this.jPanel2.add(button);
                start_blank_count +=1; 
        }
      jPanel2.revalidate();
      jPanel2.repaint();
    }
    
    public MyCalendar() {
       init();
       setDate(new Date(System.currentTimeMillis()));
       initCalendar();
       revalidate();    
       repaint();
    }
    
    public MyCalendar(CalendarInterface inter) {
       this.inter = inter;
       init();
        this.date = new Date(System.currentTimeMillis());
       initCalendar();
       revalidate();    
       repaint();
    }
    public MyCalendar(Date date, CalendarInterface inter){
       this.inter = inter;
       init();
       this.date = date;
       this.month = date.getMonth();
       this.year = date.getYear();
       initCalendar();
       revalidate();    
       repaint();
    }
    
    public void init(){
        jPanel1 = new javax.swing.JPanel();
        nextMonth_btn = new javax.swing.JButton();
        previousMonth_btn = new javax.swing.JButton();
        monthYear_label = new javax.swing.JLabel();
        monLabel = new javax.swing.JLabel();
        monLabel1 = new javax.swing.JLabel();
        monLabel2 = new javax.swing.JLabel();
        monLabel3 = new javax.swing.JLabel();
        monLabel4 = new javax.swing.JLabel();
        monLabel5 = new javax.swing.JLabel();
        monLabel6 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();

        setPreferredSize(new java.awt.Dimension(210, 220));
        setLayout(null);

        jPanel1.setBackground(new java.awt.Color(255, 255, 102));
        jPanel1.setLayout(null);

        nextMonth_btn.setFont(new Font("Segoe UI", Font.PLAIN, 10)); // NOI18N
        nextMonth_btn.setText(">");
        nextMonth_btn.setBounds(170, 0, 40, 40);
        jPanel1.add(nextMonth_btn);

        previousMonth_btn.setFont(new Font("Segoe UI", Font.PLAIN, 10)); // NOI18N
        previousMonth_btn.setText("<");
        previousMonth_btn.setToolTipText("");
        previousMonth_btn.setBounds(0, 0, 40, 40);
        jPanel1.add(previousMonth_btn);

        monthYear_label.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        monthYear_label.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        monthYear_label.setBounds(40, 0, 130, 40);
        jPanel1.add(monthYear_label);
        
        jPanel1.setBounds(0, 0, 210, 40);
        add(jPanel1);

        monLabel.setBackground(new java.awt.Color(102, 102, 102));
        monLabel.setForeground(new java.awt.Color(255, 0, 0));
        monLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        monLabel.setText("Sun");
        monLabel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        monLabel.setOpaque(true);
        monLabel.setBounds(180, 40, 30, 30);
        add(monLabel);

        monLabel1.setBackground(new java.awt.Color(102, 102, 102));
        monLabel1.setForeground(new java.awt.Color(255, 255, 255));
        monLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        monLabel1.setText("Mo");
        monLabel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        monLabel1.setOpaque(true);
        monLabel1.setBounds(0, 40, 30, 30);
        add(monLabel1);

        monLabel2.setBackground(new java.awt.Color(102, 102, 102));
        monLabel2.setForeground(new java.awt.Color(255, 255, 255));
        monLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        monLabel2.setText("Tu");
        monLabel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        monLabel2.setOpaque(true);
        monLabel2.setBounds(30, 40, 30, 30);
        add(monLabel2);

        monLabel3.setBackground(new java.awt.Color(102, 102, 102));
        monLabel3.setForeground(new java.awt.Color(255, 255, 255));
        monLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        monLabel3.setText("We");
        monLabel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        monLabel3.setOpaque(true);
        monLabel3.setBounds(60, 40, 30, 30);
        add(monLabel3);

        monLabel4.setBackground(new java.awt.Color(102, 102, 102));
        monLabel4.setForeground(new java.awt.Color(255, 255, 255));
        monLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        monLabel4.setText("Thu");
        monLabel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        monLabel4.setOpaque(true);
        monLabel4.setBounds(90, 40, 30, 30);
        add(monLabel4);

        monLabel5.setBackground(new java.awt.Color(102, 102, 102));
        monLabel5.setForeground(new java.awt.Color(255, 255, 255));
        monLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        monLabel5.setText("Fri");
        monLabel5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        monLabel5.setOpaque(true);
        monLabel5.setBounds(120, 40, 30, 30);
        add(monLabel5);

        monLabel6.setBackground(new java.awt.Color(102, 102, 102));
        monLabel6.setForeground(new java.awt.Color(255, 255, 255));
        monLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        monLabel6.setText("Sat");
        monLabel6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        monLabel6.setOpaque(true);
        monLabel6.setBounds(150, 40, 30, 30);
        add(monLabel6);
    }
    
    

    


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel monLabel;
    private javax.swing.JLabel monLabel1;
    private javax.swing.JLabel monLabel2;
    private javax.swing.JLabel monLabel3;
    private javax.swing.JLabel monLabel4;
    private javax.swing.JLabel monLabel5;
    private javax.swing.JLabel monLabel6;
    private javax.swing.JLabel monthYear_label;
    private javax.swing.JButton nextMonth_btn;
    private javax.swing.JButton previousMonth_btn;
    // End of variables declaration//GEN-END:variables
    public JLabel getMonthYearLabel(){
        return this.monthYear_label;
    }
    public JPanel getDatePanel(){
        return this.jPanel2;
    }
    
    public int getDatesNumOfMonth(){
        switch ((this.month+1)) {
            case 1:  return 31; 
            case 3:  return 31; 
            case 5:  return 31; 
            case 7:  return 31; 
            case 8:  return 31; 
            case 10:  return 31; 
            case 12:  return 31; 
            case 4: return 30;
            case 6:  return 30;
            case 9:  return 30; 
            case 11:  return 30;
            case 2:
                if (this.year%400==0 || (this.year%400!=0 && this.year %4==0)) 
                    return 29;
                else
                    return 28;
        }
        return 0;
    }
    public static void main(String[] args) {
        Date date = new Date(System.currentTimeMillis());
        System.out.println(date.getDay());
        System.out.println(date.getDate() + "/" + (date.getMonth()+1) +"/"+ (date.getYear()+1900));
    }

}
class DayButton extends javax.swing.JButton{
        private int value;
        private boolean selected;
        private MyCalendar calendar;
        
        public DayButton(int value, MyCalendar calendar){
            this.calendar = calendar;
            this.setSize(30, 30);
            this.setContentAreaFilled(false);
            this.setBorderPainted(false);
            this.setFocusPainted(false);
            this.value = value;
            this.setBackground(Color.decode("#666666"));
            this.setForeground(Color.decode("#00CCCC"));
            this.setBorder(new LineBorder(Color.black,1));
            this.setFont(new Font("Segoe UI", Font.PLAIN, 12));
            if (value != 0){
                this.setText(this.value+"");
                this.addMouseListener(new MouseAdapter(){
                    @Override
                    public void mouseEntered(java.awt.event.MouseEvent evt){
                            setBackground(Color.decode("#999999"));
                            setForeground(Color.decode("#00FFFF"));
                    }
                    @Override
                    public void mouseExited(java.awt.event.MouseEvent evt){
                             setBackground(Color.decode("#666666"));
                             setForeground(Color.decode("#00CCCC"));
                    }
                });
                this.addActionListener(new ActionListener(){
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        calendar.changeDate(value);
                    }
                });
            }
           else
                this.setText("");
        }
        
        @Override
    public void paintComponent(Graphics grphcs) {
        Graphics2D g2 = (Graphics2D) grphcs;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        
         g2.setColor(Color.decode("#000000"));
        g2.fillRoundRect(0, 0, this.getWidth() , this.getHeight(), 0, 0);
        
        g2.setColor(this.getBackground());
        g2.fillRoundRect(1, 1, this.getWidth() - 2, this.getHeight() - 2, 5, 5);
        
        if (this.value == this.calendar.getDate().getDate() && this.calendar.month == this.calendar.getDate().getMonth() && this.calendar.year == this.calendar.getDate().getYear()){
            g2.setColor(Color.decode("#FFFF66"));
             g2.fillRoundRect(1, 1, this.getWidth() - 2, this.getHeight() - 2, 20, 20);
        }
        
        super.paintComponent(grphcs);
       
    }
}
