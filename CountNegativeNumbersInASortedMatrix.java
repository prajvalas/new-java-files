public class CountNegativeNumbersInASortedMatrix {
    public static void main(String[] args) {
        int[][] grid = new int[][] { { 4, 3, 2, -1 }, { 3, 2, 1, -1 }, { 1, 1, -1, -2 }, { -1, -1, -2, -3 } };
        int res = countNegatives(grid);
        System.out.println("Result is : " + res);
    }

    public static int countNegatives(int[][] grid) {
        int count = 0;
        int m = grid.length - 1;
        int n = grid[0].length;
        int row = m;
        int col = 0;

        while (row >= 0 && col < n) {
            if (grid[row][col] < 0) {
                row--;
                count += n - col;
            } else {
                col++;
            }
        }
        return count;
    }
}
