public class main {
    public static void main(String[] args) {

        Reader reader = new Reader();
//        Writer writer = new Writer();

//        KMPAlgorithm kmp = new KMPAlgorithm();
//        BoyerMooresAlgorithm bm = new BoyerMooresAlgorithm();
        BruteForceAlgorithm bf = new BruteForceAlgorithm();
        String pattern = "000101";

        for (int i = 100; i <= 10000; i += 100) {
            String[] text = reader.ReadFiles("samples/" + i + ".txt");
            long[] performance = new long[5];
            for (int j = 0; j < 5; j++) {
                long startTime = System.nanoTime();
                int res = bf.search(pattern, text);
                long endTime = System.nanoTime();
                performance[j] += (endTime - startTime);
//                System.out.println((performance[j]));
            }
            System.out.println(i);
            Writer.writeMultiResults("BruteForce", performance, i);

            for (int j = 0; j < 5; j++) {
                long startTime = System.nanoTime();
                int res = bf.search(pattern, text);
                long endTime = System.nanoTime();
                performance[j] += (endTime - startTime);
//                System.out.println((performance[j]));
            }
            System.out.println(i);
            Writer.writeMultiResults("kmp", performance, i);
        }


    }
}
