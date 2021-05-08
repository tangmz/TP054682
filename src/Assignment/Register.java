package Assignment;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Checkbox;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Label;
import java.awt.Panel;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.PrintWriter;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JOptionPane;

public class Register extends JFrame implements ActionListener{
    private Button create, exit;
    private Label nameL, usernameL, passwordL, locationL;
    private TextField stuName, stuUsername, stuPass, stuPlace;
    private JList regLocation;
    private JFrame x;
    private Panel c,s;
    public Register(){
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
        x.setVisible(true);
        comboBox.addItem("Bukit Jalil");
        comboBox.addItem("Putrajaya");
        comboBox.addItem("Petaling Jaya");
        comboBox.addItem("Shah Alam");
        comboBox.setSelectedItem(null);*/
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
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        add(nameL);
        add(stuName);
        add(usernameL);
        add(stuUsername);
        add(passwordL);
        add(stuPass);
        add(locationL);
        add(create);
        add(exit);
        setVisible(false);
    }
    @Override
    public void actionPerformed(ActionEvent e){
        String selectedLocation = "Test";
        //String selectedLocation = (String)comboBox.getSelectedItem().toString();
        int studentID = 1;
        int i = 0;
        String studentName = stuName.getText();
        String studentUser = stuUsername.getText();
        String studentPass = stuPass.getText();
        if(e.getSource() == create){
            boolean flag = true;
            for(i = 0; i<Assignment.studentInfo.size(); i++){
                Student studentA = Assignment.studentInfo.get(i);
                if(studentName.equals(studentA.getStuName())){
                    flag = false;
                    break;
                }
            }
            studentID = i + 1;
            if (flag){
                Student studentReg = new Student(studentID,studentName,studentUser,studentPass,selectedLocation);
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
        } else if(e.getSource() == exit){
            this.dispose();
            Assignment.login.setVisible(true);
        }
    }
}
