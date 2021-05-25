package Assignment;

import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ViewRecord extends JPanel {
    private JPanel b1, b2, b3, b4, b5, b6, b7, titlePanel;
    private TextField stuID, stuName, stuUserN, stuPass, stuPlace, stuGender, stuPhone;
    private JLabel b1L, b2L, b3L, b4L, b5L, b6L, b7L, title;
    private String studentName;
    public ViewRecord(String userName){
        //Assigning variable
        studentName = userName;
        //TextFields
        stuID = new TextField(15);
        stuID.setEditable(false);
        stuName = new TextField(15);
        stuName.setEditable(false);
        stuUserN = new TextField(15);
        stuUserN.setEditable(false);
        stuPass = new TextField(15);
        stuPass.setEditable(false);
        stuPlace = new TextField(15);
        stuPlace.setEditable(false);
        stuGender = new TextField(15);
        stuGender.setEditable(false);
        stuPhone = new TextField(15);
        stuPhone.setEditable(false);
        //Label
        title = new JLabel("Self Record", JLabel.CENTER);
        title.setFont(new Font("Arial", Font.BOLD, 40));
        b1L = new JLabel("Student ID:                         ");
        b2L = new JLabel("Student Name:                 ");
        b3L = new JLabel("Student Username:          ");
        b4L = new JLabel("Student Password:          ");
        b5L = new JLabel("Student Location:             ");
        b6L = new JLabel("Student Gender:               ");
        b7L = new JLabel("Student Phone Number: ");
        //Button
        for(int i=0; i<Assignment.studentInfo.size(); i++){
            Student c = Assignment.studentInfo.get(i);
            if(studentName.equals(c.getStuUserN())){
                stuID.setText(c.getStuID());
                stuName.setText(c.getStuName());
                stuUserN.setText(c.getStuUserN());
                stuPass.setText(c.getStuPass());
                stuPlace.setText(c.getStuPlace());
                stuGender.setText(c.getStuGender());
                stuPhone.setText(c.getStuPhone());
            }
        }
       
        //Panel Design
        setLayout(new GridLayout(9, 1, 3, 3));
        titlePanel = new JPanel();
        titlePanel.add(title);
        add(titlePanel);
        b1 = new JPanel();
        b1.setLayout(new FlowLayout(FlowLayout.CENTER));
        b1.add(b1L);
        b1.add(stuID);
        add(b1);
        b2 = new JPanel();
        b2.setLayout(new FlowLayout(FlowLayout.CENTER));
        b2.add(b2L);
        b2.add(stuName);
        add(b2);
        b3 = new JPanel();
        b3.setLayout(new FlowLayout(FlowLayout.CENTER));
        b3.add(b3L);
        b3.add(stuUserN);
        add(b3);
        b4 = new JPanel();
        b4.setLayout(new FlowLayout(FlowLayout.CENTER));
        b4.add(b4L);
        b4.add(stuPass);
        add(b4);
        b5 = new JPanel();
        b5.setLayout(new FlowLayout(FlowLayout.CENTER));
        b5.add(b5L);
        b5.add(stuPlace);
        add(b5);
        b6 = new JPanel();
        b6.setLayout(new FlowLayout(FlowLayout.CENTER));
        b6.add(b6L);
        b6.add(stuGender);
        add(b6);
        b7 = new JPanel();
        b7.setLayout(new FlowLayout(FlowLayout.CENTER));
        b7.add(b7L);
        b7.add(stuPhone);
        add(b7);
    }
}
