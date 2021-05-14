package Assignment;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Label;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

public class Visitor extends JFrame implements ActionListener{
    private JButton register, exit, view;
    public JPanel header, headerUser, Body, labelDecision;
    public Label UserLoggedIn, registerL, exitL, viewL, welcome; 
    public JLabel LogoFrame, UserFrame;
    private ImageIcon Logo, User, exitLogo, viewLogo, registerLogo;
    public String userName;
    public Visitor(){
        userName = "Visitor";
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
        viewLogo = new ImageIcon(new ImageIcon(this.getClass().getResource("/PicLibrary/view.png")).getImage().getScaledInstance(150, 55, Image.SCALE_SMOOTH));
        view = new JButton(viewLogo);
        view.setBackground(Color.LIGHT_GRAY);
        registerLogo = new ImageIcon(new ImageIcon(this.getClass().getResource("/PicLibrary/sign up.png")).getImage().getScaledInstance(150, 55, Image.SCALE_SMOOTH));
        register = new JButton(registerLogo);
        register.setBackground(Color.LIGHT_GRAY);
        exitLogo = new ImageIcon(new ImageIcon(this.getClass().getResource("/PicLibrary/logout.png")).getImage().getScaledInstance(150, 55, Image.SCALE_SMOOTH));
        exit = new JButton (exitLogo);
        exit.setBackground(Color.LIGHT_GRAY);
        welcome = new Label("Welcome To Real Champion Sport Academy", Label.CENTER);
        welcome.setFont(new Font("Verdana", Font.BOLD, 20));
        UserFrame.setBorder(BorderFactory.createMatteBorder(0, 2, 0, 0, Color.DARK_GRAY));
        ///////////////////////////
        header = new JPanel();
        header.setBorder(new LineBorder(Color.DARK_GRAY, 2));
        header.setLayout(new BorderLayout());
        header.add(LogoFrame, BorderLayout.WEST);
        header.add(welcome, BorderLayout.CENTER);
        headerUser = new JPanel();
        headerUser.setLayout(new FlowLayout());
        headerUser.add(UserFrame);
        headerUser.add(UserLoggedIn);
        header.add(headerUser, BorderLayout.EAST);
        mainCont.add(header, BorderLayout.NORTH);
        Body = new JPanel();
        viewL = new Label("View", Label.CENTER);
        registerL = new Label("Register", Label.CENTER);
        exitL = new Label("Exit", Label.CENTER);
        viewL.setFont(new Font("Verdana", Font.BOLD, 50));
        registerL.setFont(new Font("Verdana", Font.BOLD, 50));
        exitL.setFont(new Font("Verdana", Font.BOLD, 50));
        Body.setLayout(new GridLayout(2,3));
        Body.setBackground(Color.WHITE);
        Body.add(viewL);
        Body.add(registerL);
        Body.add(exitL);
        Body.add(view);
        Body.add(register);
        Body.add(exit);
        mainCont.add(Body, BorderLayout.CENTER);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(false);
        System.out.println(userName);
        UserLoggedIn.setText(":\t"+userName);
//        register = new Button("Register");
//        exit = new Button("Exit");
        view.addActionListener(this);
        register.addActionListener(this);
        exit.addActionListener(this);
//        setVisible(false);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource() == register){
            setVisible(false);
            
        }
        if (ae.getSource() == register){
            setVisible(false);
            Assignment.register.setVisible(true);
        }
        if(ae.getSource() == exit){
            this.dispose();
            Assignment.login.setVisible(true);
        }
    }
}
