package Assignment;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.TextField;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ViewSchedule extends JPanel{
    private JPanel Top, ScheduleBody, ScheduleTopRow, ScheduleBottomRow, ButtonPanel, MonP, TueP, WedP, ThuP, FriP, SatP, SunP;
    private JButton Confirm, Delete;
    private JComboBox Month;
    private JLabel MonthL, Mon1L, Mon2L, Mon3L, Tue1L, Tue2L, Tue3L, Wed1L, Wed2L, Wed3L, 
            Thu1L, Thu2L, Thu3L, Fri1L, Fri2L, Fri3L, Sat1L, Sat2L, Sat3L, Sun1L, Sun2L, Sun3L;
    private TextField Mon1Sch, Mon2Sch, Mon3Sch, Tue1Sch, Tue2Sch, Tue3Sch, Wed1Sch, Wed2Sch, Wed3Sch, 
            Thu1Sch, Thu2Sch, Thu3Sch, Fri1Sch, Fri2Sch, Fri3Sch, Sat1Sch, Sat2Sch, Sat3Sch, Sun1Sch, Sun2Sch, Sun3Sch;
    private static ArrayList <String> registeredSport = new ArrayList <String>();
    private static ArrayList <String> Months = new ArrayList <String>();
    private static boolean Found=false;
    private String sport;
    DateTime dT = new DateTime();
    public ViewSchedule(String cenLocation, String userName){
        
        //++Filter Sports Name Found for Specific Center Only++//
        for(int i = 0; i<Assignment.subscription.size();i++){
            Subscription_Constr sub = Assignment.subscription.get(i);
            if(sub.getSubscriptionLocation().equals(cenLocation)&&sub.getSubscriptionName().equals(userName)){
                sport = sub.getSubscriptionSport();
            }
        }
        
        //++Filter only current and future available Months++//
        int month = Integer.parseInt(dT.getPartialMonth());
        String[] monthString = new String[]{"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
        while(month<=12){
            Months.add(monthString[month-1]);
            month++;
        }
        
        //++Create Components++//
        MonthL = new JLabel("Schedule For Entire Month Of: ");
        
        Mon1L = new JLabel("10am ~ 12pm");
        Mon2L = new JLabel("1pm ~ 3pm");
        Mon3L = new JLabel("3pm ~ 5pm");
        Tue1L = new JLabel("10am ~ 12pm");
        Tue2L = new JLabel("1pm ~ 3pm");
        Tue3L = new JLabel("3pm ~ 5pm");
        Wed1L = new JLabel("10am ~ 12pm");
        Wed2L = new JLabel("1pm ~ 3pm");
        Wed3L = new JLabel("3pm ~ 5pm");
        Thu1L = new JLabel("10am ~ 12pm");
        Thu2L = new JLabel("1pm ~ 3pm");
        Thu3L = new JLabel("3pm ~ 5pm");
        Fri1L = new JLabel("10am ~ 12pm");
        Fri2L = new JLabel("1pm ~ 3pm");
        Fri3L = new JLabel("3pm ~ 5pm");
        Sat1L = new JLabel("10am ~ 12pm");
        Sat2L = new JLabel("1pm ~ 3pm");
        Sat3L = new JLabel("3pm ~ 5pm");
        Sun1L = new JLabel("10am ~ 12pm");
        Sun2L = new JLabel("1pm ~ 3pm");
        Sun3L = new JLabel("3pm ~ 5pm");
        
        Month = new JComboBox(Months.toArray());
        //TextField for the sport time
        Mon1Sch = new TextField();
        Mon1Sch.setEnabled(false);
        Mon2Sch = new TextField();
        Mon2Sch.setEnabled(false);
        Mon3Sch = new TextField();
        Mon3Sch.setEnabled(false);
        Tue1Sch = new TextField();
        Tue1Sch.setEnabled(false);
        Tue2Sch = new TextField();
        Tue2Sch.setEnabled(false);
        Tue3Sch = new TextField();
        Tue3Sch.setEnabled(false);
        Wed1Sch = new TextField();
        Wed1Sch.setEnabled(false);
        Wed2Sch = new TextField();
        Wed2Sch.setEnabled(false);
        Wed3Sch = new TextField();
        Wed3Sch.setEnabled(false);
        Thu1Sch = new TextField();
        Thu1Sch.setEnabled(false);
        Thu2Sch = new TextField();
        Thu2Sch.setEnabled(false);
        Thu3Sch = new TextField();
        Thu3Sch.setEnabled(false);
        Fri1Sch = new TextField();
        Fri1Sch.setEnabled(false);
        Fri2Sch = new TextField();
        Fri2Sch.setEnabled(false);
        Fri3Sch = new TextField();
        Fri3Sch.setEnabled(false);
        Sat1Sch = new TextField();
        Sat1Sch.setEnabled(false);
        Sat2Sch = new TextField();
        Sat2Sch.setEnabled(false);
        Sat3Sch = new TextField();
        Sat3Sch.setEnabled(false);
        Sun1Sch = new TextField();
        Sun1Sch.setEnabled(false);
        Sun2Sch = new TextField();
        Sun2Sch.setEnabled(false);
        Sun3Sch = new TextField();
        Sun3Sch.setEnabled(false);
        for(int i = 0; i<Assignment.schedule.size(); i++){
            Schedule_Constr schedule = Assignment.schedule.get(i);
            if(schedule.getCenter().equals(cenLocation)){
                if(schedule.getMon1().equals(sport)){
                    Mon1Sch.setText(sport);
                }
                if(schedule.getMon2().equals(sport)){
                    Mon2Sch.setText(sport);
                }
                if(schedule.getMon3().equals(sport)){
                    Mon3Sch.setText(sport);
                }
                if(schedule.getTue1().equals(sport)){
                    Tue1Sch.setText(sport);
                }
                if(schedule.getTue2().equals(sport)){
                    Tue2Sch.setText(sport);
                }
                if(schedule.getTue3().equals(sport)){
                    Tue3Sch.setText(sport);
                }
                if(schedule.getWed1().equals(sport)){
                    Wed1Sch.setText(sport);
                }
                if(schedule.getWed2().equals(sport)){
                    Wed2Sch.setText(sport);
                }
                if(schedule.getWed3().equals(sport)){
                    Wed3Sch.setText(sport);
                }
                if(schedule.getThu1().equals(sport)){
                    Thu1Sch.setText(sport);
                }
                if(schedule.getThu2().equals(sport)){
                    Thu2Sch.setText(sport);
                }
                if(schedule.getThu3().equals(sport)){
                    Thu3Sch.setText(sport);
                }
                if(schedule.getFri1().equals(sport)){
                    Fri1Sch.setText(sport);
                }
                if(schedule.getFri2().equals(sport)){
                    Fri2Sch.setText(sport);
                }
                if(schedule.getFri3().equals(sport)){
                    Fri3Sch.setText(sport);
                }
                if(schedule.getSat1().equals(sport)){
                    Sat1Sch.setText(sport);
                }
                if(schedule.getSat2().equals(sport)){
                    Sat2Sch.setText(sport);
                }
                if(schedule.getSat3().equals(sport)){
                    Sat3Sch.setText(sport);
                }
                if(schedule.getSun1().equals(sport)){
                    Sun1Sch.setText(sport);
                }
                if(schedule.getSun2().equals(sport)){
                    Sun2Sch.setText(sport);
                }
                if(schedule.getSun3().equals(sport)){
                    Sun3Sch.setText(sport);
                }
//            }
//            if(schedule.getMon2().equals(registeredSport.get(i))){
//                Mon2Sch.setSelectedItem(registeredSport.get(i));
                
            }
        }
        
        Top = new JPanel();
        Top.setLayout(new FlowLayout(FlowLayout.CENTER));
        Top.add(MonthL);
        Top.add(Month);
        
        GridLayout gL = new GridLayout(3,2);
        gL.setHgap(10);
        gL.setVgap(50);
        Dimension dim = new Dimension(300, 200);
        MonP = new JPanel();
        MonP.setBorder(BorderFactory.createTitledBorder("Monday"));
        MonP.setSize(dim);
        MonP.setLayout(gL);
        MonP.add(Mon1L);
        MonP.add(Mon1Sch);
        MonP.add(Mon2L);
        MonP.add(Mon2Sch);
        MonP.add(Mon3L);
        MonP.add(Mon3Sch);
        TueP = new JPanel();
        TueP.setBorder(BorderFactory.createTitledBorder("Tuesday"));
        TueP.setSize(dim);
        TueP.setLayout(gL);
        TueP.add(Tue1L);
        TueP.add(Tue1Sch);
        TueP.add(Tue2L);
        TueP.add(Tue2Sch);
        TueP.add(Tue3L);
        TueP.add(Tue3Sch);
        WedP = new JPanel();
        WedP.setBorder(BorderFactory.createTitledBorder("Wednesday"));
        WedP.setSize(dim);
        WedP.setLayout(gL);
        WedP.add(Wed1L);
        WedP.add(Wed1Sch);
        WedP.add(Wed2L);
        WedP.add(Wed2Sch);
        WedP.add(Wed3L);
        WedP.add(Wed3Sch);
        ThuP = new JPanel();
        ThuP.setBorder(BorderFactory.createTitledBorder("Thursday"));
        ThuP.setSize(dim);
        ThuP.setLayout(gL);
        ThuP.add(Thu1L);
        ThuP.add(Thu1Sch);
        ThuP.add(Thu2L);
        ThuP.add(Thu2Sch);
        ThuP.add(Thu3L);
        ThuP.add(Thu3Sch);
        FriP = new JPanel();
        FriP.setBorder(BorderFactory.createTitledBorder("Friday"));
        FriP.setSize(dim);
        FriP.setLayout(gL);
        FriP.add(Fri1L);
        FriP.add(Fri1Sch);
        FriP.add(Fri2L);
        FriP.add(Fri2Sch);
        FriP.add(Fri3L);
        FriP.add(Fri3Sch);
        SatP = new JPanel();
        SatP.setBorder(BorderFactory.createTitledBorder("Saturday"));
        SatP.setSize(dim);
        SatP.setLayout(gL);
        SatP.add(Sat1L);
        SatP.add(Sat1Sch);
        SatP.add(Sat2L);
        SatP.add(Sat2Sch);
        SatP.add(Sat3L);
        SatP.add(Sat3Sch);
        SunP = new JPanel();
        SunP.setBorder(BorderFactory.createTitledBorder("Sunday"));
        SunP.setSize(dim);
        SunP.setLayout(gL);
        SunP.add(Sun1L);
        SunP.add(Sun1Sch);
        SunP.add(Sun2L);
        SunP.add(Sun2Sch);
        SunP.add(Sun3L);
        SunP.add(Sun3Sch);
        
        ScheduleTopRow = new JPanel();
        ScheduleTopRow.setLayout(new FlowLayout(FlowLayout.CENTER, 5,1));
        ScheduleTopRow.add(MonP);
        ScheduleTopRow.add(TueP);
        ScheduleTopRow.add(WedP);
        ScheduleTopRow.add(ThuP);
        
        ScheduleBottomRow = new JPanel();
        ScheduleBottomRow.setLayout(new FlowLayout(FlowLayout.CENTER, 50,1));
        ScheduleBottomRow.add(FriP);
        ScheduleBottomRow.add(SatP);
        ScheduleBottomRow.add(SunP);
        
        ScheduleBody = new JPanel();
        ScheduleBody.setSize(new Dimension(this.getWidth(), 250));
        ScheduleBody.setLayout(new BorderLayout(2,25));
        ScheduleBody.add(ScheduleTopRow, BorderLayout.NORTH);
        ScheduleBody.add(ScheduleBottomRow, BorderLayout.CENTER);
        
        ButtonPanel = new JPanel();
        ButtonPanel.setLayout(new FlowLayout(FlowLayout.RIGHT, 20, 30));

        
        setLayout(new BorderLayout());
        add(Top, BorderLayout.NORTH);
        add(ScheduleBody, BorderLayout.CENTER);
        add(ButtonPanel, BorderLayout.SOUTH);
    }

}
