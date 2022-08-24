public class NthTribonacciNumber {
    public static void main(String[] args) {
        int n = 25;
        System.out.println("Result is : " + tribonacci(n));
    }

    public static int[] temp = new int[40];

    public static int tribonacci(int n) {
        if (n == 0) {
            return temp[n] = 0;
        } else if (n == 1 || n == 2) {
            return temp[n] = 1;
        }
        if (temp[n] != 0) {
            return temp[n];
        }
        return temp[n] = tribonacci(n - 1) + tribonacci(n - 2) + tribonacci(n - 3);
    }
}
