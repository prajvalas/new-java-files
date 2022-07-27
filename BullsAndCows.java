import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class BullsAndCows {
    public static void main(String[] args) {
        String secret = "1807";
        String guess = "7810";
        System.out.println("Result is : " + getHint(secret, guess));
    }

    public static String getHint(String secret, String guess) {
        HashMap<Character, Integer> map = new HashMap<>();
        int count_bulls = 0;
        int count_cows = 0;

        for (int i = 0; i < secret.length(); i++) {
            if (secret.charAt(i) == guess.charAt(i)) {
                count_bulls++;
            } else {
                map.put(secret.charAt(i), map.getOrDefault(secret.charAt(i), 0) + 1);
            }
        }

        for (int i = 0; i < guess.length(); i++) {
            if (guess.charAt(i) != secret.charAt(i) && map.containsKey(guess.charAt(i))
                    && map.get(guess.charAt(i)) > 0) {
                count_cows++;
                map.put(guess.charAt(i), map.get(guess.charAt(i)) - 1);
            }
        }

        return count_bulls + "A" + count_cows + "B";

    }

    // Not very efficient
    public static String getHint1(String secret, String guess) {
        int count_bulls = 0;
        int count_cows = 0;
        List<Character> bulls = new ArrayList<>();
        List<Character> cows = new ArrayList<>();
        for (int i = 0; i < secret.length(); i++) {
            if (secret.charAt(i) == guess.charAt(i)) {
                count_bulls++;
            } else {
                bulls.add(secret.charAt(i));
                cows.add(guess.charAt(i));
            }
        }

        for (Character c : bulls) {
            if (cows.contains(c)) {
                count_cows++;
                cows.remove(c);
            }
        }

        return count_bulls + "A" + count_cows + "B";
    }
}
