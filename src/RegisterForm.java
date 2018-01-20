import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RegisterForm {

    public RegisterForm(){
        Analyser analyser = new Analyser();
        JTextField comp = new JTextField();
        comp.addKeyListener(analyser);

        JLabel info = new JLabel("Enter the follwing text",JLabel.CENTER);
        JLabel phrase = new JLabel("Hello World",JLabel.CENTER);
        JLabel user = new JLabel("Enter the username",JLabel.CENTER);
        JLabel regiter = new JLabel("Sign Up",JLabel.CENTER);
        JTextField username = new JTextField();

        JButton submit = new JButton("Register");

        Box box = Box.createVerticalBox();
        JPanel mainP = new JPanel();
        mainP.add(box);

        JFrame f = new JFrame("Register");


        f.add(mainP);
        box.add(regiter);
        box.add(user);
        box.add(username);
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
                if(username.getText().trim().equals("")){
                    JOptionPane.showMessageDialog(submit,"Please enter a username.");
                }
                else if(phrase.getText().equals(comp.getText())){
                    ProfileSaver.saveNewProfile(analyser.saveProfile());
                    JOptionPane.showMessageDialog(submit,"User registered successfully!");
                    f.dispose();


                }
                else{
                    JOptionPane.showMessageDialog(submit,"Please enter the verification phrase correctly");
                }
            }
        });
    }

}
