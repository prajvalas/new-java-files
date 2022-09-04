import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.TreeMap;

public class GetResultOfBusyIntersection {
    public static void main(String[] args) {
        int[] arrival = new int[] { 0, 0, 1, 4 };
        int[] street = new int[] { 0, 1, 1, 0 };
        int[] result = busyIntersection(arrival, street);
        System.out.println("Result is : ");
        for (int i : result) {
            System.out.print(i + " ");
        }
    }

    public static int[] busyIntersection(int[] arrival, int[] street) {
        int[] result = new int[arrival.length];

        HashMap<Integer, List<Integer>> map = new HashMap<>();
        TreeMap<Integer, List<Integer>> tmap = new TreeMap<>();
        List<Integer> ave_one = new ArrayList<>();
        List<Integer> main_st = new ArrayList<>();

        for (int i = 0; i < arrival.length; i++) {
            if (!map.containsKey(arrival[i])) {
                map.put(arrival[i], new ArrayList<>());
                map.get(arrival[i]).add(i);
            } else {
                map.get(arrival[i]).add(i);
            }
        }
        System.out.println(map);
        tmap.putAll(map);
        System.out.println(tmap);

        for (int key : map.keySet()) {
            for (int i : map.get(key)) {
                if (street[i] == 1) {
                    ave_one.add(i);
                } else {
                    main_st.add(i);
                }
            }
        }
        System.out.println(ave_one);
        System.out.println(main_st);

        int prev_sec = -2;
        int prev_car = 0;
        int counter = 0;

        while (!main_st.isEmpty() || !ave_one.isEmpty()) {
            if (main_st.isEmpty()) {
                while (!ave_one.isEmpty()) {
                    if (arrival[ave_one.get(0)] <= counter) {
                        prev_car = ave_one.get(0);
                        ave_one.remove(0);
                        prev_sec = counter;
                        result[prev_car] = counter;
                        counter++;
                    }
                    if (!ave_one.isEmpty() && arrival[ave_one.get(0)] > counter) {
                        counter = arrival[ave_one.get(0)];
                    }
                }
                break;
            } else if (ave_one.isEmpty()) {
                while (!main_st.isEmpty()) {
                    if (arrival[main_st.get(0)] <= counter) {
                        prev_car = main_st.get(0);
                        main_st.remove(0);
                        prev_sec = counter;
                        result[prev_car] = counter;
                        counter++;
                    }
                    if (!main_st.isEmpty() && arrival[main_st.get(0)] > counter) {
                        counter = arrival[main_st.get(0)];
                    }
                }
                break;
            }
            // No car wants to enter the intersection
            if (arrival[ave_one.get(0)] > counter && arrival[main_st.get(0)] > counter) {
                System.out.println("No cars" + ave_one.get(0) + ", " + main_st.get(0));
                counter = Math.min(arrival[ave_one.get(0)], main_st.get(0));
                continue;
            }
            // Only one car has arrived, using xor
            if (arrival[ave_one.get(0)] <= counter ^ arrival[main_st.get(0)] <= counter) {
                System.out.println("One car can go");
                System.out.println(counter + ", " + arrival[ave_one.get(0)] + ", " + arrival[main_st.get(0)]);
                if (arrival[ave_one.get(0)] < arrival[main_st.get(0)]) {
                    prev_car = ave_one.get(0);
                    ave_one.remove(0);
                    prev_sec = counter;
                    result[prev_car] = counter;
                } else {
                    prev_car = main_st.get(0);
                    main_st.remove(0);
                    prev_sec = counter;
                    result[prev_car] = counter;
                }
                System.out.println(ave_one);
                System.out.println(main_st);
            }
            // Two cars are ready to go
            else {
                System.out.println("Two cars are ready to go");
                System.out.println(ave_one);
                System.out.println(main_st);
                // No car passed in last sec, send car on 1st Av
                if (counter - prev_sec > 1) {
                    prev_car = ave_one.get(0);
                    ave_one.remove(0);
                    prev_sec = counter;
                    result[prev_car] = counter;
                }
                // if a car passed in last sec
                else {
                    if (street[prev_car] == 1) {
                        prev_car = ave_one.get(0);
                        ave_one.remove(0);
                        prev_sec = counter;
                        result[prev_car] = counter;
                    } else {
                        prev_car = main_st.get(0);
                        main_st.remove(0);
                        prev_sec = counter;
                        result[prev_car] = counter;
                    }

                }
                System.out.println(ave_one);
                System.out.println(main_st);

            }

            counter++;
        }

        return result;
    }
}
