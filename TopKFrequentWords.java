import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.PriorityQueue;

public class TopKFrequentWords {
    public static void main(String[] args) {
        String[] words = new String[] { "i", "love", "leetcode", "coding", "i", "love" };
        int k = 2;
        List<String> result = topKFrequent(words, k);

        System.out.println("Result is : " + result);
    }

    public static List<String> topKFrequent(String[] words, int k) {
        List<String> result = new ArrayList<>();
        HashMap<String, Integer> map = new HashMap<>();
        // PriorityQueue<HashMap.Entry<String, Integer>> max_heap = new PriorityQueue<>(
        // (a, b) -> b.getValue() - a.getValue());
        PriorityQueue<HashMap.Entry<String, Integer>> max_heap = new PriorityQueue<>(
                (a, b) -> (a.getValue() == b.getValue() ? (a.getKey().compareToIgnoreCase(b.getKey()))
                        : b.getValue() - a.getValue()));

        for (String str : words) {
            map.put(str, map.getOrDefault(str, 0) + 1);
        }
        for (HashMap.Entry<String, Integer> elem : map.entrySet()) {
            max_heap.add(elem);
        }
        int i = 0;
        while (i < k && max_heap != null) {
            result.add(max_heap.poll().getKey());
            i++;
        }

        return result;
    }
}
