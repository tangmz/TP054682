package Assignment;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Checkbox;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class RegisteredStudent extends DateTime{    
    private JPanel header, menuBody, displayBody, sidePanel, attendancePanel, menu, select1, select2, select3, select4, select5, select6, select7, select8, b1, b2, b3, b4, b5, b6, b7, c1,c2,c3,c4,c5,c6,c7, modifyPanel, d1, d2;
    private TextField stuID, stuName, stuUserN, stuPass, stuPlace, stuGender, stuPhone, modifyID, modifyName, modifyUserN, modifyPass, modifyPlace, modifyGender, modifyPhone;
    private String user, time, modPass, modPlace, modPhone, readID,readName, readUserN, readPass, readPlace, readGender, readPhone;
    private Checkbox basketball, badminton;
    private JButton viewCoach, viewRecord, viewRegSport, modifyRecord, feedbackCoach, payment, attendance, subscribeSport, attendanceConfirm, logout, modify, subscription, subscribe, unsubscribe; 
    private JLabel background, b1L, b2L, b3L, b4L, b5L, b6L, b7L,c1L,c2L,c3L,c4L,c5L,c6L,c7L, subscriptionTitle;
    private ImageIcon viewCoachLogo, viewRecordLogo, viewRegSportLogo, modifyLogo, feedbackLogo, attendanceLogo, paymentLogo, logoutLogo, backgroundImage, subscriptionLogo, subscribeLogo, unsubscribeLogo;
    public void FrameLoad(String UserName, String cenLocation){
        //++Logout Button++//
        CardLayout cl = new CardLayout();
        JFrameFormat frame = new JFrameFormat(UserName);
        frame.setVisible(true);
        frame.CenLocation.setSelectedItem(Location.valueOf(cenLocation));
        frame.CenLocation.setEnabled(false);
        viewCoachLogo = new ImageIcon(new ImageIcon(this.getClass().getResource("/PicLibrary/staff.png")).getImage().getScaledInstance(40, 40, Image.SCALE_SMOOTH));
        viewCoach = new JButton("View Coach", viewCoachLogo);
        viewCoach.setBackground(Color.WHITE);
        viewRecordLogo = new ImageIcon(new ImageIcon(this.getClass().getResource("/PicLibrary/record.png")).getImage().getScaledInstance(40, 40, Image.SCALE_SMOOTH));
        viewRecord = new JButton("View Self Record", viewRecordLogo);
        viewRecord.setBackground(Color.WHITE);
        viewRegSportLogo = new ImageIcon(new ImageIcon(this.getClass().getResource("/PicLibrary/schedule.png")).getImage().getScaledInstance(40, 40, Image.SCALE_SMOOTH));
        viewRegSport = new JButton("View Sport Schedule", viewRegSportLogo);
        viewRegSport.setBackground(Color.WHITE);
        modifyLogo = new ImageIcon(new ImageIcon(this.getClass().getResource("/PicLibrary/Modify.png")).getImage().getScaledInstance(40, 40, Image.SCALE_SMOOTH));
        modifyRecord = new JButton("Modify Record", modifyLogo);
        modifyRecord.setBackground(Color.WHITE);
        feedbackLogo = new ImageIcon(new ImageIcon(this.getClass().getResource("/PicLibrary/feedback.png")).getImage().getScaledInstance(40, 40, Image.SCALE_SMOOTH));
        feedbackCoach = new JButton("Feedback", feedbackLogo);
        feedbackCoach.setBackground(Color.WHITE);
        attendanceLogo = new ImageIcon(new ImageIcon(this.getClass().getResource("/PicLibrary/attendance.png")).getImage().getScaledInstance(40, 40, Image.SCALE_SMOOTH));
        attendance = new JButton("Attendance", attendanceLogo);
        attendance.setBackground(Color.WHITE);
        paymentLogo = new ImageIcon(new ImageIcon(this.getClass().getResource("/PicLibrary/payment.png")).getImage().getScaledInstance(40, 40, Image.SCALE_SMOOTH));
        payment = new JButton("Payment", paymentLogo);
        payment.setBackground(Color.WHITE);
        logoutLogo = new ImageIcon(new ImageIcon(this.getClass().getResource("/PicLibrary/logout.png")).getImage().getScaledInstance(40, 40, Image.SCALE_SMOOTH));
        logout = new JButton("Logout", logoutLogo);
        logout.setBackground(Color.WHITE);
        backgroundImage = new ImageIcon(new ImageIcon(this.getClass().getResource("/PicLibrary/background.png")).getImage());
        background = new JLabel(backgroundImage);
        subscriptionLogo = new ImageIcon(new ImageIcon(this.getClass().getResource("/PicLibrary/subscription.png")).getImage().getScaledInstance(40, 40, Image.SCALE_SMOOTH));
        subscription = new JButton("Subscription Sport", subscriptionLogo);
        subscription.setBackground(Color.WHITE);
        subscribeLogo = new ImageIcon(new ImageIcon(this.getClass().getResource("/PicLibrary/subscribe.png")).getImage().getScaledInstance(40, 40, Image.SCALE_SMOOTH));
        subscribe = new JButton("Subscribe", subscribeLogo);
        subscribe.setBackground(Color.WHITE);
        unsubscribeLogo = new ImageIcon(new ImageIcon(this.getClass().getResource("/PicLibrary/cancelSubscription.png")).getImage().getScaledInstance(40, 40, Image.SCALE_SMOOTH));
        unsubscribe = new JButton("Unsubscribe", unsubscribeLogo);
        unsubscribe.setBackground(Color.WHITE);
        frame.welcome.setText("Student Panel");
        frame.setTitle("Student Panel");
        menuBody = new JPanel();
        menuBody.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY, 3));
        menuBody.setPreferredSize(new Dimension(210, frame.getHeight()));
        menuBody.setBackground(Color.WHITE);
        menuBody.setLayout(new GridLayout(9,1));
        menuBody.add(viewCoach);
        menuBody.add(viewRecord);
        menuBody.add(viewRegSport);
        //frame.Body.add(menuBody, BorderLayout.CENTER);
        //sidePanel = new JPanel();
        
        menuBody.add(modifyRecord);
        menuBody.add(subscription);
        menuBody.add(feedbackCoach);
        menuBody.add(attendance);
        menuBody.add(payment);
        menuBody.add(logout);
        frame.Body.add(menuBody, BorderLayout.WEST);
        //Body//
        displayBody = new JPanel();
        displayBody.setLayout(cl);
        JLabel time = new JLabel(String.valueOf(getFullDate()), SwingConstants.CENTER);
        time.setFont(new Font("Arial", Font.BOLD, 30));
        JLabel dateTime = new JLabel(String.valueOf(getFullDate()), SwingConstants.CENTER);
        dateTime.setFont(new Font("Arial", Font.BOLD, 30));
        menu = new JPanel();
        menu.setLayout(new GridLayout(2, 1));
        menu.add(time);
        menu.add(background);
        menu.setBorder(BorderFactory.createMatteBorder(3 , 0 , 3 , 3 ,Color.DARK_GRAY));
