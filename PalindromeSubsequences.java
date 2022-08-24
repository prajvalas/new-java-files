public class PalindromeSubsequences {
    static final int MAX = 100;
    static final int MAX_CHAR = 26;

    public static void main(String[] args) {
        String s = "aabab";
        int k = 2;
        int n = s.length();
        int l[][] = new int[MAX_CHAR][MAX];
        int r[][] = new int[MAX_CHAR][MAX];

        precompute(s, n, l, r);

        System.out.println(countPalindromes(k, n, l, r));
    }

    public static void getPalindromeSubsequence() {

    }

    // Find the number of palindromic subsequence of
    // length k
    static int countPalindromes(int k, int n, int l[][],
            int r[][]) {
        int ans = 0;

        // If k is 1.
        if (k == 1) {
            for (int i = 0; i < MAX_CHAR; i++)
                ans += l[i][n - 1];

            return ans;
        }

        // If k is 2
        if (k == 2) {

            // Adding all the products of prefix array
            for (int i = 0; i < MAX_CHAR; i++)
                ans += ((l[i][n - 1] * (l[i][n - 1] - 1)) / 2);

            return ans;
        }

        // For k greater than 2. Adding all the products
        // of value of prefix and suffix array.
        for (int i = 1; i < n - 1; i++)
            for (int j = 0; j < MAX_CHAR; j++)
                ans += l[j][i - 1] * r[j][i + 1];

        return ans;
    }

    static void precompute(String s, int n, int l[][], int r[][]) {
        l[s.charAt(0) - 'a'][0] = 1;

        // Precompute the prefix 2D array
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < MAX_CHAR; j++)
                l[j][i] += l[j][i - 1];

            l[s.charAt(i) - 'a'][i]++;
        }

        r[s.charAt(n - 1) - 'a'][n - 1] = 1;

        // Precompute the Suffix 2D array.
        for (int i = n - 2; i >= 0; i--) {
            for (int j = 0; j < MAX_CHAR; j++)
                r[j][i] += r[j][i + 1];

            r[s.charAt(i) - 'a'][i]++;
        }
    }
}