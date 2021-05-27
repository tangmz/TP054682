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
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

//Allow visitor to view sports and minimum of the schedule
public class Visitor implements ActionListener{
    //Variable Declaration
    private JButton register, exit, viewB;
    private JPanel view, Footer; 
    private JLabel welcomeL, background;
    private ImageIcon exitLogo, viewLogo, registerLogo, backgroundImage;
    private JFrameFormat frame = new JFrameFormat("Visitor");
    private static ArrayList <String> sportsType = new ArrayList <String>();
    private static ArrayList <String> locationType = new ArrayList <String>();
    private String selectedLocation;
    private boolean flag = true;
    public void Visitor(String cenLocation){
        //Get the location from the enum
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
                    notiChange();
                }else if(frame.CenLocation.getSelectedItem().equals(Location.BukitJalil)){
                    notiChange();
                }
                else if(frame.CenLocation.getSelectedItem().equals(Location.PetalingJaya)){
                    notiChange();
                }
                else if(frame.CenLocation.getSelectedItem().equals(Location.ShahAlam)){
                    notiChange();
                }
            }
        });
        
        //Create new label
        welcomeL = new JLabel("Example", JLabel.CENTER);
        welcomeL.setFont(new Font("Arial", Font.BOLD, 30));
        welcomeL.setBorder(BorderFactory.createTitledBorder(null,"==Announcement Board==",TitledBorder.CENTER,TitledBorder.TOP,new Font("Verdana",Font.BOLD,30),Color.DARK_GRAY));
        notiChange();
        background = new JLabel(backgroundImage);
        
        //Frame Design
        frame.welcome.setText("Welcome To Real Champion Sport Academy");
//        frame.setSize(950,600);
        
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
        //To view the sport schedule
        if(ae.getSource() == viewB){
            selectedLocation = frame.CenLocation.getSelectedItem().toString();
            //Read the schedule info by using for loop
            for(int i = 0; i<Assignment.schedule.size(); i++){
                Schedule_Constr schedule = Assignment.schedule.get(i);
                //Check whether center is matched with the selectedLocation
                if (schedule.getCenter().equals(selectedLocation)){
                    JOptionPane.showMessageDialog(welcomeL, "Monday: \n"+schedule.getMon1()+", "+schedule.getMon2()+", "+schedule.getMon3()+"\n\nTuesday: \n"+schedule.getTue1()+", "+schedule.getTue2()+", "+schedule.getTue3()+
                            "\n\nWednesday: \n"+schedule.getWed1()+", "+schedule.getWed2()+", "+schedule.getWed3()+"\n\nThursday: \n"+schedule.getThu1()+", "+schedule.getThu2()+", "+schedule.getThu3()+
                            "\n\nFriday: \n"+schedule.getFri1()+", "+schedule.getFri2()+", "+schedule.getFri3()+"\n\nSaturday: \n"+schedule.getSat1()+", "+schedule.getSat2()+", "+schedule.getSat3()+
                            "\n\nSunday: \n"+schedule.getSun1()+", "+schedule.getSun2()+", "+schedule.getSun3(), "Schedule of RCS "+frame.CenLocation.getSelectedItem().toString(), 1);
                    flag = false;
                    break;
                }else{
                    flag = true;
                }
            }
            if (flag){
                JOptionPane.showMessageDialog(welcomeL, "No Schedule has been found");
            }
        //It will ask user to register with their details
        }else if (ae.getSource() == register){
            frame.Body.removeAll();
            frame.dispose();
            Assignment.register.setVisible(true);
        //Exit to the login system
        }else if(ae.getSource() == exit){
            frame.Body.removeAll();
            frame.dispose();
            Assignment.login.setVisible(true);
        }
    }
    //Show the notification in the panel
    private void notiChange() {
        for(int i = 0; i<Assignment.noti.size();i++){
            VisitorAnnouncement va = Assignment.noti.get(i);
            if(frame.CenLocation.getSelectedItem().equals(Location.valueOf(va.getCenLocation()))){
                //It will set the text of the label 
                welcomeL.setText(va.getMessage());
                break;
            }else{
                welcomeL.setText("==NO UPDATES==");
            }
        }
    }
}
