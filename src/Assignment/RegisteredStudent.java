package Assignment;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class RegisteredStudent extends DateTime{    
    private JPanel menuBody, displayBody, menu, select1, select2, select3, select4, select5, select6, select7, select8;
    private JButton viewCoach, viewRecord, viewRegSport, modifyRecord, feedbackCoach, payment, attendance, attendanceConfirm, logout, subscription;
    private JLabel background;
    private ImageIcon viewCoachLogo, viewRecordLogo, viewRegSportLogo, modifyLogo, feedbackLogo, attendanceLogo, paymentLogo, logoutLogo, backgroundImage, subscriptionLogo;
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
        //Design Panel and Layout
        //MenuBody Panel
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
        menuBody.add(modifyRecord);
        menuBody.add(subscription);
        menuBody.add(feedbackCoach);
        menuBody.add(attendance);
        menuBody.add(payment);
        menuBody.add(logout);
        frame.Body.add(menuBody, BorderLayout.WEST);
        //DisplayBody
        displayBody = new JPanel();
        displayBody.setLayout(cl);
        JLabel time = new JLabel(String.valueOf(getFullDate()), SwingConstants.CENTER);
        time.setFont(new Font("Arial", Font.BOLD, 30));
        JLabel dateTime = new JLabel(String.valueOf(getFullDate()), SwingConstants.CENTER);
        dateTime.setFont(new Font("Arial", Font.BOLD, 30));
        //menu Panel
        menu = new JPanel();
        menu.setLayout(new GridLayout(2, 1));
        menu.add(time);
        menu.add(background);
        menu.setBorder(BorderFactory.createMatteBorder(3 , 0 , 3 , 3 ,Color.DARK_GRAY));
        //select1 Panel for Viewing Coach
        select1 = new JPanel();
        select1.setLayout(new BorderLayout());
        ViewCoachDetail a = new ViewCoachDetail(cenLocation);
        select1.add(a);
        //select2 Panel for Viewing Self Record
        select2 = new JPanel();
        ViewRecord b = new ViewRecord(UserName);
        select2.add(b);
        //select3 Panel for Viewing Registered Sport Schedule
        select3 = new JPanel();
        select3.setLayout(new BorderLayout());
        ViewSchedule c = new ViewSchedule(cenLocation, UserName);
        select3.add(c);
        //select4 Panel for Modifying Self Record
        select4 = new JPanel();
        ModifyRecord d = new ModifyRecord(UserName, cenLocation);
        select4.add(d);
        //select5 Panel for subscribing or unsubscribing sports
        select5 = new JPanel();
        SubscriptionSport e = new SubscriptionSport(UserName, cenLocation);
        select5.add(e);
        //select 6 Panel is feedback Panel that allow student to give feedback to the coach
        select6 = new JPanel();
        select6.setLayout(new BorderLayout());
        Feedback f = new Feedback(cenLocation, UserName);
        select6.add(f);
//        SimpleDateFormat dayFormat = new SimpleDateFormat("dd");
//        SimpleDateFormat hourFormat = new SimpleDateFormat("HH");
//        Date date = new Date();
//        String dayCheck = dayFormat.format(date);
//        String hourCheck = hourFormat.format(date);
//        String day = "Monday";
//        int hourCheckInteger = Integer.parseInt(hourCheck);
//        int i = 1;
//        int startTime = 10;
//        int endTime = 12;
//        if (i == 1){
//            startTime = 10;
//            endTime = 12;
//        }
//        if (dayCheck == day){
//            if ((hourCheckInteger > startTime)&&(hourCheckInteger <endTime)){
//                
//            }
//            
//                
//        }
        //select7 for payment 
        select7 = new JPanel();
        select7.setLayout(new BorderLayout());
        select7.add(dateTime, BorderLayout.NORTH);
        attendanceConfirm = new JButton("Attendace");
        attendanceConfirm.setBackground(Color.GREEN);
        attendanceConfirm.setFont(new Font("Arial", Font.BOLD, 30));
        select7.add(attendanceConfirm, BorderLayout.CENTER);
        attendanceConfirm.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                    
            }
        });
        select8 = new JPanel();
        select8.setLayout(new BorderLayout());
        //DisplayBody for the cardLayout
        displayBody.add(menu, "1");
        displayBody.add(select1, "2");
        displayBody.add(select2, "3");
        displayBody.add(select3, "4");
        displayBody.add(select4, "5");
        displayBody.add(select5, "6");
        displayBody.add(select6, "7");
        displayBody.add(select7, "8");
        displayBody.add(select8, "9");
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
            }
        });
        viewRegSport.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                cl.show(displayBody, "4");
            }
        });

        modifyRecord.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                cl.show(displayBody, "5");
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
                cl.show(displayBody, "7");
            }
        });
        attendance.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                cl.show(displayBody, "8");
            }
        });
        payment.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                cl.show(displayBody, "9");
            }
        });


    }
}
