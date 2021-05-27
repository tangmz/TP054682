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
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.border.LineBorder;

//Allow user to register either admin or student account to login to the system
public class Register extends JFrame implements ActionListener{
    //Variable Declaration
    private Button create, exit;
    private Label title, nameL, usernameL, passwordL, locationL, genderL, phoneL, roleL;
    private TextField userName, userLoginName, userPass, userPhone;
    private JFrame x;
    private JPanel Header, Body, b1, b2, b3, b4, b5, b6, b7, Footer;
    private JRadioButton adminB, studentB, female, male;
    private JComboBox locationReg = new JComboBox();
    private String adID, stuID, visitorName, visitorUserN ,visitorPass,visitorPhone,visitorGender, selectedLocation;
    public Register(){
        //Create radio buton which only allow one selection
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
        
        //To set the location
        locationReg.addItem("PetalingJaya");
        locationReg.setSelectedItem("PetalingJaya");
        
        //Default design 
        setSize(400,380);
        setLocation(800,300);
        Container mainCont = this.getContentPane();
        mainCont.setLayout(new BorderLayout(8,6));
        setBackground(Color.white);
        
        //Create buttons for user
        create = new Button("Create");
        exit = new Button("Exit");
        
        //Create label to show the details of the inputs
        nameL = new Label("Name:      \t  ");
        usernameL = new Label("Username:   ");
        passwordL = new Label("Password:    ");
        genderL = new Label("Gender: ", Label.LEFT);
        locationL = new Label("Select your Location: ");
        phoneL = new Label("Phone number:");
        roleL = new Label("Role:          ", Label.LEFT);
        
        //Create textfield to allow user to input data
        userName = new TextField(15);
        userLoginName = new TextField(15);
        userPass = new TextField(15);
        userPhone = new TextField(15);
        
        //Add actionListener to allow user to click for further function
        male.addActionListener(this);
        female.addActionListener(this);
        create.addActionListener(this);
        exit.addActionListener(this);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        
        //To read the location from enum and set in the JComboBox
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
        //Panel Design
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
        //Store the user selected location
        selectedLocation = locationReg.getSelectedItem().toString();
        //Declare the ID of the user
        adID = "AN1";
        stuID = "SN1";
        int i = 0;
        //Receive the input of the user
        visitorName = userName.getText();
        visitorUserN = userLoginName.getText();
        visitorPass = userPass.getText();
        visitorPhone = userPhone.getText();
        if (adminB.isSelected()){
                //Create the admin info
                if(e.getSource() == create){
                    String pinAdmin = JOptionPane.showInputDialog(this, "Pin");
                    //Require password to create admin account to ensure the security of the admin
                    if (pinAdmin.equals("admin1234")){
                        boolean flag = true;
                        //Read the array of adminInfo by using for loop
                        for(i = 0; i<Assignment.adminInfo.size(); i++){
                            Admin adminA = Assignment.adminInfo.get(i);
                            //If the username is same as the admin name
                            if(visitorName.equals(adminA.getAdName())){
                                flag = false;
                                break;
                            }
                        }
                        //Assign the admin ID to the user
                        String nextID = String.valueOf(i+1);
                        adID = "AN"+(nextID);
                        //If true
                        if (flag){
                            //Store all the data before writing to the file
                            Admin adminReg = new Admin(adID, visitorName,visitorUserN,visitorPass,selectedLocation, visitorGender, visitorPhone, "no");
                            Assignment.adminInfo.add(adminReg);
                            try{
                                //To write the array into the adminLogin file
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
                        //If false, it will show that the name has been used
                        } else{
                            JOptionPane.showMessageDialog(create, "Name has been used!");
                        }
                    //If false, it will show that the admin has input the wrong pin
                    }else{
                    JOptionPane.showMessageDialog(adminB, "Wrong Pin");
                    }
                }
        //if the radio button of the student is selected
        } else if (studentB.isSelected()){
            if(e.getSource() == create){
                boolean flag = true;
                //Read studentInfo array using for loop
                for(i = 0; i<Assignment.studentInfo.size(); i++){
                    Student studentA = Assignment.studentInfo.get(i);
                    //Check whether visitorname is the same as the student name in the array
                    if(visitorName.equals(studentA.getStuName())){
                        flag = false;
                        break;
                    }
                }
                //ID for student
                String nextID = String.valueOf(i+1);
                stuID = "SN"+(nextID);
                if (flag){
                    //Store the data in the object and add into the list
                    Student studentReg = new Student(stuID,visitorName,visitorUserN,visitorPass,selectedLocation, visitorGender ,visitorPhone);
                    Assignment.studentInfo.add(studentReg);
                    try{
                        //Write the studentInfo Array into the studentLogin file
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
                //If name is found then it will show the name has been used
                } else{
                    JOptionPane.showMessageDialog(create, "Name has been used!");
                }
            }
        }
        //To exit the system
        if(e.getSource() == exit){
            userName.setText("");
            userLoginName.setText("");
            userPass.setText("");
            this.dispose();
            Assignment.login.setVisible(true);
        //To identify the gender of the users
        }else if(e.getSource() == male){
            //Store data into the visitorGender variable
            visitorGender = "Male"; 
        }else if (e.getSource() == female){
            //Store data into the visitorGender variable
            visitorGender = "Female";
        }
    }
}