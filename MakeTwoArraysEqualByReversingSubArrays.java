import java.util.Arrays;

public class MakeTwoArraysEqualByReversingSubArrays {
    public static void main(String[] args) {
        int[] target = new int[] { 1, 2, 3, 4 };
        int[] arr = new int[] { 2, 4, 1, 3 };
        System.out.println("Reversing possible? : " + canBeEqual(target, arr));
    }

    public static boolean canBeEqual(int[] target, int[] arr) {
        if (target.length != arr.length) {
            return false;
        }
        Arrays.sort(target);
        Arrays.sort(arr);
        for (int i = 0; i < target.length; i++) {
            if (arr[i] != target[i]) {
                return false;
            }
        }
        return true;

    }
}
