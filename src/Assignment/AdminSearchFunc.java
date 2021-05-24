package Assignment;

import static Assignment.Assignment.sportInfo;
import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

public class AdminSearchFunc extends JPanel{
    private JPanel Header, HeaderBox, HeaderSelection, HeaderInp, HeaderBtm, Body, BodySp, BodyCo, BodyStu;
    private JRadioButton RbSp, RbCo, RbStu;
    private ButtonGroup BGroup;
    private JButton SearchBtn;
    private DefaultTableModel TMSp, TMCo, TMStu;
    private JTable TableSp, TableCo, TableStu;
    private JLabel IdL;
    private JTextField IdIn;
    private JScrollPane ScrollSp,ScrollCo, ScrollStu;
    private boolean flag = true;
    private int selection = 1;
//    public static ArrayList<String> sportType = new ArrayList<String>();
    
    public AdminSearchFunc(){
//        CoachData=null;
//        StudentData=null;
//        SportData=null;
        
        //Create components
        BGroup = new ButtonGroup();
        RbSp = new JRadioButton("Search Sport");
        RbCo = new JRadioButton("Search Coach");
        RbStu = new JRadioButton("Search Student");
        SearchBtn = new JButton("Search");
        IdL = new JLabel("ID: ");
        IdIn = new JTextField(10);
        
        //++Creating Table++//
//        TMSp.setColumnIdentifiers(SportIdentifier);
//        TMCo.setColumnIdentifiers(CoachIdentifier);
//        TMStu.setColumnIdentifiers(StudentIdentifier);
        String[] SportIdentifier = {"Sport ID","Sport Name","Center","Coach Assigned"};
        TMSp = new DefaultTableModel(SportIdentifier,0);
        for(int i = 0; i<Assignment.sportInfo.size(); i++){
            Sport_Constr sp = Assignment.sportInfo.get(i);
            if(sp.getCenter().equals(RegisteredAdmin.centerLocation)){
                TMSp.addRow(new Object[]{sp.getSprtId(),sp.getSportN(),sp.getCenter(),sp.getCoachN()});
            }
        }
        TableSp = new JTable(TMSp);
        TableSp.setAutoCreateRowSorter(true);
        ScrollSp = new JScrollPane(TableSp);
        String[] CoachIdentifier = {"Coach ID","Name","TelNo.", "HourlyRate (RM)","RatingStars(/5)","Center","Sport ID","Sport Name", "ResidingCity","Joined","Quit"};
        TMCo = new DefaultTableModel(CoachIdentifier,0);
        for(int i = 0; i<Assignment.coachInfo.size(); i++){
            Coach_Constr co = Assignment.coachInfo.get(i);
            if(co.getCoachCenter().equals(RegisteredAdmin.centerLocation)){
                TMCo.addRow(new Object[]{co.getCoachId(),co.getCoachN(),co.getCoachTel(),co.getCoachHRate(),co.getCoachStar(),co.getCoachCenter(),
                co.getCoachSp_Id(),co.getCoach_Sp_N(),co.getCoachAdd(),co.getJDate(),co.getTDate()});
            }
        }
        TableCo = new JTable(TMCo);
        TableCo.setAutoCreateRowSorter(true);
        ScrollCo = new JScrollPane(TableCo);
        String[] StudentIdentifier = {"Student ID","Name","Username","Center","Gender","Tel.No"};
        TMStu = new DefaultTableModel(StudentIdentifier,0);
        for(int i = 0; i<Assignment.studentInfo.size(); i++){
            Student stu = Assignment.studentInfo.get(i);
            if(stu.getStuPlace().equals(RegisteredAdmin.centerLocation)){
                TMStu.addRow(new Object[]{stu.getStuID(),stu.getStuName(),stu.getStuUserN(),stu.getStuPlace(),stu.getStuGender(),stu.getStuPhone()});
            }
        }
//        TableRowSorter<DefaultTableModel> sorter3 = new TableRowSorter <>(TMStu);
        TableStu = new JTable(TMStu);
//        TableStu.setRowSorter(sorter3);
//        sorter3.setRowFilter(RowFilter.regexFilter(IdIn.getText()));///////////////////////////////////////////////////////////////
        TableStu.setAutoCreateRowSorter(true);
        ScrollStu = new JScrollPane(TableStu);
        
        //Create and Design Panels
        CardLayout cl = new CardLayout();
        setLayout(new BorderLayout(5,5));
        
        HeaderSelection = new JPanel();
        HeaderSelection.setLayout(new FlowLayout(FlowLayout.CENTER,10,5));
        HeaderSelection.add(RbSp);
        HeaderSelection.add(RbCo);
        HeaderSelection.add(RbStu);
//        Header.setSize(new Dimension(150,150));
        
        HeaderInp = new JPanel();
        HeaderInp.setLayout(new FlowLayout(FlowLayout.CENTER,15,5));
        HeaderInp.add(IdL);
        HeaderInp.add(IdIn);
        
        HeaderBtm = new JPanel();
        HeaderBtm.setLayout(new FlowLayout(FlowLayout.RIGHT,15,5));
        HeaderBtm.add(SearchBtn);
        
        HeaderBox = new JPanel();
        HeaderBox.setLayout(new GridLayout(3,1));
        HeaderBox.setBorder(BorderFactory.createLineBorder(Color.GRAY, 3, true));
        HeaderBox.add(HeaderSelection);
        HeaderBox.add(HeaderInp);
        HeaderBox.add(HeaderBtm);
        
        Header = new JPanel();
        Header.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));
        Header.setPreferredSize(new Dimension(this.getWidth(),150));
        Header.add(HeaderBox);
        
        BodySp = new JPanel();
        BodySp.setLayout(new BorderLayout());
        BodySp.add(ScrollSp, BorderLayout.CENTER);
        
        BodyCo = new JPanel();
        BodyCo.setLayout(new BorderLayout());
        BodyCo.add(ScrollCo, BorderLayout.CENTER);
        
        BodyStu = new JPanel();
        BodyStu.setLayout(new BorderLayout());
        BodyStu.add(ScrollStu, BorderLayout.CENTER);
        
        Body = new JPanel();
        Body.setLayout(cl);
        Body.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        Body.add(BodySp, "1");
        Body.add(BodyCo, "2");
        Body.add(BodyStu, "3");
        cl.show(Body, "1");
        
        add(Header, BorderLayout.NORTH);
        add(Body, BorderLayout.CENTER);

        //set Functionality to components
        BGroup.add(RbSp);
        BGroup.add(RbCo);
        BGroup.add(RbStu);
        RbSp.setSelected(true);
        RbSp.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                cl.show(Body, "1");
                selection = 1;
            }
        });
        RbCo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                cl.show(Body, "2");
                selection = 2;
            }
        });
        RbStu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                cl.show(Body, "3");
                selection =3;
            }
        });
        
        SearchBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                flag = true;
                if (selection ==1){
                    for(int i = 0; i<Assignment.sportInfo.size(); i++){ // Search for Sport
                        Sport_Constr sport = Assignment.sportInfo.get(i);
                        if (IdIn.getText().equals(sport.getSprtId())){
                            JOptionPane.showMessageDialog(IdIn, "Sport ID: "+ sport.getSprtId() + "\nSport Name: "+sport.getSportN()+"\nSport Center: "+sport.getCenter()+"\nCoach Assigned: "+sport.getCoachN());
                            flag = false;
                        
                        }
                    }
                    if(flag){
                        JOptionPane.showMessageDialog(IdIn, "Invalid Sport ID");
                    }
                    
                }else if (selection ==2){
                    flag = true;
                    for(int i = 0; i<Assignment.coachInfo.size(); i++){ //Search for Coach
                        Coach_Constr coach = Assignment.coachInfo.get(i);
                        if (IdIn.getText().equals(coach.getCoachId())){
                            JOptionPane.showMessageDialog(IdIn, "Coach ID: "+coach.getCoachId() +"\nCoach Name: "+ coach.getCoachN()+"\nCoach Phone Number: "+ coach.getCoachTel()+"\nCoach Hourly Rate: "+ coach.getCoachHRate()+"\nCoach Rating: "+coach.getCoachStar()+"\nCoach Sport Center: "+ coach.getCoachCenter()+"\nCoach Sport ID: "+ coach.getCoachSp_Id()+"\nCoach Sport Name: "+coach.getCoach_Sp_N()+"\nCoach Home Address: "+coach.getCoachAdd()+"\nCoach Joined Date: "+ coach.getJDate()+"\nCoach Terminated Date: "+ coach.getTDate());
                            flag = false;
                        }
                    }
                    if(flag){
                        JOptionPane.showMessageDialog(IdIn, "Invalid Sport ID");
                    }
                }else if (selection ==3){
//                    RowFilter<DefaultTableModel, Object> rf3 = null;
//                    rf3 = RowFilter.regexFilter(IdIn.getText());
//                    System.out.println(IdIn.getText());
//                    sorter3.setRowFilter(rf3);
                    flag = true;
                    for(int i = 0; i<Assignment.studentInfo.size(); i++){ //Search for Student
                        Student student = Assignment.studentInfo.get(i);
                        if (IdIn.getText().equals(student.getStuID())){
                            JOptionPane.showMessageDialog(IdIn, "Student ID: "+ student.getStuID() + "\nStudent Name: "+student.getStuName()+"\nStudent Username: "+student.getStuUserN()+"\nStudent Center: "+student.getStuPlace()+"\nStudent Gender: "+student.getStuGender()+"\nStudent Phone Number: "+student.getStuPhone());
                            flag = false;
                        }
                    }
                    if(flag){
                        JOptionPane.showMessageDialog(IdIn, "Invalid Student ID");
                    }
                    
                }
            }
        });
                        
                
                
        IdIn.setSize(20, 10);
        IdIn.setHorizontalAlignment(JTextField.CENTER);
        
        
    }
}
