package Assignment;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class RegisteredStudent extends DateTime{    
    private JPanel header, menuBody, displayBody, sidePanel, attendancePanel;
    private String user, time;
    private JButton viewCoach, viewRecord, viewRegSport, modifyRecord, feedbackCoach, payment, attendance, attendanceConfirm, logout; 
    private JLabel background;
    private ImageIcon viewCoachLogo, viewRecordLogo, viewRegSportLogo, modifyLogo, feedbackLogo, attendanceLogo, paymentLogo, logoutLogo, backgroundImage;
    public void FrameLoad(String UserName){
        //++Logout Button++//
        JFrameFormat frame = new JFrameFormat(UserName);
        frame.setVisible(true);
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
        frame.welcome.setText("Student Panel");
        frame.setTitle("Student Panel");
        menuBody = new JPanel();
        menuBody.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY, 3));
        menuBody.setPreferredSize(new Dimension(210, frame.getHeight()));
        menuBody.setBackground(Color.WHITE);
        menuBody.setLayout(new GridLayout(8,1));
        menuBody.add(viewCoach);
        menuBody.add(viewRecord);
        menuBody.add(viewRegSport);
        //frame.Body.add(menuBody, BorderLayout.CENTER);
        //sidePanel = new JPanel();
        
        menuBody.add(modifyRecord);
        menuBody.add(feedbackCoach);
        menuBody.add(attendance);
        menuBody.add(payment);
        menuBody.add(logout);
        frame.Body.add(menuBody, BorderLayout.WEST);
        displayBody = new JPanel();
        JLabel dateTime = new JLabel(String.valueOf(getFullDate()), SwingConstants.CENTER);
        dateTime.setFont(new Font("Arial", Font.BOLD, 30));
        displayBody.setLayout(new GridLayout(2, 1));
        displayBody.add(dateTime);
        displayBody.add(background);
        displayBody.setBorder(BorderFactory.createMatteBorder(3 , 0 , 3 , 3 ,Color.DARK_GRAY));
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
                
                displayBody.removeAll();
               
                //displayBody.add(a);
                displayBody.repaint();
            }
        });
        viewRecord.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {

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
//                displayBody.setVisible(true);
//                attendancePanel = new JPanel();
//                attendanceConfirm = new JButton("Attendace");
//                attendanceConfirm.setBackground(Color.GREEN);
//                attendancePanel.add(attendanceConfirm);
//                attendancePanel.setVisible(false);
//                frame.Body.add(attendancePanel, BorderLayout.CENTER);
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
