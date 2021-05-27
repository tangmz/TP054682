package Assignment;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Label;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Landing extends JFrame implements ActionListener{
    //Variable Declaration
    private static JButton student,admin,login,clear,exit, register, visitorView;
    private static Label locationLabel, title;
    private TextField idIn,passIn; 
    private String Switch = "StudentL";
    private static JPanel Header, Subheader, Center, SelectionBody, InputBody, ButtonBody, Footer;
    private static ImageIcon Logo, loginLogo, registerLogo, clearLogo, exitLogo;
    private JComboBox locationLogin = new JComboBox();
    //Login menu
    public Landing(){
        //Image and Label
        Logo = new ImageIcon(new ImageIcon(this.getClass().getResource("/PicLibrary/A_Logo.png")).getImage().getScaledInstance(300, 110, Image.SCALE_SMOOTH));
        JLabel LogoFrame = new JLabel(Logo);
        loginLogo = new ImageIcon(new ImageIcon(this.getClass().getResource("/PicLibrary/login1.png")).getImage().getScaledInstance(20,20, Image.SCALE_SMOOTH));
        login = new JButton("Login",loginLogo);
        login.setBackground(Color.WHITE);
        registerLogo = new ImageIcon(new ImageIcon(this.getClass().getResource("/PicLibrary/sign up.png")).getImage().getScaledInstance(20,20, Image.SCALE_SMOOTH));
        register = new JButton("Register", registerLogo);
        register.setBackground(Color.WHITE);
        clearLogo = new ImageIcon(new ImageIcon(this.getClass().getResource("/PicLibrary/clear.png")).getImage().getScaledInstance(20,20, Image.SCALE_SMOOTH));
        clear = new JButton("Clear", clearLogo);
        clear.setBackground(Color.WHITE);
        exitLogo = new ImageIcon(new ImageIcon(this.getClass().getResource("/PicLibrary/logout.png")).getImage().getScaledInstance(20,20, Image.SCALE_SMOOTH));
        exit = new JButton("Exit", exitLogo);
        exit.setBackground(Color.WHITE);
        //JComboBox for location
        locationLogin.addItem("PetalingJaya");
        locationLogin.setSelectedItem("Petalingjaya");
        //Set the default size and design for the panel
        setSize(400,420);
        setLocation(800,250);
        Container mainCont = this.getContentPane();
        mainCont.setLayout(new BorderLayout(8,6));
        //Create new design panel
        Header = new JPanel();
        Subheader = new JPanel();
        Center = new JPanel();
        SelectionBody = new JPanel();
        InputBody = new JPanel();
        ButtonBody = new JPanel();
        Footer = new JPanel();
        //Create new Buttons for different functionalities
        student = new JButton("Student");
        admin = new JButton("Admin");
        visitorView = new JButton("Visitor View");
        visitorView.setBackground(Color.WHITE);
        //Create new textField for user input for the username and password
        idIn = new TextField("Username",15);
        passIn = new TextField("Password",15);
        //Create labels for the system
        title = new Label("Sport Academy System", Label.CENTER);
        locationLabel = new Label ("Select your location");
        //Adding the action for each JButtons
        student.addActionListener(this);
        admin.addActionListener(this);
        login.addActionListener(this);
        register.addActionListener(this);
        clear.addActionListener(this);
        exit.addActionListener(this);
        visitorView.addActionListener(this);
        //To appear Username when there's no any user input when user click it then it will disappear
        idIn.addFocusListener(new FocusListener(){
            @Override
            public void focusGained(FocusEvent fe) {
                if (idIn.getText().equals("Username")){
                    idIn.setText("");
                }
            }

            @Override
            public void focusLost(FocusEvent fe) {
                if (idIn.getText().equals("")){
                    idIn.setText("Username");
                }
            }
        });
        //To appear Password when there's no any user input when user click it then it will disappear
        passIn.addFocusListener(new FocusListener(){
            @Override
            public void focusGained(FocusEvent fe) {
                if (passIn.getText().equals("Password")){
                    passIn.setText("");
                }
            }

            @Override
            public void focusLost(FocusEvent fe) {
                if (passIn.getText().equals("")){
                    passIn.setText("Password");
                }
            }
        });
        //To show the various location of the sport academy
        locationLogin.addFocusListener(new FocusListener(){
            @Override
            public void focusGained(FocusEvent fe) {
                locationLogin.setModel(new DefaultComboBoxModel(Location.values()));
                locationLogin.showPopup();
            }

            @Override
            public void focusLost(FocusEvent fe) {
                
            }
            
        });
        //Create design panel
        Header.setLayout(new BorderLayout());
        Header.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY, 3));
        Header.add(LogoFrame,BorderLayout.NORTH);
        title.setFont(new Font("Verdana", Font.BOLD, 20));
        Header.add(title, BorderLayout.CENTER);
        mainCont.add(Header, BorderLayout.NORTH);
        Center.setLayout(new BorderLayout());
        SelectionBody.setLayout(new FlowLayout(FlowLayout.CENTER));
        SelectionBody.add(student);
        student.setBackground(Color.GREEN);
        SelectionBody.add(admin);
        admin.setBackground(Color.LIGHT_GRAY);
        Center.add(SelectionBody, BorderLayout.NORTH);
        JPanel gridPanel = new JPanel();
        gridPanel.setLayout(new GridLayout(3,1,10,10));
        gridPanel.add(idIn);
        gridPanel.add(passIn);
        gridPanel.add(locationLogin);
        InputBody.setLayout(new FlowLayout(FlowLayout.CENTER));
        InputBody.add(gridPanel);
        Center.add(InputBody, BorderLayout.CENTER);
        mainCont.add(Center, BorderLayout.CENTER);
        Footer.setLayout(new BorderLayout());
        ButtonBody.setLayout(new FlowLayout(FlowLayout.CENTER));
        ButtonBody.add(login);
        ButtonBody.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, Color.DARK_GRAY));
        ButtonBody.add(register);
        ButtonBody.add(clear);
        ButtonBody.add(exit);
        Footer.add(ButtonBody, BorderLayout.NORTH);
        Footer.add(visitorView, BorderLayout.CENTER);
        mainCont.add(Footer, BorderLayout.SOUTH);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("REAL Champion Sport Academy");
        setResizable(false);
        setVisible(true);
    }
    
    @Override
    public void actionPerformed(ActionEvent e){
        //It will direct it to student role
        if(e.getSource()==student){
            student.setBackground(Color.GREEN);
            admin.setBackground(Color.LIGHT_GRAY);
            Switch= "StudentL";
        //It will direct it to admin role
        }else if(e.getSource()==admin){
            student.setBackground(Color.LIGHT_GRAY);
            admin.setBackground(Color.GREEN);
            Switch= "AdminL";
        }
        boolean flag = true;
        //Login to the system based on users' role
        if(e.getSource()==login){
            String selectedLocation = locationLogin.getSelectedItem().toString();
            String userInput = idIn.getText();
            String passInput = passIn.getText();
            if(Switch.equals("StudentL")){
                //Read the student info from the array list
                for(int i=0; i<Assignment.studentInfo.size(); i++){
                    Student c = Assignment.studentInfo.get(i);
                    //Check whether userinput is match with the studentUsername in the array list
                    if(userInput.equals(c.getStuUserN())){
                        flag = false;
                        //Check whether password input is match with the student password in the array list
                        if(passInput.equals(c.getStuPass())){
                            //Check whether the selected location in the JComboBox is the same as the student place in the array list
                            if(selectedLocation.equals(c.getStuPlace())){
                                //If true, then it allow user to login and show student panel
                                Assignment.registeredStu.FrameLoad(c.getStuUserN(),c.getStuPlace());
                                this.dispose();
                                break;
                            }else{
                                //Show error/false
                                JOptionPane.showMessageDialog(login, "Wrong Location!");
                                break;
                            }
                        }else{
                            //Show error/false
                            JOptionPane.showMessageDialog(login, "Wrong Password!");
                            break;
                        }
                    }
                }
                //Show error/false
                if (flag){
                        JOptionPane.showMessageDialog(login, "Wrong Username!");
                    }
                //it will ask user to choose the Switch either student or admin
            } else if (Switch.equals("AdminL")){
                //It will read the admin info from the array list
                for(int i=0; i<Assignment.adminInfo.size(); i++){
                    Admin c = Assignment.adminInfo.get(i);
                    //Find whether the userinput is match with the admin username in the array list
                    if(userInput.equals(c.getAdUserN())){
                        flag = false;
                        //Find whether the passInput is match with the admin password in the array list
                        if(passInput.equals(c.getAdPass())){
                            //Find whether the selectedLocation from the JComboBox is the same as admin place
                            if(selectedLocation.equals(c.getAdPlace())){
                                //If true, then it will allow user to login and show admin panel
                                Assignment.registeredAd.FrameLoad(c.getAdUserN(),c.getAdPlace(),i);
                                this.dispose();
                                break;
                            } else{
                                //Show error/false
                                JOptionPane.showMessageDialog(login, "Wrong Location!");
                                break;
                            }
                        } else{
                            //Show error/false
                            JOptionPane.showMessageDialog(login, "Wrong password!");
                            break;
                        }
                    }
                }
                //Show error/false
                if (flag){
                        JOptionPane.showMessageDialog(login, "Wrong Username!");
                    }
            }
        }else if (e.getSource() == register){ //If register button clicked then will show register menu from Register
            setVisible(false);
            Assignment.register.setVisible(true);
        }else if (e.getSource() == clear){ //If clear button clicked, it will clear user input in username and password TextField
            idIn.setText("Username");
            passIn.setText("Password");
        }else if (e.getSource() == exit){ //If exit button clicked, it will exit the system
            System.exit(0);
        }else if (e.getSource() == visitorView){//If visitorView clicked, it will show visitor menu from Visitor
            setVisible(false);
            Assignment.visitorView.Visitor("PetalingJaya");
        }
    }
}
