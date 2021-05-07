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
        if(e.getSource() == create){
            String stuID = JOptionPane.showInputDialog(("Enter your ID: "));
            boolean flag = true;
            for(int i = 0; i<Assignment.studentInfo.size(); i++){
                Student c = Assignment.studentInfo.get(i);
                if(stuID.equals(c.getStuName())){
                    flag = false;
                    break;
                }
            }
            String stuName = JOptionPane.showInputDialog(("Enter your name: "));
            boolean flag1 = true;
            for(int i = 0; i<Assignment.studentInfo.size(); i++){
                Student c = Assignment.studentInfo.get(i);
                if(stuName.equals(c.getStuName())){
                    flag1 = false;
                    break;
                }
            }
            String stuUserName = JOptionPane.showInputDialog(("Enter your username: "));
            boolean flag2 = true;
            for(int i = 0; i<Assignment.studentInfo.size(); i++){
                Student c = Assignment.studentInfo.get(i);
                if(stuUserName.equals(c.getStuName())){
                    flag2 = false;
                    break;
                }
            }
            JComboBox<String> location2 = (JComboBox<String>) e.getSource();
            String selectedLocation = (String) location2.getSelectedItem();
            if (flag){
                String pin = (JOptionPane.showInputDialog("Pin"));
                Student c = new Student(stuName, stuUserName, pin, selectedLocation);
                Assignment.studentInfo.add(c);
            } else{
                JOptionPane.showMessageDialog(create, "Name has been used!");
            }
        }
        else if(e.getSource() == exit){
            Assignment.register.setVisible(false);
            Assignment.login.setVisible(true);
        }
    }
}
