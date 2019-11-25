import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;

public class Reader {

    public String[] ReadFiles(String fileName) {
        LinkedList<String> lines = new LinkedList<>();
        String line;
        try {
            BufferedReader reader = new BufferedReader(new FileReader(fileName));
            while ((line = reader.readLine()) != null)
                lines.add(line);
        } catch (IOException e) {
            e.printStackTrace();
        }

        // convert the linkedList to array, the .toArray() didn't work
        String[] output = new String[lines.size()];
        for (int i = 0; i < lines.size(); i++){
            output[i] = (String) lines.get(i);
        }

        return output;
    }
}
