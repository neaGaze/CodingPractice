package solutions.arrayandstring;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Problem Definition:
 * https://docs.google.com/presentation/d/1fdiy3RzAzlMJuGS49GxDkOpAbA8aIJX7Ri-pZ5U4w-w/edit#slide=id.g3af456d45a_0_24
 * */
public class TaskScheduler {

    public List<String> taskScheduler(int[] tasks, int cooldown) {
        HashMap<Integer, Integer> hmap = new HashMap<Integer, Integer>();
        ArrayList<String> res = new ArrayList<String>();
        int sub = 0;
        for(int i = 0; i < tasks.length; i++) {
            int task = tasks[i];
            Integer pos = hmap.get(task);
            hmap.put(task, i + cooldown + 1);
            if(pos == null) {
                res.add(task+"");
                sub++;
            } else {
                for(int m = sub; m < pos; m++) {
                    res.add("_");
                    sub++;
                }
                res.add(task+"");
                sub++;
            }
        }
        return res;
    }

    public static void test() {
        TaskScheduler taskS = new TaskScheduler();
        List<String> res = taskS.taskScheduler(new int[] {3, 4, 5, 3, 4, 5}, 4);
        for(String str : res)
            System.out.println(str);
    }
}
