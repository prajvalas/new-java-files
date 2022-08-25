import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class CrptoBrokerPlatformCodeSignal {
    public static void main(String[] args) {
        int[] user_balance = new int[] { 9, 7, 12 };
        List<String> operations = new ArrayList<>();
        operations.add("buy 1 3 2");
        operations.add("sell 1 4 10");
        operations.add("deposit 2 12");
        operations.add("buy 2 10 2");
        operations.add("buy 2 6 3");
        List<Integer> res = performUserOperations(user_balance, operations);
        for (int elem : res) {
            System.out.println(elem);
        }
    }

    public static List<Integer> performUserOperations(int[] user_balance, List<String> operations) {
        HashMap<Integer, int[]> map = new HashMap<>();
        for (int i = 0; i < user_balance.length; i++) {
            // CryptoUser user = new CryptoUser(i+1, user_balance[i], 0);
            map.put(i + 1, new int[] { user_balance[i], 0 });
        }

        int res = 0;
        List<Integer> answer = new ArrayList<>();
        for (String s : operations) {
            String[] sarry = s.split(" ");
            switch (sarry[0]) {
                case "buy":
                    res = buy(Integer.parseInt(sarry[1]), Integer.parseInt(sarry[2]), Integer.parseInt(sarry[3]), map);
                    answer.add(res);
                    break;
                case "sell":
                    res = sell(Integer.parseInt(sarry[1]), Integer.parseInt(sarry[2]), Integer.parseInt(sarry[3]), map);
                    answer.add(res);
                    break;
                case "deposit":
                    res = deposit(Integer.parseInt(sarry[1]), Integer.parseInt(sarry[2]), map);
                    answer.add(res);
                    break;
            }
        }
        return answer;
    }

    public static int buy(int user_id, int shares, int buying_price, HashMap<Integer, int[]> map) {
        int total_cost = shares * buying_price;
        if (map.get(user_id)[0] >= total_cost) {
            map.get(user_id)[0] -= total_cost;
            map.get(user_id)[1] += shares;
        }
        return map.get(user_id)[0];
    }

    public static int sell(int user_id, int shares, int selling_cost, HashMap<Integer, int[]> map) {
        if (map.get(user_id)[1] >= shares) {
            map.get(user_id)[1] -= shares;
            map.get(user_id)[0] += selling_cost * shares;
        }
        return map.get(user_id)[0];
    }

    public static int deposit(int user_id, int amount, HashMap<Integer, int[]> map) {
        map.get(user_id)[0] += amount;
        return map.get(user_id)[0];
    }
}
