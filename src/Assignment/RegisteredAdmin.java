package Assignment;

import java.awt.BorderLayout;
import java.awt.Button;
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
    
    public JPanel header, menuBody, displayBody;
    public String user;
    public Button AddRecord, ModifyRecord, ViewRecord, SearchRecord, manageSystem, logout; //SearchRecord inclusive of Sorting
    
    public void FrameLoad(String UserName){
        
        //++Create JFrame++//
        JFrameFormat frame = new JFrameFormat(UserName);
        frame.setVisible(true);
        
        //++create Components++//
        logout = new Button("Logout");
        AddRecord = new Button("Add Records");
        ModifyRecord = new Button("Modify Records");
        ViewRecord = new Button("View Records");
        SearchRecord = new Button("Search Records");
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
        AddRecord.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                displayBody.removeAll();
                AdminAddFunc a = new AdminAddFunc();
                displayBody.add(a);
                displayBody.repaint();
            }
        });
        ModifyRecord.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                
            }
        });
        ViewRecord.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                
            }
        });
        SearchRecord.addActionListener(new ActionListener() {
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
        menuBody = new JPanel();
        menuBody.setLayout(new GridLayout(6,1));
        menuBody.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY, 3));
        menuBody.setPreferredSize(new Dimension(150, frame.getHeight()));
        menuBody.add(AddRecord);
        menuBody.add(ModifyRecord);
        menuBody.add(ViewRecord);
        menuBody.add(SearchRecord);
        menuBody.add(manageSystem);
        menuBody.add(logout);
        displayBody = new JPanel();
        displayBody.setLayout(new BorderLayout());
        displayBody.setBorder(BorderFactory.createMatteBorder(3 , 0 , 3 , 3 ,Color.DARK_GRAY));
        JLabel time = new JLabel(String.valueOf(getFullDate()), SwingConstants.CENTER);
        time.setFont(new Font("Arial", Font.BOLD, 60));
        displayBody.add(time, BorderLayout.CENTER);
        frame.Body.add(menuBody, BorderLayout.WEST);
        frame.Body.add(displayBody, BorderLayout.CENTER);
    }
}
