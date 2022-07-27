import java.util.HashMap;

public class LongestRepeatingCharacterReplacement {
    public static void main(String[] args) {
        String s = "ABCABCAA";
        int k = 2;
        System.out.println("Result is : " + characterReplacement(s, k));
    }

    public static int characterReplacement(String s, int k) {
        boolean flag = true;
        HashMap<Character, Integer> map = new HashMap<>();
        int count = 0;
        int max_frequency = 0;
        int max = 0;
        for (int start = 0, end = 0; end < s.length();) {
            if (flag) {
                flag = false;
                map.put(s.charAt(end), map.getOrDefault(s.charAt(end), 0) + 1);
            }
            for (Character key : map.keySet()) {
                if (map.get(key) > max_frequency) {
                    max_frequency = map.get(key);
                }
            }
            if (end - start - max_frequency < k) {
                end++;
                count++;
                if (max < count) {
                    max = count;
                }
                flag = true;
            } else {
                map.put(s.charAt(start), map.get(s.charAt(start)) - 1);
                start++;
                count--;
            }
        }
        return max;
    }
}
