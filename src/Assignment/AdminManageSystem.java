package Assignment;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class AdminManageSystem extends JPanel{
    private static ButtonGroup bGroup;
    private static JRadioButton rB1, rB2;
    private static JComboBox StudentUserB;
    private static JButton btn1, btn2, noti, notiClear;
    private static JLabel Lab1, Lab2, Lab3, Lab4, Lab5;
    private static JTextField Txt1, Txt2, NotiTxt;
    private static JCheckBox cB1;
    private static JPanel Header, TopSelP, CardContainer, ModOwnP, ModOwnP1, ModOwnP2, ModOwnP3, ModStuP, ModStuP1, ModStuP2, ModStuP3, Body, NotiBody, NotiButtonBody;
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
        rB1.setSelected(true);
        rB1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                cl.show(CardContainer, "1");
            }
        });
        rB2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                cl.show(CardContainer, "2");
            }
        });
        
        StudentUserB = new JComboBox(StudentUsername.toArray());
        btn1 = new JButton("Confirm");
        btn2 = new JButton("Confirm");
        noti = new JButton("Confirm");
        notiClear = new JButton("Clear");
        Txt1 = new JTextField(10);
        Txt2 = new JTextField(10);
        NotiTxt = new JTextField(50);
        Lab1 = new JLabel("Super Admin? (Yes/No):  ");
        Lab2 = new JLabel("New Password:    ");
        Lab3 = new JLabel("Username:    ");
        Lab4 = new JLabel("New Password:    ");
        Lab5 = new JLabel("Announcement Message:    ");
        cB1 = new JCheckBox();
        
        setLayout(new BorderLayout());
        
        Header = new JPanel(new BorderLayout());
        Header.setBorder(BorderFactory.createTitledBorder("Modify Account"));
        TopSelP = new JPanel(new FlowLayout(FlowLayout.CENTER,10,5));
        TopSelP.add(rB1);
        TopSelP.add(rB2);
        Header.add(TopSelP, BorderLayout.NORTH);
        
        GridLayout gL = new GridLayout(3,1);
        gL.setVgap(5);
        ModOwnP = new JPanel(gL);
        ModOwnP1 = new JPanel(new FlowLayout(FlowLayout.CENTER));
        ModOwnP1.add(Lab1);
        ModOwnP1.add(cB1);
        ModOwnP2 = new JPanel(new FlowLayout(FlowLayout.CENTER));
        ModOwnP2.add(Lab2);
        ModOwnP2.add(Txt1);
        ModOwnP3 = new JPanel(new FlowLayout(FlowLayout.CENTER));
        ModOwnP3.add(btn1);
        ModOwnP.add(ModOwnP1);
        ModOwnP.add(ModOwnP2);
        ModOwnP.add(ModOwnP3);
        
        ModStuP = new JPanel(gL);
        ModStuP1 = new JPanel(new FlowLayout(FlowLayout.CENTER));
        ModStuP1.add(Lab3);
        ModStuP1.add(StudentUserB);
        ModStuP2 = new JPanel(new FlowLayout(FlowLayout.CENTER));
        ModStuP2.add(Lab4);
        ModStuP2.add(Txt2);
        ModStuP3 = new JPanel(new FlowLayout(FlowLayout.CENTER));
        ModStuP3.add(btn2);
        ModStuP.add(ModStuP1);
        ModStuP.add(ModStuP2);
        ModStuP.add(ModStuP3);
        
        CardContainer = new JPanel(cl);
        CardContainer.add(ModOwnP, "1");
        CardContainer.add(ModStuP, "2");
        cl.show(CardContainer, "1");
        Header.add(CardContainer, BorderLayout.CENTER);
        
        Body = new JPanel(new BorderLayout());
        Body.setBorder(BorderFactory.createTitledBorder("Set System Announcement"));
        NotiBody = new JPanel(new FlowLayout());
        NotiBody.add(Lab5);
        NotiBody.add(NotiTxt);
        NotiButtonBody = new JPanel(new FlowLayout(FlowLayout.CENTER));
        NotiButtonBody.add(noti);
        NotiButtonBody.add(notiClear);
        Body.add(NotiBody, BorderLayout.NORTH);
        Body.add(NotiButtonBody, BorderLayout.CENTER);
        
        add(Header, BorderLayout.NORTH);
        add(Body, BorderLayout.CENTER);
    }
}
