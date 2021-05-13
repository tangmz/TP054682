package Assignment;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

public class Landing extends JFrame implements ActionListener{
    private Button student,admin,login,clear,exit, register, visitorView;
    private Label id,password, locationLabel, title;
    private TextField idIn,passIn; 
    private String Switch = "StudentL";
    private JPanel Header, Subheader, Center, SelectionBody, InputBody, ButtonBody, Footer;
    private JComboBox locationLogin = new JComboBox();
    private GridBagConstraints gbc = new GridBagConstraints();
    public Landing(){
        //Landing object = new Landing();
        locationLogin.addItem("Petaling Jaya");
        locationLogin.setSelectedItem("Petaling jaya");
        setSize(400,290);
        setLocation(1000,300);
        Container mainCont = this.getContentPane();
        mainCont.setLayout(new BorderLayout(8,6));
//        gbc.insets = new Insets(5,6,5,6);
        setBackground(Color.white);
        Header = new JPanel();
        Subheader = new JPanel();
        Center = new JPanel();
        SelectionBody = new JPanel();
        InputBody = new JPanel();
        ButtonBody = new JPanel();
        Footer = new JPanel();
        student = new Button("Student");
        admin = new Button("Admin");
        login = new Button("Login");
        register = new Button("Register");
        clear = new Button("Clear");
        exit = new Button("Exit");
        visitorView = new Button("Visitor View");
        //id = new Label("Username: ");
        //password = new Label("Password");
        idIn = new TextField("Username",15);
        passIn = new TextField("Password",15);
        title = new Label("Sports Center Mangement System");
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
//        gbc.gridx = 1;
//        gbc.gridy = 0;
//        gbc.anchor = GridBagConstraints.CENTER;
        Header.setLayout(new FlowLayout(FlowLayout.CENTER));
        Header.setBorder(new LineBorder(Color.DARK_GRAY, 3));
        title.setFont(new Font("Verdana", Font.BOLD, 20));
        Header.add(title);
        mainCont.add(Header, BorderLayout.NORTH);
//        gbc.anchor = GridBagConstraints.CENTER;
//        gbc.gridx =1;
//        gbc.gridy = 1;
//        add(locationLogin, gbc);
//        gbc.gridx = 1;
//        gbc.gridy = 1;
//        gbc.anchor = GridBagConstraints.WEST;
        Center.setLayout(new BorderLayout());
        SelectionBody.setLayout(new FlowLayout(FlowLayout.CENTER));
        SelectionBody.add(student);
        student.setBackground(Color.GREEN);
//        gbc.gridx = 1;
//        gbc.gridy = 1;
//        gbc.anchor = GridBagConstraints.EAST;
        SelectionBody.add(admin);
        admin.setBackground(Color.LIGHT_GRAY);
//        //add(id);
//        gbc.gridy = 2;
//        gbc.anchor = GridBagConstraints.CENTER;
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
//        //add(password);
//        gbc.gridy = 3;
//        gbc.anchor = GridBagConstraints.CENTER;
//        add(passIn, gbc);
//        gbc.gridx = 0;
//        gbc.gridy = 4;
        Footer.setLayout(new BorderLayout());
        ButtonBody.setLayout(new FlowLayout(FlowLayout.CENTER));
        ButtonBody.add(login);
//        gbc.gridx = 1;
//        gbc.gridy = 4;
//        gbc.anchor = GridBagConstraints.WEST;
        ButtonBody.add(register);
//        gbc.gridx = 1;
//        gbc.gridy = 4;
//        gbc.anchor = GridBagConstraints.EAST;
        ButtonBody.add(clear);
//        gbc.gridx = 2;
//        gbc.gridy = 4;
        ButtonBody.add(exit);
        Footer.add(ButtonBody, BorderLayout.NORTH);
//        gbc.gridx = 1;
//        gbc.gridy = 5;
//        gbc.anchor = GridBagConstraints.CENTER;
        Footer.add(visitorView, BorderLayout.CENTER);
        mainCont.add(Footer, BorderLayout.SOUTH);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setUndecorated(true);
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
                                Assignment.registeredStu.setVisible(true);
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
          
//                    } else{
//                        JOptionPane.showMessageDialog(login, "Wrong Username!");
//                        break;
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
                                setVisible(false);
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
        } else if (e.getSource() == register){
            setVisible(false);
            Assignment.register.setVisible(true);
        }else if (e.getSource() == clear){
            idIn.setText("Username");
            passIn.setText("Password");
        }else if (e.getSource() == exit){
            System.exit(0);
        } else if (e.getSource() == visitorView){
            setVisible(false);
            Assignment.visitorView.setVisible(true);
        }
    }
}
