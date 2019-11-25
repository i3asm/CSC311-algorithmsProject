public class BruteForceAlgorithm {
    /**
     * @return how many times the pattern found, -1 if not found
     */
    public int search (String pattern, String[] text){
        int found = 0;
        for (String line : text) {
            boolean match = false;
            for (int i = 0; i < line.length(); i++) { // loop in the text
                for (int j = 0; j < pattern.length(); j++) { // loop in the pattern, if it doesn't match the text break the loop
                    if (line.charAt(i+j) != pattern.charAt(j))
                        break;
                    else if (j == pattern.length()-1) {
                        match = true;
                        found++;
                    }
                }
            }
        }
        return found;
    }
}
