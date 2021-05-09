package Assignment;

import java.awt.Button;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Label;
import java.awt.Panel;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.PrintWriter;
import javax.swing.ButtonGroup;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;

public class Register extends JFrame implements ActionListener{
    private Button create, exit;
    private Label nameL, usernameL, passwordL, locationL;
    private TextField userName, userLoginName, userPass;
    private JList regLocation;
    private JFrame x;
    private Panel c,s;
    JRadioButton adminB, studentB;
    JComboBox locationReg = new JComboBox();
    public Register(){
        adminB = new JRadioButton("Admin");
        studentB = new JRadioButton("Student");
        ButtonGroup buttonG = new ButtonGroup();
        buttonG.add(adminB);
        buttonG.add(studentB);
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
        String place[] = {"Bukit Jalil", "Putrajaya", "Petaling Jaya", "Shah Alam"};
        for (int i = 0; i < place.length;i++){
            locationReg.addItem(place[i]);
        }
        locationReg.setSelectedItem("Bukit Jalil");
        setSize(300,200);
        setLocation(1000,300);
        setLayout(new FlowLayout());
        setBackground(Color.white);
        create = new Button("Create");
        exit = new Button("Exit");
        nameL = new Label("Name: ");
        usernameL = new Label("Username: ");
        passwordL = new Label("Password");
        locationL = new Label("Select your Location: ");
        userName = new TextField(15);
        userLoginName = new TextField(15);
        userPass = new TextField(15);
        create.addActionListener(this);
        exit.addActionListener(this);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        add(nameL);
        add(userName);
        add(usernameL);
        add(userLoginName);
        add(passwordL);
        add(userPass);
        add(locationL);
        add(locationReg);
        add(create);
        add(exit);
        add(adminB);
        add(studentB);
        setVisible(false);
    }
    @Override
    public void actionPerformed(ActionEvent e){
        String selectedLocation = locationReg.getSelectedItem().toString();
        //String selectedLocation = (String)comboBox.getSelectedItem().toString();
        int userID = 1;
        int i = 0;
        String visitorName = userName.getText();
        String visitorUserN = userLoginName.getText();
        String visitorPass = userPass.getText();
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
                        userID = i + 1;
                        if (flag){
                            Admin adminReg = new Admin(userID, visitorName,visitorUserN,visitorPass,selectedLocation);
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
                userID = i + 1;
                if (flag){
                    Student studentReg = new Student(userID,visitorName,visitorUserN,visitorPass,selectedLocation);
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
        else if(e.getSource() == exit){
            userName.setText("");
            userLoginName.setText("");
            userPass.setText("");
            this.dispose();
            Assignment.login.setVisible(true);
        }
    }
}