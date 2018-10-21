package solutions.sort;

/**
 * Created by neaGaze on 10/20/18.
 */
public class RotatedArraySort {

    public RotatedArraySort() {}

    public int findNum(int[] arr, int num) {
        return findNumber(arr, num, 0, arr.length-1);
    }

    // 7 8 9 1 	// 9 1
    public int findNumber(int[] arr, int num, int i, int j) {

        if(i > j) return -1;

        int middle = (i + j) / 2;			// middle = 4	// middle = 8
        if(arr[middle] == num) return middle;

        int lIndex = i, rIndex = middle - (lIndex == middle ? 0 : 1);	// l = 0, r = 3	// l = 0, r = 0
        if(isSorted(arr, lIndex, rIndex)) {
            if(num > arr[rIndex] && arr[lIndex] < num) {
                lIndex = middle + 1;
                rIndex = j;		// l = 2, r = 3
            }
        } else {
            // this is always sorted
            int newLIndex = middle + 1, newRIndex = j;	// l = 5, r = 8
            if(num <= arr[newRIndex] && num >= newLIndex) {
                lIndex = newLIndex;
                rIndex = newRIndex;
            }
        }
        System.out.println("Currently searching: (" + lIndex+", " + rIndex+")");

        return findNumber(arr, num, lIndex, rIndex);
    }

    public boolean isSorted(int[] arr, int i, int j) {
        if(arr[i] <= arr[j]) return true;
        else return false;
    }


    public static void test() {
        RotatedArraySort a = new RotatedArraySort();
        int toFind = 9;
        int[] arr = new int[]{7, 8, 9, 1, 2, 3, 4, 5, 6};
        int pos = a.findNum(arr, toFind);
        System.out.println("The position of " + toFind + " in " + arr.toString() + " is: " + pos);

        toFind = 9;
        arr = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9};
        pos = a.findNum(arr, toFind);
        System.out.println("The position of " + toFind + " in " + arr.toString() + " is: " + pos);

        toFind = 10;
        arr = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9};
        pos = a.findNum(arr, toFind);
        System.out.println("The position of " + toFind + " in " + arr.toString() + " is: " + pos);


        toFind = 10;
        arr = new int[]{7, 8, 9, 1, 2, 3, 4, 5, 6};
        pos = a.findNum(arr, toFind);
        System.out.println("The position of " + toFind + " in " + arr.toString() + " is: " + pos);

        toFind = 2;
        arr = new int[]{7, 8, 9, 1, 2, 3, 4, 5, 6};
        pos = a.findNum(arr, toFind);
        System.out.println("The position of " + toFind + " in " + arr.toString() + " is: " + pos);


        toFind = 9;
        arr = new int[]{2, 2, 2, 2, 2, 2, 6, 7, 8, 9, 2, 2};
        pos = a.findNum(arr, toFind);
        System.out.println("The position of " + toFind + " in " + arr.toString() + " is: " + pos);
    }
}
