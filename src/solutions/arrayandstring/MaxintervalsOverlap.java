package solutions.arrayandstring;

/**
 * Input: arrl[] = {1, 2, 10, 5, 5}
 *        exit[] = {4, 5, 12, 9, 12}
 * First guest in array arrives at 1 and leaves at 4,
 * second guest arrives at 2 and leaves at 5, and so on.
 *
 * Output: 5
 * There are maximum 3 guests at time 5.
 *
 * 1 2 3 4 5 6 7 8 9 10 11 12
 * 1 2 2 1 2 2 2 2 2 2   2  0
 *
 * entry
 * 1 1 0 0 2 0 0 0 0 1 0 0
 * 1 2 2 2 4 4 4 4 4 5 5 5
 *
 * exit
 * 0 0 0 1 1 0 0 0 1 0 0 2
 * 1 2 2 1 2 2 2 2 1 2 2 0
 *
 ***/
public class MaxintervalsOverlap {

    public int maxIntervalsOverlap(int[] enter, int[] exit) {
        int[] entry = new int[12];
        int[] exitPos = new int[12];
        for(int i = 0; i < enter.length; i++)
            entry[enter[i] - 1] +=  1;

        for(int j = 1; j < 12; j++) {
            entry[j] += entry[j - 1];
        }

        for(int k = 0; k < exit.length; k++)
            exitPos[exit[k] - 1] += 1;

        int maxElem = 0, count = 0;
        for(int l = 0; l < 12; l++) {
            count += exitPos[l];
            entry[l] -= count;

            if(maxElem < entry[l])
                maxElem = enter[l];
        }
        return maxElem;
    }

    public static void test() {
        MaxintervalsOverlap a = new MaxintervalsOverlap();
        int maxElem = a.maxIntervalsOverlap(new int[] {1, 2, 10, 5, 5}, new int[] {4, 5, 12, 9, 12});
        System.out.println("The max Elem is: " + maxElem);
    }
}
