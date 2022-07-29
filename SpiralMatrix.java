import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {
    public static void main(String[] args) {
        int[][] matrix = new int[][] { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
        List<Integer> result = spiralOrder(matrix);
        System.out.println("Answer is : " + result);
    }

    public static List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> answer = new ArrayList<>();
        int row_start = 0;
        int col_start = 0;
        int row_end = matrix.length;
        int col_end = matrix[0].length;
        while (row_start < row_end && col_start < col_end) {
            for (int i = col_start; i < col_end; i++) {
                answer.add(matrix[row_start][i]);
            }
            row_start++;

            for (int i = row_start; i < row_end; i++) {
                answer.add(matrix[i][col_end - 1]);
            }
            col_end--;
            if (row_start < row_end) {
                for (int i = col_end - 1; i >= col_start; i--) {
                    answer.add(matrix[row_end - 1][i]);
                }
                row_end--;
            }
            if (col_start < col_end) {
                for (int i = row_end - 1; i >= row_start; i--) {
                    answer.add(matrix[i][col_start]);
                }
                col_start++;
            }
        }
        return answer;
    }
}
