package solutions.hashmap;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SumZeroTriplets {

    public void getSumZeroTriplets(List<Integer> list) {
        Map<Integer, Integer> hmap = new HashMap<>();
        for(int i = 0; i < list.size(); i++)
            hmap.put(-list.get(i), i);

        for(int i = 0; i < list.size(); i++) {
            for(int j = i; j < list.size(); j++) {
                int sumOf2 = list.get(i) + list.get(j);
                if(hmap.get(sumOf2) != null && sumOf2 > 0) {
                    System.out.println("("+list.get(i)+","+list.get(j)+","+(-sumOf2)+")");
                }
            }
        }
    }

    public static void test() {
        new SumZeroTriplets().getSumZeroTriplets(Arrays.asList(new Integer[] {3, -6, 2, -2, 1}));
        System.out.println("");
        new SumZeroTriplets().getSumZeroTriplets(Arrays.asList(new Integer[] {1, 2, 3, 4}));
        System.out.println("");
        new SumZeroTriplets().getSumZeroTriplets(Arrays.asList(new Integer[] {-3, 3, 0, 2}));
    }
}
