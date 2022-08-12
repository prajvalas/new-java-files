public class FindEarliestMonth {
    public static void main(String[] args) {
        int[] stock_price = new int[] { 1, 3, 2, 4, 5 };
        int result = findEarliestMonth(stock_price);
        System.out.println("Month with minimum net price change is : " + result);
    }

    public static int findEarliestMonth(int[] stock_price) {

        int sum = 0;
        for (int price : stock_price) {
            sum += price;
        }

        int sum1 = 0;
        int avg1, avg2 = 0;
        int len = stock_price.length;
        int diff = 0;
        int min = Integer.MAX_VALUE;
        int result = 0;

        for (int i = 0; i < len - 1; i++) {
            sum1 += stock_price[i];
            avg1 = sum1 / (i + 1);
            avg2 = (sum - sum1) / (len - i - 1);
            diff = Math.abs(avg1 - avg2);
            System.out.println("Diff is :" + diff);
            if (diff < min) {
                min = diff;
                result = i + 1;
            }
        }
        return result;
    }
}
