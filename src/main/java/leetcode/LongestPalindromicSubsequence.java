package main.java.leetcode;

public class LongestPalindromicSubsequence {

    public static void main(String[] args) {
        System
                .out
                .println(
                        new LongestPalindromicSubsequence()
                                .longestPalindromeSubsequence(
                                        "asdfghjkkjhgfd"
                                )
                );
    }
    public int longestPalindromeSubsequence(String s) {
        int n = s.length();
        Integer[][] dp = new Integer[n][n];
        return explore(0, n-1, s, dp);
    }

    public int explore(int i, int j, String s, Integer[][] dp) {
        if(i > j) return 0;
        if(i == j) return 1;
        if(dp[i][j] != null) return dp[i][j];
        char c1 = s.charAt(i);
        char c2 = s.charAt(j);

        if(c1 == c2) {
            int res = 2 + explore(i+1, j-1, s, dp);
            dp[i][j] = res;
            return res;
        }

        int res1 = explore(i+1, j, s, dp);
        int res2 = explore(i, j-1, s, dp);

        int max = Math.max(res1, res2);
        dp[i][j] = max;
        return max;
    }
}