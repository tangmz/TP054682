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

public class RegisteredStudent{    
    private JPanel header, menuBody, displayBody, sidePanel;
    private String user, time;
    private JButton viewCoach, viewRecord, viewRegSport, modifyRecord, feedbackCoach, payment, attendance, logout; 
    private ImageIcon viewCoachLogo, viewRecordLogo, viewRegSportLogo;
    public void FrameLoad(String UserName){
        //++Logout Button++//
        JFrameFormat frame = new JFrameFormat(UserName);
        frame.setVisible(true);
        
        logout = new JButton("Logout");
        logout.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                frame.dispose();
                Assignment.login.setVisible(true);
            }
        });
        viewCoach = new JButton("View Coach");
        viewCoach.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                
            }
        });
        viewRecord = new JButton("View Self Records");
        viewRecord.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                
            }
        });
        viewRegSport = new JButton("View Sport Schedule");
        viewRegSport.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                
            }
        });
        modifyRecord = new JButton("Modify Self Records");
        modifyRecord.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                
            }
        });
        feedbackCoach = new JButton("Feedback");
        feedbackCoach.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                
            }
        });
        attendance = new JButton("Attendance");
        attendance.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                
            }
        });
        payment = new JButton("Payment");
        payment.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                
            }
        });
        viewCoachLogo = new ImageIcon(new ImageIcon(this.getClass().getResource("/PicLibrary/staff.png")).getImage().getScaledInstance(150, 150, Image.SCALE_SMOOTH));
        viewCoach = new JButton("View Coach", viewCoachLogo);
        viewRecordLogo = new ImageIcon(new ImageIcon(this.getClass().getResource("/PicLibrary/record.png")).getImage().getScaledInstance(150, 150, Image.SCALE_SMOOTH));
        viewRecord = new JButton("View Self Record", viewRecordLogo);
        viewRegSportLogo = new ImageIcon(new ImageIcon(this.getClass().getResource("/PicLibrary/schedule.png")).getImage().getScaledInstance(150, 150, Image.SCALE_SMOOTH));
        viewRegSport = new JButton("View Sport Schedule", viewRegSportLogo);
        DateFormat dateFormat = new SimpleDateFormat("dd-M-yyyy hh:mm:ss");
        String strDate = dateFormat.format(Assignment.DateTime);
        JLabel dateTime = new JLabel("Login DateTime: "+strDate, JLabel.CENTER);
        dateTime.setFont(new Font("Arial", Font.BOLD, 30));
        frame.header.add(dateTime, BorderLayout.CENTER);
        menuBody = new JPanel();
        menuBody.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY, 3));
        menuBody.setPreferredSize(new Dimension(150, frame.getHeight()));
        menuBody.setBackground(Color.WHITE);
        menuBody.setLayout(new FlowLayout());
        menuBody.add(viewCoach);
        menuBody.add(viewRecord);
        menuBody.add(viewRegSport);
        frame.Body.add(menuBody, BorderLayout.CENTER);
        sidePanel = new JPanel();
        sidePanel.setLayout(new GridLayout(5,1));
        sidePanel.add(modifyRecord);
        sidePanel.add(feedbackCoach);
        sidePanel.add(attendance);
        sidePanel.add(payment);
        sidePanel.add(logout);
        frame.Body.add(sidePanel, BorderLayout.WEST);
        displayBody = new JPanel();
        displayBody.setBorder(BorderFactory.createMatteBorder(3 , 0 , 3 , 3 ,Color.DARK_GRAY));
       

        
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
