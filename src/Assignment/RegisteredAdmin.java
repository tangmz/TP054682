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
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class RegisteredAdmin extends DateTime{
    
    public JPanel header, menuBody, displayBody, Tab1, Tab2, Tab3, Tab4;
    public String user;
    public Button AddModRecord, SearchRecord, CoachRecord, Schedule, manageSystem, logout; //SearchRecord inclusive of Sorting
    
    public void FrameLoad(String UserName){
        
        CardLayout cl = new CardLayout();
        //++Create JFrame++//
        JFrameFormat frame = new JFrameFormat(UserName);
        frame.setVisible(true);
        AdminAddFunc aa = new AdminAddFunc();
        
        //++create Components++//
        logout = new Button("Logout");
        AddModRecord = new Button("Add/Modify Record");
        SearchRecord = new Button("Search Record");
        CoachRecord = new Button("View Coaches");
        Schedule = new Button("Sport Schedule");
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
                cl.show(displayBody, "1");
            }
        });
        CoachRecord.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                
            }
        });
        Schedule.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                
            }
        });
        manageSystem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                
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
        menuBody.add(Schedule);
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
//        Tab2.add(aa);
        Tab3 = new JPanel();
        Tab3.setLayout(new BorderLayout());
//        Tab3.add(aa);
        Tab4 = new JPanel();
        Tab4.setLayout(new BorderLayout());
//        Tab4.add(aa);
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
