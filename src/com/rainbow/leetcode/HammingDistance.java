package com.rainbow.leetcode;

/**
 * 关键点：
 * - 异或运算
 */
public class HammingDistance {
    public static void main(String[] args) {
        int x = 1;
        int y = 6;

        // result is 3
        System.out.println(new HammingDistance().hammingDistance1(x, y));
        System.out.println(new HammingDistance().hammingDistance2(x, y));
    }

    public int hammingDistance1(int x, int y) {
        int xorResult = x ^ y;
        int distance = 0;
        // get 1 count
        while (xorResult != 0) {
            if (xorResult % 2 != 0) {
                distance++;
            }
            xorResult = xorResult >> 1;
        }
        return distance;
    }

    public int hammingDistance2(int x, int y) {
        return Integer.bitCount(x ^ y);
    }
}
