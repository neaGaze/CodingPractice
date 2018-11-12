package solutions.sort;

public class SparseSearch {

    public int sparseSearch(String[] arr, String num) {
        return findElem(arr, 0, arr.length - 1, num);
    }

    /**
     * Time Complexity: O( log(n) )
     * Space Complexity: O(1)
     ****/
    public int findElem(String[] arr, int start, int end, String num) {
        if(end < start) {
            //if(arr[start] == num) return start;
            return -1;
        }

        int mid = (start + end) / 2; // 6

        if(arr[mid].equals(num)) {
            return mid;
        } else if(arr[mid].equals("")) {
            // perform binary search on both halves
            int left = findElem(arr, start, mid - 1, num);
            if(left >= 0) return left;
            return findElem(arr, mid + 1, end, num);
        } else if(isLessThan(num, arr[mid])) {
            // search the left half
            return findElem(arr, start, mid - 1, num);
        } else {
            // search the right half
            return findElem(arr, mid + 1, end, num);
        }
    }

    private boolean isLessThan(String a, String b) {

        int i = 0, aLen = a.length(), bLen = b.length();
        while(aLen > 0 && bLen > 0) {
            char aChar = a.charAt(i), bChar = b.charAt(i);
            if(aChar - bChar > 0) return false;
            else if(bChar - aChar > 0) return true;
            else {
                aLen--;
                bLen--;
                i++;
            }
        }
        if(aLen > bLen) return false;
        return true;
    }

    public static void test() {
        SparseSearch a = new SparseSearch();
        String[] arrStr = new String[]{"at", "", "", "", "ball", "", "", "car", "", "", "dad", "", ""};
        String toSearch = "ball";
        System.out.println("The search for " + toSearch + ":" );
        int index = a.sparseSearch(arrStr,toSearch);
        System.out.println("Found at index: " + index);

        toSearch = "zega";
        System.out.println("\nThe search for " + toSearch + ":" );
        index = a.sparseSearch(arrStr,toSearch);
        System.out.println("Found at index: " + index);
    }
}
