package solutions.search;

import java.util.LinkedList;
import java.util.Queue;

/***
 * Input:
 *
 * 1 0 1
 * 0 1 1
 * 1 1 1
 *
 * Output:
 *
 * 1 0 1
 * 0 1 2
 * 1 2 3
 * **/
public class NearestPath {

    public NearestPath() {}

    class Pair {
        int x, y;
        Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public String toString() {
            return ("(" + x + ", " + y + ")");
        }
    }

    public int[][] findNearestPath(int[][] arr, Queue<Pair> queue) {
        int[][] minDist = new int[arr.length][arr[0].length];

        for(int i = 0; i < arr.length; i++) {
            for(int j = 0; j < arr[0].length; j++) {
                if(arr[i][j] == 0) {
                    minDist[i][j] = 0;
                    queue.offer(new Pair(i, j));
                } else if(arr[i][j] != 0) minDist[i][j] = Integer.MAX_VALUE;
            }
        }
        callBFS(arr, queue, minDist);
        return minDist;
    }

    public void callBFS(int[][] arr, Queue<Pair> queue, int[][] minDist) {
        while(! queue.isEmpty()) {
            //System.out.println("Queue: " + queue.toString());
            Pair pair = queue.remove();
            Pair[] distance = new Pair[]{
                    new Pair(-1, 0),
                    new Pair(0, -1),
                    new Pair(1, 0),
                    new Pair(0, 1),
            };

            for(Pair p : distance) {
                int newr = pair.x + p.x;
                int newc = pair.y + p.y;
                //System.out.println("newr: " + newr + ", newc: " + newc);
                if(newr >= 0 && newc >= 0 && newr < arr.length && newc < arr[0].length) {
                    int newVal = minDist[pair.x][pair.y] + 1;
                    if(minDist[newr][newc] > newVal) {
                        minDist[newr][newc] = newVal;
                        queue.offer(new Pair(newr, newc));
                    }
                }
            }
        }
    }

    public static void print(int[][] src, int[][] ans) {
        System.out.println("The min distance matrix of: ");
        for(int[] i : src) {
            StringBuilder a = new StringBuilder();
            for(int j : i)
                a.append(j).append(" ");
            System.out.println(a.toString());
        }
        System.out.println("");

        for(int[] p : ans) {
            StringBuilder b = new StringBuilder();
            for(int j : p)
                b.append(j).append(" ");
            System.out.println(b.toString());
        }
        System.out.println("");
    }

    public static void test() {
        int[][] matrix = new int[][]{{1, 0 ,1}, {0, 1 ,1}, {1, 1 ,1}};
        NearestPath nearestPath = new NearestPath();
        int[][] ans = nearestPath.findNearestPath(matrix, new LinkedList<>());
        print(matrix, ans);
    }
}
