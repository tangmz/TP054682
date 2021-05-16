package Assignment;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import javax.swing.JLabel;
import javax.swing.Timer;

public class DateTime{
    private String Year, Month, Date, hour, Day, FullDate, PartialDate;

    public DateTime(){
        ClockTick();
    }

    private void ClockTick() {
//        ActionListener aL = new ActionListener(){
//            @Override
//            public void actionPerformed(ActionEvent ae) {
//                Date dateRead = new Date();
//                DateFormat timeFormat = new SimpleDateFormat("HH:mm:ss");
//                DateTime.this.setFullTime(timeFormat.format(dateRead));
//                System.out.println(DateTime.this.getFullTime());
//            }
//            
//        };
//        Timer timer = new Timer(1000, aL);
//        timer.setInitialDelay(0);
//        timer.start();
//            Calendar calendar = Calendar.getInstance();
//            Year = String.valueOf(calendar.get(Calendar.YEAR));
//            Month = String.valueOf(calendar.get(Calendar.MONTH));
//            Date = String.valueOf(calendar.get(Calendar.DATE));
//            hour = String.valueOf(calendar.get(Calendar.HOUR));
//            minute = String.valueOf(calendar.get(Calendar.DAY_OF_WEEK));
//            FullDate = (Year+"a"+Date+"b"+hour+"c"+minute);
        Date dateRead = new Date();
        DateFormat dayFormat = new SimpleDateFormat("EEEE");
        Day = dayFormat.format(dateRead);
        DateFormat yearFormat = new SimpleDateFormat("YYYY");
        Year = yearFormat.format(dateRead);
        DateFormat monthFormat = new SimpleDateFormat("MMMM");
        Month = monthFormat.format(dateRead);
        DateFormat dateFormat = new SimpleDateFormat("dd");
        Date = dateFormat.format(dateRead);
        DateFormat hourFormat = new SimpleDateFormat("HH");
        hour = hourFormat.format(dateRead);
        DateFormat partialDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        PartialDate = partialDateFormat.format(dateRead);
        FullDate = (Day+", "+Date+" "+Month+" "+Year);
    }
    public String getFullDate() {
        return FullDate;
    }
    
    public String getYear() {
        return Year;
    }

    public String getDate() {
        return Date;
    }

    public String getHour() {
        return hour;
    }

    public String getMonth() {
        return Month;
    }

    public String getDay() {
        return Day;
    }
    
    public String getPartialDate() {
        return PartialDate;
    }

    public void setPartialDate(String PartialDate) {
        this.PartialDate = PartialDate;
    }

}
