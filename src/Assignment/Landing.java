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
    private JButton student,admin,login,clear,exit, register, visitorView;
    private Label id,password, locationLabel, title;
    private TextField idIn,passIn; 
    private String Switch = "StudentL";
    private JPanel Header, Subheader, Center, SelectionBody, InputBody, ButtonBody, Footer;
    private ImageIcon Logo, loginLogo, registerLogo, clearLogo, exitLogo;
    private JComboBox locationLogin = new JComboBox();
    public Landing(){
        //Landing object = new Landing();
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
        locationLogin.addItem("PetalingJaya");
        locationLogin.setSelectedItem("Petalingjaya");
        setSize(400,420);
        setLocation(800,250);
        Container mainCont = this.getContentPane();
        mainCont.setLayout(new BorderLayout(8,6));
        Header = new JPanel();
        Subheader = new JPanel();
        Center = new JPanel();
        SelectionBody = new JPanel();
        InputBody = new JPanel();
        ButtonBody = new JPanel();
        Footer = new JPanel();
        student = new JButton("Student");
        admin = new JButton("Admin");
        visitorView = new JButton("Visitor View");
        visitorView.setBackground(Color.WHITE);
        idIn = new TextField("Username",15);
        passIn = new TextField("Password",15);
        title = new Label("Sport Academy System", Label.CENTER);
        locationLabel = new Label ("Select your location");
        student.addActionListener(this);
        admin.addActionListener(this);
        login.addActionListener(this);
        register.addActionListener(this);
        clear.addActionListener(this);
        exit.addActionListener(this);
        visitorView.addActionListener(this);
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
        if(e.getSource()==student){
            student.setBackground(Color.GREEN);
            admin.setBackground(Color.LIGHT_GRAY);
            Switch= "StudentL";
        }else if(e.getSource()==admin){
            student.setBackground(Color.LIGHT_GRAY);
            admin.setBackground(Color.GREEN);
            Switch= "AdminL";
        }
        boolean flag = true;
        if(e.getSource()==login){
            String selectedLocation = locationLogin.getSelectedItem().toString();
            String userInput = idIn.getText();
            String passInput = passIn.getText();
            if(Switch.equals("StudentL")){
                for(int i=0; i<Assignment.studentInfo.size(); i++){
                    Student c = Assignment.studentInfo.get(i);
                    if(userInput.equals(c.getStuUserN())){
                        flag = false;
                        if(passInput.equals(c.getStuPass())){
                            if(selectedLocation.equals(c.getStuPlace())){
                                Assignment.registeredStu.FrameLoad(c.getStuUserN(),c.getStuPlace());
                                this.dispose();
                                break;
                            }else{
                                JOptionPane.showMessageDialog(login, "Wrong Location!");
                                break;
                            }
                        }else{
                            JOptionPane.showMessageDialog(login, "Wrong Password!");
                            break;
                        }
                    }
                }
                if (flag){
                        JOptionPane.showMessageDialog(login, "Wrong Username!");
                    }
            } else if (Switch.equals("AdminL")){
                for(int i=0; i<Assignment.adminInfo.size(); i++){
                    Admin c = Assignment.adminInfo.get(i);
                    if(userInput.equals(c.getAdUserN())){
                        flag = false;
                        if(passInput.equals(c.getAdPass())){
                            if(selectedLocation.equals(c.getAdPlace())){
                                Assignment.registeredAd.FrameLoad(c.getAdUserN(),c.getAdPlace(),i);
                                this.dispose();
                                break;
                            } else{
                                JOptionPane.showMessageDialog(login, "Wrong Location!");
                                break;
                            }
                        } else{
                            JOptionPane.showMessageDialog(login, "Wrong password!");
                            break;
                        }
                    }
                }
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
