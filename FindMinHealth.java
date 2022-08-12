public class FindMinHealth {
    public static void main(String[] args) {
        int[] power = new int[] { 1, 2, 3 };// { 1, 2, 6, 7 };
        int armor = 5;
        int result = findMinHealth(power, armor);
        System.out.println("Minimum health required is : " + result);
    }

    public static int findMinHealth(int[] power, int armor) {
        int sum = 0;
        int max = Integer.MIN_VALUE;
        for (int i : power) {
            if (i > max) {
                max = i;
            }
            sum += i;
        }
        return sum + 1 - Math.min(armor, max);

    }
}
