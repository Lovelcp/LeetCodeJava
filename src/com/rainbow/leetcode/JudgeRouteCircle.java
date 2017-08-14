package com.rainbow.leetcode;

public class JudgeRouteCircle {
    public static void main(String[] args) {
        String moves = "LURD";
        System.out.println(new JudgeRouteCircle().judgeCircle(moves));
    }

    public boolean judgeCircle(String moves) {
        int RCount = 0;
        int LCount = 0;
        int UCount = 0;
        int DCount = 0;

        int length = moves.length();
        for (int i = 0; i < length; i++) {
            char ch = moves.charAt(i);
            switch (ch) {
            case 'R':
                RCount++;
                break;
            case 'L':
                LCount++;
                break;
            case 'U':
                UCount++;
                break;
            case 'D':
                DCount++;
                break;
            default:
                break;
            }
        }

        return RCount == LCount && UCount == DCount;
    }
}
