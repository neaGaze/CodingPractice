package solutions.recursion;

import java.util.Stack;

/**
 * Created by neaGaze on 10/19/18.
 */
public class RobotInAGrid {

    public Stack<Pair> path;
    public Props[][] mem;

    RobotInAGrid(int[][] matrix) {
        mem = new Props[matrix.length][];
        for(int k = 0; k < matrix.length; k++)
            mem[k] = new Props[matrix[0].length];

        for(int i = 0; i < matrix.length; i++) {
            for(int j = 0; j < matrix[0].length; j++) {
                mem[i][j] = new Props(matrix[i][j], false);
                //System.out.println(mem[i][j].val);
            }
        }

        path = new Stack<Pair>();
        // searchPath(0, 0, path, mem);
    }

    public class Pair {
        int x, y;
        Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public String toString() {
            return "Pair{" + "x=" + x + ", y=" + y + '}';
        }
    }

    public class Props {
        int val;
        boolean visited;

        Props(int val, boolean visited) {
            this.val = val;
            this.visited = visited;
        }
    }

    public boolean searchLeftTopToRightBottom() {
        return searchPath(0, 0, path, mem);
    }

    public boolean searchPath(int i, int j, Stack<Pair> paths, Props[][] mem) {
        int m = mem.length, n = mem[0].length;
        System.out.println("Currently at (" + i + ", " + j + ")");
        if(i == m - 1 && j == n - 1) {
            paths.push(new Pair(i, j));
            return true;
        }

        if(i >= m || j >= n || mem[i][j].visited || mem[i][j].val == -1)
            return false;

        mem[i][j] = new Props(1, true);
        boolean isFound = false;

        if(j < n) {
            isFound = searchPath(i, j + 1, paths, mem);
            if(isFound) {
                paths.push(new Pair(i, j));
                return true;
            }
        }

        if(i < m) {
            isFound = searchPath(i + 1, j, paths, mem);
            if(isFound) {
                paths.push(new Pair(i, j));
                return true;
            }
        }
        return isFound;
    }

    public static void test() {
        int[][] arr = {{0, 0, 0, 0}, {0, -1, 0, -1}, {0, 0, -1, 0}, {0, 0, 0, 0}};
        RobotInAGrid a = new RobotInAGrid(arr);
                                              
        System.out.println("The path is " + a.searchLeftTopToRightBottom() + " and path is: " + a.path.toString());
    }
}
