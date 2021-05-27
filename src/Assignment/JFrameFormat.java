package Assignment;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Image;
import java.awt.Label;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

public class JFrameFormat extends JFrame{
    //Variable Declaration
    public JPanel header, headerUser, Body;
    public Label UserLoggedIn; 
    public JLabel welcome, LogoFrame, UserFrame;
    private ImageIcon Logo, User;
    public String UserName;
    public JComboBox CenLocation;
    //Basic format of the panel
    public JFrameFormat(String UserName){
        //Declaration of variable
        this.UserName = UserName;
        //Set the default panel size, location and design
        setSize(1150,650);
        setLocation(450,200);
        Container mainCont = this.getContentPane();
        mainCont.setLayout(new BorderLayout(8,6));
        //Labels are created
        welcome = new JLabel("", JLabel.CENTER);
        welcome.setFont(new Font("Arial", Font.BOLD, 26));
        UserLoggedIn = new Label(":\t<USER>");
        Logo = new ImageIcon(new ImageIcon(this.getClass().getResource("/PicLibrary/A_Logo.png")).getImage().getScaledInstance(150, 55, Image.SCALE_SMOOTH));
        LogoFrame = new JLabel(Logo);
        LogoFrame.setBorder(BorderFactory.createMatteBorder(0, 0, 0, 2, Color.DARK_GRAY));
        User = new ImageIcon(new ImageIcon(this.getClass().getResource("/PicLibrary/AccountHeader.png")).getImage().getScaledInstance(35,35,Image.SCALE_SMOOTH));
        UserFrame = new JLabel(User);
        UserFrame.setBorder(BorderFactory.createMatteBorder(0, 2, 0, 0, Color.DARK_GRAY));
        //JComboBox is created for the location
        CenLocation = new JComboBox(Location.values());
        CenLocation.setSelectedIndex(-1);
        //Design Panel 
        header = new JPanel();
        header.setBorder(new LineBorder(Color.DARK_GRAY, 2));
        header.setLayout(new BorderLayout());
        header.add(LogoFrame, BorderLayout.WEST);
        header.add(welcome, BorderLayout.CENTER);
        headerUser = new JPanel();
        headerUser.setLayout(new FlowLayout());
        headerUser.add(UserFrame);
        headerUser.add(UserLoggedIn);
        headerUser.add(CenLocation);
        header.add(headerUser, BorderLayout.EAST);
        mainCont.add(header, BorderLayout.NORTH);
        Body = new JPanel();
        Body.setLayout(new BorderLayout());
        mainCont.add(Body, BorderLayout.CENTER);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(false);
        setResizable(false);
        UserLoggedIn.setText(":\t"+UserName);
    }
}
