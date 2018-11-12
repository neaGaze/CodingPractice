package solutions.graph;

import java.util.LinkedList;
import java.util.Queue;

public class IslandCount {
    public int countIslands(int[][] matrix) {
        int islandCount = 0;
        Pair[] boundaries = new Pair[] {
                new Pair(0, 1),
                new Pair( 0,  -1),
                new Pair(1, 0),
                new Pair(-1, 0),
        };

        for(int r = 0; r < matrix.length; r++) {
            for(int c = 0; c < matrix[0].length; c++) {
                if(matrix[r][c] > 0) {
                    openFloodGate(matrix, r, c, boundaries);
                    islandCount += 1;
                }
            }
        }
        return islandCount;
    }

    private void openFloodGate(int[][] matrix, int r, int c, Pair[] boundaries) {
        Queue<Pair> queue = new LinkedList<>();
        queue.offer(new Pair(r, c));

        while(!queue.isEmpty()) {
            Pair curPair = queue.poll();
            matrix[curPair.r][curPair.c] = -1;
            for (Pair pair : boundaries) {
                int newR = curPair.r + pair.r;
                int newC = curPair.c + pair.c;
                if (newR >= 0 && newC >= 0 && newR < matrix.length && newC < matrix[0].length &&
                        matrix[newR][newC] == 1) {
                    queue.offer(new Pair(newR, newC));
                }
            }
        }
    }

    public class Pair {
        int r, c;
        public Pair(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    public static void test() {
        int[][] matrix = new int[][] {
            {1, 1, 0, 0, 0},
            {0, 1, 0, 0, 1},
            {1, 0, 0, 1, 1},
            {0, 0, 0, 0, 0},
            {1, 0, 1, 0, 1}
        };
        IslandCount islands = new IslandCount();
        System.out.println(islands.countIslands(matrix));
    }
}
