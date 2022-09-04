import java.util.HashMap;
import java.util.List;

// INCOMPLETE SOLUTION
public class FindAndReplacePattern {
    public static void main(String[] args) {
        String[] words = new String[] { "abc", "deq", "mee", "aqq", "dkd", "ccc" };
        String pattern = "abb";
        List<String> res = findAndReplacePattern(words, pattern);
        System.out.println(res);
    }

    public static List<String> findAndReplacePattern(String[] words, String pattern) {
        String pattern_count = "";
        int counter = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < pattern.length(); i++) {
            Character c = pattern.charAt(i);
            if (map.containsKey(c)) {
                int num = map.get(c);
                pattern_count += String.valueOf(num);
            } else {
                map.put(c, counter);
                pattern_count += String.valueOf(counter);
                counter++;
            }
        }
        System.out.println(map);
        System.out.println(pattern_count);

        // for (String s : words) {
        // for (int i = 0; i < s.length(); i++) {

        // }
        // }

        return null;
    }
}
