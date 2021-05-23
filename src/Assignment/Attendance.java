//package Assignment;
//
//import java.awt.BorderLayout;
//import java.awt.Color;
//import java.awt.FlowLayout;
//import java.awt.Font;
//import java.awt.GridLayout;
//import java.awt.Label;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//import java.text.SimpleDateFormat;
//import java.util.ArrayList;
//import java.util.Date;
//import javax.swing.JButton;
//import javax.swing.JComboBox;
//import javax.swing.JPanel;
//
//public class Attendance extends JPanel implements ActionListener{
//    private JPanel centerPanel, panel;
//    private JButton attendanceConfirm;
//    private static ArrayList <String> sportName = new ArrayList <String>();
//    private JComboBox sportList;
//    private Label sportL;
//    private String sport;
//    private satic ArrayList <Integer> 
//    public Attendance(String userName, String cenLocation){
//        setLayout(new BorderLayout());
//        SimpleDateFormat dayFormat = new SimpleDateFormat("dd");
//        SimpleDateFormat hourFormat = new SimpleDateFormat("HH");
//        Date date = new Date();
//        String dayCheck = dayFormat.format(date);
//        String hourCheck = hourFormat.format(date);
//        String day = "Monday";
//        //Read the data from subscription Array and put into JComboBox
//        sportName.removeAll(sportName);
//        for(int i = 0; i <Assignment.subscription.size(); i++){
//            Subscription_Constr c = Assignment.subscription.get(i);
//            if(c.getSubscriptionName().equals(userName)&&c.getSubscriptionLocation().equals(cenLocation)){
//                sportName.add(c.getSubscriptionSport());
//            }
//        }
//        //Label
//        sportL = new Label("Choose your sport: ", Label.CENTER);
//        sportL.setFont(new Font("Arial", Font.BOLD, 30));
//        //To let student to choose the sport that they want to take attendance
//        sportList = new JComboBox(sportName.toArray());
//        sportList.setFont(new Font("Arial", Font.BOLD, 20));
//        sport = sportList.getSelectedItem().toString();
//        int hourCheckInteger = Integer.parseInt(hourCheck);
//            for(int i = 0; i<Assignment.schedule.size(); i++){
//            Schedule_Constr schedule = Assignment.schedule.get(i);
//            if(schedule.getCenter().equals(cenLocation)){
//                if(schedule.getMon1().equals(sport)){
//                    int time1[] = {10, 12};
//                }
//                if(schedule.getMon2().equals(sport)){
//                    int time2[] = {2,4};
//                }
//                if(schedule.getMon3().equals(sport)){
//                    int time3[] = {5,6};
//                }
//                if(schedule.getTue1().equals(sport)){
//                    int time 
//                }
//                if(schedule.getTue2().equals(sport)){
//                    Tue2Sch.setText(sport);
//                }
//                if(schedule.getTue3().equals(sport)){
//                    Tue3Sch.setText(sport);
//                }
//                if(schedule.getWed1().equals(sport)){
//                    Wed1Sch.setText(sport);
//                }
//                if(schedule.getWed2().equals(sport)){
//                    Wed2Sch.setText(sport);
//                }
//                if(schedule.getWed3().equals(sport)){
//                    Wed3Sch.setText(sport);
//                }
//                if(schedule.getThu1().equals(sport)){
//                    Thu1Sch.setText(sport);
//                }
//                if(schedule.getThu2().equals(sport)){
//                    Thu2Sch.setText(sport);
//                }
//                if(schedule.getThu3().equals(sport)){
//                    Thu3Sch.setText(sport);
//                }
//                if(schedule.getFri1().equals(sport)){
//                    Fri1Sch.setText(sport);
//                }
//                if(schedule.getFri2().equals(sport)){
//                    Fri2Sch.setText(sport);
//                }
//                if(schedule.getFri3().equals(sport)){
//                    Fri3Sch.setText(sport);
//                }
//                if(schedule.getSat1().equals(sport)){
//                    Sat1Sch.setText(sport);
//                }
//                if(schedule.getSat2().equals(sport)){
//                    Sat2Sch.setText(sport);
//                }
//                if(schedule.getSat3().equals(sport)){
//                    Sat3Sch.setText(sport);
//                }
//                if(schedule.getSun1().equals(sport)){
//                    Sun1Sch.setText(sport);
//                }
//                if(schedule.getSun2().equals(sport)){
//                    Sun2Sch.setText(sport);
//                }
//                if(schedule.getSun3().equals(sport)){
//                    Sun3Sch.setText(sport);
//                }
////        }
////        if (dayCheck == day){
////            if ((hourCheckInteger > startTime)&&(hourCheckInteger <endTime)){
////                
////            }
////            
////                
////        }
//        add(sportL, BorderLayout.NORTH);
//        centerPanel = new JPanel();
//        centerPanel.setLayout(new GridLayout(2,1));
//        panel = new JPanel();
//        panel.setLayout(new FlowLayout());
//        panel.add(sportList);
//        centerPanel.add(panel);
//        attendanceConfirm = new JButton("Attendace");
//        attendanceConfirm.setBackground(Color.GREEN);
//        attendanceConfirm.setFont(new Font("Arial", Font.BOLD, 30));
//        attendanceConfirm.addActionListener(this);
//        centerPanel.add(attendanceConfirm);
//        add(centerPanel, BorderLayout.CENTER);
//    }
//
//    @Override
//    public void actionPerformed(ActionEvent ae) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }
//}
