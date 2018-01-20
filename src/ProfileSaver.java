import java.io.*;
import java.util.ArrayList;


public class ProfileSaver {
    static String database = "profiles.dat";

    public static void saveNewProfile(String value){
        try{
            FileWriter fw = new FileWriter(database,true);
            BufferedWriter bw = new BufferedWriter(fw);

            bw.write(value);
            bw.newLine();
            bw.close();
            fw.close();
            System.out.println("Profile saved!");

        }catch (IOException e){
            System.out.println("Error saving to database");
        }
    }

    public static String getProfiles(){
//        ArrayList profiles = new ArrayList();
        String profile = "";
        String value;

        try{
            FileReader fr = new FileReader(database);
            BufferedReader br = new BufferedReader(fr);

//            while((value = br.readLine()).trim() != ""){
//                profiles.add(value);
//            }
            profile = br.readLine().trim();

            br.close();
            fr.close();
            System.out.println("Connected to the database");

        }catch (IOException e){
            System.out.println("Error connecting to the database");
        }

        return profile;
    }

    public static boolean firstTime(){
        File f = new File("profiles.dat");
        return !(f.exists() && !f.isDirectory());
    }
}
