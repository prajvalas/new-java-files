import java.util.List;
import java.util.ArrayList;
import java.util.HashSet;

public class WordBreak {
    public static void main(String[] args) {
        String s = "catsandog"; // "applepenapple";// "leetcode";
        List<String> wordDict = new ArrayList<>();
        // wordDict.add("leet");
        // wordDict.add("code");
        // wordDict.add("apple");
        // wordDict.add("pen");
        wordDict.add("cats");
        wordDict.add("dog");
        wordDict.add("and");
        wordDict.add("sand");
        wordDict.add("cat");

        System.out.println("Result is : " + wordBreak(s, wordDict));
    }

    public static boolean wordBreak(String s, List<String> wordDict) {

        HashSet<String> set = new HashSet<>();
        int count;
        int count_duplicate = 0;
        for (String word : wordDict) {
            if (word.charAt(0) == s.charAt(0)) {
                int word_len = word.length();
                count = 0;
                for (int i = 0; i < word_len; i++) {
                    if (s.charAt(i) == word.charAt(i)) {
                        count++;
                    }
                }
                if (count == word_len) {
                    set.add(word);
                    s = s.substring(word_len);
                } else if (count == 0 && set.contains(word)) {
                    count_duplicate++;
                }

            }
        }
        if (set.size() == wordDict.size() - count_duplicate && s.length() == 0) {
            return true;
        } else if (s.length() != 0 && set.contains(s)) {
            return true;
        }
        return false;
    }
}
