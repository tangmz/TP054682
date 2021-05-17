package Assignment;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import static javax.swing.BorderFactory.createLineBorder;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

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
    
    AdminSearchFunc(){
        
        //Create components
        BGroup = new ButtonGroup();
        RbSp = new JRadioButton("Search Sport");
        RbCo = new JRadioButton("Search Coach");
        RbStu = new JRadioButton("Search Student");
        SearchBtn = new JButton("Search");
        IdL = new JLabel("ID: ");
        IdIn = new JTextField(2);
        
        //++Creating Table++//
//        TMSp.setColumnIdentifiers(SportIdentifier);
//        TMCo.setColumnIdentifiers(CoachIdentifier);
//        TMStu.setColumnIdentifiers(StudentIdentifier);
        String[][] SportData = new String[RegisteredAdmin.Sport.size()][4];
        for(int i = 0; i<RegisteredAdmin.Sport.size(); i++){
            Sport_Constr sp = RegisteredAdmin.Sport.get(i);
            SportData[i][0] = sp.getSprtId();
            SportData[i][1] = sp.getSportN();
            SportData[i][2] = sp.getCenter();
            SportData[i][3] = sp.getCoachN();
        }
        String[] SportIdentifier = {"Sport ID","Sport Name","Center","Coach Assigned"};
        TMSp = new DefaultTableModel(SportData, SportIdentifier);
        TableSp = new JTable(TMSp);
        TableSp.setAutoCreateRowSorter(true);
        ScrollSp = new JScrollPane(TableSp);
        String[][] CoachData = new String[RegisteredAdmin.Coach.size()][10];
        for(int i = 0; i<RegisteredAdmin.Coach.size(); i++){
            Coach_Constr co = RegisteredAdmin.Coach.get(i);
            CoachData[i][0] = co.getCoachId();
            CoachData[i][1] = co.getCoachN();
            CoachData[i][2] = co.getCoachTel();
            CoachData[i][3] = co.getCoachHRate();
            CoachData[i][4] = co.getCoachStar();
            CoachData[i][5] = co.getCoachCenter();
            CoachData[i][6] = co.getCoachSp_Id();
            CoachData[i][7] = co.getCoachAdd();
            CoachData[i][8] = co.getJDate();
            CoachData[i][9] = co.getTDate();
        }
        String[] CoachIdentifier = {"Coach ID","Name","TelNo.", "HourlyRate (RM)","RatingStars(/5)","Center","Sport ID", "ResidingCity","Joined","Quit"};
        TMCo = new DefaultTableModel(CoachData, CoachIdentifier);
        TableCo = new JTable(TMCo);
        TableCo.setAutoCreateRowSorter(true);
        ScrollCo = new JScrollPane(TableCo);
        String[][] StudentData = new String[Assignment.studentInfo.size()][6];
        for(int i = 0; i<Assignment.studentInfo.size(); i++){
            Student stu = Assignment.studentInfo.get(i);
            StudentData[i][0] = stu.getStuID();
            StudentData[i][1] = stu.getStuName();
            StudentData[i][2] = stu.getStuUserN();
            StudentData[i][3] = stu.getStuPlace();
            StudentData[i][4] = stu.getStuGender();
            StudentData[i][5] = stu.getStuPhone();
        }
        String[] StudentIdentifier = {"Student ID","Name","Username","Center","Gender","Tel.No"};
        TMStu = new DefaultTableModel(StudentData, StudentIdentifier);
        TableStu = new JTable(TMStu);
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
            }
        });
        RbCo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                cl.show(Body, "2");
            }
        });
        RbStu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                cl.show(Body, "3");
            }
        });
        SearchBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
        });
        IdIn.setSize(20, 10);
        IdIn.setHorizontalAlignment(JTextField.CENTER);
        
        
        
        //Search for Sport
        
        //Search for Coach
        
        //Seach for Student
        
    }
}
