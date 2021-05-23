package Assignment;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.io.PrintWriter;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.border.LineBorder;

public class Register extends JFrame implements ActionListener{
    private Button create, exit;
    private Label title, nameL, usernameL, passwordL, locationL, genderL, phoneL, roleL;
    private TextField userName, userLoginName, userPass, userPhone;
    private JFrame x;
    private JPanel Header, Body, b1, b2, b3, b4, b5, b6, b7, Footer;
    private JRadioButton adminB, studentB, female, male;
    private JComboBox locationReg = new JComboBox();
    private String adID, stuID, visitorName, visitorUserN ,visitorPass,visitorPhone,visitorGender, selectedLocation;
    public Register(){
        adminB = new JRadioButton("Admin");
        studentB = new JRadioButton("Student");
        ButtonGroup buttonRole = new ButtonGroup();
        buttonRole.add(adminB);
        buttonRole.add(studentB);
        male = new JRadioButton("Male");
        female = new JRadioButton("Female");
        ButtonGroup buttonGender = new ButtonGroup();
        buttonGender.add(female);
        buttonGender.add(male);
        male.addActionListener(this);
        female.addActionListener(this);
        /*JComboBox comboBox = new JComboBox();
        x = new JFrame();
        x.setSize(500, 300);
        x.setLocation(800, 200);
        x.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        c = new Panel();
        c.setBackground(Color.black);
        x.add(c,BorderLayout.CENTER);
        s = new Panel();    //FlowLayout by default
        x.add(s,BorderLayout.SOUTH);
        x.setVisible(true);*/
        locationReg.addItem("PetalingJaya");
        locationReg.setSelectedItem("PetalingJaya");
        setSize(400,380);
        setLocation(800,300);
        Container mainCont = this.getContentPane();
        mainCont.setLayout(new BorderLayout(8,6));
        setBackground(Color.white);
        create = new Button("Create");
        exit = new Button("Exit");
        nameL = new Label("Name:      \t  ");
        usernameL = new Label("Username:   ");
        passwordL = new Label("Password:    ");
        genderL = new Label("Gender: ", Label.LEFT);
        locationL = new Label("Select your Location: ");
        phoneL = new Label("Phone number:");
        roleL = new Label("Role:          ", Label.LEFT);
        userName = new TextField(15);
        userLoginName = new TextField(15);
        userPass = new TextField(15);
        userPhone = new TextField(15);
        create.addActionListener(this);
        exit.addActionListener(this);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        locationReg.addFocusListener(new FocusListener(){
            @Override
            public void focusGained(FocusEvent fe) {
                locationReg.setModel(new DefaultComboBoxModel(Location.values()));
                locationReg.showPopup();
            }

            @Override
            public void focusLost(FocusEvent fe) {
                
            }
            
        });
        Header = new JPanel();
        Header.setLayout(new FlowLayout(FlowLayout.CENTER));
        Header.setBorder(new LineBorder(Color.DARK_GRAY, 3));
        title = new Label("Register");
        title.setFont(new Font("Verdana", Font.BOLD, 20));
        Header.add(title);
        mainCont.add(Header, BorderLayout.NORTH);
        Body = new JPanel();
        GridLayout gLayout = new GridLayout(7,1);
        gLayout.setVgap(5);
        Body.setLayout(gLayout);
        b1 = new JPanel();
        b1.setLayout(new FlowLayout(FlowLayout.CENTER));
        b1.add(nameL);
        b1.add(userName);
        Body.add(b1);
        b2 = new JPanel();
        b2.setLayout(new FlowLayout(FlowLayout.CENTER));
        b2.add(usernameL);
        b2.add(userLoginName);
        Body.add(b2);
        b3 = new JPanel();
        b3.setLayout(new FlowLayout(FlowLayout.CENTER));
        b3.add(passwordL);
        b3.add(userPass);
        Body.add(b3);
        b4 = new JPanel();
        b4.setLayout(new FlowLayout(FlowLayout.CENTER));
        b4.add(genderL);
        b4.add(male);
        b4.add(female);
        Body.add(b4);
        b5 = new JPanel();
        b5.setLayout(new FlowLayout(FlowLayout.CENTER));
        b5.add(phoneL);
        b5.add(userPhone);
        Body.add(b5);
        b6 = new JPanel();
        b6.setLayout(new FlowLayout(FlowLayout.CENTER));
        b6.add(locationL);
        b6.add(locationReg);
        Body.add(b6);
        b7 = new JPanel();
        b7.setLayout(new FlowLayout(FlowLayout.CENTER));
        b7.add(roleL);
        b7.add(adminB);
        b7.add(studentB);
        Body.add(b7);
        mainCont.add(Body, BorderLayout.CENTER);
        Footer = new JPanel();
        Footer.setLayout(new FlowLayout(FlowLayout.CENTER));
        Footer.add(create);
        Footer.add(exit);
        mainCont.add(Footer, BorderLayout.SOUTH);
        setResizable(false);
        setVisible(false);
    }
    @Override
    public void actionPerformed(ActionEvent e){
        selectedLocation = locationReg.getSelectedItem().toString();
        //String selectedLocation = (String)comboBox.getSelectedItem().toString();
        adID = "AN1";
        stuID = "SN1";
        int i = 0;
        visitorName = userName.getText();
        visitorUserN = userLoginName.getText();
        visitorPass = userPass.getText();
        visitorPhone = userPhone.getText();
        if (adminB.isSelected()){
                if(e.getSource() == create){
                    String pinAdmin = JOptionPane.showInputDialog(this, "Pin");
                    if (pinAdmin.equals("admin1234")){
                        boolean flag = true;
                        for(i = 0; i<Assignment.adminInfo.size(); i++){
                            Admin adminA = Assignment.adminInfo.get(i);
                            if(visitorName.equals(adminA.getAdName())){
                                flag = false;
                                break;
                            }
                        }
                        String nextID = String.valueOf(i+1);
                        adID = "AN"+(nextID);
                        if (flag){
                            Admin adminReg = new Admin(adID, visitorName,visitorUserN,visitorPass,selectedLocation, visitorGender, visitorPhone, "no");
                            Assignment.adminInfo.add(adminReg);
                            try{
                                PrintWriter f = new PrintWriter("adminLogin.txt");
                                for(i=0; i<Assignment.adminInfo.size(); i++){
                                    Admin c = Assignment.adminInfo.get(i);
                                    f.println(c.getAdId());
                                    f.println(c.getAdName());
                                    f.println(c.getAdUserN());
                                    f.println(c.getAdPass());
                                    f.println(c.getAdPlace());
                                    f.println(c.getAdGender());
                                    f.println(c.getAdPhone());
                                    f.println(c.getSuperRole());
                                    f.println();
                                }
                                f.close();
                                this.dispose();
                                Assignment.login.setVisible(true);
                            } catch(Exception ex){
                                System.out.println("Error in stop!");
                            }
                        } else{
                            JOptionPane.showMessageDialog(create, "Name has been used!");
                        }
                    }else{
                    JOptionPane.showMessageDialog(adminB, "Wrong Pin");
                    }
                }
        } else if (studentB.isSelected()){
            if(e.getSource() == create){
                boolean flag = true;
                for(i = 0; i<Assignment.studentInfo.size(); i++){
                    Student studentA = Assignment.studentInfo.get(i);
                    if(visitorName.equals(studentA.getStuName())){
                        flag = false;
                        break;
                    }
                }
                String nextID = String.valueOf(i+1);
                stuID = "SN"+(nextID);
                if (flag){
                    Student studentReg = new Student(stuID,visitorName,visitorUserN,visitorPass,selectedLocation, visitorGender ,visitorPhone);
                    Assignment.studentInfo.add(studentReg);
                    try{
                        PrintWriter f = new PrintWriter("studentLogin.txt");
                        for(i=0; i<Assignment.studentInfo.size(); i++){
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
                        this.dispose();
                        Assignment.login.setVisible(true);
                    } catch(Exception ex){
                        System.out.println("Error in stop!");
                    }
                } else{
                    JOptionPane.showMessageDialog(create, "Name has been used!");
                }
            }
        }
        if(e.getSource() == exit){
            userName.setText("");
            userLoginName.setText("");
            userPass.setText("");
            this.dispose();
            Assignment.login.setVisible(true);
        }else if(e.getSource() == male){
            visitorGender = "Male";
        }else if (e.getSource() == female){
            visitorGender = "Female";
        }
    }
}