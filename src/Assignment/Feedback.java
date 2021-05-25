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
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class Feedback extends JPanel implements ActionListener{
    private static JLabel timeL, sportIdL, sportNameL, coachIdL, coachNameL, coachPhoneL, coachSportFeesL, coachStarL, coachJDateL, coachTDateL, feedbackL, ratingL;
    private static JTextField sportIdInText, sportNameInText, coachIdText, coachNameText, coachPhoneText, sportFeesText, coachJDateText, feedbackText;
    public static JPanel PanelTop, PanelTSelect, PanelTView, PanelTV1, PanelTV2, PanelTV3, PanelTV4,
            PanelBody, PanelSouth, PanelSouthButtons; 
    private static JComboBox sportComB, feedbackComB;
    private static Button search, submitFeedback;
    private static final DateTime dateTime = new DateTime();
    private static String coachId, sportId, location;
    private ArrayList<String> sportID = new ArrayList<String>();
    private static ArrayList <String> sportsType = new ArrayList <String>();
    private String selectedSport, studentName, selectedRating, averageRating;
    private String rating[] = {"0","1", "2", "3", "4", "5"};
    private int counter = 0;
    private float coachStar = 0;
    public Feedback(String cenLocation, String userName){
        //List for the location
        studentName = userName;
        location = cenLocation;
        sportsType.removeAll(sportsType);
        for(int i = 0; i<Assignment.subscription.size(); i++){
            Subscription_Constr sub = Assignment.subscription.get(i);
            if(sub.getSubscriptionName().equals(studentName)&&sub.getSubscriptionLocation().equals(location)){
                sportsType.add(sub.getSubscriptionSport());
            }
        }
        feedbackComB = new JComboBox(rating);
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
        feedbackL = new JLabel("Feedback:");
        ratingL = new JLabel("Rating: ");
        
        coachIdText = new JTextField(15);
        coachIdText.setText(coachId);
        coachIdText.setHorizontalAlignment(JTextField.CENTER);
        coachNameText = new JTextField(15);
        coachNameText.setHorizontalAlignment(JTextField.CENTER);
        coachPhoneText = new JTextField(15);
        coachPhoneText.setHorizontalAlignment(JTextField.CENTER);
        sportFeesText = new JTextField(15);
        sportFeesText.setHorizontalAlignment(JTextField.CENTER);
        coachJDateText = new JTextField(15);
        coachJDateText.setHorizontalAlignment(JTextField.CENTER);
        feedbackText = new JTextField(15);
        feedbackText.setHorizontalAlignment(JTextField.CENTER);

        
        
        //++Set Component Disabled by Default++//
        sportIdInText.setEnabled(false);
        sportNameInText.setEnabled(false);
        coachIdText.setEnabled(false);
        coachNameText.setEnabled(false);
        coachPhoneText.setEnabled(false);
        sportFeesText.setEnabled(false);
        coachJDateText.setEnabled(false);
        feedbackText.setEnabled(true);

        
        //++Button++//
        search = new Button("Search");
        search.addActionListener(this);
        submitFeedback = new Button("Submit Feedback");
        submitFeedback.addActionListener(this);
        
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
        PanelBody.add(feedbackComB);
        PanelBody.add(coachJDateL);
        PanelBody.add(coachJDateText);
        PanelBody.add(coachSportFeesL);
        PanelBody.add(sportFeesText);
        
        PanelSouth = new JPanel();
        PanelSouth.setLayout(new BorderLayout(5,5));
        PanelSouthButtons = new JPanel();
        PanelSouthButtons.setLayout(new FlowLayout());
        PanelSouthButtons.add(submitFeedback);
        PanelSouth.add(PanelSouthButtons, BorderLayout.SOUTH);
        
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
                if (coach.getCoachCenter().equals(location)&&coach.getCoach_Sp_N().equals(selectedSport)){
                    sportIdInText.setText(coach.getCoachSp_Id());
                    coachIdText.setText(coach.getCoachId());
                    coachNameText.setText(coach.getCoachN());
                    coachPhoneText.setText(coach.getCoachTel());
                    int coachSportFees = Integer.parseInt(coach.getCoachHRate());
                    int coachFees = coachSportFees*4;
                    sportFeesText.setText(Integer.toString(coachFees));
                    coachJDateText.setText(coach.getJDate());
                }
            }
            for(int i=0; i<Assignment.subscription.size(); i++){
                Subscription_Constr sub = Assignment.subscription.get(i);
                if(sub.getSubscriptionName().equals(studentName)&&sub.getSubscriptionLocation().equals(location)&&sub.getSubscriptionSport().equals(selectedSport)){
                    feedbackComB.setSelectedItem(sub.getRating());
                }
            }
        }else if (ae.getSource()==submitFeedback){
            if(!coachNameText.getText().equals("")){
                for(int i =0; i<Assignment.subscription.size(); i++){
                    selectedSport = sportComB.getSelectedItem().toString();
                    Subscription_Constr sub = Assignment.subscription.get(i);
                    if(sub.getSubscriptionName().equals(studentName)&&sub.getSubscriptionLocation().equals(location)&&sub.getSubscriptionSport().equals(selectedSport)){
                        selectedRating = feedbackComB.getSelectedItem().toString();
                        sub.setRating(selectedRating); 
                        sub.setFeedback(feedbackText.getText());
                    } 
                }
                try{
                    PrintWriter f = new PrintWriter("subscriptionSport.txt");
                    for(int i=0; i<Assignment.subscription.size(); i++){
                        Subscription_Constr sub = Assignment.subscription.get(i);
                        f.println(sub.getSubscriptionName());
                        f.println(sub.getSubscriptionLocation());
                        f.println(sub.getCoachID());
                        f.println(sub.getSubscriptionSport());
                        f.println(sub.getSubscriptionFee());
                        f.println(sub.getRating());
                        f.println(sub.getFeedback());
                        f.println();
                    }
                    f.close();   
                    
                } catch(Exception ex){
                    System.out.println("Error in stop!");
                }
            }else{
                JOptionPane.showMessageDialog(submitFeedback, "Please choose the sport and click search");
            }
            counter = 0;
            coachStar = 0;
            for(int i =0; i<Assignment.subscription.size(); i++){
                selectedSport = sportComB.getSelectedItem().toString();
                Subscription_Constr sub = Assignment.subscription.get(i);
                if(sub.getSubscriptionLocation().equals(location)&&sub.getSubscriptionSport().equals(selectedSport)){
                    int star = Integer.parseInt(sub.getRating());
                    coachStar = coachStar + star;
                    coachId = sub.getCoachID();
                    counter = counter +1;
                }
            }
            float averageStar = coachStar/counter;
            averageRating = String.format("%.2f", averageStar);
            for(int i =0; i<Assignment.coachInfo.size(); i++){
            selectedSport = sportComB.getSelectedItem().toString();
                Coach_Constr coach = Assignment.coachInfo.get(i);
                if(coach.getCoachId().equals(coachId)&&coach.getCoachCenter().equals(location)&&coach.getCoach_Sp_N().equals(selectedSport)){
                    coach.setCoachStar(averageRating);
                }
            }
            try{
                PrintWriter f = new PrintWriter("coach.txt");
                for(int i=0; i<Assignment.coachInfo.size(); i++){
                    Coach_Constr c = Assignment.coachInfo.get(i);
                    f.println(c.getCoachId());
                    f.println(c.getCoachN());
                    f.println(c.getCoachTel());
                    f.println(c.getCoachHRate());
                    f.println(c.getCoachStar());
                    f.println(c.getCoachCenter());
                    f.println(c.getCoachSp_Id());
                    f.println(c.getCoach_Sp_N());
                    f.println(c.getCoachAdd());
                    f.println(c.getJDate());
                    f.println(c.getTDate());
                    f.println();
                }
                f.close();   
                    
            } catch(Exception ex){
                System.out.println("Error in stop!");
            }
                
        }
        
    }
}
