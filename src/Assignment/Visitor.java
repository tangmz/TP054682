package Assignment;

import java.awt.Button;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;

public class Visitor extends JFrame implements ActionListener{
    private Button register;
    public Visitor(){
        setSize(300,200);
        setLocation(1000,300);
        setLayout(new FlowLayout());
        setBackground(Color.white);
        register = new Button("Register");
        register.addActionListener(this);
        add(register);
        setVisible(false);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == register){
            setVisible(false);
            Assignment.register.setVisible(true);
        }
    }
}
