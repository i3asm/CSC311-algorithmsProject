public class main {

    public static void main(String[] args) {

        String pattern = "aaaaaaabbbcccjdgtukpmyxwzeqinrvou";
        Algorithms bf = new BruteForceAlgorithm();
        Algorithms kmp = new KMPAlgorithm(pattern);
        Algorithms bm = new BoyerMooreAlgorithm(pattern);

        for (int i = 100; i <= 10000; i += 100) {
            String[] text = Reader.ReadFiles("samples/" + i + ".txt");
            test(bf, "Brute force", text, pattern);
        }
        for (int i = 100; i <= 10000; i += 100) {
            String[] text = Reader.ReadFiles("samples/" + i + ".txt");
            test(kmp, "KMP", text, pattern);
        }
        for (int i = 100; i <= 10000; i += 100) {
            String[] text = Reader.ReadFiles("samples/" + i + ".txt");
            test(bm, "boyer-moore", text, pattern);
        }

        // kept for debugging
//        String[] text = reader.ReadFiles("samples/" + 9300 + ".txt");
//        System.out.println(test(bf, "Brute force", 5000, text, pattern));
//        System.out.println(test(kmp, "KMP", 5000, text, pattern));
    }

    static int test(Algorithms algorithm, String name, String[] text, String pattern) {
        int res = 0;
        long[] performance = new long[5];
        for (int i = 0; i < 5; i++) {
            long startTime = System.nanoTime();
            res = algorithm.search(pattern, text);
            long endTime = System.nanoTime();
            performance[i] += (endTime - startTime);
        }
        Writer.writeMultiResults(name, performance, text.length);
        return res;
    }
}
