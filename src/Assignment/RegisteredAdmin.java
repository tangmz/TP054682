package Assignment;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class RegisteredAdmin extends DateTime{
    
    private JPanel header, menuBody, displayBody;
    private String user;
    private Button AddRecord, ModifyRecord, ViewRecord, SearchRecord, manageSystem, logout; //SearchRecord inclusive of Sorting
    
    public void FrameLoad(String UserName){
        //++Logout Button++//
        JFrameFormat frame = new JFrameFormat(UserName);
        frame.setVisible(true);
        logout = new Button("Logout");
        logout.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                frame.dispose();
                Assignment.login.setVisible(true);
            }
        });
        AddRecord = new Button("Add Records");
        AddRecord.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                
            }
        });
        ModifyRecord = new Button("Modify Records");
        ModifyRecord.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                
            }
        });
        ViewRecord = new Button("View Records");
        ViewRecord.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                
            }
        });
        SearchRecord = new Button("Search Records");
        SearchRecord.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                
            }
        });
        manageSystem = new Button("Manage System");
        manageSystem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                
            }
        });
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
        displayBody.setBorder(BorderFactory.createMatteBorder(3 , 0 , 3 , 3 ,Color.DARK_GRAY));
        JLabel time = new JLabel();
        time.setText(String.valueOf(getDay()));
        displayBody.add(time);
        frame.Body.add(menuBody, BorderLayout.WEST);
        frame.Body.add(displayBody, BorderLayout.CENTER);
        
    }
}
