package Assignment;

import static Assignment.AdminAddFunc.PanelSouth;
import static Assignment.AdminAddFunc.PanelSouthButtons;
import static Assignment.Feedback.PanelTV1;
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
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class Payment extends JPanel implements ActionListener {
    private static JLabel timeL, studentNameL, outstandingFeesL, amountPayL, title;
    private static JTextField amountPayText, studentNameText,sportFeesText;
    public static JPanel PanelTop, PanelTSelect, PanelTView, PanelTV1, PanelTV2, PanelTV3, PanelTV4,
            PanelBody, PanelSouth, PanelSouthButtons; 
    private static Button pay,paymentDetail;
    private static final DateTime dateTime = new DateTime();
    private static String location;
    private String studentName;
    private int sportFees;
    public Payment(String cenLocation, String userName){
        //List for the location
        studentName = userName;
        location = cenLocation;
//        SportMod.setModel(cbm);
        timeL = new JLabel(String.valueOf(dateTime.getFullDate()), SwingConstants.CENTER);
        timeL.setFont(new Font("Arial", Font.BOLD, 30));
        
        //label
        title = new JLabel("Payment", JLabel.CENTER);
        title.setFont(new Font("Arial", Font.BOLD, 30));
        studentNameL = new JLabel("Student Name:");
        outstandingFeesL = new JLabel("Total Outstanding Payment:");
        amountPayL = new JLabel("Amount payment: ");

        studentNameText = new JTextField(15);
        studentNameText.setHorizontalAlignment(JTextField.CENTER);
        sportFeesText = new JTextField(15);
        sportFeesText.setHorizontalAlignment(JTextField.CENTER);
        amountPayText = new JTextField(15);
        amountPayText.setHorizontalAlignment(JTextField.CENTER);


        
        
        //++Set Component Disabled by Default++//
        studentNameText.setEnabled(false);
        sportFeesText.setEnabled(false);
        amountPayText.setEnabled(true);

        //Retrieve data from subscriptionSport.txt
        
        //++Button++//
        pay = new Button("Pay");
        pay.addActionListener(this);
        paymentDetail = new Button("Payment Detail");
        paymentDetail.addActionListener(this);
        
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
        PanelTV1.add(title);
        PanelTV4 = new JPanel();
        PanelTV4.setLayout(new BorderLayout(5,5));
        PanelTView.add(PanelTV1, BorderLayout.NORTH);
        PanelTView.add(PanelTV4, BorderLayout.CENTER);
        
        PanelTop = new JPanel();
        PanelTop.setLayout(new BorderLayout(5,5));
        PanelTop.add(PanelTSelect, BorderLayout.WEST);
        PanelTop.add(PanelTView, BorderLayout.EAST);
        
        GridLayout gL1 = new GridLayout(4,4);
        gL1.setVgap(50);
        gL1.setHgap(10);
        PanelBody = new JPanel();
        PanelBody.setLayout(gL1);
        PanelBody.add(studentNameL);
        PanelBody.add(studentNameText);
        PanelBody.add(outstandingFeesL);
        PanelBody.add(sportFeesText);
        PanelBody.add(amountPayL);
        PanelBody.add(amountPayText);
        
        PanelSouth = new JPanel();
        PanelSouth.setLayout(new BorderLayout(5,5));
        PanelSouthButtons = new JPanel();
        PanelSouthButtons.setLayout(new FlowLayout());
        PanelSouthButtons.add(pay);
        PanelSouthButtons.add(paymentDetail);
        PanelSouth.add(PanelSouthButtons, BorderLayout.SOUTH);
        //Add to the main Panel
        add(PanelTop, BorderLayout.NORTH);
        add(PanelBody, BorderLayout.CENTER);
        add(PanelSouth, BorderLayout.SOUTH);
    }
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource()==pay){
            try{
                PrintWriter f = new PrintWriter("subscriptionSport.txt");
                for(int i=0; i<Assignment.subscription.size(); i++){
                    Subscription_Constr c = Assignment.subscription.get(i);
                    if(c.getSubscriptionName().equals(studentName)&&c.getSubscriptionLocation().equals(location)){
                        int amountPay = Integer.parseInt(amountPayText.getText());
                        int totalAmountPay = Integer.parseInt(c.getSubscriptionFee());
                        c.setSubscriptionFee(amountPayText.getText());
                    }
                    f.println(c.getSubscriptionName());
                    f.println(c.getSubscriptionLocation());
                    f.println(c.getSubscriptionSport());
                    f.println(c.getSubscriptionFee());
                    f.println(c.getFeedback());
                    f.println();
                }
                f.close();   
            } catch(Exception ex){
                System.out.println("Error in stop!"); 
            }  
        }else if(ae.getSource()==paymentDetail){
            for(int i=0; i<Assignment.subscription.size(); i++){
            Subscription_Constr c = Assignment.subscription.get(i);
                if(c.getSubscriptionName().equals(studentName)&&c.getSubscriptionLocation().equals(location)){
                    studentNameText.setText(c.getSubscriptionName());
                    System.out.println(c.getSubscriptionFee());
                    int coachSportFees = Integer.parseInt(c.getSubscriptionFee());
                    sportFees = coachSportFees*4;
                    sportFeesText.setText(Integer.toString(sportFees));
                }
            }
        }
        
        
    }

}
