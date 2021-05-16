package Assignment;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

public class AdminAddFunc extends JPanel implements ActionListener{
    private JLabel SportSelc , SportIdL, SportNameL;
    private TextField SportIdIn, SportNameIn;
    public JPanel PanelTop, PanelTSelect, PanelTView, PanelTSNorth, PanelTSCenter, PanelTV1, PanelTV2, PanelTV3, PanelBody; 
    private JComboBox SportComB;
    private JRadioButton AddB, ModB;
    private ButtonGroup AddModSelection;
    AdminAddFunc(){
        readFile();
        SportComB = new JComboBox();
        SportComB.addItem("Hiiiiiii");
//        SportMod.setModel(cbm);
        SportSelc = new JLabel("Sport:  ");
        SportIdL = new JLabel("Sport ID:  ");
        SportNameL = new JLabel("Sport:       ");
        SportIdIn = new TextField(15);
        SportNameIn = new TextField(15);
        
        AddB = new JRadioButton("Add Sport");
        ModB = new JRadioButton("Modify Sport");
        AddModSelection = new ButtonGroup();
        AddModSelection.add(AddB);
        AddModSelection.add(ModB);
        AddB.addActionListener(this);
        ModB.addActionListener(this);
        
        //++Set Component Disabled by Default++//
        SportComB.setEnabled(false);
        
        //++PanelDesign//++
//        Test = new JLabel("Hiiiiiii");
        GridLayout gL1 = new GridLayout(2,1);
        gL1.setVgap(2);
        PanelTSelect = new JPanel();
        PanelTSelect.setLayout(gL1);
        PanelTSelect.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        PanelTSelect.setPreferredSize(new Dimension(400,150));
        PanelTSNorth = new JPanel();
        PanelTSNorth.setLayout(new FlowLayout());
        PanelTSNorth.add(ModB);
        PanelTSNorth.add(AddB);
        PanelTSelect.add(PanelTSNorth);
        PanelTSCenter = new JPanel();
        PanelTSCenter.setLayout(new FlowLayout(FlowLayout.CENTER));
        PanelTSCenter.add(SportSelc);
        PanelTSCenter.add(SportComB);
        PanelTSelect.add(PanelTSCenter);
        
        GridLayout gL2 = new GridLayout(2,1);
        gL1.setVgap(2);
        PanelTView = new JPanel();
        PanelTView.setLayout(new BorderLayout());
        PanelTView.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        PanelTView.setPreferredSize(new Dimension(400,150));
        PanelTV1 = new JPanel();
        PanelTV1.setLayout(new FlowLayout(FlowLayout.CENTER));
        PanelTV1.add(SportIdL);
        PanelTV1.add(SportIdIn);
        PanelTV2 = new JPanel();
        PanelTV2.setLayout(new FlowLayout(FlowLayout.CENTER));
        PanelTV2.add(SportNameL);
        PanelTV2.add(SportNameIn);
        PanelTView.add(PanelTV1, BorderLayout.NORTH);
        PanelTView.add(PanelTV2, BorderLayout.CENTER);
        
        PanelTop = new JPanel();
        PanelTop.setLayout(new BorderLayout());
        PanelTop.add(PanelTSelect, BorderLayout.WEST);
        PanelTop.add(PanelTView, BorderLayout.EAST);
        setLayout(new BorderLayout());
        add(PanelTop, BorderLayout.NORTH);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if(AddB.isSelected()){
            SportComB.setEnabled(false);
        }else if(ModB.isSelected()){
            SportComB.setEnabled(true);
        }
    }

    private void readFile() {
        
    }
}
