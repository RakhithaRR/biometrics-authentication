
import java.awt.event.KeyEvent;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.security.Key;
import java.util.ArrayList;
import java.util.HashMap;


public class Analyser extends KeyAdapter {
    public String username;
    public String delimiter = "#";
    public int code;
    public long start;
    public long time;
    public long end;
    public boolean pressed = false;
    public ArrayList<Long> pressTimes = new ArrayList<Long>();
    public Analyser(String username){
        this.username = username;
    }

    public Analyser(){

    }

    public void keyTyped(KeyEvent e){
        if(!pressed){
            String value = String.valueOf(e.getKeyChar());
            if(value.matches("[a-zA-Z]+")){
                start = System.currentTimeMillis();
                pressed = true;
            }
        }

    }


    public void keyReleased(KeyEvent e){
        String value = String.valueOf(e.getKeyChar());
        if(value.matches("[a-zA-Z]+")){
            end = System.currentTimeMillis();
            time = end - start;
            code = e.getKeyCode();

            this.pressTimes.add(time);
            for(long i: pressTimes){
                System.out.print(i+" ");
            }
            System.out.println("Time pressed: "+time+ " milliseconds");
            pressed = false;
        }
    }

    public String saveProfile(){
        String saveString = "";

        for(Long time: this.pressTimes){
            saveString += delimiter + Long.toString(time);
        }

        return saveString;
    }

}
