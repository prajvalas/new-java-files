import java.util.HashMap;

public class MaximumNumberOfBallsInABox {
    public static void main(String[] args) {
        int lowLimit = 5;
        int highLimit = 15;
        System.out.println("Result is : " + countBalls(lowLimit, highLimit));
    }

    public static int countBalls(int lowLimit, int highLimit) {
        HashMap<Integer, Integer> map = new HashMap<>();

        int sum;
        int num;
        int max = Integer.MIN_VALUE;
        for (int i = lowLimit; i <= highLimit; i++) {
            num = i;
            sum = 0;
            while (num > 0) {
                sum += num % 10;
                num = num / 10;
            }

            if (map.containsKey(sum)) {
                map.put(sum, map.get(sum) + 1);
            } else {
                map.put(sum, 1);
            }
            if (map.get(sum) > max) {
                max = map.get(sum);
            }
        }
        return max;
    }
}
