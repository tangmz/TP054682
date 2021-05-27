package Assignment;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
//To extract time
public class DateTime{
    private String Year, FullMonth, PartialMonth, Date, hour, Day, FullDate, PartialDate;
    
    public DateTime(){
        ClockTick();
    }
    //To read all the format such as day, year, month, date and hour
    private void ClockTick() {
        Calendar dateRead = Calendar.getInstance();
        DateFormat dayFormat = new SimpleDateFormat("EEEE");
        Day = dayFormat.format(dateRead.getTime());
        DateFormat yearFormat = new SimpleDateFormat("YYYY");
        Year = yearFormat.format(dateRead.getTime());
        DateFormat FullmonthFormat = new SimpleDateFormat("MMMM");
        FullMonth = FullmonthFormat.format(dateRead.getTime());
        DateFormat SimplemonthFormat = new SimpleDateFormat("M");
        PartialMonth = SimplemonthFormat.format(dateRead.getTime());
        DateFormat dateFormat = new SimpleDateFormat("dd");
        Date = dateFormat.format(dateRead.getTime());
        DateFormat hourFormat = new SimpleDateFormat("HH");
        hour = hourFormat.format(dateRead.getTime());
        DateFormat partialDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        PartialDate = partialDateFormat.format(dateRead.getTime());
        FullDate = (Day+", "+Date+" "+FullMonth+" "+Year);
    }
    //To get the data from other classes
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

    public String getFullMonth() {
        return FullMonth;
    }
    
    public String getPartialMonth() {
        return PartialMonth;
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
