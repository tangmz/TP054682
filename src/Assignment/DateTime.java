package Assignment;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;

public class DateTime{
    private int Year, Date, hour, minute;
    private String Month, Day, FullDate, FullTime;

    public DateTime(){
        ClockTick();
    }

    private void ClockTick() {
//        while(true){
            Calendar calendar = Calendar.getInstance();
            Year = calendar.get(Calendar.YEAR);
            Date = calendar.get(Calendar.DATE);
            hour = calendar.get(Calendar.HOUR);
            minute = calendar.get(Calendar.MINUTE);
            FullDate = (Year+"a"+Date+"b"+hour+"c"+minute);
//            try{
//                Thread.sleep(1000);
//            }catch(InterruptedException ex){}
//        }
    }

    public int getYear() {
        return Year;
    }

    public int getDate() {
        return Date;
    }

    public int getHour() {
        return hour;
    }

    public int getMinute() {
        return minute;
    }

    public String getMonth() {
        return Month;
    }

    public String getDay() {
        return Day;
    }
    
    public String getFullDate() {
        return FullDate;
    }

    public String getFullTime() {
        return FullTime;
    }

}
