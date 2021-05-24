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
    private JLabel welcomeL, background;
    private ImageIcon exitLogo, viewLogo, registerLogo, backgroundImage;
    private JFrameFormat frame = new JFrameFormat("Visitor");
    private static ArrayList <String> sportsType = new ArrayList <String>();
    private static ArrayList <String> locationType = new ArrayList <String>();
    private JComboBox location;
    private String selectedLocation;
    private boolean flag = true;
    public void Visitor(String cenLocation){
        frame.CenLocation.setSelectedItem(Location.valueOf(cenLocation));
        //Create Image
        backgroundImage = new ImageIcon(new ImageIcon(this.getClass().getResource("/PicLibrary/background.png")).getImage().getScaledInstance(300,300, Image.SCALE_SMOOTH));
        registerLogo = new ImageIcon(new ImageIcon(this.getClass().getResource("/PicLibrary/sign up.png")).getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH));
        exitLogo = new ImageIcon(new ImageIcon(this.getClass().getResource("/PicLibrary/logout.png")).getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH));
        viewLogo = new ImageIcon(new ImageIcon(this.getClass().getResource("/PicLibrary/view.png")).getImage().getScaledInstance(100,100,Image.SCALE_SMOOTH));

        //Create new Button and Design
        register = new JButton("Register",registerLogo);
        register.setFont(new Font("Arial", Font.BOLD, 20));
        register.setBackground(Color.LIGHT_GRAY);
        exit = new JButton ("Exit",exitLogo);
        exit.setFont(new Font("Arial", Font.BOLD, 20));
        exit.setBackground(Color.LIGHT_GRAY);
        viewB = new JButton("View", viewLogo);
        viewB.setFont(new Font("Arial", Font.BOLD,20));
        viewB.setBackground(Color.LIGHT_GRAY);
        frame.CenLocation.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                if(frame.CenLocation.getSelectedItem().equals(Location.Putrajaya)){
                    frame.Body.removeAll();
                    frame.dispose();
                    Assignment.visitorView.Visitor(Location.Putrajaya.toString());
                }else if(frame.CenLocation.getSelectedItem().equals(Location.BukitJalil)){
                    frame.Body.removeAll();
                    frame.dispose();
                    Assignment.visitorView.Visitor(Location.BukitJalil.toString());
                }
                else if(frame.CenLocation.getSelectedItem().equals(Location.PetalingJaya)){
                    frame.Body.removeAll();
                    frame.dispose();
                    Assignment.visitorView.Visitor(Location.PetalingJaya.toString());
                }
                else if(frame.CenLocation.getSelectedItem().equals(Location.ShahAlam)){
                    frame.Body.removeAll();
                    frame.dispose();
                    Assignment.visitorView.Visitor(Location.ShahAlam.toString());
                }
            }
        });
        
        //Create new label
        welcomeL = new JLabel("Example", JLabel.CENTER);
        welcomeL.setFont(new Font("Arial", Font.BOLD, 30));
        welcomeL.setBorder(BorderFactory.createTitledBorder("Announcement:  "));
        String noti = "";
        for(int i = 0; i<Assignment.noti.size();i++){
            VisitorAnnouncement va = Assignment.noti.get(i);
            System.out.println(va.getMessage());
            if(frame.CenLocation.getSelectedItem().equals(Location.valueOf(va.getCenLocation()))){
                noti = va.getMessage();
                break;
            }
        }
        welcomeL.setText(noti);
        background = new JLabel(backgroundImage);
        
        //Frame Design
        frame.welcome.setText("Welcome To Real Champion Sport Academy");
//        frame.setSize(950,600);
        //JComboBox to let user to choose for location
        location = new JComboBox(Location.values());
        location.setSelectedItem("PetalingJaya");
        for(int i = 0; i<Assignment.sportInfo.size(); i++){
            Sport_Constr sport = Assignment.sportInfo.get(i);
            if(sport.getCenter().equals(location)){
                sportsType.add(sport.getSportN()); 
                
            }
        }
        //Panel
        view = new JPanel();
        view.setLayout(new GridLayout(2,1));
        view.add(welcomeL);
        view.add(background);
        
        frame.Body.add(view, BorderLayout.CENTER);
        Footer = new JPanel();
        Footer.setLayout(new FlowLayout());
        Footer.add(viewB);
        Footer.add(register);
        Footer.add(exit);
        frame.Body.add(Footer, BorderLayout.SOUTH);
        frame.setVisible(true);
        
        
        //Add ActionListener
        viewB.addActionListener(this);
        register.addActionListener((ActionListener) this);
        exit.addActionListener((ActionListener) this);
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
                    JOptionPane.showMessageDialog(viewB, "Available Sport: "+c.getSportN());
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