//        frame.Body.add(menu, BorderLayout.CENTER);
        select1 = new JPanel();
        select1.setLayout(new GridLayout(2, 1));
        
        select2 = new JPanel();
        select2.setLayout(new GridLayout(7, 1, 3, 3));
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
        b1L = new JLabel("Student ID:                         ");
        b2L = new JLabel("Student Name:                 ");
        b3L = new JLabel("Student Username:          ");
        b4L = new JLabel("Student Password:          ");
        b5L = new JLabel("Student Location:             ");
        b6L = new JLabel("Student Gender:               ");
        b7L = new JLabel("Student Phone Number: ");
        b1 = new JPanel();
        b1.setLayout(new FlowLayout(FlowLayout.CENTER));
        b1.add(b1L);
        b1.add(stuID);
        select2.add(b1);
        b2 = new JPanel();
        b2.setLayout(new FlowLayout(FlowLayout.CENTER));
        b2.add(b2L);
        b2.add(stuName);
        select2.add(b2);
        b3 = new JPanel();
        b3.setLayout(new FlowLayout(FlowLayout.CENTER));
        b3.add(b3L);
        b3.add(stuUserN);
        select2.add(b3);
        b4 = new JPanel();
        b4.setLayout(new FlowLayout(FlowLayout.CENTER));
        b4.add(b4L);
        b4.add(stuPass);
        select2.add(b4);
        b5 = new JPanel();
        b5.setLayout(new FlowLayout(FlowLayout.CENTER));
        b5.add(b5L);
        b5.add(stuPlace);
        select2.add(b5);
        b6 = new JPanel();
        b6.setLayout(new FlowLayout(FlowLayout.CENTER));
        b6.add(b6L);
        b6.add(stuGender);
        select2.add(b6);
        b7 = new JPanel();
        b7.setLayout(new FlowLayout(FlowLayout.CENTER));
        b7.add(b7L);
        b7.add(stuPhone);
        select2.add(b7);
        select3 = new JPanel();
        select3.setLayout(new BorderLayout());
