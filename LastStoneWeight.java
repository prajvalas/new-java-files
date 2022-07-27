import java.util.PriorityQueue;

public class LastStoneWeight {
    public static void main(String[] args) {
        int[] stones = new int[] { 2, 7, 4, 1, 8, 1 };
        System.out.println("Last stone weight is : " + lastStoneWeight(stones));
    }

    public static int lastStoneWeight(int[] stones) {

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);
        for (int elem : stones) {
            maxHeap.add(elem);
        }

        while (maxHeap.size() > 1) {
            int first = maxHeap.poll();
            int second = maxHeap.poll();
            if (first == second) {
                continue;
            } else {
                maxHeap.add(Math.abs(first - second));
            }
        }

        if (maxHeap.size() == 0) {
            return 0;
        } else {
            return maxHeap.poll();
        }
    }
}
