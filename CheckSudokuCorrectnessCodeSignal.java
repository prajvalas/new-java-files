import java.util.HashSet;

public class CheckSudokuCorrectnessCodeSignal {
    public static void main(String[] args) {
        int[][] grid = new int[][] { { 1, 3, 2, 5, 4, 6, 9, 8, 7, }, { 4, 6, 5, 8, 7, 9, 3, 2, 1 },
                { 7, 9, 8, 2, 1, 3, 6, 5, 4 }, { 9, 2, 1, 4, 3, 5, 8, 7, 6 }, { 3, 5, 4, 7, 6, 8, 2, 1, 9 },
                { 6, 8, 7, 1, 9, 2, 5, 4, 3 }, { 5, 7, 6, 9, 8, 1, 4, 3, 2 }, { 2, 4, 3, 6, 5, 7, 1, 9, 8 },
                { 8, 1, 9, 3, 2, 4, 7, 6, 5 } };
        boolean res = isCorrectSolution(grid);
        System.out.println(res);

    }

    public static boolean isCorrectSolution(int[][] grid) {
        HashSet<String> seen = new HashSet<>();
        for (int i = 0; i < 9; ++i) {
            for (int j = 0; j < 9; ++j) {
                int number = grid[i][j];
                if (!seen.add(number + " in row " + i) ||
                        !seen.add(number + " in column " + j) ||
                        !seen.add(number + " in block " + i / 3 + "-" + j / 3))
                    return false;
            }
        }
        return true;
    }
}
