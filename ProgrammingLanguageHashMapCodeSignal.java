import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ProgrammingLanguageHashMapCodeSignal {
    public static void main(String[] args) {
        String[] queryTypes = new String[] { "insert", "addToValue", "get", "insert", "addToKey", "addToValue", "get" };
        List<int[]> query = new ArrayList<>();
        query.add(new int[] { 1, 2 });
        query.add(new int[] { 2 });
        query.add(new int[] { 1 });
        query.add(new int[] { 2, 3 });
        query.add(new int[] { 1 });
        query.add(new int[] { -1 });
        query.add(new int[] { 3 });
        long res = hashmap(queryTypes, query);
        System.out.println(res);
    }

    public static long hashmap(String[] queryTypes, List<int[]> query) {
        HashMap<Integer, Integer> map = new HashMap<>();
        long sum = 0;
        for (int i = 0; i < queryTypes.length; i++) {
            String s = queryTypes[i];
            switch (s) {
                case "insert":
                    insert(query.get(i), map);
                    break;
                case "get":
                    sum += get(query.get(i), map);
                case "addToValue":
                    addToValue(query.get(i), map);
                    break;
                case "addToKey":
                    addToKey(query.get(i), map);
                    break;

            }
        }
        return sum;
    }

    public static void insert(int[] keyvalue, HashMap<Integer, Integer> map) {
        map.put(keyvalue[0], keyvalue[1]);
    }

    public static void addToValue(int[] keyvalue, HashMap<Integer, Integer> map) {
        for (int key : map.keySet()) {
            map.put(key, map.get(key) + keyvalue[0]);
        }
    }

    public static void addToKey(int[] keyvalue, HashMap<Integer, Integer> map) {
        HashMap<Integer, Integer> temp = new HashMap<>();
        for (int key : map.keySet()) {
            temp.put(key, map.get(key));
        }
        for (int key : temp.keySet()) {
            map.put(key + keyvalue[0], temp.get(key));
            map.remove(key);
        }
    }

    public static long get(int[] keyvalue, HashMap<Integer, Integer> map) {
        return map.get(keyvalue[0]);
    }

}
