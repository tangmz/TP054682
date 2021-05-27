package Assignment;

import Assignment.RegisteredAdmin.Repaint;
import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class AdminAddFunc extends JPanel implements ActionListener{
    //Variable Declaration
    private static JLabel SportSelc , SportIdL, SportNameL, CIdL, CNameL, CPhoneL, CRatePayL, CStarL, CAddressL, CJDateL, CTDateL;
    private static JTextField SportIdIn, SportNameIn, CId, CName, CPhone, CRatePay, CStar, CAddress, CJDate, CTDate;
    public static JPanel PanelTop, PanelTSelect, PanelTView, PanelTSNorth, PanelTSButton, PanelTSCenter, PanelTV1, PanelTV2, PanelTV3, PanelTV4,
            PanelBody, PanelSouth, PanelSouthButtons; 
    private static JComboBox SportComB;
    private static JRadioButton AddB, ModB;
    private static ButtonGroup AddModSelection;
    private static Button Search, AddCoach, TerminateCoach, modify;
    private static final DateTime dateTime = new DateTime();
    private static String coachId, sportId, whichOperation;
    private static boolean Found = false, Found1 = false;
    private static ArrayList <String> sportsAvailable = new ArrayList <String>();
    public AdminAddFunc(){
        
        //++Filter Sports Name Found for Specific Center Only++//
        sportsAvailable.removeAll(sportsAvailable);
        for(int i = 0; i<Assignment.sportInfo.size();i++){
            Sport_Constr sp = Assignment.sportInfo.get(i);
            if(sp.getCenter().equals(RegisteredAdmin.centerLocation)&&!sp.getSportN().equals("TERMINATED")){
                sportsAvailable.add(sp.getSportN());
            }
        }
        
        SportComB = new JComboBox(sportsAvailable.toArray());
        SportSelc = new JLabel("Sport:  ");
        SportIdL = new JLabel("Sport ID:  ");
        SportNameL = new JLabel("Sport:       ");
        SportIdIn = new JTextField(15);
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
        SportNameIn.addKeyListener(new KeyListener(){
            @Override
            public void keyTyped(KeyEvent ke) {
                char keyChar = ke.getKeyChar();
                if (Character.isLowerCase(keyChar)) {
                  ke.setKeyChar(Character.toUpperCase(keyChar));
                }
            }
            @Override
            public void keyPressed(KeyEvent ke) {}
            @Override
            public void keyReleased(KeyEvent ke) {}
        });
        //Create label to show the textfield represent as what variable
        CIdL = new JLabel("Coach ID:");
        CNameL = new JLabel("Name:");
        CPhoneL = new JLabel("Phone:");
        CRatePayL = new JLabel("Hourly Pay:");
        CStarL = new JLabel("Rating :");
        CAddressL = new JLabel("Residing City:");
        CJDateL = new JLabel("Joined Date:");
        CTDateL = new JLabel("Quit Date:");
        
        //Create new TextField
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
                  ke.consume();
               }
            }
            @Override
            public void keyPressed(KeyEvent ke) {}
            @Override
            public void keyReleased(KeyEvent ke) {}
        });
        CStar = new JTextField();
        CStar.setHorizontalAlignment(JTextField.CENTER);
        CAddress = new JTextField(15);
        CAddress.setHorizontalAlignment(JTextField.CENTER);
        CJDate = new JTextField();
        CJDate.setHorizontalAlignment(JTextField.CENTER);
        CTDate = new JTextField();
        CTDate.setHorizontalAlignment(JTextField.CENTER);
        Search = new Button("Search");

        AddCoach = new Button("Add Coach");

        AddCoach.addActionListener(this);
        TerminateCoach = new Button("Terminate Coach");
        modify = new Button("Modify");
        AddB = new JRadioButton("New Record");
        ModB = new JRadioButton("Modify Record");
        AddModSelection = new ButtonGroup();
        AddModSelection.add(AddB);
        AddModSelection.add(ModB);
        ModB.setSelected(true);
        modify.addActionListener(this);
        Search.addActionListener(this);
        AddB.addActionListener(this);
        ModB.addActionListener(this);
        TerminateCoach.addActionListener(this);
        
        //++Set Component Disabled by Default++//
        CId.setEnabled(false);
        CName.setEnabled(false);
        CStar.setEnabled(false);
        CJDate.setEnabled(false);
        CTDate.setEnabled(false);
        AddCoach.setVisible(false);
        
