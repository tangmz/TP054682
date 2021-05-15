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

public class Visitor implements ActionListener{
    private JButton register, exit, swimmingB, badmintonB, footballB, archeryB, gymnasticB, volleyballB, basketballB, cricketB, tennisB, tableTennisB;
    public JPanel view, Footer; 
    public JLabel welcome;
    private ImageIcon exitLogo, viewLogo, registerLogo, swimming, badminton, football, archery, gymnastic, volleyball, basketball, cricket, tennis, tableTennis;
    private java.util.Date date = new java.util.Date();
    JFrameFormat frame = new JFrameFormat("Visitor");
    public void Visitor(){
        swimming = new ImageIcon(new ImageIcon(this.getClass().getResource("/PicLibrary/swimming.png")).getImage().getScaledInstance(150, 150, Image.SCALE_SMOOTH));
        swimmingB = new JButton(swimming);
        swimmingB.setBackground(Color.WHITE);
        badminton = new ImageIcon(new ImageIcon(this.getClass().getResource("/PicLibrary/badminton.png")).getImage().getScaledInstance(150, 150, Image.SCALE_SMOOTH));
        badmintonB = new JButton(badminton);
        badmintonB.setBackground(Color.WHITE);
        football = new ImageIcon(new ImageIcon(this.getClass().getResource("/PicLibrary/football.png")).getImage().getScaledInstance(150, 150, Image.SCALE_SMOOTH));
        footballB = new JButton(football);
        footballB.setBackground(Color.WHITE);
        archery = new ImageIcon(new ImageIcon(this.getClass().getResource("/PicLibrary/archery.png")).getImage().getScaledInstance(150, 150, Image.SCALE_SMOOTH));
        archeryB = new JButton(archery);
        archeryB.setBackground(Color.WHITE);
        gymnastic = new ImageIcon(new ImageIcon(this.getClass().getResource("/PicLibrary/gymnastic.png")).getImage().getScaledInstance(150, 150, Image.SCALE_SMOOTH));
        gymnasticB = new JButton(gymnastic);
        gymnasticB.setBackground(Color.WHITE);
        volleyball = new ImageIcon(new ImageIcon(this.getClass().getResource("/PicLibrary/volleyball.png")).getImage().getScaledInstance(150, 150, Image.SCALE_SMOOTH));
        volleyballB = new JButton(volleyball);
        volleyballB.setBackground(Color.WHITE);
        basketball = new ImageIcon(new ImageIcon(this.getClass().getResource("/PicLibrary/basketball.png")).getImage().getScaledInstance(150, 150, Image.SCALE_SMOOTH));
        basketballB = new JButton(basketball);
        basketballB.setBackground(Color.WHITE);
        cricket = new ImageIcon(new ImageIcon(this.getClass().getResource("/PicLibrary/cricket.png")).getImage().getScaledInstance(150, 150, Image.SCALE_SMOOTH));
        cricketB = new JButton(cricket);
        cricketB.setBackground(Color.WHITE);
        tennis = new ImageIcon(new ImageIcon(this.getClass().getResource("/PicLibrary/tennis.png")).getImage().getScaledInstance(150, 150, Image.SCALE_SMOOTH));
        tennisB = new JButton(tennis);
        tennisB.setBackground(Color.WHITE);
        tableTennis = new ImageIcon(new ImageIcon(this.getClass().getResource("/PicLibrary/tableTennis.png")).getImage().getScaledInstance(150, 150, Image.SCALE_SMOOTH));
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
        frame.welcome.setText("Welcome To Real Champion Sport Academy");
        frame.setSize(950,600);
        
        view = new JPanel();
        view.setLayout(new GridLayout(2,5));
        view.setBorder(BorderFactory.createTitledBorder("Sports: "));
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
        frame.Body.add(view, BorderLayout.CENTER);
        Footer = new JPanel();
        Footer.setLayout(new FlowLayout());
        Footer.add(register);
        Footer.add(exit);
        frame.Body.add(Footer, BorderLayout.SOUTH);
        frame.setVisible(true);
//        register = new Button("Register");
//        exit = new Button("Exit");
        register.addActionListener((ActionListener) this);
        exit.addActionListener((ActionListener) this);
        swimmingB.addActionListener((ActionListener) this);
        badmintonB.addActionListener((ActionListener) this);
        footballB.addActionListener((ActionListener) this);
        archeryB.addActionListener((ActionListener) this);
        gymnasticB.addActionListener((ActionListener) this);
        volleyballB.addActionListener((ActionListener) this);
        basketballB.addActionListener((ActionListener) this);
        cricketB.addActionListener((ActionListener) this);
        tennisB.addActionListener((ActionListener) this);
        tableTennisB.addActionListener((ActionListener) this);
//        setVisible(false);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource() == swimmingB){
            frame.Body.removeAll();
            frame.dispose();
            Assignment.login.setVisible(true);
        }else if(ae.getSource() == badmintonB){
            frame.Body.removeAll();
            frame.dispose();
            Assignment.register.setVisible(true);
        }else if(ae.getSource() == footballB){
            
        }else if(ae.getSource() == archeryB){
            
        }else if(ae.getSource() == gymnasticB){
            
        }else if(ae.getSource() == volleyballB){
            
        }else if(ae.getSource() == basketballB){
            
        }else if(ae.getSource() == cricketB){
            
        }else if(ae.getSource() == tennisB){
            
        }else if(ae.getSource() == tableTennisB){
            
        }else if (ae.getSource() == register){
            frame.Body.removeAll();
            frame.dispose();
            Assignment.register.setVisible(true);
        }else if(ae.getSource() == exit){
            frame.Body.removeAll();
            frame.dispose();
            Assignment.login.setVisible(true);
        }
    }
}
