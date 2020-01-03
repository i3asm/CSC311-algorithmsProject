public class BoyerMooreAlgorithm implements Algorithms{

	//	128 is the number of ascii code characters
	static int numberOfChars = 128;
	private static int[] badChar;

	// this constructor is for the pre-processing of this algorithm.
	public BoyerMooreAlgorithm(String pattern){
		badCharHeuristic(pattern);
	}

	// this method search in every String int text[]
	// then combine the results
	@Override
	public int search(String pattern, String[] text) {
		int result = 0;
		//had to rename it to txt because text is defined in this scope
		for (String txt : text)
			result += BMsearch(pattern, txt);
		return result;
	}

	private int BMsearch(String pattern, String text) {
		int found = 0; // how many time the pattern found
		int m = pattern.length();
		int n = text.length();
		int s = 0; // s is shift of the pattern with respect to text

		// the main loop, will stop only if the pattern shifted to after the text
		while(s <= (n-m)){
			int j = m-1;
			// text=ABABAB pattern=ab:
			//      ----ab , 4 shifts

			/* keep reducing index j of pattern while characters of
			 * pattern and text are matching at this shift s
			 */
			while(j >= 0 && pattern.charAt(j) == text.charAt(s+j)) 
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
			}else{
				/* Shift the pattern so that the bad character in text aligns with
				 * the last occurrence of it in pattern. The Max function is used to
				 * make sure that we get a positive shift.
				 * We may get a negative shift if the last occurrence of bad character
				 * in pattern is on the right side of the current character.
				 */ 
				s += Math.max(1, j - badChar[text.charAt((int)s+j)]);
			}
		}
		return found;
	}

	/* The pre-processing for boyer-moorse algorithm.
	 * By running this function you will get your badchar[] filled
	 * with the last occurrence of each character, and that will help
	 * the algorithm find the last occurence wihtout searching for it
	 * each time
	 * So to make that happen we should do it one time only, at the constructor
	 * and store the result, of course you we can call this method again
	 * if we change the pattern in running time.
	 */
	private void badCharHeuristic(String pattern){
		badChar = new int[numberOfChars];
		//initialize all occurrence as -1
		for (int i = 0; i < badChar.length; i++)
			badChar[i] = -1;
		// Fill the last occurrence of a character
		// if never occurred it will stay -1
		for (int i = 0; i < pattern.length(); i++)
			badChar[(int) pattern.charAt(i)] = i;
	}

}
