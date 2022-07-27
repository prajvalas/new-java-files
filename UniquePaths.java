public class UniquePaths {
    public static void main(String[] args) {
        int m = 3;
        int n = 7;
        int res = uniquePaths(m, n);
        System.out.println("Result is : " + res);
    }

    public static int uniquePaths(int m, int n) {

        if (m == 1 && n == 1) {
            return 1;
        }
        int[][] dp = new int[m][n];
        dp[m - 1][n - 1] = 0;

        for (int i = m - 2, j = n - 1; i >= 0; i--) {
            dp[i][j] = 1;
        }
        for (int i = m - 1, j = n - 2; j >= 0; j--) {
            dp[i][j] = 1;
        }

        for (int i = n - 2; i >= 0; i--) {
            for (int j = m - 2; j >= 0; j--) {
                dp[j][i] = Math.max(dp[j + 1][i + 1], dp[j + 1][i] + dp[j][i + 1]);
            }
        }

        return dp[0][0];
    }
}
