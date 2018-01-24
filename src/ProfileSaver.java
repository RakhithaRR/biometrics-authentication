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

    public static ArrayList<String> getProfiles(){
//        ArrayList profiles = new ArrayList();
        ArrayList<String> dataSet = new ArrayList<>();
//        String profile = "";
        String value = "";

        try{
            FileReader fr = new FileReader(database);
            BufferedReader br = new BufferedReader(fr);

            for(int i=0;i<3;i++){
                value = br.readLine().trim();
//                System.out.println(value);
                dataSet.add(value);
            }
//            profile = br.readLine().trim();

            br.close();
            fr.close();
            System.out.println("Connected to the database");

        }catch (IOException e){
            System.out.println("Error connecting to the database");
        }

        return dataSet;
    }

    public static boolean firstTime(){
        File f = new File("profiles.dat");
        return !(f.exists() && !f.isDirectory());
    }
}
