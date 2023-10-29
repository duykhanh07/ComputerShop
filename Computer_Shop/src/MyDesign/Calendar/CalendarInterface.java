package MyDesign.Calendar;

import java.util.Date;

public interface CalendarInterface {
     void changeDate(int value);
     void setDate(Date date);
     void newMonth(int forward);
}
