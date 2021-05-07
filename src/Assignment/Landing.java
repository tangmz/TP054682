package Assignment;

import static Assignment.Assignment.adminInfo;
import static Assignment.Assignment.studentInfo;
import java.awt.Button;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Label;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.PrintWriter;
import java.util.Scanner;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JOptionPane;

public class Landing extends JFrame implements ActionListener{
    private Button student,admin,login,clear,exit, register;
    private JList location;
    private Label id,password, locationLabel;
    private TextField idIn,passIn; 
    private String Switch = "StudentL";
    public Landing(){
        //Landing object = new Landing();
        String place[] = {"Bukit Jalil", "Putrajaya", "Petaling Jaya", "Shah Alam"};
        JComboBox<String> location = new JComboBox<>(place);
        setSize(300,200);
        setLocation(1000,300);
        setLayout(new FlowLayout());
        setBackground(Color.white);
        student = new Button("Student");
        admin = new Button("Admin");
        login = new Button("Login");
        register = new Button("Register");
        clear = new Button("Clear");
        exit = new Button("Exit");
        id = new Label("ID: ");
        password = new Label("Password");
        idIn = new TextField(10);
        passIn = new TextField(10);
        locationLabel = new Label ("Select your location");
        student.addActionListener(this);
        admin.addActionListener(this);
        login.addActionListener(this);
        location.addActionListener(this);
        register.addActionListener(this);
        clear.addActionListener(this);
        exit.addActionListener(this);
        add(student);
        student.setBackground(Color.GREEN);
        add(admin);
        admin.setBackground(Color.LIGHT_GRAY);
        add(id);
        add(idIn);
        add(password);
        add(passIn);
        add(login);
        add(location);
        add(register);
        add(clear);
        add(exit);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent e){
        if(e.getSource()==student){
            student.setBackground(Color.GREEN);
            admin.setBackground(Color.LIGHT_GRAY);
            Switch= "StudentL";
        }else if(e.getSource()==admin){
            student.setBackground(Color.LIGHT_GRAY);
            admin.setBackground(Color.GREEN);
            Switch= "AdminL";
        }else if(e.getSource()==login){
            if(Switch=="StudenL"){
                String userInput = idIn.getText();
                for(int i=0; i<Assignment.studentInfo.size(); i++){
                    Student c = Assignment.studentInfo.get(i);
                    if(userInput.equals(c.getStuUserN())){
                        Assignment.whoStudentLogin = c;
                        break;
                    }
                }
                if(Assignment.whoStudentLogin==null){
                    JOptionPane.showMessageDialog(login, "Wrong username!");
                } else{
                    String passInput = passIn.getText();
                    if(passInput != Assignment.whoStudentLogin.getStuPass()){
                        JOptionPane.showMessageDialog(login, "Wrong password!");
                        Assignment.whoStudentLogin = null;
                    } else{
                        setVisible(false);  //same as this.setVisible(false);
                    }
                }
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
                System.out.println("DENY");
            }
            } else if (Switch == "AdminL"){
                String inputAdmin = JOptionPane.showInputDialog(("Enter name: "));
                boolean flag = true;
                for(int i = 0; i<Assignment.adminInfo.size(); i++){
                    Admin adminLogin = Assignment.adminInfo.get(i);
                    if(inputAdmin.equals(adminLogin.getAdName())){
                        flag = false;
                        Assignment.whoAdminLogin = adminLogin;
                        break;
                    }
                }
            }
            if(Assignment.whoAdminLogin == null){
                JOptionPane.showMessageDialog(login, "Wrong username!");
            } else{
                String s = JOptionPane.showInputDialog("Password:");
                if(s != Assignment.whoAdminLogin.getAdPass()){
                    JOptionPane.showMessageDialog(login, "Wrong password!");
                    Assignment.whoAdminLogin = null;
                } else{
                    setVisible(false); //same as this.setVisible(false);
                    //Assignment.second.setVisible(true);
                    }
            }
        }else if (e.getSource() == exit){
            try{
                PrintWriter f = new PrintWriter("studentLogin.txt");
                for(int i=0; i<Assignment.studentInfo.size(); i++){
                    Student c = Assignment.studentInfo.get(i);
                    f.println(c.getStuName());
                    f.println(c.getStuUserN());
                    f.println(c.getStuPass());
                    f.println(c.getStuPlace());
                    f.println();
                }
                f.close();
                f = new PrintWriter("adminLogin.txt");
                for (int i=0; i <Assignment.adminInfo.size(); i++){
                    Admin b = Assignment.adminInfo.get(i);
                    f.println(b.getAdName());
                    f. println(b.getAdUserN());
                    f.println(b.getAdPass());
                    f.println(b.getAdPlace());
                }
                f.close();
                System.exit(0);
            } catch (Exception error){
                System.out.println("Error");
                Runtime.getRuntime().exit(0);
            }
        } else if (e.getSource() == register){
            setVisible(false);
            Assignment.register.setVisible(true);
        }else if (e.getSource() == clear){
            idIn.setText("");
            passIn.setText("");
        }
    }
}
