package Assignment;

import java.awt.Button;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class RegisteredAdmin{
    
    private JPanel header, menuBody, menuTop, menuR1, menuR2;
    private String User;
    private Button logout;
    
    public void FrameLoad(String UserName){
        JFrameFormat frame = new JFrameFormat(UserName);
        frame.setVisible(true);
        logout = new Button("Logout");
        logout.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                frame.dispose();
                Assignment.login.setVisible(true);
            }
        });
        frame.Body.add(logout);
    }
//    @Override
//    public void actionPerformed(ActionEvent ae) {
//        
//    }
}
