package Assignment;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

public class AdminManageSystem extends JPanel{
    //Variable Declaration
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
        StudentUsername.removeAll(StudentUsername);
        
        for(int i = 0; i<Assignment.studentInfo.size();i++){
            Student c = Assignment.studentInfo.get(i);
            if(c.getStuPlace().equals(RegisteredAdmin.centerLocation)){
                StudentUsername.add(c.getStuName());
            }
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
        cB1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                String pinAdmin = JOptionPane.showInputDialog("Passphrase");
                if (!pinAdmin.equals("rcsadmin")){
                    JOptionPane.showMessageDialog(cB1, "Wrong Passphrase!");
                    if(cB1.isSelected()==false){
                        cB1.setSelected(true);
                    }else if(cB1.isSelected()==true){
                        cB1.setSelected(false);
                    }
                }
            }
        });
        noti.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                boolean Found = false;
                for(int i = 0; i<Assignment.noti.size(); i++){
                    VisitorAnnouncement vs = Assignment.noti.get(i);
                    if(vs.getCenLocation().equals(RegisteredAdmin.centerLocation)){
                        vs.setMessage(NotiTxt.getText());
                        Assignment.noti.set(i, vs);
                        Found = true;
                    }
                }
                if(Found == true){
                    try{
                        PrintWriter f = new PrintWriter("announcement.txt");
                        for(int i=0; i<Assignment.noti.size(); i++){
                            VisitorAnnouncement vs = Assignment.noti.get(i);
                            f.println(vs.getCenLocation());
                            f.println(vs.getMessage());
                            f.println();
                        }
                        f.close();   

                    } catch(Exception ex){
                        System.out.println("Error in stop!");
                    }
                    Found = false;
                }else if(Found == false){
                    VisitorAnnouncement writeVS = new VisitorAnnouncement(RegisteredAdmin.centerLocation,NotiTxt.getText());
                    Assignment.noti.add(writeVS);
                    try{
                        PrintWriter f = new PrintWriter("announcement.txt");
                        for(int i=0; i<Assignment.noti.size(); i++){
                            VisitorAnnouncement vs = Assignment.noti.get(i);
                            f.println(vs.getCenLocation());
                            f.println(vs.getMessage());
                            f.println();
                        }
                        f.close();   

                    } catch(Exception ex){
                        System.out.println("Error in stop!");
                    }
                }
                RegisteredAdmin.Repaint r = new RegisteredAdmin.Repaint();
                JOptionPane.showMessageDialog(noti,"Announcement Sent!");
            }
        });
        notiClear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                NotiTxt.setText("==NO UPDATES==");
            }
        });
        btn1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                for(int i = 0; i<Assignment.adminInfo.size();i++){
                    Admin ad = Assignment.adminInfo.get(i);
                    if(ad.getAdUserN().equals(RegisteredAdmin.Username)){
                        if(cB1.isSelected()==true){
                            ad.setSuperRole("yes");
                        }else{
                            ad.setSuperRole("no");
                        }
                        if(!Txt1.getText().equals("")){
                            ad.setAdPass(Txt1.getText());
                        }
                        Assignment.adminInfo.set(i, ad);
                        System.out.println(Assignment.adminInfo.get(i));
                        JOptionPane.showMessageDialog(btn2, "\tAccount Updated!\n\n\tSuper Admin:    "+ad.getSuperRole());
                        break;
                    }
                }
            }
        });
        btn2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                for(int i = 0; i<Assignment.studentInfo.size();i++){
                    Student stu = Assignment.studentInfo.get(i);
                    if(stu.getStuUserN().equals(StudentUserB.getSelectedItem())){
                        stu.setStuPass(Txt2.getText());
                        Assignment.studentInfo.set(i, stu);
                        JOptionPane.showMessageDialog(btn2, stu.getStuName()+"'s new password:  "+stu.getStuPass());
                        break;
                    }
                }
            }
        });
        
        //To read and set Text to the TextField
        for(int i = 0; i<Assignment.noti.size(); i++){
            VisitorAnnouncement vs = Assignment.noti.get(i);
            if(vs.getCenLocation().equals(RegisteredAdmin.centerLocation)){
                NotiTxt.setText(vs.getMessage());
            }
            break;
        }
        
        SuperAdmin();
        
        setLayout(new BorderLayout());
        
        Header = new JPanel(new BorderLayout());
        Header.setBorder(BorderFactory.createTitledBorder(null,"--Modify Account--",TitledBorder.CENTER,TitledBorder.TOP,new Font("Verdana",Font.BOLD,25),Color.DARK_GRAY));
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
        Body.setBorder(BorderFactory.createTitledBorder(null,"--System Announcement--",TitledBorder.CENTER,TitledBorder.TOP,new Font("Verdana",Font.BOLD,25),Color.DARK_GRAY));
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
    
    private void SuperAdmin(){
        for(int i = 0; i<Assignment.adminInfo.size();i++){
            Admin a = Assignment.adminInfo.get(i);
            if(a.getAdUserN().equals(RegisteredAdmin.Username)&&a.getSuperRole().equals("yes")){
                cB1.setSelected(true);
            }else{
                cB1.setSelected(false);
            }
        }
    }
}
