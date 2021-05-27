package Assignment;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class ViewCoachDetail extends JPanel implements ActionListener{
    private static JLabel timeL, sportIdL, sportNameL, coachIdL, coachNameL, coachPhoneL, coachSportFeesL, coachStarL, coachJDateL;
    private static JTextField sportIdInText, sportNameInText, coachIdText, coachNameText, coachPhoneText, sportFeesText, coachStarText, coachJDateText, coachTDateText;
    public static JPanel PanelTop, PanelTSelect, PanelTView, PanelTV1, PanelTV2, PanelTV3, PanelTV4,
            PanelBody, PanelSouth; 
    private static JComboBox sportComB;
    private static JRadioButton AddB, ModB;
    private static ButtonGroup AddModSelection;
    private static Button search;
    private static final DateTime dateTime = new DateTime();
    private static String coachId, sportId, whichOperation, location;
    private ArrayList<String> sportID = new ArrayList<String>();
    private static ArrayList <String> sportsType = new ArrayList <String>();
    private String selectedSport;
    public ViewCoachDetail(String cenLocation){
        //List for the location
        
        location = cenLocation;
        sportsType.removeAll(sportsType);
        for(int i = 0; i<Assignment.sportInfo.size(); i++){
            Sport_Constr sport = Assignment.sportInfo.get(i);
            if(sport.getCenter().equals(location)&&!sport.getSportN().equals("TERMINATED")){
                sportsType.add(sport.getSportN()); 
                
            }
        }
        sportComB = new JComboBox(sportsType.toArray());
//        SportMod.setModel(cbm);
        timeL = new JLabel(String.valueOf(dateTime.getFullDate()), SwingConstants.CENTER);
        timeL.setFont(new Font("Arial", Font.BOLD, 30));
        sportIdL = new JLabel("Sport ID:  ");
        sportNameL = new JLabel("Sport:       ");
        sportIdInText= new JTextField(15);
        sportIdInText.setText(sportId);
        sportNameInText = new JTextField(15);
        
        
        coachIdL = new JLabel("Coach ID:");
        coachNameL = new JLabel("Name:");
        coachPhoneL = new JLabel("Phone:");
        coachSportFeesL = new JLabel("Sport Fees per month (8 classes):");
        coachStarL = new JLabel("Rating:");
        coachJDateL = new JLabel("Joined Date:");
        
        coachIdText = new JTextField(15);
        coachIdText.setText(coachId);
        coachIdText.setHorizontalAlignment(JTextField.CENTER);
        coachNameText = new JTextField(15);
        coachNameText.setHorizontalAlignment(JTextField.CENTER);
        coachPhoneText = new JTextField(15);
        coachPhoneText.setHorizontalAlignment(JTextField.CENTER);
        sportFeesText = new JTextField(15);
        sportFeesText.setHorizontalAlignment(JTextField.CENTER);
        coachStarText = new JTextField(15);
        coachStarText.setHorizontalAlignment(JTextField.CENTER);
        coachJDateText = new JTextField(15);
        coachJDateText.setHorizontalAlignment(JTextField.CENTER);
        coachTDateText = new JTextField(15);
        coachTDateText.setHorizontalAlignment(JTextField.CENTER);

        
        
        //++Set Component Disabled by Default++//
        sportIdInText.setEnabled(false);
        sportNameInText.setEnabled(false);
        coachIdText.setEnabled(false);
        coachNameText.setEnabled(false);
        coachPhoneText.setEnabled(false);
        sportFeesText.setEnabled(false);
        coachStarText.setEnabled(false);
        coachJDateText.setEnabled(false);
        coachTDateText.setEnabled(false);

        
        //++Button++//
        search = new Button("Search");
        search.addActionListener(this);
        
        //++PanelDesign//++
        
        setLayout(new BorderLayout(0,20));
        
        PanelTSelect = new JPanel();
        int TopWidth = (this.getWidth());
        GridLayout gL = new GridLayout(3,1);
        gL.setVgap(20);
        gL.setHgap(10);
        PanelTSelect.setLayout(gL);
        PanelTSelect.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1, true));
        PanelTSelect.setPreferredSize(new Dimension(500,150));
        PanelTSelect.add(timeL);
        
        PanelTView = new JPanel();
        PanelTView.setLayout(new BorderLayout(5,5));
        PanelTView.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1 , true));
        PanelTView.setPreferredSize(new Dimension(550,150));
        PanelTV1 = new JPanel();
        PanelTV1.setLayout(new FlowLayout(FlowLayout.CENTER));
        PanelTV1.add(sportIdL);
        PanelTV1.add(sportIdInText);
        PanelTV2 = new JPanel();
        PanelTV2.setLayout(new FlowLayout(FlowLayout.CENTER));
        PanelTV2.add(sportNameL);
        PanelTV2.add(sportComB);
        PanelTV3 = new JPanel();
        PanelTV3.setLayout(new FlowLayout(FlowLayout.RIGHT));
        PanelTV3.add(search);

        PanelTV4 = new JPanel();
        PanelTV4.setLayout(new BorderLayout(5,5));
        PanelTV4.add(PanelTV2, BorderLayout.NORTH);
        PanelTV4.add(PanelTV3, BorderLayout.CENTER);
        PanelTView.add(PanelTV1, BorderLayout.NORTH);
        PanelTView.add(PanelTV4, BorderLayout.CENTER);
        
        PanelTop = new JPanel();
        PanelTop.setLayout(new BorderLayout(5,5));
        PanelTop.add(PanelTSelect, BorderLayout.WEST);
        PanelTop.add(PanelTView, BorderLayout.EAST);
        
        GridLayout gL1 = new GridLayout(3,4);
        gL1.setVgap(50);
        gL1.setHgap(10);
        PanelBody = new JPanel();
        PanelBody.setLayout(gL1);
        PanelBody.setBorder(BorderFactory.createTitledBorder("Coach:    "));
        PanelBody.add(coachNameL);
        PanelBody.add(coachNameText);
        PanelBody.add(coachIdL);
        PanelBody.add(coachIdText);
        PanelBody.add(coachPhoneL);
        PanelBody.add(coachPhoneText);
        PanelBody.add(coachStarL);
        PanelBody.add(coachStarText);
        PanelBody.add(coachJDateL);
        PanelBody.add(coachJDateText);
        PanelBody.add(coachSportFeesL);
        PanelBody.add(sportFeesText);
        
        PanelSouth = new JPanel();
        PanelSouth.setLayout(new BorderLayout(5,5));
        
        add(PanelTop, BorderLayout.NORTH);
        add(PanelBody, BorderLayout.CENTER);
        add(PanelSouth, BorderLayout.SOUTH);
    }
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource()==search){
            selectedSport = sportComB.getSelectedItem().toString();
            for(int i=0; i<Assignment.coachInfo.size(); i++){
                Coach_Constr coach = Assignment.coachInfo.get(i);
                if (coach.getCoachCenter().equals(location)){
//                    for(int counter = 0; counter<sportID.size(); counter++){
                    if (coach.getCoach_Sp_N().equals(selectedSport)){
                        sportIdInText.setText(coach.getCoachSp_Id());
                        coachIdText.setText(coach.getCoachId());
                        coachNameText.setText(coach.getCoachN());
                        coachPhoneText.setText(coach.getCoachTel());
                        coachStarText.setText(coach.getCoachStar());
                        int coachSportFees = Integer.parseInt(coach.getCoachHRate());
                        int coachFees = coachSportFees*4;
                        sportFeesText.setText(Integer.toString(coachFees));
                        coachJDateText.setText(coach.getJDate());
                        coachTDateText.setText(coach.getTDate());
                    }
                }
                else{
                    System.out.println("Error");
                }
                
            }
        }
        
    }
}