//        Tab3.add(aa);
        select4 = new JPanel();
        select4.setLayout(new GridLayout(8, 1, 3, 3));
        modifyID = new TextField(15);
        modifyID.setEditable(false);
        modifyName = new TextField(15);
        modifyName.setEditable(false);
        modifyUserN = new TextField(15);
        modifyUserN.setEditable(false);
        modifyPass = new TextField(15);
        modifyPass.setEditable(true);
        modifyPlace = new TextField(15);
        modifyPlace.setEditable(true);
        modifyGender = new TextField(15);
        modifyGender.setEditable(false);
        modifyPhone = new TextField(15);
        modifyPhone.setEditable(true);
        c1L = new JLabel("Student ID:                         ");
        c2L = new JLabel("Student Name:                 ");
        c3L = new JLabel("Student Username:          ");
        c4L = new JLabel("Student Password:          ");
        c5L = new JLabel("Student Location:             ");
        c6L = new JLabel("Student Gender:               ");
        c7L = new JLabel("Student Phone Number: ");
        c1 = new JPanel();
        c1.setLayout(new FlowLayout(FlowLayout.CENTER));
        c1.add(c1L);
        c1.add(modifyID);
        select4.add(c1);
        c2 = new JPanel();
        c2.setLayout(new FlowLayout(FlowLayout.CENTER));
        c2.add(c2L);
        c2.add(modifyName);
        select4.add(c2);
        c3 = new JPanel();
        c3.setLayout(new FlowLayout(FlowLayout.CENTER));
        c3.add(c3L);
        c3.add(modifyUserN);
        select4.add(c3);
        c4 = new JPanel();
        c4.setLayout(new FlowLayout(FlowLayout.CENTER));
        c4.add(c4L);
        c4.add(modifyPass);
        select4.add(c4);
        c5 = new JPanel();
        c5.setLayout(new FlowLayout(FlowLayout.CENTER));
        c5.add(c5L);
        c5.add(modifyPlace);
        select4.add(c5);
        c6 = new JPanel();
        c6.setLayout(new FlowLayout(FlowLayout.CENTER));
        c6.add(c6L);
        c6.add(modifyGender);
        select4.add(c6);
        c7 = new JPanel();
        c7.setLayout(new FlowLayout(FlowLayout.CENTER));
        c7.add(c7L);
        c7.add(modifyPhone);
        select4.add(c7);
        modify = new JButton("Modify");
        modify.setFont(new Font ("Arial", Font.BOLD, 30));
        modify.setBackground(Color.WHITE);
        select4.add(modify);
        select5 = new JPanel();
        select5.setLayout(new BorderLayout());
        subscriptionTitle = new JLabel("Subscription Sport", JLabel.CENTER);
        subscriptionTitle.setFont(new Font("Arial", Font.BOLD, 50));
        badminton = new Checkbox("Badminton");
        badminton.setFont(new Font("Arial", Font.BOLD, 30));
        basketball = new Checkbox("Basketball");
        basketball.setFont(new Font("Arial", Font.BOLD, 30));
        select5.add(subscriptionTitle, BorderLayout.NORTH);
        d1 = new JPanel();
        d1.setLayout(new FlowLayout());
        d1.add(badminton);
        d1.add(basketball);
        select5.add(d1, BorderLayout.CENTER);
        select6 = new JPanel();
        select6.setLayout(new BorderLayout());
        select6.add(dateTime, BorderLayout.NORTH);
        SimpleDateFormat dayFormat = new SimpleDateFormat("dd");
        SimpleDateFormat hourFormat = new SimpleDateFormat("HH");
        Date date = new Date();
        String dayCheck = dayFormat.format(date);
        String hourCheck = hourFormat.format(date);
        String day = "Monday";
        int hourCheckInteger = Integer.parseInt(hourCheck);
        int i = 1;
        int startTime = 10;
        int endTime = 12;
        if (i == 1){
            startTime = 10;
            endTime = 12;
        }
        if (dayCheck == day){
            if ((hourCheckInteger > startTime)&&(hourCheckInteger <endTime)){
                
            }
            
                
        }
        attendanceConfirm = new JButton("Attendace");
        attendanceConfirm.setBackground(Color.GREEN);
        attendanceConfirm.setFont(new Font("Arial", Font.BOLD, 30));
        select6.add(attendanceConfirm, BorderLayout.CENTER);
        attendanceConfirm.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                    
            }
        });
        
        select7 = new JPanel();
        select7.setLayout(new BorderLayout());

        
        displayBody.add(menu, "1");
        displayBody.add(select1, "2");
        displayBody.add(select2, "3");
        displayBody.add(select3, "4");
        displayBody.add(select4, "5");
        displayBody.add(select5, "6");
        displayBody.add(select6, "7");
        displayBody.add(select7, "8");
        cl.show(displayBody, "1");
        frame.Body.add(displayBody, BorderLayout.CENTER);
        logout.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                frame.dispose();
                Assignment.login.setVisible(true);
            }
        });
        viewCoach.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                cl.show(displayBody, "2");
            }
        });
        viewRecord.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                cl.show(displayBody, "3");
                for(int i=0; i<Assignment.studentInfo.size(); i++){
                    Student c = Assignment.studentInfo.get(i);
                    if(UserName.equals(c.getStuUserN())){
                        stuID.setText(c.getStuID());
                        stuName.setText(c.getStuName());
                        stuUserN.setText(c.getStuUserN());
                        stuPass.setText(c.getStuPass());
                        stuPlace.setText(c.getStuPlace());
                        stuGender.setText(c.getStuGender());
                        stuPhone.setText(c.getStuPhone());
                    }
                }
            }
        });
        viewRegSport.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {

            }
        });
        modifyRecord.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                cl.show(displayBody, "5");
                for(int i=0; i<Assignment.studentInfo.size(); i++){
                    Student c = Assignment.studentInfo.get(i);
                    if(UserName.equals(c.getStuUserN())){
                        modifyID.setText(c.getStuID());
                        modifyName.setText(c.getStuName());
                        modifyUserN.setText(c.getStuUserN());
                        modifyPass.setText(c.getStuPass());
                        modifyPlace.setText(c.getStuPlace());
                        modifyGender.setText(c.getStuGender());
                        modifyPhone.setText(c.getStuPhone());
                    }
                }
            }
        });
        modify.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                modPass = modifyPass.getText();
                modPlace = modifyPlace.getText();
                modPhone = modifyPhone.getText();
                try{
                    PrintWriter f = new PrintWriter("studentLogin.txt");
                    for(int i=0; i<Assignment.studentInfo.size(); i++){
                        Student c = Assignment.studentInfo.get(i);
                        if(UserName.equals(c.getStuUserN())){
                            c.setStuPass(modPass);
                            c.setStuPlace(modPlace);
                            c.setStuPhone(modPhone);
                        }    
//                        }else{
//                            System.out.println(c.getStuID());
//                            tempF.println(c.getStuID());
//                            tempF.println(c.getStuName());
//                            tempF.println(c.getStuUserN());
//                            tempF.println(c.getStuPass());
//                            tempF.println(c.getStuPlace());
//                            tempF.println(c.getStuGender());
//                            tempF.println(c.getStuPhone());
//                            tempF.println();
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
//                        tempF.flush();
//                        oldFile.delete();
//                        newFile.renameTo(oldFile);
                
                     
                    
                } catch(Exception ex){
                            System.out.println("Error in stop!");
                    }
            }
        });
        subscription.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                cl.show(displayBody, "6");
            }
        });
        feedbackCoach.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {

            }
        });
        attendance.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                cl.show(displayBody, "7");
            }
        });
        payment.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {

            }
        });


    }
}

//    @Override
//    public void actionPerformed(ActionEvent ae) {
//        
//    }
//}
//    private JButton view, modify, feedback, exit;
//    Image newImage = new ImageIcon(this.getClass().getResource("/PicLibrary/badminton.png")).getImage().getScaledInstance(200, 200, Image.SCALE_SMOOTH);
//    Icon image1 = new ImageIcon(newImage);
//    private JPanel header, menuBody, menuTop, menuR1, menuR2;
//    private String user;
//    private Button logout;
//    public void FrameLoad(String userName){
//        JFrameFormat frame = new JFrameFormat(userName);
//        frame.setVisible(true);
//        logout = new Button("Logout");
//        logout.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent ae) {
//                frame.dispose();
//                Assignment.login.setVisible(true);
//            }
//        });
//        frame.Body.add(logout);
//    }
//}
//    
//    public RegisteredStudent(){
//        setSize(300,200);
//        setLocation(800,300);
//        setLayout(new FlowLayout());
//        setBackground(Color.white);
//        view = new JButton(image1);
//        add(view);
//        setVisible(false);
//    }
//
//    @Override
//    public void actionPerformed(ActionEvent ae) {
//     
//    }
//    
//}
