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
    private JButton register, exit, swimmingB, badmintonB, footballB, archeryB, gymnasticB, volleyballB, basketballB, cricketB, tennisB, tableTennisB;
    public JPanel header, headerUser, Body, view;
    public Label UserLoggedIn, viewL, welcome; 
    public JLabel LogoFrame, UserFrame;
    private ImageIcon Logo, User, exitLogo, viewLogo, registerLogo, swimming, badminton, football, archery, gymnastic, volleyball, basketball, cricket, tennis, tableTennis;
    public String userName;
    private java.util.Date date = new java.util.Date();
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
        swimming = new ImageIcon(new ImageIcon(this.getClass().getResource("/PicLibrary/swimming.png")).getImage().getScaledInstance(150, 55, Image.SCALE_SMOOTH));
        swimmingB = new JButton(swimming);
        swimmingB.setBackground(Color.WHITE);
        badminton = new ImageIcon(new ImageIcon(this.getClass().getResource("/PicLibrary/badminton.png")).getImage().getScaledInstance(150, 55, Image.SCALE_SMOOTH));
        badmintonB = new JButton(badminton);
        badmintonB.setBackground(Color.WHITE);
        football = new ImageIcon(new ImageIcon(this.getClass().getResource("/PicLibrary/football.png")).getImage().getScaledInstance(150, 55, Image.SCALE_SMOOTH));
        footballB = new JButton(football);
        footballB.setBackground(Color.WHITE);
        archery = new ImageIcon(new ImageIcon(this.getClass().getResource("/PicLibrary/archery.png")).getImage().getScaledInstance(150, 55, Image.SCALE_SMOOTH));
        archeryB = new JButton(archery);
        archeryB.setBackground(Color.WHITE);
        gymnastic = new ImageIcon(new ImageIcon(this.getClass().getResource("/PicLibrary/gymnastic.png")).getImage().getScaledInstance(150, 55, Image.SCALE_SMOOTH));
        gymnasticB = new JButton(gymnastic);
        gymnasticB.setBackground(Color.WHITE);
        volleyball = new ImageIcon(new ImageIcon(this.getClass().getResource("/PicLibrary/volleyball.png")).getImage().getScaledInstance(150, 55, Image.SCALE_SMOOTH));
        volleyballB = new JButton(volleyball);
        volleyballB.setBackground(Color.WHITE);
        basketball = new ImageIcon(new ImageIcon(this.getClass().getResource("/PicLibrary/basketball.png")).getImage().getScaledInstance(150, 55, Image.SCALE_SMOOTH));
        basketballB = new JButton(basketball);
        basketballB.setBackground(Color.WHITE);
        cricket = new ImageIcon(new ImageIcon(this.getClass().getResource("/PicLibrary/cricket.png")).getImage().getScaledInstance(150, 55, Image.SCALE_SMOOTH));
        cricketB = new JButton(cricket);
        cricketB.setBackground(Color.WHITE);
        tennis = new ImageIcon(new ImageIcon(this.getClass().getResource("/PicLibrary/tennis.png")).getImage().getScaledInstance(150, 55, Image.SCALE_SMOOTH));
        tennisB = new JButton(tennis);
        tennisB.setBackground(Color.WHITE);
        tableTennis = new ImageIcon(new ImageIcon(this.getClass().getResource("/PicLibrary/tableTennis.png")).getImage().getScaledInstance(150, 55, Image.SCALE_SMOOTH));
        tableTennisB = new JButton(tableTennis);
        tableTennisB.setBackground(Color.WHITE);
        registerLogo = new ImageIcon(new ImageIcon(this.getClass().getResource("/PicLibrary/sign up.png")).getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH));
        register = new JButton("Register",registerLogo);
        register.setFont(new Font("Arial", Font.BOLD, 20));
        register.setBackground(Color.LIGHT_GRAY);
        exitLogo = new ImageIcon(new ImageIcon(this.getClass().getResource("/PicLibrary/logout.png")).getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH));
        exit = new JButton ("Exit",exitLogo);
        exit.setFont(new Font("Arial", Font.BOLD, 20));
        exit.setBackground(Color.LIGHT_GRAY);
        welcome = new Label("Welcome To Real Champion Sport Academy", Label.CENTER);
        welcome.setFont(new Font("Arial", Font.BOLD, 20));
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
        view = new JPanel();

        view.setLayout(new GridLayout(2,5));
        view.add(swimmingB);
        view.add(badmintonB);
        view.add(footballB);
        view.add(archeryB);
        view.add(gymnasticB);
        view.add(volleyballB);
        view.add(basketballB);
        view.add(cricketB);
        view.add(tennisB);
        view.add(tableTennisB);
        mainCont.add(view, BorderLayout.CENTER);
        Body = new JPanel();
        Body.setLayout(new FlowLayout());
        Body.add(register);
        Body.add(exit);
        mainCont.add(Body, BorderLayout.SOUTH);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(false);
        System.out.println(userName);
        UserLoggedIn.setText(":\t"+userName);
//        register = new Button("Register");
//        exit = new Button("Exit");
        register.addActionListener(this);
        exit.addActionListener(this);
//        setVisible(false);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource() == swimmingB){
            
        }else if(ae.getSource() == badmintonB){
            
        }else if(ae.getSource() == footballB){
            
        }else if(ae.getSource() == archeryB){
            
        }else if(ae.getSource() == gymnasticB){
            
        }else if(ae.getSource() == volleyballB){
            
        }else if(ae.getSource() == basketballB){
            
        }else if(ae.getSource() == cricketB){
            
        }else if(ae.getSource() == tennisB){
            
        }else if(ae.getSource() == tableTennisB){
            
        }else if(ae.getSource() == register){
            setVisible(false);
            
        }else if (ae.getSource() == register){
            setVisible(false);
            Assignment.register.setVisible(true);
        }else if(ae.getSource() == exit){
            this.dispose();
            Assignment.login.setVisible(true);
        }
    }
}
