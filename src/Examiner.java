import java.util.ArrayList;
import java.util.DoubleSummaryStatistics;

public class Examiner {
    public final double THRESHOLD = 0.65;
    public final int ERROR = 30;
    public double similarity;
    public ArrayList<Double> matchPercentages = new ArrayList<>();
    public int count = 0;


    public boolean match(ArrayList<String> master, String slave){


        ArrayList<Long> slaveTimes = new ArrayList<Long>();

        ArrayList<String> ss = new ArrayList<String>();



        String[] slavePro = slave.split("#");
        for(int i = 0; i<slavePro.length; i++){
            ss.add(slavePro[i]);
        }
        ss.remove(0);

        for(int i = 0; i<ss.size(); i++){
            slaveTimes.add(Long.parseLong(ss.get(i)));
        }

        for(String inputs: master){
            int matches = 0;
            int mismatches = 0;
            String[] masterPro;
            ArrayList<Long> masterTimes = new ArrayList<Long>();
            ArrayList<String> ms = new ArrayList<String>();

            masterPro = inputs.split("#");
            for(int i = 1; i<masterPro.length; i++){
//                System.out.print(masterPro[i] + ",");
                ms.add(masterPro[i]);
            }
//            ms.remove(0);
            for(int i = 0; i<ms.size(); i++){

                masterTimes.add(Long.parseLong(ms.get(i)));
            }
            System.out.println(masterTimes.size());
            System.out.println(slaveTimes.size());

            for(int j = 0; j<masterTimes.size();j++ ){
                long diff = Math.abs(masterTimes.get(j)-slaveTimes.get(j));
                if(diff <= ERROR){
                    matches++;
                }
                else{
                    mismatches++;
                }
            }

            similarity = ((double)matches/((double)matches + (double)mismatches));
            matchPercentages.add(similarity);
        }

        for(Double values : matchPercentages){
            System.out.printf("Similarity: %.3f\n",values);
            if(values >= THRESHOLD){
                count++;
            }
        }

        return count >= 1;

    }
}
