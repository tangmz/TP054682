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
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

//To show the payment details and allow student to pay
public class Payment extends JPanel implements ActionListener {
    //Variable Declaration
    private static JLabel timeL, studentNameL, outstandingFeesL, amountPayL, title, totalPayL;
    private static JTextField amountPayText, studentNameText,sportFeesText, totalPayText;
    public static JPanel PanelTop, PanelTSelect, PanelTView, PanelTV1, PanelTV2, PanelTV3, PanelTV4,
            PanelBody, PanelSouth, PanelSouthButtons; 
    private static Button pay,paymentDetail;
    private static final DateTime dateTime = new DateTime();
    private static String location, studentAttendance = "8";
    private String studentName,finalOutBalance;
    private boolean flag = true;
    public Payment(String userName, String cenLocation){
        //Store the string into a variable
        studentName = userName;
        location = cenLocation;
        //Create label for the panel
        timeL = new JLabel(String.valueOf(dateTime.getFullDate()), SwingConstants.CENTER);
        timeL.setFont(new Font("Arial", Font.BOLD, 30));
        title = new JLabel("Payment", JLabel.CENTER);
        title.setFont(new Font("Arial", Font.BOLD, 30));
        studentNameL = new JLabel("Student Name:");
        outstandingFeesL = new JLabel("Outstanding Balance:");
        totalPayL = new JLabel("Total Payment:");
        amountPayL = new JLabel("Amount payment: ");
        
        //Create textfield
        studentNameText = new JTextField(15);
        studentNameText.setHorizontalAlignment(JTextField.CENTER);
        sportFeesText = new JTextField(15);
        sportFeesText.setHorizontalAlignment(JTextField.CENTER);
        amountPayText = new JTextField(15);
        amountPayText.setHorizontalAlignment(JTextField.CENTER);
        totalPayText = new JTextField(15);
        totalPayText.setHorizontalAlignment(JTextField.CENTER);

        //++Set Component Disabled by Default++//
        studentNameText.setEnabled(false);
        sportFeesText.setEnabled(false);
        amountPayText.setEnabled(true);
        totalPayText.setEnabled(false);

        //Set Text for Student Name
        studentNameText.setText(studentName);
        
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
        PanelBody.add(totalPayL);
        PanelBody.add(totalPayText);
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
        //To pay the the outstanding balance
        if (ae.getSource()==pay){
            try{
                //It will read the payment array list using for loop
                for(int i=0; i<Assignment.payment.size(); i++){
                    StudentPayment c = Assignment.payment.get(i);
                    //Check whether the student name and location are matched in the array
                    if(c.getStudentName().equals(studentName)&&c.getStudentLocation().equals(location)){
                        //if outstanding balance is more than 0, then the amount of money will deduct it from the outstanding baalnce
                        if (Integer.parseInt(c.getStudentBalance())>=0){
                            int totalAmountPay = Integer.parseInt(c.getStudentBalance());
                            int amountPay = Integer.parseInt(amountPayText.getText());
                            int outstandingBalance = totalAmountPay - amountPay;
                            finalOutBalance = Integer.toString(outstandingBalance);
                            //Replace the outstanding balance into the array list before writing into the file
                            c.setStudentBalance(finalOutBalance);
                        //If false, then it will show user that they have paid
                        }else{
                            JOptionPane.showMessageDialog(pay, "You have paid");
                            break;
                        }
                    }
                }
                try{
                    //Write the latets array into the studentPayment file
                    PrintWriter f = new PrintWriter("studentPayment.txt");
                    //It will write into the file by using for loop
                    for(int i=0; i<Assignment.payment.size(); i++){
                        StudentPayment c = Assignment.payment.get(i);
                        //Check whether the student name and location are match with the user inputs
                        if(c.getStudentName().equals(studentName)&&c.getStudentLocation().equals(location)){
                            f.println(c.getStudentName());
                            f.println(c.getSportName());
                            f.println(c.getStudentLocation());
                            f.println(c.getStudentTotalPayment());
                            f.println(c.getStudentBalance());
                            f.println(c.getStudentAttendance());
                            f.println();

                        }
                        f.close(); 
                        //It will also set the latest outstanding balance on the textfield
                        sportFeesText.setText(finalOutBalance);
                    }
                } catch(Exception ex){
                    System.out.println("Error in stop!"); 
                } 
            }
            catch(Exception e){
                JOptionPane.showMessageDialog(this, "Please enter an amount!");
            }
        //Show the detail of the total payment and outstanding balance
        }else if(ae.getSource()==paymentDetail){
            //Read the array using for loop
            for(int i=0; i<Assignment.payment.size(); i++){
                StudentPayment c = Assignment.payment.get(i);
                //Check whether the student name and location are matched
                if(c.getStudentName().equals(studentName)&&c.getStudentLocation().equals(location)){
                    //It will display the details on the textfield
                    totalPayText.setText(c.getStudentTotalPayment());
                    sportFeesText.setText(c.getStudentBalance());
                }
            }
            
        }
        
        
    }

}
