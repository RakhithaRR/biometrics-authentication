import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class MainPage {
    public MainPage(){
        Box hbox = Box.createHorizontalBox();
        Box vbox = Box.createVerticalBox();
        JPanel panel = new JPanel();
        panel.add(vbox);

        JLabel label1 = new JLabel("Welcome to Keystroke Dynamics Authenticator");
        JLabel labe2 = new JLabel(" ");
        JButton signup = new JButton("Register");
        JButton login = new JButton("Log In");

        vbox.add(label1);
        vbox.add(labe2);
        vbox.add(hbox);
        hbox.add(signup);
        hbox.add(login);

        JFrame f = new JFrame("Biometric Authenticator");

        f.add(panel);
        f.setSize(500,150);

        f.setLocationRelativeTo(null);
        f.setVisible(true);

        signup.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                RegisterForm reg = new RegisterForm();
            }
        });

        login.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                LoginForm log = new LoginForm();
            }
        });
    }
}
