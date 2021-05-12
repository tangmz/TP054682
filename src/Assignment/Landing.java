package Assignment;

import java.awt.Button;
import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Label;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Landing extends JFrame implements ActionListener{
    private Button student,admin,login,clear,exit, register, visitorView;
    private Label id,password, locationLabel;
    private TextField idIn,passIn; 
    private String Switch = "StudentL";
    JComboBox locationLogin = new JComboBox();
    GridBagConstraints gbc = new GridBagConstraints();
    public Landing(){
        //Landing object = new Landing();
        String place[] = {"Bukit Jalil", "Putrajaya", "Petaling Jaya", "Shah Alam"};
        for (int i = 0; i < place.length;i++){
            locationLogin.addItem(place[i]);
        }
        locationLogin.setSelectedItem("Bukit Jalil");
        setSize(350,250);
        setLocation(1000,300);
        setLayout(new GridBagLayout());
        gbc.insets = new Insets(5,6,5,6);
        setBackground(Color.white);
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
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.WEST;
        add(student, gbc);
        student.setBackground(Color.GREEN);
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.EAST;
        add(admin, gbc);
        admin.setBackground(Color.LIGHT_GRAY);
        //add(id);
        gbc.gridy = 1;
        gbc.anchor = GridBagConstraints.CENTER;
        add(idIn, gbc);
        //add(password);
        gbc.gridy = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        add(passIn, gbc);
        gbc.gridy = 3;
        gbc.anchor = GridBagConstraints.CENTER;
        add(locationLogin, gbc);
        gbc.gridx = 0;
        gbc.gridy = 4;
        add(login, gbc);
        gbc.gridx = 1;
        gbc.gridy = 4;
        gbc.anchor = GridBagConstraints.WEST;
        add(register, gbc);
        gbc.gridx = 1;
        gbc.gridy = 4;
        gbc.anchor = GridBagConstraints.EAST;
        add(clear,gbc);
        gbc.gridx = 2;
        gbc.gridy = 4;
        add(exit, gbc);
        gbc.gridx = 1;
        gbc.gridy = 5;
        gbc.anchor = GridBagConstraints.CENTER;
        add(visitorView, gbc);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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
                                setVisible(false);
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
