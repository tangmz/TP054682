package Assignment;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Image;
import java.awt.Label;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

public class JFrameFormat extends JFrame{
    
    public JPanel header, headerUser, Body;
    public Label UserLoggedIn; 
    public JLabel LogoFrame, UserFrame;
    private ImageIcon Logo, User;
    public String UserName;

    public JFrameFormat(String UserName){
        this.UserName = UserName;
        setSize(900,650);
        setLocation(500,200);
        Container mainCont = this.getContentPane();
        mainCont.setLayout(new BorderLayout(8,6));
        UserLoggedIn = new Label(":\t<USER>");
        Logo = new ImageIcon(new ImageIcon(this.getClass().getResource("/PicLibrary/A_Logo.png")).getImage().getScaledInstance(150, 55, Image.SCALE_SMOOTH));
        LogoFrame = new JLabel(Logo);
        LogoFrame.setBorder(BorderFactory.createMatteBorder(0, 0, 0, 2, Color.DARK_GRAY));
        User = new ImageIcon(new ImageIcon(this.getClass().getResource("/PicLibrary/AccountHeader.png")).getImage().getScaledInstance(55,55,Image.SCALE_SMOOTH));
        UserFrame = new JLabel(User);
        UserFrame.setBorder(BorderFactory.createMatteBorder(0, 2, 0, 0, Color.DARK_GRAY));
        ///////////////////////////
        header = new JPanel();
        header.setBorder(new LineBorder(Color.DARK_GRAY, 2));
        header.setLayout(new BorderLayout());
        header.add(LogoFrame, BorderLayout.WEST);
        headerUser = new JPanel();
        headerUser.setLayout(new FlowLayout());
        headerUser.add(UserFrame);
        headerUser.add(UserLoggedIn);
        header.add(headerUser, BorderLayout.EAST);
        mainCont.add(header, BorderLayout.NORTH);
        Body = new JPanel();
        mainCont.add(Body, BorderLayout.CENTER);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(false);
        System.out.println(UserName);
        UserLoggedIn.setText(":\t"+UserName);
    }
}
