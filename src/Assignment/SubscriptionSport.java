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
import javax.swing.JPanel;

public class SubscriptionSport extends JPanel implements ActionListener{
    private JPanel d1,d2;
    private JLabel subscriptionTitle;
    private Checkbox swimming, badminton, football, archery, gymnastic, volleyball, basketball, cricket, tennis, tableTennis;
    private ImageIcon subscribeLogo, unsubscribeLogo;
    private JButton subscribe, unsubscribe;
    private String location;
    private JComboBox sportComB;
    private static ArrayList <String> sportsType = new ArrayList <String>();
    public SubscriptionSport(String userName, String cenLocation){
        //Image and JButton
        location = cenLocation;
        subscribeLogo = new ImageIcon(new ImageIcon(this.getClass().getResource("/PicLibrary/subscribe.png")).getImage().getScaledInstance(40, 40, Image.SCALE_SMOOTH));
        subscribe = new JButton("Subscribe", subscribeLogo);
        subscribe.setBackground(Color.WHITE);
        unsubscribeLogo = new ImageIcon(new ImageIcon(this.getClass().getResource("/PicLibrary/cancelSubscription.png")).getImage().getScaledInstance(40, 40, Image.SCALE_SMOOTH));
        unsubscribe = new JButton("Unsubscribe", unsubscribeLogo);
        unsubscribe.setBackground(Color.WHITE);
        //Checkbox for Sports
        swimming = new Checkbox("Swimming");
        badminton = new Checkbox("Badminton");
        football = new Checkbox("Football");
        archery = new Checkbox("Archery");
        gymnastic = new Checkbox("Gymnastic");
        volleyball = new Checkbox("Volleyball");
        basketball = new Checkbox("Basketball");
        cricket = new Checkbox("Cricket");
        tennis = new Checkbox("Tennis");
        tableTennis = new Checkbox("Table Tennis");
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
//            for(int i=0; i<Assignment.coachInfo.size(); i++){
//                Coach_Constr coach = Assignment.coachInfo.get(i);
//                if (coach.getCoachCenter().equals(location)){
//                    
//                }

        }else if(ae.getSource() == unsubscribe){
            
        }
    }
}
