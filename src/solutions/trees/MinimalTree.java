package solutions.trees;
import java.util.*;

/**
 * Created by neaGaze on 10/3/18.
 */
public class MinimalTree {
    public int[] arr = new int[]{1, 3, 5, 7, 10, 11, 14, 19, 22, 24, 25};

    public void createTree() {
        List<Integer> binArr = recursiveSearch(0, arr.length - 1);
        binArr.forEach(e -> System.out.println(e));
    }

    /**
     * Time Complexity = O(n)
     * Space Complexity = O(nlogn)
     * **/
    public List<Integer> recursiveSearch(int s, int e) {
        if(s > e) return Arrays.asList();

        int mid = ((e - s) % 2 == 0 ? (s + (e-s)/2) : (s + (e-s)/2 + 1));
        ArrayList<Integer> list = new ArrayList<>();
        list.add(arr[mid]);
        list.addAll(recursiveSearch(s, mid - 1));
        list.addAll(recursiveSearch(mid + 1, e));
        return list;
    }

    public static void test() {
        MinimalTree tree = new MinimalTree();
        tree.createTree();
    }
}
