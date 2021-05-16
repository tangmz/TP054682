package Assignment;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

class ScheduleFunc  extends JPanel{
    
    private JPanel Top, ScheduleBody, ScheduleTopRow, ScheduleBottomRow, ButtonPanel, MonP, TueP, WedP, ThuP, FriP, SatP, SunP;
    private JButton Confirm, Delete;
    private JComboBox Month, Mon1Sch, Mon2Sch, Mon3Sch, Tue1Sch, Tue2Sch, Tue3Sch, Wed1Sch, Wed2Sch, Wed3Sch, 
            Thu1Sch, Thu2Sch, Thu3Sch, Fri1Sch, Fri2Sch, Fri3Sch, Sat1Sch, Sat2Sch, Sat3Sch, Sun1Sch, Sun2Sch, Sun3Sch;
    private JLabel MonthL, Mon1L, Mon2L, Mon3L, Tue1L, Tue2L, Tue3L, Wed1L, Wed2L, Wed3L, 
            Thu1L, Thu2L, Thu3L, Fri1L, Fri2L, Fri3L, Sat1L, Sat2L, Sat3L, Sun1L, Sun2L, Sun3L;
    DateTime dT = new DateTime();
    ScheduleFunc(){
        
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
        
        Month = new JComboBox();
        Mon1Sch = new JComboBox();
        Mon2Sch = new JComboBox();
        Mon3Sch = new JComboBox();
        Tue1Sch = new JComboBox();
        Tue2Sch = new JComboBox();
        Tue3Sch = new JComboBox();
        Wed1Sch = new JComboBox();
        Wed2Sch = new JComboBox();
        Wed3Sch = new JComboBox();
        Thu1Sch = new JComboBox();
        Thu2Sch = new JComboBox();
        Thu3Sch = new JComboBox();
        Fri1Sch = new JComboBox();
        Fri2Sch = new JComboBox();
        Fri3Sch = new JComboBox();
        Sat1Sch = new JComboBox();
        Sat2Sch = new JComboBox();
        Sat3Sch = new JComboBox();
        Sun1Sch = new JComboBox();
        Sun2Sch = new JComboBox();
        Sun3Sch = new JComboBox();
        
        Confirm = new JButton("Confirm");
        Delete = new JButton("Delete");
        
        
        Top = new JPanel();
        Top.setLayout(new FlowLayout(FlowLayout.CENTER));
        Top.add(MonthL);
        Top.add(Month);
        
        GridLayout gL = new GridLayout(3,2);
        gL.setHgap(5);
        gL.setVgap(50);
        Dimension dim = new Dimension(200, 100);
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
        ScheduleTopRow.setLayout(new FlowLayout(FlowLayout.CENTER, 10,1));
        ScheduleTopRow.add(MonP);
        ScheduleTopRow.add(TueP);
        ScheduleTopRow.add(WedP);
        ScheduleTopRow.add(ThuP);
        
        ScheduleBottomRow = new JPanel();
        ScheduleBottomRow.setLayout(new FlowLayout(FlowLayout.CENTER, 20,1));
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
