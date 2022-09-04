public class MaximumNumberOfWordsFoundInSentences {
    public static void main(String[] args) {
        String[] sentences = new String[] { "alice and bob love leetcode", "i think so too",
                "this is great thanks very much" };
        int res = mostWordsFound(sentences);
        System.out.println(res);
    }

    public static int mostWordsFound(String[] sentences) {
        int max = 0;
        int count = 0;

        for (String sent : sentences) {
            count = 0;
            String[] words = sent.split(" ");
            for (String s : words) {
                count++;
            }
            if (count > max) {
                max = count;
            }
        }
        return max;
    }
}
