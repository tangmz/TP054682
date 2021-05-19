package Assignment;

import java.awt.BorderLayout;
import java.awt.Checkbox;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class SubscriptionSport extends JPanel implements ActionListener{
    private JPanel d1,d2;
    private JLabel subscriptionTitle;
    private Checkbox swimming, badminton, football, archery, gymnastic, volleyball, basketball, cricket, tennis, tableTennis;
    private ImageIcon subscribeLogo, unsubscribeLogo;
    private JButton subscribe, unsubscribe;
    public SubscriptionSport(String cenLocation){
        //Image and JButton
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
        for(int i = 0; i<Assignment.sportInfo.size(); i++){
            Sport_Constr sport = Assignment.sportInfo.get(i);
            for(int counter = 0; counter<Assignment.sportInfo.size(); counter++){
                if(sport.getCenter().equals(cenLocation)){
                    if(sport.getSportN().equals("swimming")){
                        d1.add(swimming, BorderLayout.CENTER);
                    }else if (sport.getSportN().equals("badminton")){
                        
                       d1. add(badminton, BorderLayout.CENTER);
                    }else if (sport.getSportN().equals("football")){
                        
                        d1.add(football, BorderLayout.CENTER);
                    }else if (sport.getSportN().equals("archery")){
                        
                        d1.add(archery, BorderLayout.CENTER);
                    }else if (sport.getSportN().equals("gymnastic")){
                        
                        d1.add(gymnastic, BorderLayout.CENTER);
                    }else if (sport.getSportN().equals("volleyball")){
                        
                        d1.add(volleyball, BorderLayout.CENTER);
                    }else if (sport.getSportN().equals("basketball")){
                        
                        d1.add(basketball, BorderLayout.CENTER);
                    }else if (sport.getSportN().equals("cricket")){
                       
                        d1.add(cricket, BorderLayout.CENTER);
                    }else if (sport.getSportN().equals("tennis")){
                        
                        d1.add(tennis, BorderLayout.CENTER);
                    }else if (sport.getSportN().equals("table tennis")){
                        
                        d1.add(tableTennis, BorderLayout.CENTER);
                    }
                }
            }
        }
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
            
        }else if(ae.getSource() == unsubscribe){
            
        }
    }
}
