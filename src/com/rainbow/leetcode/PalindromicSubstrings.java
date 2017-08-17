package com.rainbow.leetcode;

/**
 * https://leetcode.com/problems/palindromic-substrings/description/
 */
public class PalindromicSubstrings {
    public static void main(String[] args) {
        String str = "abaaba";
        System.out.println(new PalindromicSubstrings().countSubstrings(str));
    }

    public int countSubstrings(String s) {
        int count = 0;

        for (int i = 0; i < s.length(); i++) {
            char current = s.charAt(i);
            for (int k = i; k < s.length(); k++) {
                char stop = s.charAt(k);
                if (current == stop) {
                    boolean isFound = true;
                    // 判断 current 到 stop之间的字符串是否为回文字符串
                    for (int n = i, m = k; n <= m; n++, m--) {
                        if (s.charAt(n) != s.charAt(m)) {
                            isFound = false;
                            break;
                        }
                    }
                    if (isFound) {
                        count++;
                    }
                }
            }
        }

        return count;
    }

    public int countSubstrings1(String s) {
        int n = s.length();
        int res = 0;
        boolean[][] dp = new boolean[n][n];
        for (int i = n - 1; i >= 0; i--) {
            for (int j = i; j < n; j++) {
                dp[i][j] = s.charAt(i) == s.charAt(j) && (j - i < 3 || dp[i + 1][j - 1]);
                if (dp[i][j]) {
                    ++res;
                }
            }
        }
        return res;
    }
}
