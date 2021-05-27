package Assignment;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.PrintWriter;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

//The main panel for Admin 
public class RegisteredAdmin extends DateTime{
    public static JPanel header, menuBody, displayBody, Tab1, Tab2, Tab3, Tab4, Tab5;
    private int counter;
    public static String centerLocation;
    public JButton AddModRecord, SearchRecord, CoachRecord, ScheduleB, manageSystem, logout; //SearchRecord inclusive of Sorting
    public boolean Check = true;
    public static String Username;
    private static ImageIcon AddModRecordLogo,SearchRecordLogo,CoachRecordLogo,ScheduleLogo,ManageSystemLogo,LogoutLogo;
    
    public void FrameLoad(String UserName, String cenLocation, int counter){
        //Variable Declaration
        RegisteredAdmin.Username = UserName;
        this.counter = counter;
        RegisteredAdmin.centerLocation = cenLocation;
        CardLayout cl = new CardLayout();
        
        //++Create JFrame++//
        JFrameFormat frame = new JFrameFormat(UserName);
        AdminAddFunc aa = new AdminAddFunc();
        AdminSearchFunc as = new AdminSearchFunc();
        ViewCoachFunc vc = new ViewCoachFunc();
        ScheduleFunc sch = new ScheduleFunc();
        AdminManageSystem adMS = new AdminManageSystem();
        frame.setVisible(true);
        //Set the location from the enum
        frame.CenLocation.setSelectedItem(Location.valueOf(centerLocation));
        while(Check == true){
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
        LogoutLogo = new ImageIcon(new ImageIcon(this.getClass().getResource("/PicLibrary/logout.png")).getImage().getScaledInstance(40, 40, Image.SCALE_SMOOTH));
        logout = new JButton("Logout",LogoutLogo);
        logout.setBackground(Color.WHITE);
        AddModRecordLogo = new ImageIcon(new ImageIcon(this.getClass().getResource("/PicLibrary/record.png")).getImage().getScaledInstance(40, 40, Image.SCALE_SMOOTH));
        AddModRecord = new JButton("Add/Modify Record",AddModRecordLogo);
        AddModRecord.setBackground(Color.WHITE);
        SearchRecordLogo = new ImageIcon(new ImageIcon(this.getClass().getResource("/PicLibrary/search.png")).getImage().getScaledInstance(40, 40, Image.SCALE_SMOOTH));
        SearchRecord = new JButton("Search Record", SearchRecordLogo);
        SearchRecord.setBackground(Color.WHITE);
        CoachRecordLogo = new ImageIcon(new ImageIcon(this.getClass().getResource("/PicLibrary/coach.png")).getImage().getScaledInstance(40, 40, Image.SCALE_SMOOTH));
        CoachRecord = new JButton("Coaches",CoachRecordLogo);
        CoachRecord.setBackground(Color.WHITE);
        ScheduleLogo = new ImageIcon(new ImageIcon(this.getClass().getResource("/PicLibrary/schedule.png")).getImage().getScaledInstance(40, 40, Image.SCALE_SMOOTH));
        ScheduleB = new JButton("Sport Schedule",ScheduleLogo);
        ScheduleB.setBackground(Color.WHITE);
        ManageSystemLogo = new ImageIcon(new ImageIcon(this.getClass().getResource("/PicLibrary/changePassword.png")).getImage().getScaledInstance(40, 40, Image.SCALE_SMOOTH));
        manageSystem = new JButton("Manage System",ManageSystemLogo);
        manageSystem.setBackground(Color.WHITE);
        frame.welcome.setText("Admin Panel");
        frame.setTitle("Admin Panel");
        
        //++Define Button Actions++//
        logout.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                try{
                    PrintWriter f = new PrintWriter("adminLogin.txt");
                    for(int i=0; i<Assignment.adminInfo.size(); i++){
                        Admin c = Assignment.adminInfo.get(i);
                        f.println(c.getAdId());
                        f.println(c.getAdUserN());
                        f.println(c.getAdPass());
                        f.println(c.getAdName());
                        f.println(c.getAdPlace());
                        f.println(c.getAdGender());
                        f.println(c.getAdPhone());
                        f.println(c.getSuperRole());
                        f.println();
                    }
                    f.close();   
                    
                } catch(Exception ex){
                    System.out.println("Error in stop!");
                }
                try{
                    PrintWriter f = new PrintWriter("studentLogin.txt");
                    for(int i=0; i<Assignment.studentInfo.size(); i++){
                        Student c = Assignment.studentInfo.get(i);
                        f.println(c.getStuID());
                        f.println(c.getStuName());
                        f.println(c.getStuUserN());
                        f.println(c.getStuPass());
                        f.println(c.getStuPlace());
                        f.println(c.getStuGender());
                        f.println(c.getStuPhone());
                        f.println();
                    }
                    f.close();   
                    
                } catch(Exception ex){
                    System.out.println("Error in stop!");
                }
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
                cl.show(displayBody, "6");
            }
        });
        
        
        //++Design Panels and Layout++//
        //menu//
        menuBody = new JPanel();
        menuBody.setLayout(new GridLayout(6,1));
        menuBody.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY, 3));
        menuBody.setPreferredSize(new Dimension(190, frame.getHeight()));
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
        Tab5 = new JPanel();
        Tab5.setLayout(new BorderLayout());
        Tab5.add(adMS);
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
        displayBody.add(Tab5, "6");
        cl.show(displayBody, "1");
        frame.Body.add(menuBody, BorderLayout.WEST);
        frame.Body.add(displayBody, BorderLayout.CENTER);
        
        frame.CenLocation.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                if(frame.CenLocation.getSelectedItem().equals(Location.Putrajaya)){
                    RegisteredAdmin.centerLocation = Location.Putrajaya.toString();
                    Repaint repaint = new Repaint();
                }else if(frame.CenLocation.getSelectedItem().equals(Location.BukitJalil)){
                    RegisteredAdmin.centerLocation = Location.BukitJalil.toString();
                    Repaint repaint = new Repaint();
                }
                else if(frame.CenLocation.getSelectedItem().equals(Location.PetalingJaya)){
                    RegisteredAdmin.centerLocation = Location.PetalingJaya.toString();
                    Repaint repaint = new Repaint();
                }
                else if(frame.CenLocation.getSelectedItem().equals(Location.ShahAlam)){
                    RegisteredAdmin.centerLocation = Location.ShahAlam.toString();
                    Repaint repaint = new Repaint();
                }
            }
        });
    }

    public static class Repaint {

        public Repaint() {
            Tab1.removeAll();
            Tab2.removeAll();
            Tab3.removeAll();
            Tab4.removeAll();
            Tab5.removeAll();
            AdminAddFunc aa = new AdminAddFunc();
            AdminSearchFunc as = new AdminSearchFunc();
            ViewCoachFunc vc = new ViewCoachFunc();
            ScheduleFunc sch = new ScheduleFunc();
            AdminManageSystem adMS = new AdminManageSystem();
            Tab1.add(aa);
            Tab1.revalidate();
            Tab1.repaint();
            Tab2.add(as);
            Tab2.revalidate();
            Tab2.repaint();
            Tab3.add(vc);
            Tab3.revalidate();
            Tab3.repaint();
            Tab4.add(sch);
            Tab4.revalidate();
            Tab4.repaint();
            Tab5.add(adMS);
            Tab5.revalidate();
            Tab5.repaint();
        }
    }
}
