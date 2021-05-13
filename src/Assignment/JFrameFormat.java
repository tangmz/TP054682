package Assignment;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Image;
import java.awt.Label;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class JFrameFormat extends JFrame{
    
    public JPanel header, headerUser, Body;
    public Label UserLoggedIn; 
    public JLabel LogoFrame, UserFrame;
    private ImageIcon Logo, User;
    public JFrameFormat(){
        setSize(800,650);
        setLocation(800,300);
        Container mainCont = this.getContentPane();
        mainCont.setLayout(new BorderLayout(8,6));
        UserLoggedIn = new Label(":\t<USER>");
        Logo = new ImageIcon(new ImageIcon("/PicLibrary/A_Logo.png").getImage().getScaledInstance(100,38,Image.SCALE_DEFAULT));
        LogoFrame = new JLabel();
        LogoFrame.setIcon(Logo);
        User = new ImageIcon(new ImageIcon("/PicLibrary/AccountHeader.png").getImage().getScaledInstance(38,38,Image.SCALE_DEFAULT));
        UserFrame = new JLabel();
        UserFrame.setIcon(User);
        ///////////////////////////
        header = new JPanel();
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
        setVisible(false);
    }
}
