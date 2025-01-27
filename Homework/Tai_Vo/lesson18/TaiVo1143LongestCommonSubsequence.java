package lesson18;

import java.util.Arrays;

/**
 * @author taivt
 * @link https://leetcode.com/problems/longest-common-subsequence/
 * @since 2022/06/07 00:05:28
 */
public class TaiVo1143LongestCommonSubsequence {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.longestCommonSubsequence("abcde", "ace"));
        System.out.println(solution.longestCommonSubsequence("abc", "abc"));
        System.out.println(solution.longestCommonSubsequence("abc", "def"));
        System.out.println(solution.longestCommonSubsequence("bsbininm", "jmjkbkjkv"));
    }

    // n: s.length, m: t.length
    // Space Complexity: O(n * m)
    // Time Complexity: O(n * m)
    private static class Solution {
        private String s;
        private String t;
        private int n;
        private int m;
        private int[][] dp;

        public int longestCommonSubsequence(String s, String t) {
            this.s = s;
            this.t = t;
            n = s.length();
            m = t.length();
            dp = new int[n + 1][m + 1]; // dp[i][j] the len of the longest common sequence when considering s[0...i] vs t[0...j]

            for (int[] arr : dp) {
                Arrays.fill(arr, -1);
            }
            return recursive(n, m);
//            return iterative();
        }

        private int iterative() {
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= m; j++) {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                    if (s.charAt(i - 1) == t.charAt(j - 1)) {
                        dp[i][j] = Math.max(dp[i][j], dp[i - 1][j - 1] + 1);
                    }
                }
            }
            return dp[n][m];
        }

        private int recursive(int i, int j) {
            if (i == 0 || j == 0) {
                return 0;
            }
            if (dp[i][j] != -1) {
                return dp[i][j];
            }
            dp[i][j] = Math.max(recursive(i - 1, j), recursive(i, j - 1));
            if (s.charAt(i - 1) == t.charAt(j - 1)) {
                dp[i][j] = Math.max(dp[i][j], recursive(i - 1, j - 1) + 1);
            }
            return dp[i][j];
        }

    }
}
