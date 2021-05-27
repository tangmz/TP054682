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
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

public class AdminSearchFunc extends JPanel{
    //Variable Declaration
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
    
    public AdminSearchFunc(){
        //Create components
        BGroup = new ButtonGroup();
        RbSp = new JRadioButton("Search Sport");
        RbCo = new JRadioButton("Search Coach");
        RbStu = new JRadioButton("Search Student");
        SearchBtn = new JButton("Search");
        IdL = new JLabel("ID: ");
        IdIn = new JTextField(10);
        
        //++Creating Table++//
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
        //To change to the specific panel
        RbSp.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                cl.show(Body, "1");
                selection = 1;
            }
        });
        //To change to the specific panel
        RbCo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                cl.show(Body, "2");
                selection = 2;
            }
        });
        //To change to the specific panel
        RbStu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                cl.show(Body, "3");
                selection =3;
            }
        });
        //To filter the table and find the matched word
        SearchBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                flag = true;
                if (selection ==1){
                    TableRowSorter<DefaultTableModel> sorter1 = new TableRowSorter<DefaultTableModel>(TMSp);
                    TableSp.setRowSorter(sorter1);
                    sorter1.setRowFilter(RowFilter.regexFilter(IdIn.getText().trim(),0));
                }else if (selection ==2){
                    TableRowSorter<DefaultTableModel> sorter1 = new TableRowSorter<DefaultTableModel>(TMCo);
                    TableCo.setRowSorter(sorter1);
                    sorter1.setRowFilter(RowFilter.regexFilter(IdIn.getText().trim(),0));
                }else if (selection ==3){
                    TableRowSorter<DefaultTableModel> sorter1 = new TableRowSorter<DefaultTableModel>(TMStu);
                    TableStu.setRowSorter(sorter1);
                    sorter1.setRowFilter(RowFilter.regexFilter(IdIn.getText().trim(),0));
                }
            }
        });
                        
                
                
        IdIn.setSize(20, 10);
        IdIn.setHorizontalAlignment(JTextField.CENTER);
        
        
    }
}
