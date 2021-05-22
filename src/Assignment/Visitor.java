package Assignment;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Visitor implements ActionListener{
    private JButton register, exit, viewB;
    private JPanel view, Footer; 
    private JLabel welcome;
    private ImageIcon exitLogo, viewLogo, registerLogo;
    private java.util.Date date = new java.util.Date();
    private JFrameFormat frame = new JFrameFormat("Visitor");
    private static ArrayList <String> sportsType = new ArrayList <String>();
    private static ArrayList <String> locationType = new ArrayList <String>();
    private JComboBox location, sportList;
    private String selectedLocation, selectedSport;
    private boolean flag = true;
    public void Visitor(){
        //Image and Button Design
        registerLogo = new ImageIcon(new ImageIcon(this.getClass().getResource("/PicLibrary/sign up.png")).getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH));
        register = new JButton("Register",registerLogo);
        register.setFont(new Font("Arial", Font.BOLD, 20));
        register.setBackground(Color.LIGHT_GRAY);
        exitLogo = new ImageIcon(new ImageIcon(this.getClass().getResource("/PicLibrary/logout.png")).getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH));
        exit = new JButton ("Exit",exitLogo);
        exit.setFont(new Font("Arial", Font.BOLD, 20));
        exit.setBackground(Color.LIGHT_GRAY);
        viewLogo = new ImageIcon(new ImageIcon(this.getClass().getResource("/PicLibrary/view.png")).getImage().getScaledInstance(100,100,Image.SCALE_SMOOTH));
        viewB = new JButton("View", viewLogo);
        viewB.setFont(new Font("Arial", Font.BOLD,20));
        viewB.setBackground(Color.LIGHT_GRAY);
        //Frame Design
        frame.welcome.setText("Welcome To Real Champion Sport Academy");
        frame.setSize(950,600);
        //JComboBox to let user to choose for location
        location = new JComboBox(Location.values());
        location.setSelectedItem("PetalingJaya");
        for(int i = 0; i<Assignment.sportInfo.size(); i++){
            Sport_Constr sport = Assignment.sportInfo.get(i);
            if(sport.getCenter().equals(location)){
                sportsType.add(sport.getSportN()); 
                
            }
        }
        sportList = new JComboBox(sportsType.toArray());
        //Panel
        view = new JPanel();
        view.setLayout(new GridLayout(2,1));
        view.setBorder(BorderFactory.createTitledBorder("Location: "));
        
        view.setBorder(BorderFactory.createTitledBorder("Sports: "));
        for(int i = 0; i<Assignment.sportInfo.size(); i++){
            Sport_Constr sport = Assignment.sportInfo.get(i);
            locationType.add(sport.getCenter());        
        }
        view.add(location);
        
//        selectedSport = sportList.getSelectedItem().toString();
        
        frame.Body.add(view, BorderLayout.CENTER);
        Footer = new JPanel();
        Footer.setLayout(new FlowLayout());
        Footer.add(viewB);
        Footer.add(register);
        Footer.add(exit);
        frame.Body.add(Footer, BorderLayout.SOUTH);
        frame.setVisible(true);
//        register = new Button("Register");
//        exit = new Button("Exit");
        viewB.addActionListener(this);
        register.addActionListener((ActionListener) this);
        exit.addActionListener((ActionListener) this);
//        setVisible(false);
    }

    @Override
    public void actionPerformed (ActionEvent ae) {
        if(ae.getSource() == viewB){
            selectedLocation = location.getSelectedItem().toString();
            for(int i = 0; i<Assignment.schedule.size(); i++){
                Schedule_Constr schedule = Assignment.schedule.get(i);
                if (schedule.getCenter().equals(selectedLocation)){
                    JOptionPane.showMessageDialog(viewB, "Monday: "+schedule.getMon1()+", "+schedule.getMon2()+", "+schedule.getMon3()+"\nTuesday: "+schedule.getTue1()+", "+schedule.getTue2()+", "+schedule.getTue3()+"\nWednesday: "+schedule.getWed1()+", "+schedule.getWed2()+", "+schedule.getWed3()+"\nThursday: "+schedule.getThu1()+", "+schedule.getThu2()+", "+schedule.getThu3()+"\nFriday: "+schedule.getFri1()+", "+schedule.getFri2()+", "+schedule.getFri3()+"\nSaturday: "+schedule.getSat1()+", "+schedule.getSat2()+", "+schedule.getSat3()+"\nSunday: "+schedule.getSun1()+", "+schedule.getSun2()+", "+schedule.getSun3());
                    flag = false;
                    break;
                }else{
                    flag = true;
                }
            }
            if (flag){
                JOptionPane.showMessageDialog(viewB, "No Schedule has been found");
            }
            for(int i = 0; i<Assignment.sportInfo.size(); i++){
                Sport_Constr c = Assignment.sportInfo.get(i);
                if (c.getCenter().equals(selectedLocation)){
                    JOptionPane.showMessageDialog(viewB, "Availble Sport: "+c.getSportN());
                    flag = false;
                    break;
                }else{
                    flag = true;
                }
            }
            if (flag){
                JOptionPane.showMessageDialog(viewB, "No available Sport in "+selectedLocation);
                
            }
            
        
        }else if (ae.getSource() == register){
            frame.Body.removeAll();
            frame.dispose();
            Assignment.register.setVisible(true);
        }else if(ae.getSource() == exit){
            frame.Body.removeAll();
            frame.dispose();
            Assignment.login.setVisible(true);
        }
    }
}
