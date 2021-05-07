package Assignment;

import java.awt.Button;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Label;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JOptionPane;

public class Register extends JFrame implements ActionListener{
    private Button create, exit;
    private Label nameL, usernameL, passwordL, locationL;
    private TextField stuName, stuUsername, stuPass, stuPlace;
    private JList regLocation;
    public Register(){
        String place[] = {"Bukit Jalil", "Putrajaya", "Petaling Jaya", "Shah Alam"};
        JComboBox<String> location = new JComboBox<>(place);
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
        stuName = new TextField(15);
        stuUsername = new TextField(15);
        stuPass = new TextField(15);
        create.addActionListener(this);
        exit.addActionListener(this);
        location.addActionListener(this);
        add(nameL);
        add(stuName);
        add(usernameL);
        add(stuUsername);
        add(passwordL);
        add(stuPass);
        add(locationL);
        add(location);
        add(create);
        add(exit);
        setVisible(false);
    }
    public void actionPerformed(ActionEvent e){
        int studentID = 0;
        String studentName = stuName.getText();
        String studentUser = stuUsername.getText();
        String studentPass = stuPass.getText();
        JComboBox<String> location2 = (JComboBox<String>) e.getSource();
        String selectedLocation = (String) location2.getSelectedItem();
        if (selectedLocation.equals("Bukit Jalil")){
            System.out.println("Bukit Jalil is selected");
        } else if (selectedLocation.equals("Putrajaya")){
            System.out.println("Putrajaya is selected");
        }else if (selectedLocation.equals("Petaling Jaya")){
            System.out.println("Petaling Jaya is selected");
        }else if (selectedLocation.equals("Shah Alam")){
            System.out.println("Shah Alam is selected");
        }else{
            System.out.println("Bukit Jalil is selected");
        }
        if(e.getSource() == create){
            boolean flag = true;
            for(int i = 0; i<Assignment.studentInfo.size(); i++){
                Student studentA = Assignment.studentInfo.get(i);
                if(studentName.equals(studentA.getStuName())){
                    flag = false;
                    break;
                }
            }
            if (flag){
                Student studentReg = new Student(studentID,studentName,studentUser,studentPass,selectedLocation);
                Assignment.studentInfo.add(studentReg);
            } else{
                JOptionPane.showMessageDialog(create, "Name has been used!");
            }
        } else if(e.getSource() == exit){
            Assignment.register.setVisible(false);
            Assignment.login.setVisible(true);
        }
    }
}
