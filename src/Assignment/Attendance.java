package Assignment;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JPanel;

public class Attendance extends JPanel implements ActionListener{
    private JPanel centerPanel, panel;
    private JButton attendanceConfirm;
    private static ArrayList <String> sportName = new ArrayList <String>();
    private JComboBox sportList;
    private Label sportL;
    public Attendance(String userName, String cenLocation){
        setLayout(new BorderLayout());
        SimpleDateFormat dayFormat = new SimpleDateFormat("dd");
        SimpleDateFormat hourFormat = new SimpleDateFormat("HH");
        Date date = new Date();
        String dayCheck = dayFormat.format(date);
        String hourCheck = hourFormat.format(date);
        String day = "Monday";
        //Read the data from subscription Array and put into JComboBox
        for(int i = 0; i <Assignment.subscription.size(); i++){
            Subscription_Constr sub = Assignment.subscription.get(i);
            if(sub.getSubscriptionName().equals(userName)&&sub.getSubscriptionLocation().equals(cenLocation)){
                sportName.add(sub.getSubscriptionSport());
            }
        }
        //Label
        sportL = new Label("Choose your sport: ", Label.CENTER);
        sportL.setFont(new Font("Arial", Font.BOLD, 30));
        //To let student to choose the sport that they want to take attendance
        sportList = new JComboBox(sportName.toArray());
        sportList.setFont(new Font("Arial", Font.BOLD, 20));
        int hourCheckInteger = Integer.parseInt(hourCheck);
//        }
//        if (dayCheck == day){
//            if ((hourCheckInteger > startTime)&&(hourCheckInteger <endTime)){
//                
//            }
//            
//                
//        }
        add(sportL, BorderLayout.NORTH);
        centerPanel = new JPanel();
        centerPanel.setLayout(new GridLayout(2,1));
        panel = new JPanel();
        panel.setLayout(new FlowLayout());
        panel.add(sportList);
        centerPanel.add(panel);
        attendanceConfirm = new JButton("Attendace");
        attendanceConfirm.setBackground(Color.GREEN);
        attendanceConfirm.setFont(new Font("Arial", Font.BOLD, 30));
        attendanceConfirm.addActionListener(this);
        centerPanel.add(attendanceConfirm);
        add(centerPanel, BorderLayout.CENTER);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
