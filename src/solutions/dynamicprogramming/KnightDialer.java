package solutions.dynamicprogramming;

import java.util.Arrays;
/**
 * This time, we place our chess knight on any numbered key of a phone pad (indicated above), and the knight makes N-1 hops.  Each hop must be from one key to another numbered key.
 *
 * Each time it lands on a key (including the initial placement of the knight), it presses the number of that key, pressing N digits total.
 *
 * How many distinct numbers can you dial in this manner?
 *
 * Since the answer may be large, output the answer modulo 10^9 + 7.
 * ***/
public class KnightDialer {
    class Solution {
        public int knightDialer(int N) {
            int MOD = 1_000_000_007;
            int[][] moves = new int[][]{
                    {4,6},{6,8},{7,9},{4,8},{3,9,0},
                    {},{1,7,0},{2,6},{1,3},{2,4}};

            int[][] dp = new int[2][10];
            Arrays.fill(dp[0], 1);
            for (int hops = 0; hops < N-1; ++hops) {
                Arrays.fill(dp[~hops & 1], 0);
                for (int node = 0; node < 10; ++node)
                    for (int nei: moves[node]) {
                        dp[~hops & 1][nei] += dp[hops & 1][node];
                        dp[~hops & 1][nei] %= MOD;
                    }
            }

            long ans = 0;
            for (int x: dp[~N & 1])
                ans += x;
            return (int) (ans % MOD);
        }
    }
}
