package Assignment;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

public class AdminManageSystem extends JPanel{
    private static ButtonGroup bGroup;
    private static JRadioButton rB1, rB2;
    private static JComboBox StudentUserB;
    private static JButton btn1, btn2,noti;
    private static JLabel Lab1, Lab2, Lab3, Lab4;
    private static JPanel Header, TopSelP, ModOwnP, ModOwnP1, ModOwnP2, ModOwnP3, ModStuP, ModStuP1, ModStuP2, ModStuP3, Body, NotiBody, NotiButtonBody;
    private static final ArrayList <String> StudentUsername = new <String> ArrayList();
    public AdminManageSystem(){
        CardLayout cl = new CardLayout();
        
        for(int i = 0; i<Assignment.studentInfo.size();i++){
            Student c = Assignment.studentInfo.get(i);
            StudentUsername.add(c.getStuName());
        }
        
        bGroup = new ButtonGroup();
        rB1 = new JRadioButton("Self Account");
        rB2 = new JRadioButton("Student Account");
        bGroup.add(rB1);
        bGroup.add(rB2);
        
        StudentUserB = new JComboBox(StudentUsername.toArray());
        btn1 = new JButton("Confirm");
        btn2 = new JButton("Confirm");
        noti = new JButton("Confirm");
        Lab1 = new JLabel("Username:    ");
        Lab2 = new JLabel("New Password:    ");
        Lab3 = new JLabel("Super Admin? (Yes/No):  ");
        Lab4 = new JLabel("New Password:    ");
        
        setLayout(new BorderLayout());
        
        Header = new JPanel(new FlowLayout(FlowLayout.CENTER,5,5));
        TopSelP = new JPanel(new FlowLayout(FlowLayout.CENTER,10,5));
        TopSelP.setBorder(BorderFactory.createTitledBorder("Modify Account"));
        TopSelP.add(rB1);
        TopSelP.add(rB2);
        Header.add(TopSelP);
        
        GridLayout gL = new GridLayout(3,1);
        gL.setVgap(5);
        ModOwnP = new JPanel(gL);
        ModOwnP1 = new JPanel(new FlowLayout(FlowLayout.CENTER));
        ModOwnP1.add(Lab3);
        ModOwnP2 = new JPanel(new FlowLayout(FlowLayout.CENTER));
        ModOwnP2.add(Lab4);
        ModOwnP3 = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        ModOwnP3.add(btn2);
        ModOwnP.add(ModOwnP1);
        ModOwnP.add(ModOwnP2);
        ModOwnP.add(ModOwnP3);
        
        ModStuP = new JPanel(gL);
        ModStuP1 = new JPanel(new FlowLayout(FlowLayout.CENTER));
        ModStuP1.add(Lab1);
        ModStuP1.add(StudentUserB);
        ModStuP2 = new JPanel(new FlowLayout(FlowLayout.CENTER));
        ModStuP2.add(Lab2);
        ModStuP3 = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        ModStuP3.add(btn1);
        ModStuP.add(ModStuP1);
        ModStuP.add(ModStuP2);
        ModStuP.add(ModStuP3);
        
        Header.add(ModOwnP);
        Header.add(ModStuP);
        
        Body = new JPanel(new BorderLayout());
        NotiBody = new JPanel(new FlowLayout());
        NotiButtonBody = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        NotiButtonBody.add(noti);
        Body.add(NotiBody, BorderLayout.NORTH);
        Body.add(NotiButtonBody, BorderLayout.CENTER);
        
        add(Header, BorderLayout.NORTH);
        add(Body, BorderLayout.CENTER);
    }
}
