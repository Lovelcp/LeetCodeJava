package com.rainbow.leetcode;

/**
 * https://leetcode.com/problems/arithmetic-slices/description/
 */
public class ArithmeticSlices {
    public static void main(String[] args) {
        System.out.println(new ArithmeticSlices().numberOfArithmeticSlices(new int[] { 1, 3, 5, 7, 9,11}));
    }

    public int numberOfArithmeticSlices(int[] A) {
        if (A.length < 3) {
            return 0;
        }

        int result = 0;

        for (int start = 0; start < A.length; ) {
            int diff = A[start + 1] - A[start];
            int stop = start + 2;
            while (true) {
                if (diff == A[stop] - A[stop - 1]) {
                    if (stop >= A.length - 1) {
                        break;
                    }
                    else {
                        stop++;
                    }
                }
                else {
                    stop--;
                    break;
                }
            }

            if (stop - start >= 2) {
                result += (stop - start - 1) * (stop - start) / 2;
            }
            start = stop;

            // 如果剩余的串小于3，则停止
            if (A.length - stop < 3) {
                break;
            }
        }
        return result;
    }
}
