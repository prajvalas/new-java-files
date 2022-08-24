import java.util.Arrays;
import java.util.Comparator;
import java.util.function.Function;
import java.util.ArrayList;
import java.util.Collections;

public class SortByBinaryCardinality {
    public static void main(String[] args) {
        int[] nums = new int[] { 1, 2, 3, 4, 5 };
        int[] res = sortByCardinality(nums);
        for (int i : res) {
            System.out.println(i);
        }
    }

    public static int[] sortByCardinality1(int[] nums) {

        Comparator<Integer> comp = Comparator.comparing(Integer::bitCount).thenComparing(Function.identity());
        return Arrays.stream(nums).boxed().sorted(comp).mapToInt(Integer::intValue).toArray();
    }

    public static int[] sortByCardinality(int[] nums) {
        ArrayList<Integer> al = new ArrayList<>();
        for (int i : nums) {
            al.add(i);
        }
        Collections.sort(al, (a, b) -> Integer.bitCount(a) == Integer.bitCount(b) ? a - b
                : Integer.bitCount(a) - Integer.bitCount(b));
        for (int i = 0; i < nums.length; i++) {
            nums[i] = al.get(i);
        }
        return nums;
    }
}
