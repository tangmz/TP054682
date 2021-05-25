package Assignment;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

class ScheduleFunc  extends JPanel{
    
    private JPanel Top, ScheduleBody, ScheduleTopRow, ScheduleBottomRow, ButtonPanel, MonP, TueP, WedP, ThuP, FriP, SatP, SunP;
    private JButton Confirm, Delete;
    private JComboBox Month, Mon1Sch, Mon2Sch, Mon3Sch, Tue1Sch, Tue2Sch, Tue3Sch, Wed1Sch, Wed2Sch, Wed3Sch, 
            Thu1Sch, Thu2Sch, Thu3Sch, Fri1Sch, Fri2Sch, Fri3Sch, Sat1Sch, Sat2Sch, Sat3Sch, Sun1Sch, Sun2Sch, Sun3Sch;
    private JLabel MonthL, Mon1L, Mon2L, Mon3L, Tue1L, Tue2L, Tue3L, Wed1L, Wed2L, Wed3L, 
            Thu1L, Thu2L, Thu3L, Fri1L, Fri2L, Fri3L, Sat1L, Sat2L, Sat3L, Sun1L, Sun2L, Sun3L;
    private static ArrayList <String> sportsAvailable = new ArrayList <String>();
    private static ArrayList <String> Months = new ArrayList <String>();
    private static boolean Found=false;
    RegisteredAdmin Ad = new RegisteredAdmin();
    ScheduleFunc(){
        
        //++Filter Sports Name Found for Specific Center Only++//
        sportsAvailable.removeAll(sportsAvailable);
        for(int i = 0; i<Assignment.sportInfo.size();i++){
            Sport_Constr sp = Assignment.sportInfo.get(i);
            if(sp.getCenter().equals(RegisteredAdmin.centerLocation)&&!sp.getCoachN().equals("-")){
                sportsAvailable.add(sp.getSportN());
            }
        }
        
        //++Filter only current and future available Months++//
        Months.removeAll(Months);
        int month = Integer.parseInt(Ad.getPartialMonth());
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
        Mon1Sch = new JComboBox(sportsAvailable.toArray());
        Mon2Sch = new JComboBox(sportsAvailable.toArray());
        Mon3Sch = new JComboBox(sportsAvailable.toArray());
        Tue1Sch = new JComboBox(sportsAvailable.toArray());
        Tue2Sch = new JComboBox(sportsAvailable.toArray());
        Tue3Sch = new JComboBox(sportsAvailable.toArray());
        Wed1Sch = new JComboBox(sportsAvailable.toArray());
        Wed2Sch = new JComboBox(sportsAvailable.toArray());
        Wed3Sch = new JComboBox(sportsAvailable.toArray());
        Thu1Sch = new JComboBox(sportsAvailable.toArray());
        Thu2Sch = new JComboBox(sportsAvailable.toArray());
        Thu3Sch = new JComboBox(sportsAvailable.toArray());
        Fri1Sch = new JComboBox(sportsAvailable.toArray());
        Fri2Sch = new JComboBox(sportsAvailable.toArray());
        Fri3Sch = new JComboBox(sportsAvailable.toArray());
        Sat1Sch = new JComboBox(sportsAvailable.toArray());
        Sat2Sch = new JComboBox(sportsAvailable.toArray());
        Sat3Sch = new JComboBox(sportsAvailable.toArray());
        Sun1Sch = new JComboBox(sportsAvailable.toArray());
        Sun2Sch = new JComboBox(sportsAvailable.toArray());
        Sun3Sch = new JComboBox(sportsAvailable.toArray());
        
        Confirm = new JButton("Confirm");
        Delete = new JButton("Delete");
        Confirm.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                Schedule_Constr writeSch = new Schedule_Constr(Month.getSelectedItem().toString(),RegisteredAdmin.centerLocation,Mon1Sch.getSelectedItem().toString(),Mon2Sch.getSelectedItem().toString(),Mon3Sch.getSelectedItem().toString(),
                        Tue1Sch.getSelectedItem().toString(),Tue2Sch.getSelectedItem().toString(),Tue3Sch.getSelectedItem().toString(),Wed1Sch.getSelectedItem().toString(),Wed2Sch.getSelectedItem().toString(),
                        Wed3Sch.getSelectedItem().toString(),Thu1Sch.getSelectedItem().toString(),Thu2Sch.getSelectedItem().toString(),Thu3Sch.getSelectedItem().toString(),Fri1Sch.getSelectedItem().toString(),
                        Fri2Sch.getSelectedItem().toString(),Fri3Sch.getSelectedItem().toString(),Sat1Sch.getSelectedItem().toString(),Sat2Sch.getSelectedItem().toString(),Sat3Sch.getSelectedItem().toString(),
                        Sun1Sch.getSelectedItem().toString(),Sun2Sch.getSelectedItem().toString(),Sun3Sch.getSelectedItem().toString());
                
//                System.out.println(Found);
                for(int i = 0;i<Assignment.schedule.size();i++){
                    Schedule_Constr schedule = Assignment.schedule.get(i);
                    if(RegisteredAdmin.centerLocation.equals(schedule.getCenter())){
                        if(schedule.getSchMonth().equals(Month.getSelectedItem())){
                            Found = true;
                            Assignment.schedule.set(i, writeSch);   //replace existing data to new data first before write into file
                            break;
                        }else{
                            Found = false;
                        }
                    }else{
                        Found = false;
                    }
                }
                if(Found == false){
                    Assignment.schedule.add(writeSch);
                    try{
                        PrintWriter f = new PrintWriter("schedule.txt");
                        for(int i=0; i<Assignment.schedule.size(); i++){
                            Schedule_Constr s = Assignment.schedule.get(i);
                            f.println(s.getSchMonth());
                            f.println(s.getCenter());
                            f.println(s.getMon1());
                            f.println(s.getMon2());
                            f.println(s.getMon3());
                            f.println(s.getTue1());
                            f.println(s.getTue2());
                            f.println(s.getTue3());
                            f.println(s.getWed1());
                            f.println(s.getWed2());
                            f.println(s.getWed3());
                            f.println(s.getThu1());
                            f.println(s.getThu2());
                            f.println(s.getThu3());
                            f.println(s.getFri1());
                            f.println(s.getFri2());
                            f.println(s.getFri3());
                            f.println(s.getSat1());
                            f.println(s.getSat2());
                            f.println(s.getSat3());
                            f.println(s.getSun1());
                            f.println(s.getSun2());
                            f.println(s.getSun3());
                            f.println();
                        }
                        f.close();   

                    } catch(Exception ex){
                        System.out.println("Error in stop!");
                    }
                    JOptionPane.showMessageDialog(Confirm, "Schedule is Created!");
                }else if(Found == true){
                    try{
                        PrintWriter f = new PrintWriter("schedule.txt");
                        for(int i=0; i<Assignment.schedule.size(); i++){
                            Schedule_Constr s = Assignment.schedule.get(i);
                            f.println(s.getSchMonth());
                            f.println(s.getCenter());
                            f.println(s.getMon1());
                            f.println(s.getMon2());
                            f.println(s.getMon3());
                            f.println(s.getTue1());
                            f.println(s.getTue2());
                            f.println(s.getTue3());
                            f.println(s.getWed1());
                            f.println(s.getWed2());
                            f.println(s.getWed3());
                            f.println(s.getThu1());
                            f.println(s.getThu2());
                            f.println(s.getThu3());
                            f.println(s.getFri1());
                            f.println(s.getFri2());
                            f.println(s.getFri3());
                            f.println(s.getSat1());
                            f.println(s.getSat2());
                            f.println(s.getSat3());
                            f.println(s.getSun1());
                            f.println(s.getSun2());
                            f.println(s.getSun3());
                            f.println();
                        }
                        f.close();
                        Found = false;

                    } catch(Exception ex){
                        System.out.println("Error in stop!");
                    }
                    JOptionPane.showMessageDialog(Confirm, "Schedule is Updated!");
                }
                
            }
        });
        Delete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                for(int i = 0;i<Assignment.schedule.size();i++){
                    Schedule_Constr schedule = Assignment.schedule.get(i);
                    if(schedule.getSchMonth().equals(Month.getSelectedItem())){
                        Found = true;
                        Assignment.schedule.remove(i);   //remove existing data
                    }
                }
                if(Found == true){
                    try{
                        PrintWriter f = new PrintWriter("schedule.txt");
                        for(int i=0; i<Assignment.schedule.size(); i++){
                            Schedule_Constr s = Assignment.schedule.get(i);
                            f.println(s.getSchMonth());
                            f.println(s.getCenter());
                            f.println(s.getMon1());
                            f.println(s.getMon2());
                            f.println(s.getMon3());
                            f.println(s.getTue1());
                            f.println(s.getTue2());
                            f.println(s.getTue3());
                            f.println(s.getWed1());
                            f.println(s.getWed2());
                            f.println(s.getWed3());
                            f.println(s.getThu1());
                            f.println(s.getThu2());
                            f.println(s.getThu3());
                            f.println(s.getFri1());
                            f.println(s.getFri2());
                            f.println(s.getFri3());
                            f.println(s.getSat1());
                            f.println(s.getSat2());
                            f.println(s.getSat3());
                            f.println(s.getSun1());
                            f.println(s.getSun2());
                            f.println(s.getSun3());
                            f.println();
                        }
                        f.close();   

                    } catch(Exception ex){
                        System.out.println("Error in stop!");
                    }
                }else{
                    JOptionPane.showMessageDialog(Delete, "No Schedule Record Found!");
                }
            }
        });
        
        
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
        ScheduleBottomRow.setLayout(new FlowLayout(FlowLayout.CENTER, 30,1));
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
        ButtonPanel.add(Delete);
        ButtonPanel.add(Confirm);
        
        setLayout(new BorderLayout());
        add(Top, BorderLayout.NORTH);
        add(ScheduleBody, BorderLayout.CENTER);
        add(ButtonPanel, BorderLayout.SOUTH);
    }
}
