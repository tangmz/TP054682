package Assignment;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class RegisteredAdmin extends DateTime{
    public static ArrayList <Coach_Constr> Coach = new ArrayList<Coach_Constr>();
    public static ArrayList <Schedule_Constr> Schedule = new ArrayList<Schedule_Constr>();
    public static ArrayList <Sport_Constr> Sport = new ArrayList<Sport_Constr>();
    public JPanel header, menuBody, displayBody, Tab1, Tab2, Tab3, Tab4;
    private int counter;
    public static String centerLocation;
    public Button AddModRecord, SearchRecord, CoachRecord, ScheduleB, manageSystem, logout; //SearchRecord inclusive of Sorting
    public boolean Check = true;
    
        
    public void FrameLoad(String UserName, String cenLocation, int counter){
        
        //++Read File++//
            
        Scanner s = null;
        try {
            s = new Scanner(new File("sport.txt"));
        } catch (FileNotFoundException ex) {
            System.out.println("Empty Read");
        }
            while(s.hasNext()){
                String sp1 = s.nextLine();
                String sp2 = s.nextLine();
                String sp3 = s.nextLine();
                String sp4 = s.nextLine();
                Sport_Constr sport_read = new Sport_Constr(sp1,sp2,sp3,sp4);
                Sport.add(sport_read);
            }
        s = null;
        try {
            s = new Scanner(new File("coach.txt"));
        } catch (FileNotFoundException ex) {
            System.out.println("Empty Read");
        }
            while(s.hasNext()){
                String c1 = s.nextLine();
                String c2 = s.nextLine();
                String c3 = s.nextLine();
                String c4 = s.nextLine();
                String c5 = s.nextLine();
                String c6 = s.nextLine();
                String c7 = s.nextLine();
                String c8 = s.nextLine();
                String c9 = s.nextLine();
                String c10 = s.nextLine();
                s.nextLine();
                Coach_Constr coach_read = new Coach_Constr(c1,c2,c3,c4,c5,c6,c7,c8,c9,c10);
                Coach.add(coach_read);
            }
            /////////////////////////////////NOT READY//////////////////////////
//        try {
//            s = new Scanner(new File("schedule.txt"));
//        } catch (FileNotFoundException ex) {
//            System.out.println("Empty Read");
//        }
//            while(s.hasNext()){
//                String sc1 = s.nextLine();
//                String sc2 = s.nextLine();
//                String sc3 = s.nextLine();
//                String sc4 = s.nextLine();
//                String sc5 = s.nextLine();
//                String sc6 = s.nextLine();
//                String sc7 = s.nextLine();
//                String sc8 = s.nextLine();
//                String sc9 = s.nextLine();
//                String sc10 = s.nextLine();
//                String sc11 = s.nextLine();
//                String sc12 = s.nextLine();
//                String sc13 = s.nextLine();
//                String sc14 = s.nextLine();
//                String sc15 = s.nextLine();
//                String sc16 = s.nextLine();
//                String sc17 = s.nextLine();
//                String sc18 = s.nextLine();
//                String sc19 = s.nextLine();
//                String sc20 = s.nextLine();
//                String sc21 = s.nextLine();
//                String sc22 = s.nextLine();
//                s.nextLine();
//                Schedule_Constr schedule_read = new Schedule_Constr(sc1,sc2,sc3,sc4,sc5,sc6,sc7,sc8,sc9,sc10,sc11,sc12,sc13,sc14,sc15,sc16,sc17,sc18,sc19,sc20,sc21,sc22);
//                Schedule.add(schedule_read);
//            }

        this.counter = counter;
        this.centerLocation = cenLocation;
        CardLayout cl = new CardLayout();
        //++Create JFrame++//
        JFrameFormat frame = new JFrameFormat(UserName);
        AdminAddFunc aa = new AdminAddFunc();
        AdminSearchFunc as = new AdminSearchFunc();
        ViewCoachFunc vc = new ViewCoachFunc();
        ScheduleFunc sch = new ScheduleFunc();
        frame.setVisible(true);
        frame.CenLocation.setSelectedItem(Location.valueOf(centerLocation));
        while(Check = true){
            Admin c = Assignment.adminInfo.get(this.counter);
            if("no".equals(c.getSuperRole())){
                frame.CenLocation.setEnabled(false);
                Check = false;
                break;
            } else{
                frame.CenLocation.setEnabled(true);
                Check = false;
                break;
            }
        }
        
        //++create Components++//
        logout = new Button("Logout");
        AddModRecord = new Button("Add/Modify Record");
        SearchRecord = new Button("Search Record");
        CoachRecord = new Button("View Coaches");
        ScheduleB = new Button("Sport Schedule");
        manageSystem = new Button("Manage System");
        frame.welcome.setText("Admin Panel");
        frame.setTitle("Admin Panel");
        
        //++Define Button Actions++//
        logout.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                frame.dispose();
                Assignment.login.setVisible(true);
            }
        });
        AddModRecord.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                cl.show(displayBody, "2");
            }
        });
        SearchRecord.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                cl.show(displayBody, "3");
            }
        });
        CoachRecord.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                cl.show(displayBody, "4");
            }
        });
        ScheduleB.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                cl.show(displayBody, "5");
            }
        });
        manageSystem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                cl.show(displayBody, "1");
            }
        });
        
        
        //++Design Panels and Layout++//
        //menu//
        menuBody = new JPanel();
        menuBody.setLayout(new GridLayout(6,1));
        menuBody.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY, 3));
        menuBody.setPreferredSize(new Dimension(150, frame.getHeight()));
        menuBody.add(AddModRecord);
        menuBody.add(SearchRecord);
        menuBody.add(CoachRecord);
        menuBody.add(ScheduleB);
        menuBody.add(manageSystem);
        menuBody.add(logout);
        //Body//
        displayBody = new JPanel();
        displayBody.setLayout(cl);
        Tab1 = new JPanel();
        Tab1.setLayout(new BorderLayout());
        Tab1.add(aa);
        Tab2 = new JPanel();
        Tab2.setLayout(new BorderLayout());
        Tab2.add(as);
        Tab3 = new JPanel();
        Tab3.setLayout(new BorderLayout());
        Tab3.add(vc);
        Tab4 = new JPanel();
        Tab4.setLayout(new BorderLayout());
        Tab4.add(sch);
        displayBody.setBorder(BorderFactory.createMatteBorder(3 , 0 , 3 , 3 ,Color.DARK_GRAY));
        JLabel time = new JLabel(String.valueOf(getFullDate()), SwingConstants.CENTER);
        time.setFont(new Font("Arial", Font.BOLD, 60));
//        AdminAddFunc aa = new AdminAddFunc();
        //add Panels to JFrameFormat()//
        displayBody.add(time, "1");
        displayBody.add(Tab1, "2");
        displayBody.add(Tab2, "3");
        displayBody.add(Tab3, "4");
        displayBody.add(Tab4, "5");
        cl.show(displayBody, "1");
        frame.Body.add(menuBody, BorderLayout.WEST);
        frame.Body.add(displayBody, BorderLayout.CENTER);
    }
}
