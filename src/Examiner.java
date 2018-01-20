import java.util.ArrayList;

public class Examiner {
    public final double TOLERANCE = 0.7;
    public final int ERROR = 25;
    String username;

    public boolean match(String master, String slave){
        int matches = 0;
        int mismatches = 0;
        ArrayList<Long> masterTimes = new ArrayList<Long>();
        ArrayList<Long> slaveTimes = new ArrayList<Long>();

        ArrayList<String> ms = new ArrayList<String>();
        ArrayList<String> ss = new ArrayList<String>();

        String[] masterPro = master.split("#");
        String[] slavePro = slave.split("#");

        for(int i = 0; i<masterPro.length; i++){
            ms.add(masterPro[i]);
        }
        ms.remove(0);

        for(int i = 0; i<slavePro.length; i++){
            ss.add(slavePro[i]);
        }
        ss.remove(0);
//        username = masterPro[0];
        for(int i = 0; i<ms.size(); i++){
            masterTimes.add(Long.parseLong(ms.get(i)));
        }

        for(int i = 0; i<ss.size(); i++){
            slaveTimes.add(Long.parseLong(ss.get(i)));
        }

        for(int j = 0; j<masterTimes.size();j++ ){
            long diff = Math.abs(masterTimes.get(j)-slaveTimes.get(j));
            if(diff <= ERROR){
                matches++;
            }
            else{
                mismatches++;
            }
        }

        double similarity = ((double)matches/((double)matches + (double)mismatches));
        System.out.printf("Similarity: %.2f",similarity);
        return similarity >= TOLERANCE;

    }
}
