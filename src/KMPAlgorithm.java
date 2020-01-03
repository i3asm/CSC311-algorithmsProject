public class KMPAlgorithm implements Algorithms {

    static int[] lps;

    public KMPAlgorithm(String pattern) {
        lps = new int[pattern.length()];
        computeLPSArray(pattern, lps);
    }

    @Override
    public int search(String pattern, String[] text) {
        int result = 0;
        //had to rename it to txt because text is defined in this scope
        for (String txt : text)
            result += KMPsearch(pattern, txt);
        return result;
    }

    private int KMPsearch(String pat, String txt) {
        int found = 0;
        int m = pat.length();
        int n = txt.length();

        int j = 0; // index for pat[]
        int i = 0; // index for txt[]
        while (i < n) {
            if (pat.charAt(j) == txt.charAt(i)) {
                j++;
                i++;
            }
            if (j == m) {
                found++;
                j = lps[j - 1];
            }

            // mismatch after j matches
            else if (i < n && pat.charAt(j) != txt.charAt(i)) {
                // Do not match lps[0..lps[j-1]] characters,
                // they will match anyway
                if (j != 0)
                    j = lps[j - 1];
                else
                    i = i + 1;
            }
        }
        return found;
    }

    /*
     * The pre-processing method
     */
    private void computeLPSArray(String pat, int[] lps) {
        // length of the previous longest prefix suffix
        int len = 0;
        int i = 1;
        lps[0] = 0; // lps[0] is always 0

        // the loop calculates lps[i] for i = 1 to M-1
        while (i < pat.length()) {
            if (pat.charAt(i) == pat.charAt(len)) {
                len++;
                lps[i] = len;
                i++;
            } else {
                if (len != 0) {
                    len = lps[len - 1];

                    // Also, note that we do not increment i here
                } else {
                    lps[i] = len;
                    i++;
                }
            }
        }
    }
}
