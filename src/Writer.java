import java.io.FileWriter;
import java.io.IOException;

public class Writer {
    /*
     *  each algorithm will send it's results to this method to write it in a .csv file
     *  the results will be visualized in graphs by using excel's built-in tools
     */
    public static boolean writeResult (String algorithm, double time, int size){
        try {
            FileWriter writer = new FileWriter("results.csv", true);
            String result = algorithm + ", " + time + ", " + size;
            writer.write(result + "\n");
            writer.close();
        }catch (IOException e) {
            System.out.println(e.getMessage());
            return false;
        }
        return true;
    }
    public static boolean writeMultiResults (String algorithm, long[] times, int size){
        try {
            FileWriter writer = new FileWriter("results.csv", true);
            String result = algorithm + ", " + size;
            for (double time : times)
                result += ", " + time;
            writer.write(result + "\n");
            writer.close();
        }catch (IOException e) {
            System.out.println(e.getMessage());
            return false;
        }
        return true;
    }
}