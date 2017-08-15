package com.rainbow.leetcode;

import java.util.stream.IntStream;

/**
 * https://leetcode.com/problems/counting-bits/description/
 */
public class CountingBits {
    public static void main(String[] args) {
        int num = 11;
        IntStream.of(new CountingBits().countBits(num))
                 .forEach(System.out::println);
    }

    public int[] countBits(int num) {
        int[] result = new int[num + 1];
        int currentMaximumOfPowerOf2 = 1;
        for (int i = 0; i <= num; i++) {
            if (i == 0) {
                result[i] = 0;
                continue;
            }

            if (i == 1) {
                result[i] = 1;
                continue;
            }

            if (i % 2 == 0) {
                // 如果i是个偶数，那么1的数量与i/2的1的数量相同
                result[i] = result[i / 2];
            }
            else {
                // 如果i是个奇数
                result[i] = 1 + result[i - currentMaximumOfPowerOf2];
            }

            if (i % 2 == 0 && i / 2 == currentMaximumOfPowerOf2) {
                i = currentMaximumOfPowerOf2 * 2;
            }
        }
        return result;
    }
}
