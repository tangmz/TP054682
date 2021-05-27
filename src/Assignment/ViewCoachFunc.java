package Assignment;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

public class ViewCoachFunc  extends JPanel{
    
    private JPanel Header, HeaderBox, HeaderInp, HeaderBtm;
    private JButton SearchBtn;
    private DefaultTableModel TMCo;
    private JTable TableCo;
    private JLabel IdL;
    private JTextField IdIn;
    private JScrollPane ScrollCo;
    
    public ViewCoachFunc(){
        
        //Create components
        SearchBtn = new JButton("Search");
        IdL = new JLabel("Coach Overall Perforamnce (Rating): ");
        IdIn = new JTextField(10);
        IdIn.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent ke) {
                char c = ke.getKeyChar();
                if (!((c >= '0') && (c <= '5') ||
                    (c == KeyEvent.VK_BACK_SPACE) ||
                    (c == KeyEvent.VK_DELETE)   ||
                    (c == KeyEvent.VK_PERIOD)   ||
                    (c == KeyEvent.VK_DECIMAL))) {
                  ke.consume();
               }
            }
            @Override
            public void keyPressed(KeyEvent ke) {}
            @Override
            public void keyReleased(KeyEvent ke) {}
        });
        
        //++Creating Table++//
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
        
        //Create and Design Panels
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
        
        add(ScrollCo, BorderLayout.CENTER);
        add(Header, BorderLayout.NORTH);

        //set Functionality to components

        
        SearchBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                TableRowSorter<DefaultTableModel> sorter1 = new TableRowSorter<DefaultTableModel>(TMCo);
                TableCo.setRowSorter(sorter1);
                sorter1.setRowFilter(RowFilter.regexFilter(IdIn.getText().trim(),4));
//                flag = true;
//                for(int i = 0; i<Assignment.coachInfo.size(); i++){ // Search for Sport
//                    Coach_Constr coach = Assignment.coachInfo.get(i);
//                    if (IdIn.getText().equals(coach.getCoachStar())){
//                        JOptionPane.showMessageDialog(IdIn, "Coach ID: "+coach.getCoachId() +"\nCoach Name: "+ coach.getCoachN()+"\nCoach Phone Number: "+ coach.getCoachTel()+"\nCoach Hourly Rate: "+ coach.getCoachHRate()+"\nCoach Rating: "+coach.getCoachStar()+"\nCoach Sport Center: "+ coach.getCoachCenter()+"\nCoach Sport ID: "+ coach.getCoachSp_Id()+"\nCoach Sport Name: "+coach.getCoach_Sp_N()+"\nCoach Home Address: "+coach.getCoachAdd()+"\nCoach Joined Date: "+ coach.getJDate()+"\nCoach Terminated Date: "+ coach.getTDate());
//                        flag = false;
//
//                    }
//                }
//                if(flag){
//                    JOptionPane.showMessageDialog(IdIn, "Invalid Coach Rating");
//                    
//                }
            }
        });
                        
                
                
        IdIn.setSize(20, 10);
        IdIn.setHorizontalAlignment(JTextField.CENTER);
        
        
    }
    
}
