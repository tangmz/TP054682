package Assignment;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;

public class RegisteredStudent extends JFrame implements ActionListener{
    private JButton view, modify, feedback, exit;
    Image newImage = new ImageIcon(this.getClass().getResource("/PicLibrary/badminton.png")).getImage().getScaledInstance(200, 200, Image.SCALE_SMOOTH);
    Icon image1 = new ImageIcon(newImage);
    
    public RegisteredStudent(){
        setSize(300,200);
        setLocation(1000,300);
        setLayout(new FlowLayout());
        setBackground(Color.white);
        view = new JButton(image1);
        add(view);
        setVisible(false);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
     
    }
    
}
