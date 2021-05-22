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
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

class ViewCoachFunc  extends JPanel{
    
    private JPanel Header, HeaderBox, HeaderSelection, HeaderInp, HeaderBtm, Body, BodyCo;
    private JButton SearchBtn;
    private DefaultTableModel TMCo;
    private JTable TableCo;
    private JLabel IdL;
    private JTextField IdIn;
    private JScrollPane ScrollCo;
    private boolean flag = true;
    private int selection = 1;
    public static String[][] CoachData = new String[Assignment.coachInfo.size()][11];
    
    public ViewCoachFunc(){
        
        //Create components
        SearchBtn = new JButton("Search");
        IdL = new JLabel("Coach Overall Perforamnce (Rating): ");
        IdIn = new JTextField(10);
        
        //++Creating Table++//
//        TMSp.setColumnIdentifiers(SportIdentifier);
//        TMCo.setColumnIdentifiers(CoachIdentifier);
//        TMStu.setColumnIdentifiers(StudentIdentifier);
        for(int i = 0; i<Assignment.coachInfo.size(); i++){
            Coach_Constr co = Assignment.coachInfo.get(i);
            CoachData[i][0] = co.getCoachId();
            CoachData[i][1] = co.getCoachN();
            CoachData[i][2] = co.getCoachTel();
            CoachData[i][3] = co.getCoachHRate();
            CoachData[i][4] = co.getCoachStar();
            CoachData[i][5] = co.getCoachCenter();
            CoachData[i][6] = co.getCoachSp_Id();
            CoachData[i][7] = co.getCoach_Sp_N();
            CoachData[i][8] = co.getCoachAdd();
            CoachData[i][9] = co.getJDate();
            CoachData[i][10] = co.getTDate();
        }
        String[] CoachIdentifier = {"Coach ID","Name","TelNo.", "HourlyRate (RM)","RatingStars(/5)","Center","Sport ID","Sport Name", "ResidingCity","Joined","Quit"};
        TMCo = new DefaultTableModel(CoachData, CoachIdentifier);
        TableCo = new JTable(TMCo);
        TableCo.setAutoCreateRowSorter(true);
        ScrollCo = new JScrollPane(TableCo);
        
        //Create and Design Panels
//        CardLayout cl = new CardLayout();
        setLayout(new BorderLayout(5,5));
        

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

        HeaderBox.add(HeaderInp);
        HeaderBox.add(HeaderBtm);
        
        Header = new JPanel();
        Header.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));
        Header.setPreferredSize(new Dimension(this.getWidth(),150));
        Header.add(HeaderBox);
        
//        BodySp = new JPanel();
//        BodySp.setLayout(new BorderLayout());
////        BodySp.add(ScrollSp, BorderLayout.CENTER);
        
        add(ScrollCo, BorderLayout.CENTER);
        
//        BodyStu = new JPanel();
//        BodyStu.setLayout(new BorderLayout());
////        BodyStu.add(ScrollStu, BorderLayout.CENTER);
        
//        Body = new JPanel();
////        Body.setLayout(cl);
//        Body.setBorder(BorderFactory.createLineBorder(Color.BLACK));
//        Body.add(BodySp, "1");
//        Body.add(BodyCo, "2");
//        Body.add(BodyStu, "3");
//        cl.show(Body, "1");
        
        add(Header, BorderLayout.NORTH);
//        add(Body, BorderLayout.CENTER);

        //set Functionality to components

        
        SearchBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                flag = true;
                for(int i = 0; i<Assignment.coachInfo.size(); i++){ // Search for Sport
                    Coach_Constr coach = Assignment.coachInfo.get(i);
                    if (IdIn.getText().equals(coach.getCoachStar())){
                        JOptionPane.showMessageDialog(IdIn, "Coach ID: "+coach.getCoachId() +"\nCoach Name: "+ coach.getCoachN()+"\nCoach Phone Number: "+ coach.getCoachTel()+"\nCoach Hourly Rate: "+ coach.getCoachHRate()+"\nCoach Rating: "+coach.getCoachStar()+"\nCoach Sport Center: "+ coach.getCoachCenter()+"\nCoach Sport ID: "+ coach.getCoachSp_Id()+"\nCoach Sport Name: "+coach.getCoach_Sp_N()+"\nCoach Home Address: "+coach.getCoachAdd()+"\nCoach Joined Date: "+ coach.getJDate()+"\nCoach Terminated Date: "+ coach.getTDate());
                        flag = false;

                    }
                }
                if(flag){
                    JOptionPane.showMessageDialog(IdIn, "Invalid Coach Rating");
                    
                }
            }
        });
                        
                
                
        IdIn.setSize(20, 10);
        IdIn.setHorizontalAlignment(JTextField.CENTER);
        
        
    }
    
}
