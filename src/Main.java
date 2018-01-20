import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.security.Key;

public class Main {

    public static void main(String[] args) {
//        MainPage page = new MainPage();

        if(ProfileSaver.firstTime()){
            java.awt.EventQueue.invokeLater(new Runnable() {
                @Override
                public void run() {
                    new RegisterForm();
                }
            });
        }
        else{
            java.awt.EventQueue.invokeLater(new Runnable() {
                @Override
                public void run() {
                    new LoginForm();
                }
            });
        }

    }
}