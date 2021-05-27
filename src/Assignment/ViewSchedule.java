package Assignment;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
//To allow user to view the registered sport schedule
public class ViewSchedule extends JPanel implements ActionListener{
    //Variable Declration
    private JPanel Top, ScheduleBody, ScheduleTopRow, ScheduleBottomRow, ButtonPanel, MonP, TueP, WedP, ThuP, FriP, SatP, SunP;
    private JButton search;
    private JComboBox selectMonth;
    private JLabel MonthL, Mon1L, Mon2L, Mon3L, Tue1L, Tue2L, Tue3L, Wed1L, Wed2L, Wed3L, 
            Thu1L, Thu2L, Thu3L, Fri1L, Fri2L, Fri3L, Sat1L, Sat2L, Sat3L, Sun1L, Sun2L, Sun3L;
    private TextField Mon1Sch, Mon2Sch, Mon3Sch, Tue1Sch, Tue2Sch, Tue3Sch, Wed1Sch, Wed2Sch, Wed3Sch, 
            Thu1Sch, Thu2Sch, Thu3Sch, Fri1Sch, Fri2Sch, Fri3Sch, Sat1Sch, Sat2Sch, Sat3Sch, Sun1Sch, Sun2Sch, Sun3Sch;
    private static ArrayList <String> registeredSport = new ArrayList <String>();
    private static ArrayList <String> months = new ArrayList <String>();
    private static ArrayList <String> sportType = new ArrayList <String>();
    private String location;
    RegisteredStudent dT = new RegisteredStudent();
    //To view the registered sport schedule
    public ViewSchedule(String cenLocation, String userName){
        location = cenLocation;
        //++Filter Sports Name Found for Specific Center Only++//
        for(int i = 0; i<Assignment.subscription.size();i++){
            Subscription_Constr sub = Assignment.subscription.get(i);
            if(sub.getSubscriptionLocation().equals(cenLocation)&&sub.getSubscriptionName().equals(userName)){
                sportType.add(sub.getSubscriptionSport());
            }
        }
        
        //++Filter only current and future available Months++//
        months.removeAll(months);
        int month = Integer.parseInt(dT.getPartialMonth());
        String[] monthString = new String[]{"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
        while(month<=12){
            months.add(monthString[month-1]);
            month++;
        }
        //Create buttons
        search = new JButton("Search");
        search.addActionListener(this);
        
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
        //ComboBox for the Months
        selectMonth = new JComboBox(months.toArray());
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
        
        Top = new JPanel();
        Top.setLayout(new FlowLayout(FlowLayout.CENTER));
        Top.add(MonthL);
        Top.add(selectMonth);
        Top.add(search);
        
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

    @Override
    public void actionPerformed(ActionEvent ae) {
        //To search the registered sport schedule
        if(ae.getSource()==search){
            //setText to empty when user search a new month
            Mon1Sch.setText("");
            Mon2Sch.setText("");
            Mon3Sch.setText("");
            Tue1Sch.setText("");
            Tue2Sch.setText("");
            Tue3Sch.setText("");
            Wed1Sch.setText("");
            Wed2Sch.setText("");
            Wed3Sch.setText("");
            Thu1Sch.setText("");
            Thu2Sch.setText("");
            Thu3Sch.setText("");
            Fri1Sch.setText("");
            Fri2Sch.setText("");
            Fri3Sch.setText("");
            Sat1Sch.setText("");
            Sat2Sch.setText("");
            Sat3Sch.setText("");
            Sun1Sch.setText("");
            Sun2Sch.setText("");
            Sun3Sch.setText("");
            //Find the sportType using for loop
            for(int counter = 0; counter< sportType.size(); counter++){
                for(int i = 0; i<Assignment.schedule.size(); i++){
                    Schedule_Constr schedule = Assignment.schedule.get(i);
                    //Check whether the Center and SchMonth are matched with the inputs
                    if(schedule.getCenter().equals(location)&&schedule.getSchMonth().equals(selectMonth.getSelectedItem().toString())){
                        //Get the data for each sports
                        if(schedule.getMon1().equals(sportType.get(counter))){
                            Mon1Sch.setText(sportType.get(counter));
                        }
                        if(schedule.getMon2().equals(sportType.get(counter))){
                            Mon2Sch.setText(sportType.get(counter));
                        }
                        if(schedule.getMon3().equals(sportType.get(counter))){
                            Mon3Sch.setText(sportType.get(counter));
                        }
                        if(schedule.getTue1().equals(sportType.get(counter))){
                            Tue1Sch.setText(sportType.get(counter));
                        }
                        if(schedule.getTue2().equals(sportType.get(counter))){
                            Tue2Sch.setText(sportType.get(counter));
                        }
                        if(schedule.getTue3().equals(sportType.get(counter))){
                            Tue3Sch.setText(sportType.get(counter));
                        }
                        if(schedule.getWed1().equals(sportType.get(counter))){
                            Wed1Sch.setText(sportType.get(counter));
                        }
                        if(schedule.getWed2().equals(sportType.get(counter))){
                            Wed2Sch.setText(sportType.get(counter));
                        }
                        if(schedule.getWed3().equals(sportType.get(counter))){
                            Wed3Sch.setText(sportType.get(counter));
                        }
                        if(schedule.getThu1().equals(sportType.get(counter))){
                            Thu1Sch.setText(sportType.get(counter));
                        }
                        if(schedule.getThu2().equals(sportType.get(counter))){
                            Thu2Sch.setText(sportType.get(counter));
                        }
                        if(schedule.getThu3().equals(sportType.get(counter))){
                            Thu3Sch.setText(sportType.get(counter));
                        }
                        if(schedule.getFri1().equals(sportType.get(counter))){
                            Fri1Sch.setText(sportType.get(counter));
                        }
                        if(schedule.getFri2().equals(sportType.get(counter))){
                            Fri2Sch.setText(sportType.get(counter));
                        }
                        if(schedule.getFri3().equals(sportType.get(counter))){
                            Fri3Sch.setText(sportType.get(counter));
                        }
                        if(schedule.getSat1().equals(sportType.get(counter))){
                            Sat1Sch.setText(sportType.get(counter));
                        }
                        if(schedule.getSat2().equals(sportType.get(counter))){
                            Sat2Sch.setText(sportType.get(counter));
                        }
                        if(schedule.getSat3().equals(sportType.get(counter))){
                            Sat3Sch.setText(sportType.get(counter));
                        }
                        if(schedule.getSun1().equals(sportType.get(counter))){
                            Sun1Sch.setText(sportType.get(counter));
                        }
                        if(schedule.getSun2().equals(sportType.get(counter))){
                            Sun2Sch.setText(sportType.get(counter));
                        }
                        if(schedule.getSun3().equals(sportType.get(counter))){
                            Sun3Sch.setText(sportType.get(counter));
                        }
                    }
                }
            }        
        }
    }

}
