import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class RevealCardsInIncreasingOrder {
    public static void main(String[] args) {
        int[] deck = new int[] { 17, 13, 11, 2, 3, 5, 7 };
        int[] res = deckRevealedIncreasing(deck);
        for (int i : res) {
            System.out.println(i);
        }
    }

    public static int[] deckRevealedIncreasing(int[] deck) {
        Arrays.sort(deck);
        int[] result = new int[deck.length];
        Queue<Integer> queue = new LinkedList<Integer>();

        for (int i : deck) {
            queue.add(i);
        }

        for (int i : queue) {
            result[queue.poll()] = deck[i];
            queue.add(queue.poll());
        }
        return result;
    }
}
