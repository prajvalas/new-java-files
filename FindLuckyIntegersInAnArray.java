import java.util.HashMap;

public class FindLuckyIntegersInAnArray {
    public static void main(String[] args) {
        int[] arr = new int[] { 2, 2, 3, 4, 4, 4, 4 };
        System.out.println("Lucky integer is : " + findLucky(arr));
    }

    public static int findLucky(int[] arr) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i : arr) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        int max = -1;
        for (int key : map.keySet()) {
            if (key == map.get(key)) {
                if (max < key) {
                    max = key;
                }
            }
        }
        return max;
    }
}
