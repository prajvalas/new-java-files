public class ClimbingStairs {
    public static void main(String[] args) {
        System.out.println("Result is : " + climbStairs(7));
    }

    public static int[] temp = new int[47];

    public static int climbStairs(int n) {
        if (n == 0 || n == 1) {
            return 1;
        }
        if (temp[n] != 0) {
            return temp[n];
        }
        return temp[n] = climbStairs(n - 1) + climbStairs(n - 2);

    }
}
