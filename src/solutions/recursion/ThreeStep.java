package solutions.recursion;

/**
 * Created by neaGaze on 10/12/18.
 */
public class ThreeStep {

    public ThreeStep(int n) {
        int[] list = new int[n + 1];
        System.out.println("When steps equals "+n+", total number of ways to skip steps: " + totalSteps(n, list));
    }

    public int totalSteps(int steps, int[] list) {
        //if(list[steps] >= 1) return list[steps];
        if(steps == 1) list[steps] = 1;
        if(steps == 2) list[steps] = 2;
        if(steps == 3) list[steps] = 4;

        if(list[steps] >= 1) return list[steps];
        list[steps] = totalSteps(steps - 1, list) + totalSteps(steps - 2, list) + totalSteps(steps - 3, list);
        return list[steps];
    }

    public static void test() {
        ThreeStep a = new ThreeStep(4);
        ThreeStep b = new ThreeStep(7);
    }
}
