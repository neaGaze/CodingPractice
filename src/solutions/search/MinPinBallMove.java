package solutions.search;

public class MinPinBallMove {
    //  0 1 0 0 (S)
    //  1 0 0 0
    //  0 0 1 1
    //  0 0 0 0 (D)
    // ans : 4
    public int minMoves(int[][] arr, int sx, int sy, int dx, int dy) {
        int[][] mem = new int[arr.length][arr[0].length];
        for(int i = 0; i < arr.length; i++)
            for(int j = 0; j < arr[0].length; j++)
                mem[i][j] = Integer.MAX_VALUE;
        return dfs(arr, sx, sy, dx, dy, 0, mem);
    }

    public int dfs(int[][] arr, int sr, int sc, int dr, int dc, int pathCount, int[][] mem) {
        if(sr < 0 || sr >= arr.length || sc < 0 || sc >= arr[0].length) return pathCount;

        if(arr[sr][sc] < 0) return Math.min(mem[sr][sc], pathCount);

        if(arr[sr][sc] == arr[dr][dc]) {
            mem[sr][sc] = 0;
            return mem[sr][sc];
        }

        arr[sr][sc] = -1;

        int minPath = Integer.MAX_VALUE;

        Pair[] pairs = new Pair[] {
                new Pair(0, -1),
                new Pair(-1, 0),
                new Pair(0, 1),
                new Pair(1, 0),
        };

        for(int i = 0; i < pairs.length; i++) {
            Pair p = pairs[i];
            if(haveSpace(sr, sc, arr, direction[i])) {
                Pair left = getEndOfTunnel(new Pair(sr + p.r, sc + p.c), arr, direction[i]);
                minPath = Math.min(dfs(arr, left.r, left.c, dr, dc, pathCount + 1, mem), minPath);
            }
        }

        if(mem[sr][sc] > pathCount) mem[sr][sc] = pathCount;
        return mem[sr][sc];
    }

    public class Pair {
        int r, c;
        public Pair(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    int[] direction = new int[]{8, 4, 2, 1};

    public boolean haveSpace(int sr, int sc, int[][] arr, int dir) {
        if(1 << 3 == dir)
            if(sc == 0 || arr[sr][sc] != 0) return false;
        if(1 << 2 == dir)
            if(sr == arr.length - 1 || arr[sr][sc] != 0) return false;
        if(1 << 1 == dir)
            if(sc == arr[0].length - 1 || arr[sr][sc] != 0) return false;
        if(1 == dir)
            if(sr == 0 || arr[sr][sc] != 0) return false;

        return true;
    }

    public Pair getEndOfTunnel(Pair src, int[][] arr, int direction) {

        if(1 << 3 == direction && src.c > 0 && arr[src.r][src.c - 1] == 0)
            return getEndOfTunnel(new Pair(src.r, src.c - 1), arr, direction);
        if(1 << 2 == direction && src.r < arr.length - 1 && arr[src.r + 1][src.c] == 0)
            return getEndOfTunnel(new Pair(src.r +1, src.c), arr, direction);
        if(1 << 1 == direction && src.c < arr[0].length - 1 && arr[src.r][src.c + 1] == 0)
            return getEndOfTunnel(new Pair(src.r, src.c + 1), arr, direction);
        if(1 == direction && src.r > 0 && arr[src.r - 1][src.c] == 0)
            return getEndOfTunnel(new Pair(src.r - 1, src.c), arr, direction);
        return src;
    }

    /*
    class Solution {
    public boolean isValid(String s) {

    }

        Pair[] direction = new Pair[] {
            new Pair(0, -1),    // left
            new Pair(-1, 0),    // up
            new Pair(0, 1),     // right
            new Pair(1, 0),     // down
        };

    class Pair {
        int r, c;
        Pair(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    public int minPinBallMove(int[][] arr, int sr, int sc, int dr, int dc) {
        int[][] dis = new int[arr.length][arr[0].length];
        for(int i = 0; i < arr.length; i++)
            for(int j = 0; j < arr[0].length; j++)
                dis[i][j] = Integer.MAX_VALUE;
        return dfs(arr, new Pair(sr, sc), new Pair(dr, dc), int[][] dis, new Pair(0, -1));
    }

    public int dfs(int[][] arr, Pair src, Pair dest, int[][] dis, Pair curDir) {
        if(src.r < 0 || src.c < 0 || src.r >= arr.length || src.c >= arr[0].length) return Integer.MAX_VALUE;

        if(arr[src.r][src.c] < 0)
            return dis[src.r][src.c];

        // update the visited
        arr[src.r][src.c] = -1;

        if(src.c == dest.c && src.r == dest.r) return 0;

        for(Pair p : direction) {
            Pair child = new Pair(src.r + p.r, src.c + p.c);
            Pair otherSide = findTheEndOfTunnel(child, arr, p);
            if(otherSide != null && ! (p.r == -curDir.r && p.c == -curDir.c)) {
                int curDis = dfs(arr, otherSide, dest, dis, p);
                if(curDis != Integer.MAX_VALUE)
                    dis[src.r][src.c] = Math.min(curDis + 1, dis[src.r][src.c]);
            }
        }

        return dis[src.r][src.c];
    }

    public Pair findTheEndOfTunnel(Pair src, int[][] arr, Pair dir) {
        if(arr[src.r][src.c] == 1 || src.r < 0 || src.c < 0) return null;
        return src;
    }
}
    **/
}
