import java.util.List;
import java.util.ArrayList;
import java.util.HashSet;

public class NumbersWithSameConsecutiveDifferences {
    public static void main(String[] args) {
        int n = 2;
        int k = 0;
        int[] result = numsSameConsecDiff(n, k);
        for (int i : result) {
            System.out.println(i);
        }
    }

    public static int[] numsSameConsecDiff(int n, int k) {
        HashSet<Integer> result = new HashSet<>();

        for (int i = 1; i <= 9; i++) {
            dfs(n - 1, i, k, result);
        }

        return result.stream().mapToInt(elem -> elem).toArray();
    }

    public static void dfs(int n, int num, int k, HashSet<Integer> result) {
        if (n == 0) {
            result.add(num);
            return;
        }
        int previous = num % 10;
        List<Integer> possible_nums = new ArrayList<>();
        possible_nums.add(previous + k);
        possible_nums.add(previous - k);

        int next_pass_num = 0;
        for (int elem : possible_nums) {
            if (elem >= 0 && elem <= 9) {
                next_pass_num = num * 10 + elem;
                dfs(n - 1, next_pass_num, k, result);
            }
        }
    }
}
