package Assignment;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class RegisteredStudent{    
    private JPanel header, menuBody, displayBody;
    private String user;
    private Button viewCoach, viewRecord, viewRegSport, modifyRecord, feedbackCoach, payment, attendance, logout; //SearchRecord inclusive of Sorting
    
    public void FrameLoad(String UserName){
        //++Logout Button++//
        JFrameFormat frame = new JFrameFormat(UserName);
        frame.setVisible(true);
        logout = new Button("Logout");
        logout.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                frame.dispose();
                Assignment.login.setVisible(true);
            }
        });
        viewCoach = new Button("View Coach");
        viewCoach.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                
            }
        });
        viewRecord = new Button("View Self Records");
        viewRecord.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                
            }
        });
        viewRegSport = new Button("View Sport Schedule");
        viewRegSport.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                
            }
        });
        modifyRecord = new Button("Modify Self Records");
        modifyRecord.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                
            }
        });
        feedbackCoach = new Button("Feedback");
        feedbackCoach.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                
            }
        });
        attendance = new Button("Attendance");
        attendance.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                
            }
        });
        payment = new Button("Payment");
        payment.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                
            }
        });
        menuBody = new JPanel();
        menuBody.setLayout(new GridLayout(8,1));
        menuBody.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY, 3));
        menuBody.setPreferredSize(new Dimension(150, frame.getHeight()));
        menuBody.add(viewCoach);
        menuBody.add(viewRecord);
        menuBody.add(viewRegSport);
        menuBody.add(modifyRecord);
        menuBody.add(feedbackCoach);
        menuBody.add(attendance);
        menuBody.add(payment);
        menuBody.add(logout);
        displayBody = new JPanel();
        displayBody.setBorder(BorderFactory.createMatteBorder(3 , 0 , 3 , 3 ,Color.DARK_GRAY));
        frame.Body.add(menuBody, BorderLayout.WEST);
        frame.Body.add(displayBody, BorderLayout.CENTER);
        
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
