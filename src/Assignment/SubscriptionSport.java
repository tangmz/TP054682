package Assignment;

import java.awt.BorderLayout;
import java.awt.Checkbox;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class SubscriptionSport extends JPanel implements ActionListener{
    private JPanel d1,d2;
    private JLabel subscriptionTitle;
    private ImageIcon subscribeLogo, unsubscribeLogo;
    private JButton subscribe, unsubscribe;
    private String location, studentName,selectedSport, feedback;
    private JComboBox sportComB;
    private boolean found=true;
    private static ArrayList <String> sportsType = new ArrayList <String>();
    public SubscriptionSport(String userName, String cenLocation){
        //Image and JButton
        feedback = "0";
        studentName = userName;
        location = cenLocation;
        subscribeLogo = new ImageIcon(new ImageIcon(this.getClass().getResource("/PicLibrary/subscribe.png")).getImage().getScaledInstance(40, 40, Image.SCALE_SMOOTH));
        subscribe = new JButton("Subscribe", subscribeLogo);
        subscribe.setBackground(Color.WHITE);
        unsubscribeLogo = new ImageIcon(new ImageIcon(this.getClass().getResource("/PicLibrary/cancelSubscription.png")).getImage().getScaledInstance(40, 40, Image.SCALE_SMOOTH));
        unsubscribe = new JButton("Unsubscribe", unsubscribeLogo);
        unsubscribe.setBackground(Color.WHITE);
        subscribe.addActionListener(this);
        unsubscribe.addActionListener(this);
        //Panel Design
        setLayout(new BorderLayout());
        subscriptionTitle = new JLabel("Subscription Sport", JLabel.CENTER);
        subscriptionTitle.setFont(new Font("Arial", Font.BOLD, 50));
        add(subscriptionTitle, BorderLayout.NORTH);
        d1 = new JPanel();
        d1.setLayout(new FlowLayout());
        //Sport that matched with the sportInfo if true then it will create Checkbox
        
        location = cenLocation;
        for(int i = 0; i<Assignment.sportInfo.size(); i++){
            Sport_Constr sport = Assignment.sportInfo.get(i);
            if(sport.getCenter().equals(location)){
                sportsType.add(sport.getSportN()); 
                
            }
        }
        sportComB = new JComboBox(sportsType.toArray());
        d1.add(sportComB);
        add(d1, BorderLayout.CENTER);
        d2 = new JPanel();
        d2.setLayout(new FlowLayout());
        d2.add(subscribe);
        d2.add(unsubscribe);
        add(d2, BorderLayout.SOUTH);
    }
    @Override
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource()== subscribe){
           selectedSport = sportComB.getSelectedItem().toString();
           for(int i = 0; i <Assignment.subscription.size(); i++){
                Subscription_Constr sub = Assignment.subscription.get(i);
                if(sub.getSubscriptionName().equals(studentName)&&sub.getSubscriptionSport().equals(selectedSport)&&sub.getSubscriptionLocation().equals(location)){
                    found = false;
                }else{
                    found = true;
                }
            }
            if(found){
                for(int i=0; i<Assignment.coachInfo.size(); i++){
                    Coach_Constr coach = Assignment.coachInfo.get(i);
                    if (coach.getCoachCenter().equals(location)&&(coach.getCoach_Sp_N().equals(selectedSport))){
                        Subscription_Constr sub = new Subscription_Constr(studentName, location, selectedSport, coach.getCoachHRate(), feedback);
                        Assignment.subscription.add(sub);
                    }
                }
                try{
                    PrintWriter f = new PrintWriter("subscriptionSport.txt");
                    for(int i=0; i<Assignment.subscription.size(); i++){
                        Subscription_Constr c = Assignment.subscription.get(i);
                        f.println(c.getSubscriptionName());
                        f.println(c.getSubscriptionLocation());
                        f.println(c.getSubscriptionSport());
                        f.println(c.getSubscriptionFee());
                        f.println(c.getFeedback());
                        f.println();
                    }
                    f.close();
                    JOptionPane.showMessageDialog(unsubscribe, "You have subscribed "+selectedSport);
                } catch(Exception ex){
                    System.out.println("Error!");
                }
           }else{
               JOptionPane.showMessageDialog(subscribe, "Sport has subscribed");
           }
                            
                        
                    
                
            
        }else if(ae.getSource() == unsubscribe){
            selectedSport = sportComB.getSelectedItem().toString();
            try{
                PrintWriter f = new PrintWriter("subscriptionSport.txt");
                for (int i = 0; i<Assignment.subscription.size(); i++){
                    Subscription_Constr sub = Assignment.subscription.get(i);
                    if(sub.getSubscriptionName().equals(studentName)&&sub.getSubscriptionSport().equals(selectedSport)&&sub.getSubscriptionLocation().equals(location)){
                        Assignment.subscription.remove(sub);
                        break;
                    }
                    f.println(sub.getSubscriptionName());
                    f.println(sub.getSubscriptionLocation());
                    f.println(sub.getSubscriptionSport());
                    f.println(sub.getSubscriptionFee());
                    f.println(sub.getFeedback());
                    f.println();
                }
                f.close();
                JOptionPane.showMessageDialog(unsubscribe, "You have unsubscribed "+selectedSport);
                  
            } catch(Exception ex){
                System.out.println("Error!"); 
            }  
        }
    }
}
