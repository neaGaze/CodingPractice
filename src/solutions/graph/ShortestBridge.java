package solutions.graph;

import java.util.LinkedList;
import java.util.Queue;

/**
 * In a given 2D binary array A, there are two islands.  (An island is a 4-directionally connected group of 1s not connected to any other 1s.)
 *
 * Now, we may change 0s to 1s so as to connect the two islands together to form 1 island.
 *
 * Return the smallest number of 0s that must be flipped.  (It is guaranteed that the answer is at least 1.)
 *
 * Eg: [[1,1,1,1,1],
 *      [1,0,0,0,1],
 *      [1,0,1,0,1],
 *      [1,0,0,0,1],
 *      [1,1,1,1,1]]
 * **/
public class ShortestBridge {
    public int shortestBridge(int[][] A) {
        Queue<Pair> beach = new LinkedList<Pair>();

        Pair[] direction = new Pair[] {
                new Pair(0, -1),
                new Pair(-1, 0),
                new Pair(0, 1),
                new Pair(1, 0),
        };

        boolean isFirstIslandFound = false;
        for(int i = 0; i < A.length; i++) {
            for(int j = 0; j < A[0].length; j++) {
                if(A[i][j] > 0) {
                    beach = openFloodGate(i, j, A, direction);
                    isFirstIslandFound = true;
                    break;
                }
            }
            if(isFirstIslandFound) break;
        }

        while(!beach.isEmpty()) {
            Pair curPair = beach.poll();
            //System.out.println("(" + curPair.r+","+curPair.c+") = " + A[curPair.r][curPair.c]);
            //print(A);
            for(Pair pair : direction) {
                int newR = curPair.r + pair.r;
                int newC = curPair.c + pair.c;
                if(newR >= 0 && newC >= 0 && newR < A.length && newC < A[0].length) {
                    Pair child = new Pair(newR, newC);
                    if(A[newR][newC] == 0) {
                        beach.offer(child);
                        A[newR][newC] = A[curPair.r][curPair.c] + ((A[curPair.r][curPair.c] >= 0) ? 1 : 3);
                    } else if(A[newR][newC] == 1){
                        return A[curPair.r][curPair.c] - 1;
                    }
                }
            }
        }
        return -1;
    }

    public Queue<Pair> openFloodGate(int r, int c, int[][] A, Pair[] direction) {
        Queue<Pair> queue = new LinkedList<Pair>();
        Queue<Pair> beach = new LinkedList<Pair>();
        queue.add(new Pair(r, c));

        while(!queue.isEmpty()) {
            Pair curPair = queue.poll();
            A[curPair.r][curPair.c] = -1;
            boolean isBeach = false;
            for(Pair pair : direction) {
                int newR = curPair.r + pair.r;
                int newC = curPair.c + pair.c;
                if(newR >= 0 && newC >= 0 && newR < A.length && newC < A[0].length) {
                    Pair child = new Pair(newR, newC);
                    if(A[newR][newC] > 0) {
                        queue.offer(child);
                    } else if(A[newR][newC] == 0 && !isBeach) {
                        isBeach = true;
                        beach.offer(curPair);
                    }
                }
            }
        }
        return beach;
    }

    public class Pair {
        int r, c;
        public Pair(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    public void print(int[][] A) {

        for(int i = 0; i < A.length; i++) {
            StringBuilder strB = new StringBuilder();
            for(int j = 0; j < A[0].length; j++) {
               strB.append(A[i][j]).append(" ");
            }
            System.out.println(strB.toString());
        }
        System.out.println("");
    }

    public static void test() {
        ShortestBridge bridge = new ShortestBridge();
        //System.out.println(bridge.shortestBridge(new int[][] {{0, 1, 0}, {0, 0, 0}, {0, 0, 1}}));
        System.out.println(bridge.shortestBridge(new int[][] {
                {0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 1, 0, 1, 1, 0},
                {0, 0, 1, 1, 1, 1, 0, 0},
                {0, 1, 1, 1, 1, 1, 0, 0},
                {0, 1, 0, 1, 1, 1, 0, 0},
                {0, 0, 0, 1, 1, 1, 0, 0},
                {0, 0, 0, 0, 1, 0, 0, 0},
                {0, 0, 0, 0, 1, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0},
                {0, 1, 0, 0, 0, 0, 0, 0},
                {0, 1, 1, 0, 0, 0, 0, 0},
                {0, 0, 1, 0, 0, 0, 0, 0},
                {0, 0, 1, 1, 1, 0, 0, 0},
        }));
    }
}
