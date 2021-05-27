package Assignment;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Attendance extends JPanel implements ActionListener{
    private JPanel centerPanel, panel;
    private JButton attendanceConfirm, search;
    private static ArrayList <String> sportName = new ArrayList <String>();
    private JComboBox sportList;
    private Label sportL;
    private String sport, dayCheck, hourCheck, location, currentMonth, studentName, finalAtt;
    private static ArrayList <Integer> timeSport = new ArrayList <Integer>();
    private int hourCheckInteger;
    private boolean flag = false;
    public Attendance(String userName, String cenLocation){
        DateTime month = new DateTime();//To extract time from DateTime
        //Store data into variables
        studentName = userName;
        currentMonth = month.getFullMonth();
        dayCheck = month.getDay();
        hourCheck = month.getHour();
        
        setLayout(new BorderLayout());
        location = cenLocation;
        //Read the data from subscription Array and put into JComboBox
        sportName.removeAll(sportName);
        for(int i = 0; i <Assignment.subscription.size(); i++){
            Subscription_Constr c = Assignment.subscription.get(i);
            if(c.getSubscriptionName().equals(userName)&&c.getSubscriptionLocation().equals(cenLocation)){
                sportName.add(c.getSubscriptionSport());
            }
        }
        //Label
        sportL = new Label("Choose your sport: ", Label.CENTER);
        sportL.setFont(new Font("Arial", Font.BOLD, 30));
        //To let student to choose the sport that they want to take attendance
        sportList = new JComboBox(sportName.toArray());
        sportList.setFont(new Font("Arial", Font.BOLD, 20));
        
        hourCheckInteger = Integer.parseInt(hourCheck);
        //Button list
        search = new JButton("Search");
        search.addActionListener(this);
        attendanceConfirm = new JButton("Attendace");
        attendanceConfirm.setFont(new Font("Arial", Font.BOLD, 30));
        attendanceConfirm.setBackground(Color.RED);
        attendanceConfirm.setEnabled(false);
        flag = false;
        //Panel and Design
        add(sportL, BorderLayout.NORTH);
        centerPanel = new JPanel();
        centerPanel.setLayout(new GridLayout(2,1));
        panel = new JPanel();
        panel.setLayout(new FlowLayout());
        panel.add(sportList);
        panel.add(search);
        centerPanel.add(panel);
        attendanceConfirm.addActionListener(this);
        centerPanel.add(attendanceConfirm);
        add(centerPanel, BorderLayout.CENTER);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        //To search the attendance from the schedule file
        if(ae.getSource()==search){
            flag = false;
            sport = sportList.getSelectedItem().toString();
            attendanceConfirm.setBackground(Color.RED);
            attendanceConfirm.setEnabled(false);
            //Read the schedule from Array List
            for(int i = 0; i<Assignment.schedule.size(); i++){
                Schedule_Constr schedule = Assignment.schedule.get(i);
                //To find the matched location and current month
                if(schedule.getCenter().equals(location)&&schedule.getSchMonth().equals(currentMonth)){
                    if(schedule.getMon1().equals(sport)&&(dayCheck.equals("Monday"))&&(hourCheckInteger>10)&&(hourCheckInteger<12)){
                        flag = true;
                    }
                    if(schedule.getMon2().equals(sport)&&(dayCheck.equals("Monday"))&&(hourCheckInteger>=13)&&(hourCheckInteger<=15)){
                        flag = true;
                    }
                    if(schedule.getMon3().equals(sport)&&(dayCheck.equals("Monday"))&&(hourCheckInteger>=15)&&(hourCheckInteger<=17)){
                        flag = true;
                    }
                    if(schedule.getTue1().equals(sport)&&(dayCheck.equals("Tuesday"))&&(hourCheckInteger>=10)&&(hourCheckInteger<=12)){
                        flag = true;
                    }
                    if(schedule.getTue2().equals(sport)&&(dayCheck.equals("Tuesday"))&&(hourCheckInteger>=13)&&(hourCheckInteger<=15)){
                        flag = true;
                    }
                    if(schedule.getTue3().equals(sport)&&(dayCheck.equals("Tuesday"))&&(hourCheckInteger>=15)&&(hourCheckInteger<=17)){
                        flag = true;
                    }
                    if(schedule.getWed1().equals(sport)&&(dayCheck.equals("Wednesday"))&&(hourCheckInteger>=10)&&(hourCheckInteger<=12)){
                        flag = true;
                    }
                    if(schedule.getWed2().equals(sport)&&(dayCheck.equals("Wednesday"))&&(hourCheckInteger>=13)&&(hourCheckInteger<=15)){
                        flag = true;
                    }
                    if(schedule.getWed3().equals(sport)&&(dayCheck.equals("Wednesday"))&&(hourCheckInteger>=15)&&(hourCheckInteger<=17)){
                        flag = true;
                    }
                    if(schedule.getThu1().equals(sport)&&(dayCheck.equals("Thursday"))&&(hourCheckInteger>=10)&&(hourCheckInteger<=12)){
                        flag = true;
                    }
                    if(schedule.getThu2().equals(sport)&&(dayCheck.equals("Thursday"))&&(hourCheckInteger>=13)&&(hourCheckInteger<=15)){
                        flag = true;
                    }
                    if(schedule.getThu3().equals(sport)&&(dayCheck.equals("Thursday"))&&(hourCheckInteger>=15)&&(hourCheckInteger<=17)){
                        flag = true;
                    }
                    if(schedule.getFri1().equals(sport)&&(dayCheck.equals("Friday"))&&(hourCheckInteger>=10)&&(hourCheckInteger<=12)){
                        flag = true;
                    }
                    if(schedule.getFri2().equals(sport)&&(dayCheck.equals("Friday"))&&(hourCheckInteger>=13)&&(hourCheckInteger<=15)){
                        flag = true;
                    }
                    if(schedule.getFri3().equals(sport)&&(dayCheck.equals("Friday"))&&(hourCheckInteger>=15)&&(hourCheckInteger<=17)){
                        flag = true;
                    }
                    if(schedule.getSat1().equals(sport)&&(dayCheck.equals("Saturday"))&&(hourCheckInteger>=10)&&(hourCheckInteger<=12)){
                        flag = true;
                    }   
                    if(schedule.getSat2().equals(sport)&&(dayCheck.equals("Saturday"))&&(hourCheckInteger>=13)&&(hourCheckInteger<=15)){
                        flag = true;
                    }
                    if(schedule.getSat3().equals(sport)&&(dayCheck.equals("Saturday"))&&(hourCheckInteger>=15)&&(hourCheckInteger<=17)){
                        flag = true;
                    }
                    if(schedule.getSun1().equals(sport)&&(dayCheck.equals("Sunday"))&&(hourCheckInteger>=10)&&(hourCheckInteger<=12)){
                        flag = true;
                    }
                    if(schedule.getSun2().equals(sport)&&(dayCheck.equals("Sunday"))&&(hourCheckInteger>=13)&&(hourCheckInteger<=15)){
                        flag = true;
                    }
                    if(schedule.getSun3().equals(sport)&&(dayCheck.equals("Sunday"))&&(hourCheckInteger>=15)&&(hourCheckInteger<=17)){
                        flag = true;
                    }
                //When there's matched attendance, then it will turn green
                }if(flag){
                    attendanceConfirm.setBackground(Color.GREEN);
                    attendanceConfirm.setEnabled(true);
                }
            }
        //To ensure the attendance has taken
        }else if(ae.getSource()==attendanceConfirm){
            for(int i=0; i<Assignment.payment.size(); i++){
                StudentPayment c = Assignment.payment.get(i);
                if(c.getStudentName().equals(studentName)&&c.getSportName().equals(sport)&&c.getStudentLocation().equals(location)){
                    int totalAtt = Integer.parseInt(c.getStudentAttendance());
                    if (totalAtt>=0){
                        totalAtt = totalAtt - 1;
                        finalAtt = Integer.toString(totalAtt);
                        c.setStudentAttendance(finalAtt);
                    }else{
                        JOptionPane.showMessageDialog(attendanceConfirm, "You have attend all the classes");
                        break;
                        
                    }
                }
            }
            try{
                //Write into the file when the attendance is confirmed
                PrintWriter f = new PrintWriter("studentPayment.txt");
                for(int i=0; i<Assignment.payment.size(); i++){
                    StudentPayment c = Assignment.payment.get(i);
                    f.println(c.getStudentName());
                    f.println(c.getSportName());
                    f.println(c.getStudentLocation());
                    f.println(c.getStudentTotalPayment());
                    f.println(c.getStudentBalance());
                    f.println(c.getStudentAttendance());
                    f.println();
                }
                f.close(); 
                JOptionPane.showMessageDialog(attendanceConfirm, "You left "+finalAtt+" classes");
            } catch(Exception ex){
                System.out.println("Error in stop!"); 
                
            }
            //The attendance button will turn red after the process has done
            attendanceConfirm.setBackground(Color.RED);
            attendanceConfirm.setEnabled(false);
        }
    }
}
