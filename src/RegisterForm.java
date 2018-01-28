import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RegisterForm {

    public RegisterForm(){
        Analyser analyser = new Analyser();
        JTextField comp = new JTextField();
//        analyser1.setTurn(1);
        comp.addKeyListener(analyser);

        Analyser analyser1 = new Analyser();
        JTextField comp1 = new JTextField();
//        analyser1.setTurn(1);
        comp1.addKeyListener(analyser1);

        Analyser analyser2 = new Analyser();
        JTextField comp2 = new JTextField();
//        analyser2.setTurn(2);
        comp2.addKeyListener(analyser2);
//
//        Analyser analyser3 = new Analyser();
//        JTextField comp3 = new JTextField();
//        analyser3.setTurn(3);
//        comp1.addKeyListener(analyser3);

        JLabel info = new JLabel("Enter the follwing text",JLabel.CENTER);
        JLabel phrase = new JLabel("The quick brown fox jumps over lazy dog",JLabel.CENTER);
        JLabel user = new JLabel("Enter the username",JLabel.CENTER);
        JLabel register = new JLabel("Sign Up",JLabel.CENTER);
        JTextField username = new JTextField();


        JButton submit = new JButton("Register");

        Box box = Box.createVerticalBox();
        JPanel mainP = new JPanel();
        mainP.setAlignmentX(Component.CENTER_ALIGNMENT);
        mainP.add(box);

        JFrame f = new JFrame("Register");
        f.setResizable(false);


        f.add(mainP);
        box.add(register);
        box.add(user);
        box.add(username);
        box.add(info);
        box.add(phrase);
        box.add(comp);
        box.add(comp1);
        box.add(comp2);
        box.add(submit);



        f.setSize(400,400);
        f.setLocationRelativeTo(null);
        f.setVisible(true);


        submit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(username.getText().trim().equals("")){
                    JOptionPane.showMessageDialog(submit,"Please enter a username.");
                }
                else if(phrase.getText().equals(comp.getText()) && phrase.getText().equals(comp1.getText()) && phrase.getText().equals(comp2.getText())){
                    ProfileSaver.saveNewProfile(analyser.saveProfile());
                    ProfileSaver.saveNewProfile(analyser1.saveProfile());
                    ProfileSaver.saveNewProfile((analyser2.saveProfile()));
                    JOptionPane.showMessageDialog(submit,"User registered successfully!");
                    f.dispose();
                    new LoginForm();


                }
                else{
                    JOptionPane.showMessageDialog(submit,"Please enter the verification phrase correctly");
                }
            }
        });
    }

}
