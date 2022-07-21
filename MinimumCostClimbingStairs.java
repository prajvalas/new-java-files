public class MinimumCostClimbingStairs {
    public static void main(String[] args) {
        int[] cost = new int[] { 1, 100, 1, 1, 1, 100, 1, 1, 100, 1 };// { 10, 15, 20 };
        System.out.println("Result is : " + minCostClimbingStairs(cost));
    }

    public static int[] dp = new int[1002];

    public static int minCostClimbingStairs2(int[] cost) {
        dp[cost.length - 1] = cost[cost.length - 1];
        dp[cost.length] = 0;
        for (int i = cost.length - 2; i >= 0; i--) {
            dp[i] = Math.min(dp[i + 1] + cost[i], dp[i + 2] + cost[i]);
        }

        return Math.min(dp[0], dp[1]);
    }

    // Uses no extra space
    public static int minCostClimbingStairs(int[] cost) {
        int len = cost.length;
        cost[len - 2] = Math.min(cost[len - 1] + cost[len - 2], cost[len - 2]);

        for (int i = len - 3; i >= 0; i--) {
            cost[i] = Math.min(cost[i + 1] + cost[i], cost[i + 2] + cost[i]);
        }

        return Math.min(cost[0], cost[1]);
    }
}
