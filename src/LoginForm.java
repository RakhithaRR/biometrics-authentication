import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class LoginForm {

    public LoginForm(){
        Analyser analyser = new Analyser();
        JTextField comp = new JTextField();
        comp.addKeyListener(analyser);

        JLabel info = new JLabel("Enter the follwing text",JLabel.CENTER);
        JLabel phrase = new JLabel("The quick brown fox jumps over lazy dog",JLabel.CENTER);
        JLabel login = new JLabel("Login",JLabel.CENTER);
        JLabel user = new JLabel("Enter the username",JLabel.CENTER);

        JButton submit = new JButton("Login");

        Box box = Box.createVerticalBox();
        JPanel mainP = new JPanel();
        mainP.add(box);

        JFrame f = new JFrame("Login");

        f.add(mainP);
        box.add(info);
        box.add(phrase);
        box.add(comp);
        box.add(submit);
        //f.add(comp);
        f.setSize(400,400);
        f.setLocationRelativeTo(null);
        f.setVisible(true);

        submit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(phrase.getText().equals(comp.getText())){
                    ArrayList master = ProfileSaver.getProfiles();
                    String slave = analyser.saveProfile();
                    Examiner ex = new Examiner();
                    if(ex.match(master,slave)){
                        JOptionPane.showMessageDialog(submit,"Login Successful!");
                        f.dispose();
                    }
                    else{
                        JOptionPane.showMessageDialog(submit,"Dynamics mismatch");
                        comp.setText("");
                        comp.requestFocus();
                        analyser.clearStack();
                    }



                }
                else{
                    JOptionPane.showMessageDialog(submit,"Phrase mismach! Please try again.");
                    comp.setText("");
                    comp.requestFocus();
                }
            }
        });
    }



}
