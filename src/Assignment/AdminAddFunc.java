package Assignment;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.PrintWriter;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class AdminAddFunc extends JPanel implements ActionListener{
    private static JLabel SportSelc , SportIdL, SportNameL, CIdL, CNameL, CPhoneL, CRatePayL, CStarL, CAddressL, CJDateL, CTDateL;
    private static JTextField SportIdIn, SportNameIn, CId, CName, CPhone, CRatePay, CStar, CAddress, CJDate, CTDate;
    public static JPanel PanelTop, PanelTSelect, PanelTView, PanelTSNorth, PanelTSCenter, PanelTV1, PanelTV2, PanelTV3, PanelTV4,
            PanelBody, PanelSouth, PanelSouthButtons; 
    private static JComboBox SportComB;
    private static JRadioButton AddB, ModB;
    private static ButtonGroup AddModSelection;
    private static Button Search, AddSport, AddCoach, TerminateCoach;
    private static final DateTime dateTime = new DateTime();
    private static String coachId, sportId, whichOperation;
    public AdminAddFunc(){
        
        SportComB = new JComboBox();
        SportComB.addItem("Hiiiiiii");/////////////Delete Later
//        SportMod.setModel(cbm);
        SportSelc = new JLabel("Sport:  ");
        SportIdL = new JLabel("Sport ID:  ");
        SportNameL = new JLabel("Sport:       ");
        SportIdIn = new JTextField(15);
        SportIdIn.setText(sportId);
        SportIdIn.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent ke) {
                char c = ke.getKeyChar();{
                  ke.consume();
               }
            }
            @Override
            public void keyPressed(KeyEvent ke) {}
            @Override
            public void keyReleased(KeyEvent ke) {}
        });
        SportNameIn = new JTextField(15);
        
        
        CIdL = new JLabel("Coach ID:");
        CNameL = new JLabel("Name:");
        CPhoneL = new JLabel("Phone:");
        CRatePayL = new JLabel("Hourly Pay:");
        CStarL = new JLabel("Rating :");
        CAddressL = new JLabel("Residing City:");
        CJDateL = new JLabel("Joined Date:");
        CTDateL = new JLabel("Quit Date:");
        
        CId = new JTextField(15);
        CId.setText(coachId);
        CId.setHorizontalAlignment(JTextField.CENTER);
        CName = new JTextField(15);
        CName.setHorizontalAlignment(JTextField.CENTER);
        CPhone = new JTextField(15);
        CPhone.setHorizontalAlignment(JTextField.CENTER);
        CRatePay = new JTextField(15);
        CRatePay.setHorizontalAlignment(JTextField.CENTER);
        CRatePay.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent ke) {
                char c = ke.getKeyChar();
                if (!((c >= '0') && (c <= '9') ||
                    (c == KeyEvent.VK_BACK_SPACE) ||
                    (c == KeyEvent.VK_DELETE))) {
                  ke.consume();
               }
            }
            @Override
            public void keyPressed(KeyEvent ke) {}
            @Override
            public void keyReleased(KeyEvent ke) {}
        });
        CStar = new JTextField("0");
        CStar.setHorizontalAlignment(JTextField.CENTER);
        CAddress = new JTextField(15);
        CAddress.setHorizontalAlignment(JTextField.CENTER);
        CJDate = new JTextField(dateTime.getPartialDate());
        CJDate.setHorizontalAlignment(JTextField.CENTER);
        CTDate = new JTextField("-");
        CTDate.setHorizontalAlignment(JTextField.CENTER);
        Search = new Button("Search");
        AddSport = new Button("Add Sport");
        AddCoach = new Button("Add Coach");
        AddSport.addActionListener(this);
        AddCoach.addActionListener(this);
        TerminateCoach = new Button("Terminate Coach");
        
        AddB = new JRadioButton("New Record");
        ModB = new JRadioButton("Modify Record");
        AddModSelection = new ButtonGroup();
        AddModSelection.add(AddB);
        AddModSelection.add(ModB);
        ModB.setSelected(true);
        AddB.addActionListener(this);
        ModB.addActionListener(this);
        
        //++Set Component Disabled by Default++//
        CId.setEnabled(false);
        CStar.setEnabled(false);
        CJDate.setEnabled(false);
        CTDate.setEnabled(false);
        AddSport.setVisible(false);
        AddCoach.setVisible(false);
        
        //++Retrieve Data++//
        retrieve r = new retrieve();
        
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
        PanelTSelect.add(Search);
        
        PanelTView = new JPanel();
        PanelTView.setLayout(new BorderLayout(5,5));
        PanelTView.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1 , true));
        PanelTView.setPreferredSize(new Dimension(550,150));
        PanelTV1 = new JPanel();
        PanelTV1.setLayout(new FlowLayout(FlowLayout.CENTER));
        PanelTV1.add(SportIdL);
        PanelTV1.add(SportIdIn);
        PanelTV2 = new JPanel();
        PanelTV2.setLayout(new FlowLayout(FlowLayout.CENTER));
        PanelTV2.add(SportNameL);
        PanelTV2.add(SportNameIn);
        PanelTV3 = new JPanel();
        PanelTV3.setLayout(new FlowLayout(FlowLayout.RIGHT));
        PanelTV3.add(AddSport);
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
        
        GridLayout gL1 = new GridLayout(4,4);
        gL1.setVgap(50);
        gL1.setHgap(10);
        PanelBody = new JPanel();
        PanelBody.setLayout(gL1);
        PanelBody.add(CNameL);
        PanelBody.add(CName);
        PanelBody.add(CIdL);
        PanelBody.add(CId);
        PanelBody.add(CPhoneL);
        PanelBody.add(CPhone);
        PanelBody.add(CStarL);
        PanelBody.add(CStar);
        PanelBody.add(CAddressL);
        PanelBody.add(CAddress);
        PanelBody.add(CJDateL);
        PanelBody.add(CJDate);
        PanelBody.add(CRatePayL);
        PanelBody.add(CRatePay);
        PanelBody.add(CTDateL);
        PanelBody.add(CTDate);
        
        PanelSouth = new JPanel();
        PanelSouth.setLayout(new BorderLayout(5,5));
        PanelSouthButtons = new JPanel();
        PanelSouthButtons.setLayout(new FlowLayout());
        PanelSouthButtons.add(TerminateCoach);
        PanelSouthButtons.add(AddCoach);
        PanelSouth.add(PanelSouthButtons, BorderLayout.SOUTH);
        
        add(PanelTop, BorderLayout.NORTH);
        add(PanelBody, BorderLayout.CENTER);
        add(PanelSouth, BorderLayout.SOUTH);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource() == AddSport){
            whichOperation = "Sport";
            writeFile writeFile = new writeFile(whichOperation);
            retrieve r = new retrieve();
            
        }else if(ae.getSource() == AddCoach){
            whichOperation = "Coach";
            writeFile writeFile = new writeFile(whichOperation);
            retrieve r = new retrieve();
        }else if(ae.getSource() == AddB){
            Selection selection = new Selection(1);
        }else if(ae.getSource() == ModB){
            Selection selection = new Selection(2);
        }
    }
    
    //++Write File++//
    private static class writeFile {

        String SportPre = SportNameIn.getText();
        String SportNcap = SportPre.toUpperCase();
        private writeFile(String whichButton) {
            if(whichButton.equals("Coach")){
                Coach_Constr writeC = new Coach_Constr(CId.getText(),CName.getText(),CPhone.getText(),CRatePay.getText(),CStar.getText(),
                RegisteredAdmin.centerLocation,SportIdIn.getText(),SportNcap,CAddress.getText(), CJDate.getText(), CTDate.getText());
                Assignment.coachInfo.add(writeC);
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
            else if(whichButton.equals("Sport")){
                Sport_Constr writeS = new Sport_Constr(SportIdIn.getText(),SportNcap,RegisteredAdmin.centerLocation,CName.getText());
                Assignment.sportInfo.add(writeS);
                try{
                    PrintWriter f = new PrintWriter("sport.txt");
                    for(int i=0; i<Assignment.sportInfo.size(); i++){
                        Sport_Constr c = Assignment.sportInfo.get(i);
                        f.println(c.getSprtId());
                        f.println(c.getSportN());
                        f.println(c.getCenter());
                        f.println(c.getCoachN());
                        f.println();
                    }
                    f.close();   
                    
                } catch(Exception ex){
                    System.out.println("Error in stop!");
                }
            }
        }
    }

    private class Selection {

        private Selection(int RadioB) {
            if(RadioB == 1){
                AddSport.setVisible(true);
                AddCoach.setVisible(true);
                TerminateCoach.setVisible(false);
                SportComB.setEnabled(false);
                PanelSouthButtons.revalidate();
                PanelSouthButtons.repaint();
            }else if(RadioB == 2){
                TerminateCoach.setVisible(true);
                AddSport.setVisible(false);
                AddCoach.setVisible(false);
                SportComB.setEnabled(true);
                PanelSouthButtons.revalidate();
                PanelSouthButtons.repaint();
            }
        }
    }
    
    private class retrieve {

        private retrieve() {
            String nextID = "";
            int i = 0;
            i = Assignment.coachInfo.size();
            nextID = String.valueOf(i+1);
            coachId = "CN0"+(nextID);
            CId.setText(coachId);
            
            int x;
            x = Assignment.sportInfo.size();
            nextID = String.valueOf(x+1);
            
            if(RegisteredAdmin.centerLocation.equals("BukitJalil")){
                sportId = "RCSBJ0"+(nextID);
                SportIdIn.setText(sportId);
            }else if(RegisteredAdmin.centerLocation.equals("PetalingJaya")){
                sportId = "RCSPJ0"+(nextID);
                SportIdIn.setText(sportId);
            }else if(RegisteredAdmin.centerLocation.equals("Putrajaya")){
                sportId = "RCSPU0"+(nextID);
                SportIdIn.setText(sportId);
            }else if(RegisteredAdmin.centerLocation.equals("ShahAlam")){
                sportId = "RCSSA0"+(nextID);
                SportIdIn.setText(sportId);
            }
        }
    }
}
