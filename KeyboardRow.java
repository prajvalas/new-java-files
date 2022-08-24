import java.util.HashSet;
import java.util.List;
import java.util.ArrayList;

public class KeyboardRow {
    public static void main(String[] args) {
        String[] words = new String[] { "Hello", "Alaska", "Dad", "Peace" };
        String[] result = findWords(words);
        for (String s : result) {
            System.out.println(s);
        }
    }

    public static String[] findWords(String[] words) {

        char[] first_arr = new char[] { 'q', 'w', 'e', 'r', 't', 'y', 'u', 'i', 'o', 'p', 'Q', 'W', 'E', 'R', 'T', 'Y',
                'U', 'I', 'O', 'P' };
        char[] second_arr = new char[] { 'a', 's', 'd', 'f', 'g', 'h', 'j', 'k', 'l', 'A', 'S', 'D', 'F', 'G', 'H', 'J',
                'K', 'L' };
        char[] third_arr = new char[] { 'z', 'x', 'c', 'v', 'b', 'n', 'm', 'Z', 'X', 'C', 'V', 'B', 'N', 'M' };
        HashSet<Character> first = new HashSet<>();
        for (char elem : first_arr) {
            first.add(elem);
        }
        HashSet<Character> second = new HashSet<>();
        for (char elem : second_arr) {
            second.add(elem);
        }
        HashSet<Character> third = new HashSet<>();
        for (char elem : third_arr) {
            third.add(elem);
        }
        List<String> result = new ArrayList<>();

        int count = 0;
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            System.out.println(word);
            if (first.contains(word.charAt(0))) {
                count = 1;
                for (int j = 1; j < word.length(); j++) {
                    if (first.contains(word.charAt(j))) {
                        count++;
                        continue;
                    } else {
                        break;
                    }
                }
                if (count == word.length()) {
                    result.add(word);
                }
            } else if (second.contains(word.charAt(0))) {
                count = 1;
                for (int j = 1; j < word.length(); j++) {
                    if (second.contains(word.charAt(j))) {
                        count++;
                        continue;
                    } else {
                        break;
                    }
                }
                if (count == word.length()) {
                    result.add(word);
                }
            } else {
                count = 1;
                for (int j = 1; j < word.length(); j++) {

                    if (third.contains(word.charAt(j))) {
                        count++;
                        continue;
                    } else {
                        break;
                    }
                }
                if (count == word.length()) {
                    result.add(word);
                }
            }
        }
        System.out.println(result);
        return result.toArray(new String[result.size()]);
    }

}
