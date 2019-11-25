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
			int count = 0; // count of chars written.
			try {
				String fileName = "samples/"+length+".txt"; // the name of each file, should be like: "2300.txt"
				File file = new File(fileName);
				file.createNewFile();
				PrintWriter writer = new PrintWriter(file);
				Random random = new Random();
				for (int i = 0; count < length; i++) { // create words until it reaches $(length) chars.
					char[] word = new char[random.nextInt(10) + 5]; // words of length 5 through 15.
					count++;
					for (int j = 0; j < word.length; j++) // init random small chars in the word
						word[j] = (char) (random.nextInt(26)+97);
					writer.print(new String(word) + ' '); // write the word adn a white space after it
					if (i % 8 == 0 && i>1) // after writing 8 words insert a new line.
						writer.println();
				}
				writer.close();
			} catch (IOException e) {
				System.out.println(e.getMessage());
			}
		}
	}
}