//        //++Retrieve Data++// ////////////////////////////Delete Later/////////////
//        retrieve r = new retrieve();
        
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
        PanelTSButton = new JPanel();
        PanelTSButton.setLayout(new FlowLayout(FlowLayout.RIGHT,5,5));
        PanelTSButton.add(Search);
        PanelTSCenter = new JPanel();
        PanelTSCenter.setLayout(new FlowLayout(FlowLayout.CENTER));
        PanelTSCenter.add(SportSelc);
        PanelTSCenter.add(SportComB);
        PanelTSelect.add(PanelTSCenter);
        PanelTSelect.add(PanelTSButton);
        
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
        PanelSouthButtons.add(modify);
        PanelSouthButtons.add(TerminateCoach);
        PanelSouthButtons.add(AddCoach);
        PanelSouth.add(PanelSouthButtons, BorderLayout.SOUTH);
        
        add(PanelTop, BorderLayout.NORTH);
        add(PanelBody, BorderLayout.CENTER);
        add(PanelSouth, BorderLayout.SOUTH);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        //To add new coach
        if(ae.getSource() == AddCoach){
            //if the whichOperation is CoachA
            whichOperation ="CoachA";
            if(!CName.getText().equals("")){
                for(int i=0; i<Assignment.sportInfo.size(); i++){
                    Sport_Constr s = Assignment.sportInfo.get(i);
                    if(s.getSportN().equals(SportNameIn.getText())&&s.getCenter().equals(RegisteredAdmin.centerLocation)){
                        Found = true;
                        break;
                    }
                }
                if (Found == true){
                    JOptionPane.showMessageDialog(AddCoach, "Sport existed!");
                }else{
                    for(int i=0; i<Assignment.coachInfo.size(); i++){
                        Coach_Constr c = Assignment.coachInfo.get(i);
                        if(c.getCoachN().equals(CName.getText())&&c.getCoachCenter().equals(RegisteredAdmin.centerLocation)){
                            Found1 = true;
                            break;
                        }
                    }
                    if(Found1==false&&Found==false){
                        writeFile writeFile = new writeFile(whichOperation);
                        JOptionPane.showMessageDialog(this, "Sport and Coach Added!");
                    }else if (Found==false &&Found1 == true){
                        JOptionPane.showMessageDialog(AddCoach, "Coach existed!");
                        Found1 = false;
                    }
                    retrieve r = new retrieve();
                    SportNameIn.setText("");
                    CName.setText("");
                    CPhone.setText("");
                    CRatePay.setText("");
                    CAddress.setText("");
                }
            }else{
                JOptionPane.showMessageDialog(this, "Please Enter All The Needed Details!");
            }
        //To modify exisiting coach info
        }else if(ae.getSource() == modify){
            whichOperation = "Modify";
            if(!CName.getText().equals("")){
                for(int i =0; i<Assignment.sportInfo.size();i++){
                    Sport_Constr sp = Assignment.sportInfo.get(i);
                    if(sp.getSprtId().equals(SportIdIn.getText())){
                        sp.setSportN(SportNameIn.getText());
                        sp.setCoachN(CName.getText());
                        Assignment.sportInfo.set(i, sp);
                        Found = true;
                        break;
                    }
                }
                for(int i = 0; i<Assignment.coachInfo.size();i++){
                    Coach_Constr c = Assignment.coachInfo.get(i);
                    if(c.getCoachN().equals(CName.getText())&&c.getCoachCenter().equals(RegisteredAdmin.centerLocation)){
                        c.setCoach_Sp_N(SportNameIn.getText());
                        c.setCoachTel(CPhone.getText());
                        c.setCoachAdd(CAddress.getText());
                        c.setCoachHRate(CRatePay.getText());
                        Assignment.coachInfo.set(i, c);
                        Found1 = true;
                        break;
                    }
                }
                if(Found == true&&Found1 == true){
                    writeFile writeFile = new writeFile(whichOperation);
                    JOptionPane.showMessageDialog(this, "Modification Successful!");
                    Found = false;
                    Found1 = false;
                }
            }else{
                JOptionPane.showMessageDialog(this, "Please Select a Sport!");
            }
        //To terminate exisitng coach from the system
        }else if(ae.getSource() == TerminateCoach){
            whichOperation = "Terminate";
            if(!CName.getText().equals("")){
                //Read the coachInfo arrayList to find if there are matched coach name and location
                for(int i=0; i<Assignment.coachInfo.size(); i++){
                    Coach_Constr c = Assignment.coachInfo.get(i);
                    if(c.getCoachN().equals(CName.getText())&&c.getCoachCenter().equals(RegisteredAdmin.centerLocation)){
                        c.setCoach_Sp_N("TERMINATED");
                        c.setCoachSp_Id("TERMINATED");
                        c.setTDate(dateTime.getPartialDate());
                        Assignment.coachInfo.set(i, c);
                        CTDate.setText(dateTime.getPartialDate());
                        System.out.println(Found);
                        Found = true;
                        break;
                    }
                }
                //Read the sportInfo arraylist to find if there is matched sportId and replace it with "Terminated" in the sport name and set the coach as "-"
                for(int i =0; i<Assignment.sportInfo.size();i++){
                    Sport_Constr sp = Assignment.sportInfo.get(i);
                    if(sp.getSprtId().equals(SportIdIn.getText())){
                        sp.setSportN("TERMINATED");
                        sp.setCoachN("-");
                        Assignment.sportInfo.set(i, sp);
                        System.out.println(Found1);
                        Found1 = true;
                        break;
                    }
                }
                //If Found and Found1 are true, then it will write into the file
                if(Found == true&&Found1==true){
                    writeFile writeFile = new writeFile(whichOperation);
                    JOptionPane.showMessageDialog(this, "Coach Termianted!");
                    Found = false;
                    Found1 = false;
                }
            //If not true, it will show a message dialog
            }else{
                JOptionPane.showMessageDialog(this, "No Coach to Terminate!");
            }
        //To search the info of the coach in sportInfo and coachInfo ArrayList
        }else if(ae.getSource() == Search){
            for(int i=0; i<Assignment.sportInfo.size(); i++){
                Sport_Constr s = Assignment.sportInfo.get(i);
                if(s.getSportN().equals(SportComB.getSelectedItem())&&s.getCenter().equals(RegisteredAdmin.centerLocation)){
                    Found = true;
                    SportNameIn.setText(s.getSportN());
                    SportIdIn.setText(s.getSprtId());
                    break;
                }
            }
            if (Found == false){
                JOptionPane.showMessageDialog(AddCoach, "No Existing Sport Record!");
            }
            else if(Found == true){
                for(int i=0; i<Assignment.coachInfo.size(); i++){
                    Coach_Constr c = Assignment.coachInfo.get(i);
                    if(c.getCoachSp_Id().equals(SportIdIn.getText())){
                        CId.setText(c.getCoachId());
                        CName.setText(c.getCoachN());
                        CPhone.setText(c.getCoachTel());
                        CRatePay.setText(c.getCoachHRate());
                        CStar.setText(c.getCoachStar());
                        CAddress.setText(c.getCoachAdd());
                        CJDate.setText(c.getJDate());
                        CTDate.setText(c.getTDate());
                        Found = false;
                        break;
                    }
                }
            }
        //RadioButton to decide add coach button
        }else if(ae.getSource() == AddB){
            Selection selection = new Selection(1);
            retrieve r = new retrieve();
            SportNameIn.setText("");
            CName.setText("");
            CName.setEnabled(true);
            CPhone.setText("");
            CRatePay.setText("");
            CStar.setText("0");
            CAddress.setText("");
            CJDate.setText(dateTime.getPartialDate());
            CTDate.setText("-");
        //Radiobutton to choose modify button
        }else if(ae.getSource() == ModB){
            Selection selection = new Selection(2);
            SportNameIn.setText("");
            SportIdIn.setText("");
            CId.setText("");
            CName.setText("");
            CName.setEnabled(false);
            CPhone.setText("");
            CRatePay.setText("");
            CStar.setText("");
            CAddress.setText("");
            CJDate.setText("");
            CTDate.setText("");
        }
        
    }
    
    //++Write File++//
    private static class writeFile {

        String SportPre = SportNameIn.getText();
        String SportNcap = SportPre.toUpperCase();
        private writeFile(String whichButton) {
            if(whichButton.equals("CoachA")){
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
                //To repaint the panel
                Repaint r = new Repaint();
             //if the whichButton is Modify, it will reset and modify the record
            }else if (whichButton.equals("Modify")){
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
                    
                    PrintWriter fw = new PrintWriter("sport.txt");
                    for (int i = 0; i<Assignment.sportInfo.size(); i++){
                        Sport_Constr c = Assignment.sportInfo.get(i);
                        fw.println(c.getSprtId());
                        fw.println(c.getSportN());
                        fw.println(c.getCenter());
                        fw.println(c.getCoachN());
                        fw.println();
                    }
                    fw.close();   
                } catch(Exception ex){
                    System.out.println("Error in stop!"); 
                }
                Repaint r = new Repaint();
            //If whichButton is "Terminate", it will replace it with "TERMINATED" and "-".Then, write into the file
            }else if (whichButton.equals("Terminate")){
                try{
                    PrintWriter f = new PrintWriter("coach.txt");
                    System.out.println("3");
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
                    PrintWriter fw = new PrintWriter("sport.txt");
                    for (int i = 0; i<Assignment.sportInfo.size(); i++){
                        Sport_Constr c = Assignment.sportInfo.get(i);
                        fw.println(c.getSprtId());
                        fw.println(c.getSportN());
                        fw.println(c.getCenter());
                        fw.println(c.getCoachN());
                        fw.println();
                    }
                    fw.close();
                  
                } catch(Exception ex){
                    System.out.println("Error in stop!"); 
                }  
                Repaint r = new Repaint();
            }
        }
    }

    private class Selection {
        //To choose which radiobutton for the mode
        private Selection(int RadioB) {
            if(RadioB == 1){
                Search.setVisible(false);
                modify.setVisible(false);
                AddCoach.setVisible(true);
                TerminateCoach.setVisible(false);
                SportComB.setEnabled(false);
                PanelSouthButtons.revalidate();
                PanelSouthButtons.repaint();
            }else if(RadioB == 2){
                Search.setVisible(true);
                modify.setVisible(true);
                TerminateCoach.setVisible(true);
                AddCoach.setVisible(false);
                SportComB.setEnabled(true);
                PanelSouthButtons.revalidate();
                PanelSouthButtons.repaint();
            }
        }
    }
    
    private class retrieve {
        //To retrieve the ID from sportInfo and assign to the coachID and sportID
        private retrieve() {
            String nextCID = "";
            int i = 0;
            i = Assignment.coachInfo.size();
            nextCID = String.valueOf(i+1);
            coachId = "CN0"+(nextCID);
            CId.setText(coachId);
            String nextID = "1";
            try{
                int x = 1;
                for(i=0; i<Assignment.sportInfo.size(); i++){
                    Sport_Constr c = Assignment.sportInfo.get(i);
                    if(c.getCenter().equals(RegisteredAdmin.centerLocation)){
                        x++;
                        nextID = String.valueOf(x);
                    }
                }
            }catch(Exception e){
                System.out.println("Error");
            }
 
            
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
