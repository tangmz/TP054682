package Assignment;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class AdminAddFunc extends JPanel implements ActionListener{
//    private JLabel Test;
    public JPanel PanelTop, PanelMod, PanelAdd, PanelBody; 
    private JComboBox SportMod;
    AdminAddFunc(){
        readFile();
        SportMod = new JComboBox();
//        SportMod.setModel(cbm);
        
        //++PanelDesign//++
//        Test = new JLabel("Hiiiiiii");
        PanelMod = new JPanel();
        PanelMod.setLayout(new FlowLayout());
        PanelMod.add(SportMod);
        PanelTop = new JPanel();
        PanelTop.setLayout(new BorderLayout());
        PanelTop.add(PanelMod, BorderLayout.WEST);
        setLayout(new BorderLayout());
        add(PanelTop, BorderLayout.NORTH);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void readFile() {
        
    }
}
