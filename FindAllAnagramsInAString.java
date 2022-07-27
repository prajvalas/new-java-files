import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Arrays;

public class FindAllAnagramsInAString {
    public static void main(String[] args) {
        String s = "cbaebabacd";// "ckaldcba";
        String p = "bca";
        List<Integer> result = findAnagrams(s, p);
        System.out.println(result);

    }

    public static List<Integer> findAnagrams(String s, String p) {
        int ns = s.length();
        int np = p.length();
        List<Integer> result = new ArrayList<>();

        if (np > ns) {
            return result;
        }

        int[] sCount = new int[26];
        int[] pCount = new int[26];

        for (int i = 0; i < np; i++) {
            pCount[p.charAt(i) - 'a']++;
        }
        int start = 0;
        for (int i = 0; i < ns; i++) {
            sCount[s.charAt(i) - 'a']++;

            if (i >= np) {
                sCount[s.charAt(i - np) - 'a']--;
                start++;
            }

            if (i >= np - 1 && Arrays.equals(sCount, pCount)) {
                result.add(start);
            }
        }

        return result;
    }

    // Time Limit Exceeded
    public static List<Integer> findAnagrams2(String s, String p) {
        // HashMap<Character, Integer> map_s = new HashMap<>();
        // HashMap<Character, Integer> map_p = new HashMap<>();
        List<Integer> answer = new ArrayList<>();
        int len_s = s.length();
        int len_p = p.length();
        if (len_p > len_s) {
            return answer;
        } else if (len_s == len_p) {
            if (isSame(getCount(s), getCount(p))) {
                answer.add(0);
                return answer;
            } else
                return answer;
        }

        for (int i = 0; i <= s.length() - len_p; i++) {
            if (isSame(getCount(s.substring(i, i + len_p)), getCount(p))) {
                answer.add(i);
            }

        }
        return answer;

    }

    public static HashMap<Character, Integer> getCount(String str) {
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < str.length(); i++) {
            map.put(str.charAt(i), map.getOrDefault(str.charAt(i), 0) + 1);
        }
        return map;
    }

    public static boolean isSame(HashMap<Character, Integer> map_s, HashMap<Character, Integer> map_p) {
        for (Character key : map_p.keySet()) {
            if (map_s.containsKey(key) && map_p.get(key) == map_s.get(key)) {
                continue;
            } else {
                return false;
            }
        }
        return true;
    }

    // Time limit exceeded
    public static List<Integer> findAnagrams1(String s, String p) {
        HashMap<Character, Integer> map = new HashMap<>();

        int count_p = 0;
        for (int i = 0; i < p.length(); i++) {
            count_p++;
            map.put(p.charAt(i), map.getOrDefault(p.charAt(i), 0) + 1);
        }

        List<Integer> result = new ArrayList<>();
        HashMap<Character, Integer> local_map = new HashMap<>();
        int count_s = 0;
        local_map.putAll(map);
        for (int start = 0, end = 0; end - start < count_p && end < s.length() && start < s.length();) {
            if (local_map.containsKey(s.charAt(end)) && local_map.get(s.charAt(end)) > 0) {
                local_map.put(s.charAt(end), local_map.get(s.charAt(end)) - 1);
                end++;
                count_s++;
            } else if (local_map.containsKey(s.charAt(end))) {
                start = start + 1;
                end = start;
                count_s = 0;
                local_map.putAll(map);

            } else {
                end++;
                start = end;
                count_s = 0;
                local_map.putAll(map);
            }
            if (count_p == count_s) {
                count_s = 0;
                result.add(start);
                start++;
                end = start;
                local_map.putAll(map);
            }
        }

        return result;
    }
}
