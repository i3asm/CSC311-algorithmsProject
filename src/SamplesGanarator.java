import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;

public class SamplesGanarator {
	/*
	 * This code was originally copy-pasted from
	 * https://stackoverflow.com/questions/44338541/create-a-random-txt-file-of-approximate-size-in-java
	 * use it to make a random text files to apply your algorithms.
	 */
	public static void start(String[] args) {

		for (int length=100; length<=10000; length += 100){ // loop for writing files of length [100, 200, 300,...,1000]
			try {
				String fileName = "samples/"+length+".txt"; // the name of each file, should be like: "2300.txt"
				File file = new File(fileName);
				file.createNewFile();
				PrintWriter writer = new PrintWriter(file);
				Random random = new Random();
                for (int i = 0; i < length; i++) { // create lines until it reaches $(length) lines
                    char[] line = new char[128]; // each line is 128 bit
					for (int j = 0; j < line.length; j++) // init random small chars in the word
						line[j] = (char)(random.nextInt(2)+48);
					writer.print(new String(line)); // write the line and cast it to String
					 	writer.println();
				}
				writer.close();
			} catch (IOException e) {
				System.out.println(e.getMessage());
			}
		}
	}
}
