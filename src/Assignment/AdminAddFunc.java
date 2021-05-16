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
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class AdminAddFunc extends JPanel implements ActionListener{
    private JLabel SportSelc , SportIdL, SportNameL, CIdL, CNameL, CPhoneL, CRatePayL, CStarL, CAddressL, CJDateL, CTDateL;
    private JTextField SportIdIn, SportNameIn, CId, CName, CPhone, CRatePay, CStar, CAddress, CJDate, CTDate;
    public JPanel PanelTop, PanelTSelect, PanelTView, PanelTSNorth, PanelTSCenter, PanelTV1, PanelTV2, PanelTV3, PanelTV4,
            PanelBody, PanelSouth, PanelSouthButtons; 
    private JComboBox SportComB;
    private JRadioButton AddB, ModB;
    private ButtonGroup AddModSelection;
    private Button Search, AddSport, AddCoach, TerminateCoach;
    private static RegisteredAdmin rAd = new RegisteredAdmin();
    private DateTime dateTime = new DateTime();
    AdminAddFunc(){
        
        SportComB = new JComboBox();
        SportComB.addItem("Hiiiiiii");
//        SportMod.setModel(cbm);
        SportSelc = new JLabel("Sport:  ");
        SportIdL = new JLabel("Sport ID:  ");
        SportNameL = new JLabel("Sport:       ");
        SportIdIn = new JTextField(15);
        SportNameIn = new JTextField(15);
        
        AddB = new JRadioButton("New Record");
        ModB = new JRadioButton("Modify Record");
        AddModSelection = new ButtonGroup();
        AddModSelection.add(AddB);
        AddModSelection.add(ModB);
        AddB.addActionListener(this);
        ModB.addActionListener(this);
        
        CIdL = new JLabel("Coach ID:");
        CNameL = new JLabel("Name:");
        CPhoneL = new JLabel("Phone:");
        CRatePayL = new JLabel("Hourly Pay:");
        CStarL = new JLabel("Rating :");
        CAddressL = new JLabel("Address:");
        CJDateL = new JLabel("Joined Date:");
        CTDateL = new JLabel("Quit Date:");
        
        CId = new JTextField(15);
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
                  getToolkit().beep();
                  ke.consume();
               }
            }
            @Override
            public void keyPressed(KeyEvent ke) {}
            @Override
            public void keyReleased(KeyEvent ke) {}
        });
        CStar = new JTextField(15);
        CStar.setHorizontalAlignment(JTextField.CENTER);
        CAddress = new JTextField(15);
        CAddress.setHorizontalAlignment(JTextField.CENTER);
        CJDate = new JTextField(dateTime.getPartialDate());
        CJDate.setHorizontalAlignment(JTextField.CENTER);
        CTDate = new JTextField(15);
        CTDate.setHorizontalAlignment(JTextField.CENTER);
        
        Search = new Button("Search");
        AddSport = new Button("Add Sport");
        AddCoach = new Button("Add Coach");
        TerminateCoach = new Button("Terminate Coach");
        
        //++Set Component Disabled by Default++//
        SportComB.setEnabled(false);
        CId.setEnabled(false);
        CStar.setEnabled(false);
        CJDate.setEnabled(false);
        CTDate.setEnabled(false);
        
        //++PanelDesign//++
//        Test = new JLabel("Hiiiiiii");
        PanelTSelect = new JPanel();
        PanelTSelect.setLayout(new GridLayout(3,1));
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
        PanelTSelect.add(Search);
        
        PanelTView = new JPanel();
        PanelTView.setLayout(new BorderLayout(5,5));
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
        
        GridLayout gL = new GridLayout(4,4);
        gL.setVgap(15);
        PanelBody = new JPanel();
        PanelBody.setLayout(gL);
        PanelBody.add(CIdL);
        PanelBody.add(CId);
        PanelBody.add(CNameL);
        PanelBody.add(CName);
        PanelBody.add(CPhoneL);
        PanelBody.add(CPhone);
        PanelBody.add(CRatePayL);
        PanelBody.add(CRatePay);
        PanelBody.add(CStarL);
        PanelBody.add(CStar);
        PanelBody.add(CAddressL);
        PanelBody.add(CAddress);
        PanelBody.add(CJDateL);
        PanelBody.add(CJDate);
        PanelBody.add(CTDateL);
        PanelBody.add(CTDate);
        
        PanelSouth = new JPanel();
        PanelSouth.setLayout(new BorderLayout(5,5));
        PanelSouthButtons = new JPanel();
        PanelSouthButtons.setLayout(new FlowLayout());
        PanelSouthButtons.add(TerminateCoach);
        PanelSouthButtons.add(AddCoach);
        PanelSouth.add(PanelSouthButtons, BorderLayout.SOUTH);
        
        setLayout(new BorderLayout());
        add(PanelTop, BorderLayout.NORTH);
        add(PanelBody, BorderLayout.CENTER);
        add(PanelSouth, BorderLayout.SOUTH);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if(AddB.isSelected()){
            SportComB.setEnabled(false);
            AddSport.setVisible(true);
        }else if(ModB.isSelected()){
            SportComB.setEnabled(true);
            AddSport.setVisible(false);
        }
    }

    private void writeFile() {
    //++Write File++//
//    if(e.getSource() == create){
//                    String pinAdmin = JOptionPane.showInputDialog(this, "Pin");
//                    if (pinAdmin.equals("admin1234")){
//                        boolean flag = true;
//                        for(int i = 0; i<rAd.Coach.size(); i++){
//                            Admin adminA = Assignment.adminInfo.get(i);
//                            if(visitorName.equals(adminA.getAdName())){
//                                flag = false;
//                                break;
//                            }
//                        }
//                        String nextID = String.valueOf(i+1);
//                        adID = "AN"+(nextID);
//                        if (flag){
//                            Admin adminReg = new Admin(adID, visitorName,visitorUserN,visitorPass,selectedLocation, visitorGender, visitorPhone, "no");
//                            Assignment.adminInfo.add(adminReg);
//                            try{
//                                PrintWriter f = new PrintWriter("adminLogin.txt");
//                                for(i=0; i<Assignment.adminInfo.size(); i++){
//                                    Admin c = Assignment.adminInfo.get(i);
//                                    f.println(c.getAdId());
//                                    f.println(c.getAdName());
//                                    f.println(c.getAdUserN());
//                                    f.println(c.getAdPass());
//                                    f.println(c.getAdPlace());
//                                    f.println(c.getAdGender());
//                                    f.println(c.getAdPhone());
//                                    f.println(c.getSuperRole());
//                                    f.println();
//                                }
//                                f.close();
//                                this.dispose();
//                                Assignment.login.setVisible(true);
//                            } catch(Exception ex){
//                                System.out.println("Error in stop!");
//                            }
//                        } else{
//                            JOptionPane.showMessageDialog(create, "Name has been used!");
//                        }
//                    }else{
//                    JOptionPane.showMessageDialog(adminB, "Wrong Pin");
//                    }
//                }
    }
}