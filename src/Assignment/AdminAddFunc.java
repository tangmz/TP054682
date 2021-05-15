package Assignment;

import java.awt.FlowLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class AdminAddFunc extends JPanel{
    public String Stringg = "Hii";
    public JLabel Test = new JLabel(Stringg);
    public JPanel MainPanel; 
    AdminAddFunc(){
        Stringg = "Hiiiiiii";
        Test = new JLabel(Stringg);
//        MainPanel = new JPanel();
        setLayout(new FlowLayout());
//        Assignment.registeredAd.displayBody.add(Test);
        add(Test);
    }
}
