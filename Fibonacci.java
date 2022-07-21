public class Fibonacci {
    public static void main(String[] args) {
        int res = fib(8);
        System.out.println("Result is : " + res);
    }
    // Recursive, not efficient
    // public static int fib(int n) {
    // if(n==0 || n==1){
    // return n;
    // }
    // return fib(n-1)+fib(n-2);
    // }

    // Dynamic, 100% efficient
    public static int[] temp = new int[32];

    public static int fib(int n) {
        if (n == 0 || n == 1) {
            return n;
        }
        if (temp[n] != 0) {
            return temp[n];
        }
        return temp[n] = fib(n - 1) + fib(n - 2);
    }
}
