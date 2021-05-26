package Assignment;

import Assignment.RegisteredStudent.studentRepaint;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.io.PrintWriter;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;


public class ModifyRecord extends JPanel implements ActionListener {
    private TextField modifyID, modifyName, modifyUserN, modifyPass,  modifyGender, modifyPhone;
    private JComboBox locationReg;
    private JLabel titleL, c1L,c2L,c3L,c4L,c5L,c6L,c7L;
    private JPanel title, c1,c2,c3,c4,c5,c6,c7;
    private JButton modify;
    private String userName2, selectedLocation;
    private static boolean flag = false;
    public ModifyRecord(String UserName, String cenLocation){
        //TextField

        userName2 = UserName;
        modifyID = new TextField(15);
        modifyID.setEditable(false);
        modifyName = new TextField(15);
        modifyName.setEditable(false);
        modifyUserN = new TextField(15);
        modifyUserN.setEditable(false);
        modifyPass = new TextField(15);
        modifyPass.setEditable(true);
        modifyGender = new TextField(15);
        modifyGender.setEditable(false);
        modifyPhone = new TextField(15);
        modifyPhone.setEditable(true);
        //To get the data from studentInfo and display in the TextFields
        for(int i=0; i<Assignment.studentInfo.size(); i++){
            Student c = Assignment.studentInfo.get(i);
            if(UserName.equals(c.getStuUserN())){
                modifyID.setText(c.getStuID());
                modifyName.setText(c.getStuName());
                modifyUserN.setText(c.getStuUserN());
                modifyPass.setText(c.getStuPass());
                        
                modifyGender.setText(c.getStuGender());
                modifyPhone.setText(c.getStuPhone());
            }
        }
        //Label for all the TextFields
        titleL = new JLabel("Modify Self Record");
        titleL.setFont(new Font("Arial", Font.BOLD, 40));
        c1L = new JLabel("Student ID:                         ");
        c2L = new JLabel("Student Name:                 ");
        c3L = new JLabel("Student Username:          ");
        c4L = new JLabel("Student Password:          ");
        c5L = new JLabel("Student Location:             ");
        c6L = new JLabel("Student Gender:               ");
        c7L = new JLabel("Student Phone Number: ");
        //Panel Design
        setLayout(new GridLayout(9, 1, 3, 3));
        title = new JPanel();
        title.setLayout(new FlowLayout(FlowLayout.CENTER));
        title.add(titleL);
        add(title);
        c1 = new JPanel();
        c1.setLayout(new FlowLayout(FlowLayout.CENTER));
        c1.add(c1L);
        c1.add(modifyID);
        add(c1);
        c2 = new JPanel();
        c2.setLayout(new FlowLayout(FlowLayout.CENTER));
        c2.add(c2L);
        c2.add(modifyName);
        add(c2);
        c3 = new JPanel();
        c3.setLayout(new FlowLayout(FlowLayout.CENTER));
        c3.add(c3L);
        c3.add(modifyUserN);
        add(c3);
        c4 = new JPanel();
        c4.setLayout(new FlowLayout(FlowLayout.CENTER));
        c4.add(c4L);
        c4.add(modifyPass);
        add(c4);
        c5 = new JPanel();
        c5.setLayout(new FlowLayout(FlowLayout.CENTER));
        c5.add(c5L);
        locationReg = new JComboBox();
        locationReg.addItem(cenLocation);
        locationReg.setSelectedItem(cenLocation);
        c5.add(locationReg);
        add(c5);
        c6 = new JPanel();
        c6.setLayout(new FlowLayout(FlowLayout.CENTER));
        c6.add(c6L);
        c6.add(modifyGender);
        add(c6);
        c7 = new JPanel();
        c7.setLayout(new FlowLayout(FlowLayout.CENTER));
        c7.add(c7L);
        c7.add(modifyPhone);
        add(c7);
        modify = new JButton("Modify");
        modify.setFont(new Font ("Arial", Font.BOLD, 30));
        modify.setBackground(Color.WHITE);
        add(modify);
        modify.addActionListener(this);

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
    }
    @Override
    public void actionPerformed(ActionEvent ae) {
        selectedLocation = locationReg.getSelectedItem().toString();
        if (ae.getSource()==modify){
            for(int i=0; i<Assignment.studentInfo.size(); i++){
                Student c = Assignment.studentInfo.get(i);
                if(userName2.equals(c.getStuUserN())){
                    c.setStuPass(modifyPass.getText());
                    c.setStuPlace(selectedLocation);
                    c.setStuPhone(modifyPhone.getText());
                }
            }
            try{
                PrintWriter f = new PrintWriter("studentLogin.txt");
                for(int i=0; i<Assignment.studentInfo.size(); i++){
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
            } catch(Exception ex){
                System.out.println("Error in stop!");
            }
            JOptionPane.showMessageDialog(modify, "You have modified your self record");
        }
        studentRepaint paint = new studentRepaint();
    }
}
