import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;
import java.util.HashSet;

public class GetMaxCurrency {
    public static void main(String[] args) {

        String first_line = "USD,GBP,0.7;USD,JPY,109;CAD,CNY,5.27;GBP,JPY,155;CAD,KRN,921";
        // "USD,GBP,0.7;USD,JPY,109;USD,CNY,0.5;CAD,CNY,5.27;GBP,CAD,100;GBP,JPY,155;";
        // "USD,CAD,1.3;USD,GBP,0.71;USD,JPY,109;GBP,JPY,155";
        String from = "USD";
        String to = "CNY";// "JPY";
        HashMap<String, HashMap<String, Double>> map = convertToMap(first_line);
        findMax(map, from, to);
        double max = -1;
        for (double i : answer_options) {
            if (i > max) {
                max = i;
            }
        }
        System.out.println(max);
    }

    public static HashSet<String> visited = new HashSet<>();
    public static HashSet<String> localset = new HashSet<>();
    public static List<Double> values = new ArrayList<>();
    public static List<Double> answer_options = new ArrayList<>();

    public static void findMax(HashMap<String, HashMap<String, Double>> map, String from, String to) {
        for (String key : map.keySet()) {
            if (from.equals(key) && map.get(key).containsKey(to)) {
                values.add(map.get(key).get(to));
                double var = 1;
                for (double item : values) {
                    var *= item;
                }
                answer_options.add(var);
                localset.clear();
                values.clear();
            } else {
                if (map.get(key).containsKey(to)) {
                    localset.add(key);
                    localset.add(to);
                    if (!visited.contains(key + to)) {
                        visited.add(key + to);
                        values.add(map.get(key).get(to));
                        findMax(map, from, key);
                    } else {
                        localset.clear();
                        values.clear();
                    }

                }

            }
        }
    }

    public static HashMap<String, HashMap<String, Double>> convertToMap(String input) {

        HashMap<String, HashMap<String, Double>> map = new HashMap<>();
        String[] arr = input.split(";");

        for (int i = 0; i < arr.length; i++) {
            String[] arr1 = arr[i].split(",");
            map.putIfAbsent(arr1[0], new HashMap<>());
            map.get(arr1[0]).put(arr1[1], Double.parseDouble(arr1[2]));
        }
        return map;
    }

}
