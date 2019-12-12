public class BoyerMooresAlgorithm implements Algorithms{

	//	128 is the number of ascii code characters
	static int numberOfChars = 128;
	public static int[] badChar;

	public void BoyerMooresAlgorithm(String pattern, int[] badChar){
		badCharHeuristic(pattern, badChar)
	}

	@Override
	public int search(String pattern, String text) {
		int found = 0; // how many time the pattern found
		int m = pattern.length();
		int n = text.length();
		int s = 0; // s is shift of the pattern with respect to text

		// the main loop, will stop only if the pattern shifted to after the text
		while(s <= (n-m)){
			int j = m-1;

			/* keep reducing index j of pattern while characters of
			 * pattern and text are matching at this shift s
			 */
			while(j >= 0 && pattern.charAt(j)== text.charAt(s+j)) 
				j--;

			/* if the pattern is present at current shift, then
			 * index j will become -1 after the above loop
			 */
			if (j < 0) { 
				found++;

				/* Shift the pattern so that the next character in text aligns
				 * with the last occurrence of it in pattern. The condition s+m < n is
				 * necessary for the case when pattern occurs at the end of text
				 * without it you may get StringIndexOutOfBoundsException
				 */
				s += (s+m < n)? m-badChar[text.charAt(s+m)] : 1; 
			}
		}
		return found;
	}

	/*
	 * By running this function you will get your badchar[] filled
	 * with the last occurrence of each character, and that will help
	 * the algorithm find the last occurence wihtout searching for it
	 * each time
	 */
	public void badCharHeuristic (String pattern, int[] badChar){
		//initialize all occurrence as -1
		for (int i = 0; i < NumberOfChars; i++)
			badChar[i] = -1;
		// Fill the last occurrence of a character
		// if never occurred it will stay -1
		for (int i = 0; i < pattern.length(); i++)
			badChar[(int) pattern.charAt(i)] = i;
	}
}
